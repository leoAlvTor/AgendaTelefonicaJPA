package ec.edu.ups.dao;

import java.util.Set;

import ec.edu.ups.modelo.Telefono;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer>{

	public abstract Telefono findByNumberAndID(String number, String ID);
	
	public abstract Set<Telefono> findByID(String ID);
	
}
