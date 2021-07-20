package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;

public class TestBLLEnchere {

	public static void main(String[] args) {

		EnchereManager em = new EnchereManager();

		System.out.println(em.getListEncheres());
		

	}

}
