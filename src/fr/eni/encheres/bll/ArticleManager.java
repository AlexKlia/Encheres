package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleManager {
	private ArticleDAO articleDAO;

	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}
	
	public int add(Article article) throws DALException {
		return articleDAO.insert(article);
	}
	
	public int update(Article article) throws DALException {
		return articleDAO.update(article);
	}
	
	public Article getArticleById(int id) throws DALException {
		return articleDAO.selectById(id);
	}
}
