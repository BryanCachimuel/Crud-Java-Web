package ec.com.ib.repository.persistence;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;

/*
    Esta clase abstracta servirá como base para otras clases, entonces esta clase serviría 
    como herencia para otras clases 

    Nota: Al ser una clase abstracta esta no puede ser instanciada 
*/

public abstract class CrudRepository<T> implements Repository<T>{
 
    private final Class<T> entityClass;

    public CrudRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    @PersistenceContext(unitName = "CRUD_PU")
    protected EntityManager em;
    
    protected abstract EntityManager getEntityManager();
    
    @Override
    public List<T> findAll(){
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    @Override
    public T save(T entity){
        getEntityManager().persist(entity);
        return entity;
    }
    
    @Override
    public T update(T entity){
        getEntityManager().merge(entity);
        return entity;
    }
    
    @Override
    public T findById(Object entityId){
        return getEntityManager().find(entityClass, entityId);
    }
    
    @Override
    public void delete(T entity){
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
}
