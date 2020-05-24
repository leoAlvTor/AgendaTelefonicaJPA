import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.jpa.JPADAOFactory;
import ec.edu.ups.jpa.JPATelefonoDAO;
import ec.edu.ups.jpa.JPAUsuarioDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

import java.util.Optional;

public class Min {

	public static void main(String[] args) {
		TelefonoDAO telefonoDAO = JPADAOFactory.getFactory().getTelefonoDAO();

		System.out.println();
	}

	private void create(){
		UsuarioDAO usuarioDAO = JPADAOFactory.getFactory().getUsuarioDAO();

		Usuario u1 = new Usuario("0102324564", "Leo", "Alvarado", "passo", "correo@correo.com", null);
		Telefono telefono = new Telefono(0, "123", "NA", "NA", u1);

		u1.addTelefono(telefono);

		System.out.println(usuarioDAO.create(u1));
	}
}
