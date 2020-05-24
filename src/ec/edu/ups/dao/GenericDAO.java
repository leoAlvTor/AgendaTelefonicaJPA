package ec.edu.ups.dao;


import java.util.List;

public interface GenericDAO<T, ID> {
	
	public boolean create(T entidad);
	
	public T read(ID id);

	public List<T> readAll();
	
	public boolean update(T entity);
	
	public boolean delete(T entity);
	
	public boolean deleteByID(ID id);

	
}
