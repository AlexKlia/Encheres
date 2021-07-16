package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO extends DAO<Utilisateur> {
	public List<Utilisateur> selectIdentifiant() throws DALException;
}
