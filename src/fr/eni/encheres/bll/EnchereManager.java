package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;

public class EnchereManager {
	
	private EnchereDAO enchereDAO;

	public EnchereManager() {
		this.enchereDAO = DAOFactory.getEnchereDAO();
		
	}
	
	public List<Enchere> getListEncheres()  throws DALException  {
//		BusinessException exception = new BusinessException();
		List<Enchere> encheres = null;
//		try {
			encheres = enchereDAO.selectAll();
			
			
			
/*		} catch (Exception  DALException  e) {
			
			 * e.printStackTrace();
			throw new BLLException("Erreur récupération ListEncheres()", e);
			
		}
*/		return encheres; 
		
	}
	
	
	public Enchere getEnchereByID(int id) throws DALException {
		Enchere enchere = null;
		return enchere = enchereDAO.selectById(id);		
				
	}
	
	
	
	
	
	

}
