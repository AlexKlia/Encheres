package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;


public class TestBLL {
	public static void main(String[] args) {

	UtilisateurManager utilisateurManager = null;
	utilisateurManager = new UtilisateurManager();

	// Instanciation du jeu d'essai
	Utilisateur u1 = new Utilisateur("od", "olivier", "durand", "olivier@gmail.fr", "0652598789","rue de la republique", "84000", "Avignon", "oliv59", 200, true);

	Utilisateur u = utilisateurManager.seConnecter(u1.getPseudo(),u1.getMotDePasse());
		System.out.println("Sélection de l'article par id  : " + u1.toString());


}
}
