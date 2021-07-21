package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private static final String SELECT_ALL = "select no_utilisateur, no_article, date_enchere, montant_enchere from Encheres";
	private static final String SELECT_BY_ID = "select top 1 nom_article, montant_enchere, date_debut_encheres, date_fin_encheres, date_enchere, e.no_utilisateur" + 
			"	from Encheres e inner join Utilisateurs u on e.no_utilisateur = u.no_utilisateur" + 
			"					inner join Articles_vendus a on e.no_article = a.no_article" + 
			"					where a.no_article = ?" + 
			"					order by montant_enchere desc";
	
	@Override
	public List<Enchere> selectAll() throws DALException {
		List<Enchere> encheres = new ArrayList<Enchere>();
/*		Enchere enchere = null;
		
		try {
			Connection con = ConnectionProvider.getConnection(); 
			
			
			try {
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery(SELECT_ALL);
				
				while (rs.next()) {
					enchere = new Enchere(rs.getInt("no_utilisateur"), rs.getInt("no_article"), rs.getDate("date_enchere").toLocalDate(), rs.getInt("montant_enchere"));
					encheres.add(enchere);
			} 
				rs.close();                       
				stmt.close();
				con.close();
			}	
				catch (Exception e) {
				e.printStackTrace();
				con.close();
				throw e;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
*/
		return encheres;
	}

	
	@Override
	public Enchere selectById(int id) throws DALException {
		
		Enchere enchere = null;
		try (Connection con = ConnectionProvider.getConnection()) {
			try {
				PreparedStatement prpstm = con.prepareStatement(SELECT_BY_ID);
				prpstm.setInt(1, id);
				ResultSet rs = prpstm.executeQuery();
				
				while (rs.next()) {
					
					enchere = new Enchere();
					
					Utilisateur acheteur = new Utilisateur();
					acheteur.setNoUtilisateur(rs.getInt("no_utilisateur"));
					enchere.setAcheteur(acheteur);
					
					Article article = new Article();
					article.setNoArticle(id);
					article.setNomArticle(rs.getString("nom_article"));
					article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
					article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
					enchere.setArticle(article);
					
					enchere.setDateEnchere(rs.getDate("date_enchere").toLocalDate());
					enchere.setMontantEnchere(rs.getInt("montant_enchere"));
					
					
					
				}
				rs.close();                       
				prpstm.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
				con.close();
				throw e;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return enchere;

	}

	@Override
	public Enchere update(Enchere data) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enchere insert(Enchere data) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub

	}

}
