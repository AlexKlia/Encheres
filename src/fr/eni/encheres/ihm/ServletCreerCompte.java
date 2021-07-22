package fr.eni.encheres.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class ServletCreerCompte
 */
@WebServlet("/ServletCreerCompte")
public class ServletCreerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/enchereUtilisateur/creerCompte.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isAddButton = request.getParameter("submitButton").equals("add");
		boolean isCancelButton = request.getParameter("submitButton").equals("cancel");

		if (isAddButton) {

			// Recuperation des donnees du formulaire

			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String tel = request.getParameter("tel");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			String motDePasse = request.getParameter("mdp");
			String motDePasseConfirmation = request.getParameter("mdpC");

			UtilisateurManager utilisateurManager = new UtilisateurManager();
			Utilisateur utilisateuraAjouter = new Utilisateur(pseudo, nom, prenom, email, tel, rue, codePostal, ville,
					motDePasse,motDePasseConfirmation);
			Utilisateur utilsateurRenvoye = null;

			try {

				utilsateurRenvoye = utilisateurManager.add(utilisateuraAjouter);

			} catch (DALException e) {

				e.printStackTrace();
			} catch (BusinessException e) {
				String[] errorMessages = e.getErrorMessages();
				request.setAttribute("errorMessages", errorMessages);
			}

			if (utilsateurRenvoye != null) {
				// Redirection vers la page d'accueil
				response.sendRedirect(request.getContextPath());
			} else {
				String erreurCreation = "Compte utilisateur non crée, renseigner à nouveau les champs";
				System.out.println("Identifiant et mot de passe incorrects");
				request.setAttribute("erreur", erreurCreation);
				RequestDispatcher rd = request
						.getRequestDispatcher("/WEB-INF/encheres/enchereUtilisateur/creerCompte.jsp");
				rd.forward(request, response);
			}

		}

		if (isCancelButton) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/accueil.jsp");
			rd.forward(request, response);
		}

	}

}