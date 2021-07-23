package fr.eni.encheres.ihm;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.RetraitManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class ServletEnchereModeVente
 */
@WebServlet("/ventes")
public class ServletEnchereModeVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Utilisateur user = null;
	private UtilisateurManager um = new UtilisateurManager();
	private ArticleManager am = new ArticleManager();
	private RetraitManager rm = new RetraitManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object id = session.getAttribute("noUtilisateur");
		if (null ==  id || id.equals("")) {
			response.sendRedirect(request.getContextPath()+"/ServletConnexion");
		} else {
			int userId = Integer.parseInt(id.toString());

			try {
				if (null == user) {
					user = um.getUserById(userId);
				}

				if (null != user) {
					if (null != request.getAttribute("noArticle") || null != request.getParameter("noArticle")) {
						String articleIdToString = null == request.getAttribute("noArticle")
								? request.getParameter("noArticle").toString()
								: request.getAttribute("noArticle").toString()
						;
						int articleId = Integer.parseInt(articleIdToString);
						Article article = am.getArticleById(articleId);
						Retrait retrait = rm.getRetraitById(articleId);

						// Informations article
						Object noUtilisateur = session.getAttribute("noUtilisateur");
						request.setAttribute("noUtilisateur", noUtilisateur);
						request.setAttribute("id", articleIdToString);
						request.setAttribute("isVendeurArticle", article.getVendeur().getNoUtilisateur() == userId);
						request.setAttribute("article", article.getNomArticle());
						request.setAttribute("description", article.getDescription());
						request.setAttribute("categorie", String.valueOf(article.getCategorie().getNoCategorie()));
						request.setAttribute("miseAPrix", String.valueOf(article.getMiseAPrix()));
						request.setAttribute("debut", article.getDateDebutEncheres().toString());
						request.setAttribute("fin", article.getDateFinEncheres().toString());
						request.setAttribute("isCancellable", article.getDateDebutEncheres().isAfter(LocalDate.now()));
						if (null != retrait) {
							request.setAttribute("rue", retrait.getRue());
							request.setAttribute("codePostal", String.valueOf(retrait.getCodePostal()));
							request.setAttribute("ville", retrait.getVille());
						} else {
							// Informations user
							request.setAttribute("rue", user.getRue());
							request.setAttribute("codePostal", String.valueOf(user.getCodePostal()));
							request.setAttribute("ville", user.getVille());
						}
					}
				}
			} catch (DALException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/enchereModeVente/enchereNonCommencee.jsp");
			rd.forward(request, response); 	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Article article = null;
		Retrait retrait = null;
		Categorie categorie = new Categorie();
		String requestNoArticle = request.getParameter("noArticle");
		boolean isDeleteButton = request.getParameter("submitButton").equals("delete");
		boolean isCancelButton = request.getParameter("submitButton").equals("cancel");
		boolean articleAlreadyExist = null != requestNoArticle && !requestNoArticle.equals("");
		Integer noArticle = articleAlreadyExist ? Integer.parseInt(requestNoArticle) : null;
		
		// On recherche l'article si un id est passé en parametre de la requete pour le mettre a jour
		if (articleAlreadyExist) {
			try {
				article = am.getArticleById(noArticle);
				retrait = rm.getRetraitById(noArticle);
			} catch (NumberFormatException | DALException e) {
				e.printStackTrace();
			}
		} else {
			// Sinon on ajoute un nouvelle article
			article = new Article();
			retrait = new Retrait();
		}
		
		if (!articleAlreadyExist || user.getNoUtilisateur() == article.getVendeur().getNoUtilisateur()) {
			// On verifie l'action qu'on veux effectuer: suppression, ajout ou modification.
			if (isDeleteButton && articleAlreadyExist) {
				// Suppression de l'article
				if (LocalDate.now().isBefore(article.getDateDebutEncheres())) {
					try {
						rm.remove(Integer.parseInt(requestNoArticle));
						am.remove(Integer.parseInt(requestNoArticle));
						request.setAttribute("deleteSuccess", true);
						request.setAttribute("alertClass", "info");
					} catch (NumberFormatException | DALException e) {
						e.printStackTrace();
					}
				}
			} else {
				// Dans le cas du clic sur le boutton "Annuler", le traitement est terminé.
				if (!isCancelButton) {
					article.setNomArticle(request.getParameter("article"));
					article.setDescription(request.getParameter("description"));
					
					if (!request.getParameter("miseAPrix").equals("")) {
						article.setMiseAPrix(Integer.parseInt(request.getParameter("miseAPrix")));	
					}

					categorie.setNoCategorie(Integer.parseInt(request.getParameter("categorie")));
					article.setCategorie(categorie);
					
					String debutEnchere = request.getParameter("debutEnchere");
					if (!debutEnchere.equals("")) {
						article.setDateDebutEncheres(LocalDate.parse(debutEnchere));
					}

					String finEnchere = request.getParameter("finEnchere");
					if (!finEnchere.equals("")) {
						article.setDateFinEncheres(LocalDate.parse(finEnchere));
					}

					if (articleAlreadyExist) {
						retrait.setNoArticle(noArticle);
					}

					retrait.setRue(request.getParameter("rue"));
					retrait.setCodePostal(request.getParameter("codePostal"));
					retrait.setVille(request.getParameter("ville"));
					
					article.setRetrait(retrait);
					article.setVendeur(user);
				}
				
				try {
					if (isCancelButton) {
						request.setAttribute("cancelSuccess", true);
						request.setAttribute("alertClass", "warning");
					} else {
						request.setAttribute("alertClass", "success");
						if (null != article.getNoArticle()) {
							am.update(article);
							rm.update(retrait);
							request.setAttribute("updateSuccess", true);
						} else {
							noArticle = am.add(article);
							retrait.setNoArticle(noArticle);
							rm.add(retrait);
							request.setAttribute("addSuccess", true);
						}
					}
				} catch (BusinessException e) {
					String[] errorMessages = e.getErrorMessages();
					request.setAttribute("alertClass", "danger");
					request.setAttribute("errorMessages", errorMessages);
				} catch (DALException e) {
					e.printStackTrace();
				}

				if (null != noArticle) {
					request.setAttribute("noArticle", noArticle);
				}	
			}
		}
		
		doGet(request, response);
	}
}
