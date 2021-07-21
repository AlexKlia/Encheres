package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Utilisateur;

public class TestDAL {

	public static void main(String[] args) {
		// Déclaration et instanciation de la DAO
		// UtilisateurDAOJdbcImpl utilisateurDAO = new UtilisateurDAOJdbcImpl();
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();

		//  Instanciation du jeu d'essai
//		 Utilisateur u1 = new Utilisateur("opd", "olivier", "durand",
//		 "olivier@gmail.fr", "0652598789",
//		 "rue de la republique", "84000", "Avignon", "oliv59", 200, true);
//		 Utilisateur u1 = new Utilisateur(22,"opd", "olivier", "durand",
//				 "olivier@gmail.fr", "0652598789",
//				 "rue de la republique", "84000", "Avignon", "oliv59", 200, true);
		Utilisateur u2 = new Utilisateur();
		u2.setNoUtilisateur(15);

		try {

			
//			Utilisateur u = utilisateurDAO.selectIdentifiant(u1.getPseudo(),u1.getMotDePasse());
//			System.out.println("Sélection de l'article par id  : " + u1.toString() );

//			utilisateurDAO.insert(u1);
//			System.out.println("Utilisateur ajouté : " + u1.toString());
			utilisateurDAO.deleteByUser(u2);
			System.out.println("Utilisateur supprime : " + u2.toString());
			
//			Utilisateur user = utilisateurDAO.selectById(u1.getNoUtilisateur());
//			System.out.println("selectById(no_utilisateur) = " + user.toString());

		} catch (DALException e) {
	
			e.printStackTrace();
		}
		

		// SelectAll Article
//		ArticleDAO articleDAO = DAOFactory.getArticleDAO();
//		try {
//			List<Article> articles = articleDAO.selectAll();
//			for (Article article: articles) {
//				System.out.println(article);
//			}
//		} catch (DALException e1) {
//			e1.printStackTrace();
//		}
	}

}
