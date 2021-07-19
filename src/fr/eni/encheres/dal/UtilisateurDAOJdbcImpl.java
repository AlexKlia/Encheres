package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			      user.setNoUtilisateur( rs.getInt("no_utilisateur"));
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
	public Utilisateur update(Utilisateur data) throws DALException {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public Utilisateur insert(Utilisateur utilisateur) throws DALException {
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
				return utilisateur;
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();

		}
		return utilisateur;
	}

	@Override
	public void delete(int id) throws DALException {
		

	}

	@Override
	public Utilisateur selectIdentifiant(String id, String mdp ) {
		Utilisateur u = null;
		 try(Connection cnx = ConnectionProvider.getConnection())
		 {
		 PreparedStatement pstmt = cnx.prepareStatement(SELECT_IDENTIFIANT);
		 pstmt.setString(1,id);
		 pstmt.setString(2,mdp);
		 ResultSet rs = pstmt.executeQuery();
		 
		if(rs.next()) {
			
			System.out.println("Connexion etablie");
			u = new Utilisateur (rs.getInt("no_utilisateur"),
					rs.getString("pseudo"),
					rs.getString("nom"),
					rs.getString("prenom"),
					rs.getString("email"),
					rs.getString("telephone"),
					rs.getString("rue"),
					rs.getString("code_postal"),
					rs.getString("ville"),
					rs.getString("mot_de_passe"),
					rs.getInt("credit"),
					rs.getBoolean("administrateur"));
			
			} else {
				String message = "Le combo pseudo et mdp n'est pas valide";
//		throw new UserNotFoundException(message);
			}

		
		 } catch (SQLException e) {
//		 e.printStackTrace();
		 }
		
		return u;
	}
	
//	private Utilisateur utilisateurBuilder(ResultSet rs) throws SQLException {
//		Utilisateur utilisateurCourant;
//		utilisateurCourant = new Utilisateur();
//		utilisateurCourant.setPseudo(rs.getString("pseudo"));
//		// a remplir
//		return utilisateurCourant;
//	}

}
