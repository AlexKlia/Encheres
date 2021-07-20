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
		boolean isConnexionButton = request.getParameter("submitButton").equals("connexion");
		boolean isAddButton = request.getParameter("submitButton").equals("add");
		
			if (isConnexionButton) {
				// Recuperation des donnees du formulaire

				String id = request.getParameter("identifiant");
				String mdp = request.getParameter("mdp");

				UtilisateurManager utilisateurManager = new UtilisateurManager();

				try {

					Utilisateur utilisateurConnecte = utilisateurManager.seConnecter(id, mdp);
					if (utilisateurConnecte != null) {
						System.out.println(utilisateurConnecte);

						// Creation de la session utilisateur
						HttpSession session = request.getSession();

						session.setAttribute("noUtilisateur", utilisateurConnecte.getNoUtilisateur());
						session.setAttribute("identifiant", id);
						session.setAttribute("mdp", mdp);

						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/listeEncheresConnecte.jsp");
						rd.forward(request, response);
					} else {
						String erreurConnexion = "Identifiant et mot de passe incorrects";
						System.out.println("Identifiant et mot de passe incorrects");
						request.setAttribute("erreur", erreurConnexion);
						RequestDispatcher rd = request
								.getRequestDispatcher("/WEB-INF/encheres/enchereUtilisateur/connexion.jsp");
						rd.forward(request, response);
					}
				} catch (DALException e) {
					e.printStackTrace();
				}
			}

			if (isAddButton) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/WEB-INF/encheres/enchereUtilisateur/creerCompte.jsp");
				rd.forward(request, response);
			}

		

	}

}
