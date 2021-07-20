package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;

public class EnchereManager {
	
	private static EnchereDAO enchereDAO;

	public EnchereManager() /*throws BLLException*/ {
		enchereDAO = DAOFactory.getEnchereDAO();
		
	}
	
	public List<Enchere> getListEncheres()  /*throws BLLException*/  {
		List<Enchere> encheres = null;
		try {
			encheres = enchereDAO.selectAll();
		} catch (Exception /* DALException*/  e) {
			/*
			 * e.printStackTrace();
			throw new BLLException("Erreur récupération ListEncheres()", e);
			 *  */
		}
		return encheres; 
		
	}
	
	
	
	
	
	

}
