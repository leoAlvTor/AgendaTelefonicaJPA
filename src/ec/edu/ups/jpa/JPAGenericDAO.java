package ec.edu.ups.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ec.edu.ups.dao.GenericDAO;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {
	private final Class<T> persistentClass;
	protected EntityManager entityManager;
	
	public JPAGenericDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		this.entityManager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	}

	@Override
	public boolean create(T entidad) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(entidad);
			System.out.println(entidad.toString());
			entityManager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			System.out.println("Error al crear JPAGenericDAO:create: " + e.getMessage());
			if(entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			return false;
		}
	}

	@Override
	public T read(ID id) {
		return entityManager.find(persistentClass, id);
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public List<T> readAll() {
		entityManager.getTransaction().begin();
		List<T> list = null;
		try{
			javax.persistence.criteria.CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
			criteriaQuery.select(criteriaQuery.from(persistentClass));
			list = entityManager.createQuery(criteriaQuery).getResultList();
			entityManager.getTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public boolean update(T entity) {
		entityManager.getTransaction().begin();
		try {
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			System.out.println("Error al actualizar JPAGenericDAO:update: " + e.getMessage());
			if(entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			return false;
		}
	}

	@Override
	public boolean delete(T entity) {
		entityManager.getTransaction().begin();
		try {
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			System.out.println("Error al eliminar JPAGenericDAO:delete: " + e.getMessage());
			if(entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			return false;
		}
	}

	@Override
	public boolean deleteByID(ID id) {
		T entity = this.read(id);
		if(entity != null)
			return this.delete(entity);
		else
			return false;
	}

	

}
