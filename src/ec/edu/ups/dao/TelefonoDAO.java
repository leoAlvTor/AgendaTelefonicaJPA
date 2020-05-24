package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.modelo.Telefono;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer>{

	Telefono findByNumberAndID(String number, String ID);
	
	List<Telefono> findByID(String ID);
	
}
