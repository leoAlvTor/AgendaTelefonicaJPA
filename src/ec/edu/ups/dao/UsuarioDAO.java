package ec.edu.ups.dao;

import ec.edu.ups.modelo.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, String>{
	
	public abstract boolean verifyUser(String user, String password);
	
	public abstract String getID(String mail);
	
}
