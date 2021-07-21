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
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class ServletModifierProfil
 */
@WebServlet("/ServletModifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/enchereUtilisateur/modifierProfil.jsp");
		rd.forward(request, response);
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
		Object mdp = session.getAttribute("mdp");
		request.setAttribute("mdp", mdp);
		Object credit = session.getAttribute("credit");
		request.setAttribute("credit", credit);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isUpdateButton = request.getParameter("submitButton").equals("update");
		boolean isDeleteButton = request.getParameter("submitButton").equals("delete");

		if (isUpdateButton) {
			HttpSession session = request.getSession();
			Object noUtilisateur = session.getAttribute("noUtilisateur");
			int noUtilisateurInt = (Integer) noUtilisateur;
			// Recuperation des donnees du formulaire
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String tel = request.getParameter("tel");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			String mdp = request.getParameter("mdp");
			String credit = request.getParameter("credit");
			int creditInt = Integer.parseInt(credit);

			UtilisateurManager utilisateurManager = new UtilisateurManager();
			Utilisateur utilisateuraModifier = new Utilisateur(noUtilisateurInt, pseudo, nom, prenom, email, tel, rue,
					codePostal, ville,mdp,creditInt);

			try {
				utilisateurManager.update(utilisateuraModifier);

			} catch (DALException e) {

				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/enchereUtilisateur/modifierProfil.jsp");
			rd.forward(request, response);

		}
		if (isDeleteButton) {
			HttpSession session = request.getSession();
			Object noUtilisateur = session.getAttribute("noUtilisateur");
			int noUtilisateurInt = (Integer) noUtilisateur;

			UtilisateurManager utilisateurManager = new UtilisateurManager();
			Utilisateur utilisateuraSupprimer = new Utilisateur(noUtilisateurInt);
			try {
				utilisateurManager.delete(utilisateuraSupprimer);
			} catch (DALException e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/listeEncheresConnecte.jsp");
			rd.forward(request, response);
		}
	}

}
