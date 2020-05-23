package ec.edu.ups.jpa;

import java.util.Set;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.modelo.Telefono;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, Integer> implements TelefonoDAO{

	public JPATelefonoDAO() {
		super(Telefono.class);
	}

	@Override
	public Telefono findByNumberAndID(String number, String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Telefono> findByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
