package fr.eni.encheres.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/enchereUtilisateur/connexion.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=null;
		String mdp=null;
		
		// Recuperation des donnees du formulaire
		id = request.getParameter("identifiant");
		mdp = request.getParameter("mdp");

		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		try {
		utilisateurManager.seConnecter(id,mdp);
		
		
//		// Creation de la session utilisateur
//		HttpSession session = request.getSession();
//		session.setAttribute("identifiant", id);
//		session.setAttribute("mdp", mdp);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/enchereModeVente/enchereNonCommencee.jsp");
		rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Identifiant et mot de passe incorrects");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/enchereUtilisateur/connexion.jsp");
			rd.forward(request, response);
		}
		

	}

}
