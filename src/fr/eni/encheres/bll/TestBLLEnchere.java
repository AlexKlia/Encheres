package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;
import fr.eni.encheres.dal.EnchereDAOJdbcImpl;
import fr.eni.encheres.dal.UtilisateurDAO;

public class TestBLLEnchere {

	public static void main(String[] args) throws DALException {

/*		EnchereManager em = new EnchereManager();
		System.out.println(em.getListEncheres());
*/		
		
//		EnchereDAO enchereDAO = DAOFactory.getEnchereDAO();
		
		EnchereDAOJdbcImpl enchereDAO = new EnchereDAOJdbcImpl();
		
		Enchere enchere = enchereDAO.selectById(8);
		System.out.println(enchere);
		
//		List<Enchere> list = enchereDAO.selectAll();
//		System.out.println(list);		
				
		
		
		
/*		ArticleManager am = new ArticleManager();

		System.out.println(am.getArticleById(8));
*/	

	}

}
