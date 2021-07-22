package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.RetraitDAO;
import fr.eni.encheres.BusinessException;

public class RetraitManager {
	private RetraitDAO retraitDAO;

	public RetraitManager() {
		this.retraitDAO = DAOFactory.getRetraitDAO();
	}
	
	public int add(Retrait retrait) throws DALException, BusinessException {
		BusinessException exception = new BusinessException();
		validation(retrait, exception);
		
		if(!exception.hasErreurs())
		{
			retrait = retraitDAO.insert(retrait);
			System.out.println("RetraitManager " + retrait);
			return retrait.getNoArticle();
		} else {
			throw exception;
		}
	}
	
	public int update(Retrait retrait) throws DALException, BusinessException {
		BusinessException exception = new BusinessException();
		validation(retrait, exception);
		
		if(!exception.hasErreurs())
		{
			retrait = retraitDAO.update(retrait);
			return retrait.getNoArticle();
		} else {
			throw exception;
		}
	}
	
	public void remove(int id) throws DALException {
		retraitDAO.delete(id);
	}
	
	public Retrait getRetraitById(int id) throws DALException {
		return retraitDAO.selectById(id);
	}

	
	/**
	 * Cette méthode permet de vérifier les règles à respecter sur Retraits.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet BusinessException.
	 * @param Article article
	 * @param BusinessException businessException 
	 */
	private void validation(Retrait retrait, BusinessException businessException)
	{
		if(null == retrait.getRue()|| retrait.getRue().equals("")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_NOM_NULL, "Nom de rue obligatoire");
		} else {
			if(30 < retrait.getRue().length()) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_NOM_ERREUR, "Nom de rue trop long.");
			}	
		}

		if(null == retrait.getVille()|| retrait.getVille().equals("")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_NOM_NULL, "Nom de ville obligatoire");
		} else {
			if(30 < retrait.getVille().length()) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_NOM_ERREUR, "Nom de ville trop long.");
			}	
		}

		if(null == retrait.getCodePostal()|| retrait.getCodePostal().equals("")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_NOM_NULL, "Code postal obligatoire");
		} else {
			if(15 < retrait.getCodePostal().length()) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_NOM_ERREUR, "Code postal trop long.");
			}	
		}
	}
}
