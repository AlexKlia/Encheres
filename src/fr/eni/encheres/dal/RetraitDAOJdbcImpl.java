package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import fr.eni.encheres.bo.Retrait;

public class RetraitDAOJdbcImpl implements RetraitDAO {
	private static final String SELECT_BY_ID = "SELECT * FROM RETRAITS WHERE no_article=?";
	private static final String INSERT_RETRAIT = "INSERT INTO RETRAITS(rue, code_postal, ville, no_article) values (?,?,?,?)";
	private static final String UPDATE_RETRAIT = "UPDATE RETRAITS SET rue=?, code_postal=?, ville=? WHERE no_article=?";
	private static final String DELETE_BY_ID = "DELETE FROM RETRAITS WHERE no_article=?";

	@Override
	public Retrait insert(Retrait retrait) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt = insertUpdatePreparedStatement(retrait, pstmt);
				pstmt.executeUpdate();

				ResultSet rs = pstmt.getGeneratedKeys();	
				if (rs.next()) {
					retrait.setNoArticle(rs.getInt(1));
				}
				rs.close();
				pstmt.close();
				cnx.commit();
				System.out.println("RetraitDAO " + retrait);
				return retrait;
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
	public Retrait selectById(int id) throws DALException {
		Retrait retrait = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					retrait = createRetraitFromResulSet(rs);
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

		return retrait;
	}

	@Override
	public Retrait update(Retrait article) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(UPDATE_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
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
	public List<Retrait> selectAll() throws DALException {
		// TODO Auto-generated method stub
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
	
	private PreparedStatement insertUpdatePreparedStatement(Retrait retrait, PreparedStatement pstmt) throws SQLException {
		pstmt.setString(1, retrait.getRue().trim());
		pstmt.setString(2, retrait.getCodePostal().trim());
		pstmt.setString(3, retrait.getVille().trim());
		pstmt.setInt(4, retrait.getNoArticle());
		
		return pstmt;
	}
	

	
	private Retrait createRetraitFromResulSet(ResultSet rs) throws SQLException {
		Retrait retrait = new Retrait();
		retrait.setNoArticle(rs.getInt("no_article"));
		retrait.setRue(rs.getString("rue"));
		retrait.setCodePostal(rs.getString("code_postal"));
		retrait.setVille(rs.getString("ville"));
		
		return retrait;
	}
}
