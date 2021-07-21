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
		//Connexion de l'utilisateur
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
						//Récupération des informations de la session
						session.setAttribute("noUtilisateur", utilisateurConnecte.getNoUtilisateur());
						session.setAttribute("identifiant", id);
						session.setAttribute("mdp", mdp);
						session.setAttribute("pseudo", utilisateurConnecte.getPseudo());
						session.setAttribute("nom", utilisateurConnecte.getNom());
						session.setAttribute("prenom", utilisateurConnecte.getPrenom());
						session.setAttribute("email", utilisateurConnecte.getEmail());
						session.setAttribute("tel", utilisateurConnecte.getTelephone());
						session.setAttribute("rue", utilisateurConnecte.getRue());
						session.setAttribute("codePostal", utilisateurConnecte.getCodePostal());
						session.setAttribute("ville", utilisateurConnecte.getVille());
						session.setAttribute("mdp", utilisateurConnecte.getMotDePasse());
						session.setAttribute("credit", utilisateurConnecte.getCredit());
						//Redirection vers la page d'accueil
						response.sendRedirect(request.getContextPath());
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
//Création d'un compte utilisateur
			if (isAddButton) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/WEB-INF/encheres/enchereUtilisateur/creerCompte.jsp");
				rd.forward(request, response);
			}

		

	}

}
