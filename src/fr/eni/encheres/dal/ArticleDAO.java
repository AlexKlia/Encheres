package fr.eni.encheres.dal;


import fr.eni.encheres.bo.Article;

public interface ArticleDAO extends DAO<Article> {
	public int insert(Article article) throws DALException;
	public Article selectById(int id) throws DALException;
	public int update(Article article) throws DALException;
}
