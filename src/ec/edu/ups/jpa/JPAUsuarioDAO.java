package ec.edu.ups.jpa;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO{
	
	public JPAUsuarioDAO() {
		super(Usuario.class);
	}

	@Override
	public boolean verifyUser(String user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getID(String mail) {
		// TODO Auto-generated method stub
		return null;
	} 

}
