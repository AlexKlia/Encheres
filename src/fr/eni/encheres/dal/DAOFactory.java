package fr.eni.encheres.dal;

public abstract class DAOFactory {
	public static UtilisateurDAO getUtilisateurDAO(){
		return new UtilisateurDAOJdbcImpl();
	}
	public static ArticleDAO getArticleDAO(){
		return new ArticleDAOJdbcImpl();
	}
	public static EnchereDAO getEnchereDAO(){
		return new EnchereDAOJdbcImpl();
	}
	public static RetraitDAO getRetraitDAO(){
		return new RetraitDAOJdbcImpl();
	}
}
