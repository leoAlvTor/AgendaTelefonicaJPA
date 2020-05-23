package ec.edu.ups.dao;


public interface GenericDAO<T, ID> {
	
	public boolean create(T entidad);
	
	public T read(ID id);
	
	public boolean update(T entity);
	
	public boolean delete(T entity);
	
	public boolean deleteByID(ID id);
	
}
