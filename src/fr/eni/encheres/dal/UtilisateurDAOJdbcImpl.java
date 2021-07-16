package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private static final String SELECT_ALL = "select * from utilisateurs";
	private static final String INSERT_UTILISATEUR = "insert into UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit,administrateur) values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_IDENTIFIANT = "select * from UTILISATEURS where pseudo=? AND mot_de_passe=?";
	private static final String SELECT_BY_ID = "select * from UTILISATEURS where no_utilisateur=?";

	@Override
	public Utilisateur selectById(int no_utilisateur) throws DALException {
		Utilisateur user = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
				preparedStatement.setInt(1, no_utilisateur);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
				  user = new Utilisateur();
			      user.setPseudo( rs.getString("pseudo"));
			      user.setNom( rs.getString("nom"));
			      user.setPrenom( rs.getString("prenom"));
			      user.setEmail( rs.getString("email"));
			      user.setTelephone( rs.getString("telephone"));
			      user.setRue( rs.getString("rue"));
			      user.setCodePostal( rs.getString("code_postal"));
			      user.setVille( rs.getString("ville"));
			      user.setMotDePasse( rs.getString("mot_de_passe"));
			      user.setCredit( rs.getInt("credit"));
			      user.setAdministrateur( rs.getBoolean("administrateur"));
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

		return user;
	}

	@Override
	public List<Utilisateur> selectAll() throws DALException {
		// List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
		// try(Connection cnx = ConnectionProvider.getConnection()) {
		// PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
		// ResultSet rs = pstmt.executeQuery();
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		return null;
	}

	@Override
	public void update(Utilisateur data) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(Utilisateur utilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR,
						PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getNom());
				pstmt.setString(3, utilisateur.getPrenom());
				pstmt.setString(4, utilisateur.getEmail());
				pstmt.setString(5, utilisateur.getTelephone());
				pstmt.setString(6, utilisateur.getRue());
				pstmt.setString(7, utilisateur.getCodePostal());
				pstmt.setString(8, utilisateur.getVille());
				pstmt.setString(9, utilisateur.getMotDePasse());
				pstmt.setInt(10, utilisateur.getCredit());
				pstmt.setBoolean(11, utilisateur.isAdministrateur());
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt(1));
				}
				rs.close();
				pstmt.close();
				cnx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();

		}
	}

	@Override
	public void delete(Utilisateur obj) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Utilisateur> selectIdentifiant() throws DALException {
		// List<Utilisateur> listeUtilisateurIdentifiant = new ArrayList<Utilisateur>();
		// try(Connection cnx = ConnectionProvider.getConnection())
		// {
		// PreparedStatement pstmt = cnx.prepareStatement(SELECT_IDENTIFIANT);
		//
		//
		// } catch (SQLException e) {
		//
		// e.printStackTrace();
		// }
		//
		return null;
	}

}
