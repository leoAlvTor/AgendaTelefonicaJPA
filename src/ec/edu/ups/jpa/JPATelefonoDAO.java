package ec.edu.ups.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, Integer> implements TelefonoDAO{

	public JPATelefonoDAO() {
		super(Telefono.class);
	}

	@Override
	public Telefono findByNumberAndID(String number, String ID) {
		Usuario usuario = JPADAOFactory.getFactory().getUsuarioDAO().read(ID);

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Telefono> criteriaQuery = criteriaBuilder.createQuery(Telefono.class);
		Root<Telefono> telefonoRoot = criteriaQuery.from(Telefono.class);
		List<Predicate> predicateList = new ArrayList<>();
		predicateList.add(criteriaBuilder.equal(telefonoRoot.get("numero"), number));
		predicateList.add(criteriaBuilder.equal(telefonoRoot.get("usuario"), usuario));

		criteriaQuery.select(telefonoRoot).where(predicateList.toArray(new Predicate[]{}));
		try {
			return entityManager.createQuery(criteriaQuery).getSingleResult();
		}catch (NoResultException noResultException){
			return new Telefono();
		}
	}

	@Override
	public List<Telefono> findByID(String ID) {
		List<Telefono> telefonoList = new ArrayList<>();
		Usuario usuario = JPADAOFactory.getFactory().getUsuarioDAO().read(ID);

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Telefono> criteriaQuery = criteriaBuilder.createQuery(Telefono.class);
		Root<Telefono> telefonoRoot = criteriaQuery.from(Telefono.class);

		Predicate predicate = criteriaBuilder.equal(telefonoRoot.get("usuario"), usuario);

		criteriaQuery.select(telefonoRoot).where(predicate);
		try {
			return entityManager.createQuery(criteriaQuery).getResultList();
		}catch (NoResultException noResultException){
			return telefonoList;
		}
	}

	
	
}
