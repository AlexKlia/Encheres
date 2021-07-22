package fr.eni.encheres.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class ServletListeEnchereEnCours
 */
@WebServlet("")
public class ServletListeEnchereEnCours extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		String recherche = request.getParameter("recherche");
		String categorie = request.getParameter("categorie");
		
		
/*		HttpSession session = request.getSession();
		if(session.getAttribute("sessionOuverte")!=null)
		{
*/
		String mode = request.getParameter("mode");
		String typeAchats;
		String typeVentes;
	
		if (mode=="achats") {
			typeAchats = request.getParameter("achats");
		} else {
			typeVentes = request.getParameter("ventes");
		}
		
/*		}
		session.setAttribute("sessionOuverte", "1");
*/
	
		
		
		List<Article> listArticles = new ArrayList<Article>(); 
		ArticleManager articleManager = new ArticleManager();
		List<Enchere> listEncheres = new ArrayList<Enchere>();
		List<Utilisateur> listUtilisateurs = new ArrayList<Utilisateur>();
		List<String> listMontantMax = new ArrayList<>(); 
		List<String> listPseudoVendeur = new ArrayList<>(); 
		
		
		try {
			listArticles = articleManager.getAllArticles();
			for (Article element : listArticles) {
				EnchereManager enchereManager = new EnchereManager();
				// Enchere enchereMax = enchereManager.getEnchereByID(element.getNoArticle());
				if (null != element.getNoArticle()) {
					Integer montantMax = null;
					Enchere enchere = enchereManager.getEnchereByID(element.getNoArticle());
					if (null != enchere) {
						montantMax = enchere.getMontantEnchere();// Integer misAPris = element.getMiseAPrix();
						if (montantMax < element.getMiseAPrix()) {
							montantMax = element.getMiseAPrix();
							listMontantMax.add(montantMax.toString());
						} else {
						}
						
						
						UtilisateurManager utilisateurManager = new UtilisateurManager();
						
						String pseudoVendeur = utilisateurManager.getPseudoVendeur(element.getNoArticle());
						listPseudoVendeur.add(pseudoVendeur);
					}
					
					
					
				}

				// listEncheres.add(enchereMax);
				UtilisateurManager utilisateurManager = new UtilisateurManager();
				String pseudoVendeur = utilisateurManager.getPseudoVendeur(element.getNoArticle());
				if (null != pseudoVendeur) {
					listPseudoVendeur.add(pseudoVendeur);
				}
				/*
				 * Utilisateur vendeur = utilisateurManager.getUserById(element.getNoArticle());
				 * element.setDescription(psedoVendeur); listUtilisateurs.add(vendeur);
				 */ }

		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		request.setAttribute("listArticles", listArticles);
		request.setAttribute("listEncheres", listEncheres);
		request.setAttribute("listUtilisateurs", listUtilisateurs);
		request.setAttribute("listMontantMax", listMontantMax);
		request.setAttribute("listPseudoVendeur", listPseudoVendeur);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/accueil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
		

			}

}
