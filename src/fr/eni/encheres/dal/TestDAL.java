package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateur;

public class TestDAL {

	public static void main(String[] args) {
		// Déclaration et instanciation de la DAO
		// UtilisateurDAOJdbcImpl utilisateurDAO = new UtilisateurDAOJdbcImpl();
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();

		// Instanciation du jeu d'essai
		Utilisateur u1 = new Utilisateur("od", "olivier", "durand", "olivier@gmail.fr", "0652598789",
				"rue de la republique", "84000", "Avignon", "oliv59", 200, true);

		System.out.println("Ajout des utilisateurs ");

		try {
			utilisateurDAO.insert(u1);
			System.out.println("Utilisateur ajouté : " + u1.toString());

			Utilisateur user = utilisateurDAO.selectById(u1.getNoUtilisateur());
			System.out.println("selectById(no_utilisateur) = " + user.toString());
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

}
