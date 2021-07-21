package fr.eni.encheres.dal;


import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO extends DAO<Utilisateur> {

	public Utilisateur selectIdentifiant(String id, String mdp) throws DALException;
	public Utilisateur selectById(int id) throws DALException;
	public Utilisateur delete(Utilisateur utilisateur) throws DALException;
	public Utilisateur update(Utilisateur utilisateur) throws DALException;

}
