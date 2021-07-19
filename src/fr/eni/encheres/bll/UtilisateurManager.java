package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UserNotFoundException;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	private UtilisateurDAO utilisateurDAO;

	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public Utilisateur seConnecter(String id, String mdp) throws DALException {

		Utilisateur utilisateur = utilisateurDAO.selectIdentifiant(id, mdp);

		return utilisateur;

	}

	public Utilisateur getUserById(int id) throws DALException {
		return utilisateurDAO.selectById(id);
	}
}
