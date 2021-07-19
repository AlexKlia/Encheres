package fr.eni.encheres.ihm;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletListeEnchereEnCours
 */
@WebServlet("/ServletListeEnchereEnCours")
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
