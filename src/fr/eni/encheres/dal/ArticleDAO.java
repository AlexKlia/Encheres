package fr.eni.encheres.dal;


import fr.eni.encheres.bo.Article;

public interface ArticleDAO extends DAO<Article> {
	public Article insert(Article article) throws DALException;
	public Article selectById(int id) throws DALException;
	public Article update(Article article) throws DALException;
	public void delete(int id) throws DALException;
}
