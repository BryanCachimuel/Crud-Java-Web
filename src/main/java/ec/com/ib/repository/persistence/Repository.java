package ec.com.ib.repository.persistence;

import jakarta.ejb.Local;
import java.util.List;

/* Los T significa que son una clase genérica */

@Local
public interface Repository<T> {
    
    List<T> findAll();
    
    T save(T entity);
    
    T update(T entity);
    
    T findById(Object entityId);
    
    void delete(T entity);
    
}
