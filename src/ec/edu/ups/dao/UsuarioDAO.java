package ec.edu.ups.dao;

import ec.edu.ups.modelo.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, String>{
	
	boolean verifyUser(String user, String password);
	
	String getID(String mail);
	
}
