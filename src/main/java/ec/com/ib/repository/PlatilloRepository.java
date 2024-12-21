package ec.com.ib.repository;

import ec.com.ib.model.entity.Platillo;
import ec.com.ib.repository.persistence.CrudRepository;
import jakarta.persistence.EntityManager;

public class PlatilloRepository extends CrudRepository<Platillo>{

    public PlatilloRepository() {
        super(Platillo.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    
}
