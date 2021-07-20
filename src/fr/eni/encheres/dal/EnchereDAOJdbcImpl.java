package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private static final String SELECT_ALL = "select no_article, montant_enchere, date_enchere, no_utilisateur from Encheres";
	
	@Override
	public List<Enchere> selectAll() throws DALException {
		List<Enchere> encheres = new ArrayList<Enchere>();
		Enchere enchere = null;

		return encheres;


	}

	@Override
	public Enchere selectById(int i) throws DALException {
		// TODO Auto-generated method stub
		return null;
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
