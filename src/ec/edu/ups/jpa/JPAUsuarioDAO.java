package ec.edu.ups.jpa;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO{
	protected EntityManager entityManager;

	public JPAUsuarioDAO() {
		super(Usuario.class);
		this.entityManager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	}

	@Override
	public boolean verifyUser(String usuario, String password) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> usuarioRoot = criteriaQuery.from(Usuario.class);
		// List of predicates
		List<Predicate> predicateList = new ArrayList<>();
		predicateList.add(criteriaBuilder.equal(usuarioRoot.get("correo"), usuario));
		predicateList.add(criteriaBuilder.equal(usuarioRoot.get("contrasena"), password));

		criteriaQuery.select(usuarioRoot).where(predicateList.toArray(new Predicate[]{}));
		int resultSize = entityManager.createQuery(criteriaQuery).getResultList().size();

		return resultSize > 0;
	}

	@Override
	public String getID(String mail) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);

		Root<Usuario> usuarioRoot = criteriaQuery.from(Usuario.class);
		Predicate predicate = criteriaBuilder.equal(usuarioRoot.get("correo"), mail);
		criteriaQuery.select(usuarioRoot).where(predicate);
		Usuario usuario = null;
		try{
			usuario = entityManager.createQuery(criteriaQuery).getSingleResult();
			return usuario.getCedula();
		}catch (NoResultException e){
			System.out.println("NO RESULT COULD BE RETRIEVED");
			return "";
		}
	} 

}
