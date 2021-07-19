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

import fr.eni.encheres.bll.ArticleManager;
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object id = session.getAttribute("identifiant");
		if (null ==  id || id.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/enchereUtilisateur/connexion.jsp");
			rd.forward(request, response);
		} else {
			int userId = Integer.parseInt(id.toString());

			try {
				if (null == user) {
					user = um.getUserById(userId);
				}
				
				if (null != request.getAttribute("noArticle")) {
					int articleId = Integer.parseInt(request.getAttribute("noArticle").toString()); 
					Article article = am.getArticleById(articleId);
					
					// Informations article
					request.setAttribute("id", request.getAttribute("noArticle").toString());
					request.setAttribute("article", article.getNomArticle());
					request.setAttribute("description", article.getDescription());
					request.setAttribute("categorie", String.valueOf(article.getCategorie().getNoCategorie()));
					request.setAttribute("miseAPrix", String.valueOf(article.getMiseAPrix()));
					request.setAttribute("debut", article.getDateDebutEncheres().toString());
					request.setAttribute("fin", article.getDateFinEncheres().toString());
				}

				if (null != user) {
					// Informations user
					request.setAttribute("rue", user.getRue());
					request.setAttribute("codePostal", String.valueOf(user.getCodePostal()));
					request.setAttribute("ville", user.getVille());
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
		String requestNoArticle = request.getParameter("noArticle");
		boolean isDeleteButton = request.getParameter("submitButton").equals("delete");
		boolean isCancelButton = request.getParameter("submitButton").equals("cancel");
		boolean articleAlreadyExist = null != requestNoArticle && !requestNoArticle.equals("");
		
		// On verifie l'action qu'on veux effectuer: suppression, ajout ou modification.
		if (isDeleteButton && articleAlreadyExist) {
			// Suppression de l'article
			try {
				am.remove(Integer.parseInt(requestNoArticle));
				request.setAttribute("deleteSuccess", true);
				request.setAttribute("alertClass", "info");
			} catch (NumberFormatException | DALException e) {
				e.printStackTrace();
			}
		} else {
			// On recherche l'article si un id est passé en parametre de la requete pour le mettre a jour
			if (articleAlreadyExist) {
				try {
					article = am.getArticleById(Integer.parseInt(requestNoArticle));
				} catch (NumberFormatException | DALException e) {
					e.printStackTrace();
				}
			} else {
				// Sinon on ajoute un nouvelle article
				article = new Article();
			}
			
			// Dans le cas du clic sur le boutton "Annuler", le traitement est terminé.
			if (!isCancelButton) {
				article.setNomArticle(request.getParameter("article"));
				article.setDescription(request.getParameter("description"));
				
				if (null != request.getParameter("miseAPrix")) {
					article.setMiseAPrix(Integer.parseInt(request.getParameter("miseAPrix")));	
				}
				
				Categorie categorie = new Categorie();
				categorie.setNoCategorie(Integer.parseInt(request.getParameter("categorie")));
				article.setCategorie(categorie);
				
				String debutEnchere = request.getParameter("debutEnchere");
				if (null != debutEnchere) {
					article.setDateDebutEncheres(LocalDate.parse(debutEnchere));
				}

				String finEnchere = request.getParameter("finEnchere");
				if (null != finEnchere) {
					article.setDateFinEncheres(LocalDate.parse(finEnchere));
				}
				
				Retrait retrait = new Retrait();
				retrait.setRue(request.getParameter("rue"));
				retrait.setCodePostal(request.getParameter("codePostal"));
				retrait.setVille(request.getParameter("ville"));
				
				article.setRetrait(retrait);
				article.setVendeur(user);
			}
			
			try {
				Integer noArticle;
				if (isCancelButton) {
					noArticle = null == article ? null : article.getNoArticle();
					request.setAttribute("cancelSuccess", true);
					request.setAttribute("alertClass", "warning");
				} else {
					request.setAttribute("alertClass", "success");
					if (null != article.getNoArticle()) {
						noArticle = am.update(article);
						request.setAttribute("updateSuccess", true);
					} else {
						noArticle = am.add(article);
						request.setAttribute("addSuccess", true);
					}
				}
				
				if (null != noArticle) {
					request.setAttribute("noArticle", noArticle);
				}
			} catch (DALException e) {
				e.printStackTrace();
			}
		}
		
		doGet(request, response);
	}
}
