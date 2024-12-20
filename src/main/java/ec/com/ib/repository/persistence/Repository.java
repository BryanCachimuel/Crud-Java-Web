package ec.com.ib.repository.persistence;

import java.util.List;

/* Los T significa que son una clase genérica */

public interface Repository<T> {
    
    List<T> findAll();
    
    T save(T entity);
    
    T update(T entity);
    
    T findById(Object entityId);
    
    void delete(T entity);
    
}
