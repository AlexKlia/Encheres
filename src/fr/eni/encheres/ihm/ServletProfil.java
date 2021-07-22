package fr.eni.encheres.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
//import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class ServletProfil
 */
@WebServlet("/ServletProfil")
public class ServletProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// private UtilisateurManager u = new UtilisateurManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Recuperation des informations de la session

		Object pseudo = session.getAttribute("pseudo");
		request.setAttribute("pseudo", pseudo);
		Object nom = session.getAttribute("nom");
		request.setAttribute("nom", nom);
		Object prenom = session.getAttribute("prenom");
		request.setAttribute("prenom", prenom);
		Object email = session.getAttribute("email");
		request.setAttribute("email", email);
		Object tel = session.getAttribute("tel");
		request.setAttribute("tel", tel);
		Object rue = session.getAttribute("rue");
		request.setAttribute("rue", rue);
		Object codePostal = session.getAttribute("codePostal");
		request.setAttribute("codePostal", codePostal);
		Object ville = session.getAttribute("ville");
		request.setAttribute("ville", ville);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/enchereUtilisateur/monProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isUpdateButton = request.getParameter("submitButton").equals("update");
		boolean isCancelButton = request.getParameter("submitButton").equals("cancel");

		if (isUpdateButton) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/enchereUtilisateur/modifierProfil.jsp");
			rd.forward(request, response);
			
		}
		if (isCancelButton) {
			//Redirection vers la page d'accueil
			response.sendRedirect(request.getContextPath());
		}
	}

}
