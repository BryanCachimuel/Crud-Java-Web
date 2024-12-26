package ec.com.ib.repository;

import ec.com.ib.model.entity.Platillo;
import ec.com.ib.repository.persistence.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

@Stateless
public class PlatilloRepository extends CrudRepository<Platillo>{

    public PlatilloRepository() {
        super(Platillo.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    
    
    public List<Platillo> findAllNombre(){
        Query query = em.createQuery("SELECT p FROM Platillo p WHERE p.nombre LIKE '%S%'");
        return query.getResultList();
    }
    
    public List<Platillo> findAllDescripcion(){
        Query query = em.createQuery("SELECT p FROM Platillo p WHERE p.descripcion LIKE '%C%'");
        return query.getResultList();
    }
    
    public List<Platillo> findAllPrecio(){
        Query query = em.createQuery("SELECT p FROM Platillo p WHERE p.precio < 1 ");
        return query.getResultList();
    }
    
}
