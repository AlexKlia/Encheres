package fr.eni.encheres.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

public class ArticleDAOJdbcImpl implements ArticleDAO {
	private static final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) values (?,?,?,?,?,?,?)";
	private static final String UPDATE_ARTICLE = "UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, no_utilisateur=?, no_categorie=? WHERE no_article=?";
	private static final String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article=?";
	private static final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
	private static final String DELETE_BY_ID = "DELETE FROM ARTICLES_VENDUS WHERE no_article=?";
	
	@Override
	public Article selectById(int id) throws DALException {
		Article article = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					article = createArticleFromResulSet(rs);
			    }
				rs.close();                       
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				connection.close();
				throw e;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return article;
	}

	@Override
	public List<Article> selectAll() throws DALException {
		List<Article> articles = new ArrayList<Article>();
		Article article = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(SELECT_ALL);
				while (rs.next()) {
					article = createArticleFromResulSet(rs);
					articles.add(article);
			    }
				rs.close();                       
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				connection.close();
				throw e;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return articles;
	}

	@Override
	public Article update(Article article) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt = insertUpdatePreparedStatement(article, pstmt);
				pstmt.executeUpdate();
				pstmt.close();
				cnx.commit();

				return article;
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();

		}

		return null;
	}

	@Override
	public Article insert(Article article) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt = insertUpdatePreparedStatement(article, pstmt);
				
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					article.setNoArticle(rs.getInt(1));
				}
				rs.close();
				pstmt.close();
				cnx.commit();
				return article;
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();

		}

		return null;
	}

	@Override
	public void delete(int id) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
				preparedStatement.setInt(1, id);
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				connection.close();
				throw e;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private PreparedStatement insertUpdatePreparedStatement(Article article, PreparedStatement pstmt) throws SQLException {
		int miseAPrix = null == article.getMiseAPrix() ? 0 : article.getMiseAPrix();

		pstmt.setString(1, article.getNomArticle().trim());
		pstmt.setString(2, article.getDescription().trim());
		pstmt.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
		pstmt.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
		pstmt.setInt(5, miseAPrix);
		pstmt.setInt(6, article.getVendeur().getNoUtilisateur());
		pstmt.setInt(7, article.getCategorie().getNoCategorie());
		
		if (null != article.getNoArticle()) {
			pstmt.setInt(8, article.getNoArticle());
		}
		
		return pstmt;
	}
	
	private Article createArticleFromResulSet(ResultSet rs) throws SQLException {
		Article article = new Article();
		article.setNoArticle(rs.getInt("no_article"));
		article.setNomArticle(rs.getString("nom_article"));
		article.setDescription(rs.getString("description"));
		article.setDateDebutEncheres(LocalDate.parse(rs.getString("date_debut_encheres")));
		article.setDateFinEncheres(LocalDate.parse(rs.getString("date_fin_encheres")));
		article.setMiseAPrix(rs.getInt("prix_initial"));
		article.setPrixVente(rs.getInt("prix_vente"));
		
		Utilisateur vendeur = new Utilisateur();
		vendeur.setNoUtilisateur(rs.getInt("no_utilisateur"));
		article.setVendeur(vendeur);

		Categorie categorie = new Categorie();
		categorie.setNoCategorie(rs.getInt("no_categorie"));
		article.setCategorie(categorie);
		
		return article;
	}
}
