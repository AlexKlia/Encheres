package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;

public class ArticleManager {
	private ArticleDAO articleDAO;

	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}
	
	public int add(Article article) throws DALException, BusinessException {
		BusinessException exception = new BusinessException();
		validation(article, exception);
		
		if(!exception.hasErreurs())
		{
			article = articleDAO.insert(article);
			return article.getNoArticle();
		} else {
			throw exception;
		}
	}
	
	public int update(Article article) throws DALException, BusinessException {
		BusinessException exception = new BusinessException();
		validation(article, exception);
		
		if(!exception.hasErreurs())
		{
			article = articleDAO.update(article);
			return article.getNoArticle();
		} else {
			throw exception;
		}
	}
	
	public void remove(int id) throws DALException {
		articleDAO.delete(id);
	}
	
	public Article getArticleById(int id) throws DALException {
		return articleDAO.selectById(id);
	}

	
	/**
	 * Cette méthode permet de vérifier les règles à respecter sur Article.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet BusinessException.
	 * @param Article article
	 * @param BusinessException businessException 
	 */
	private void validation(Article article, BusinessException businessException)
	{
		if(null == article.getNomArticle() || article.getNomArticle().equals("")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_NOM_NULL, "Nom de l'article obligatoire.");
		} else {
			if(30 < article.getNomArticle().length()) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_NOM_ERREUR, "Nom de l'article trop long.");
			}	
		}
		
		if(null == article.getDescription() || article.getDescription().equals("")) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DESCRIPTION_NULL, "Déscription de l'article obligatoire.");
		} else {
			if(300 < article.getDescription().length()) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DESCRIPTION_ERREUR, "Déscription de l'article trop longue.");
			}	
		}
		
		if(null == article.getDateDebutEncheres()) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DATE_DEBUT_NULL, "Date de début de la vente est obligatoire.");
		} else {
			if(article.getDateDebutEncheres().isBefore(LocalDate.now())) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DATE_DEBUT_ERREUR, "Date de début de la vente doit se situer dans le futur.");
			}	
		}
		
		if(null == article.getDateFinEncheres()) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DATE_FIN_NULL, "Date de fin de la vente est obligatoire.");
		} else {
			if(article.getDateFinEncheres().isBefore(LocalDate.now())) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DATE_FIN_BEFORE_NOW, "Date de fin de la vente doit se situer dans le futur.");
			}
			
			if(null != article.getDateDebutEncheres() && article.getDateFinEncheres().isBefore(article.getDateDebutEncheres())) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DATE_FIN_BEFORE_DEBUT, "Date de fin de la vente doit etre superieur a la date de debut.");
			}	
		}
	}
}
