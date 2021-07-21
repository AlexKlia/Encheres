package fr.eni.encheres.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bo.Enchere;
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
		String mode = request.getParameter("mode");
		String typeAchats;
		String typeVentes;
	
		if (mode=="achats") {
			typeAchats = request.getParameter("achats");
		} else {
			typeVentes = request.getParameter("ventes");
		}
		
		
		
		EnchereManager encheres = new EnchereManager();
		try {
			List<Enchere> listEncheres = encheres.getListEncheres();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
//		request.setAttribute("listEncheres", listEncheres);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/accueil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(request, response);
		
//		photoArticle;
		String nomArticle;
		int meilleureOffre;
		LocalDate finEnchere;
		String vendeur;
		
			}

}
