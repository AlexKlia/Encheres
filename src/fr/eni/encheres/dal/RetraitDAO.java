package fr.eni.encheres.dal;


import fr.eni.encheres.bo.Retrait;

public interface RetraitDAO extends DAO<Retrait> {
	public Retrait insert(Retrait retrait) throws DALException;
	public Retrait selectById(int id) throws DALException;
	public Retrait update(Retrait retrait) throws DALException;
	public void delete(int id) throws DALException;
}
