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

	@Override
	public Utilisateur selectById(Utilisateur obj) throws DALException {
		// TODO Auto-generated method stub
		return null;
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
	public Utilisateur selectIdentifiant(Utilisateur utilisateurIdentifier) {
		Utilisateur u = null;
		 try(Connection cnx = ConnectionProvider.getConnection())
		 {
		 PreparedStatement pstmt = cnx.prepareStatement(SELECT_IDENTIFIANT);
		 pstmt.setString(1,utilisateurIdentifier.getPseudo());
		 pstmt.setString(2,utilisateurIdentifier.getMotDePasse());
		 ResultSet rs = pstmt.executeQuery();
		 
		if(rs.next()) {
			
			System.out.println("Connexion etablie");
			u = new Utilisateur (rs.getString("pseudo"),
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
				throw new UserNotFoundException(message);
			}

		
		 } catch (SQLException e) {
			 System.out.println("Impossible de se connecter au formulaire");
		 e.printStackTrace();
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
