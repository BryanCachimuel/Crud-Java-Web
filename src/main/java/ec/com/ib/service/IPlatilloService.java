package ec.com.ib.service;

import ec.com.ib.model.entity.Platillo;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface IPlatilloService {
    
    List<Platillo> listar();
    
    Platillo guardar(Platillo platillo);
    
    Platillo editar(Platillo platillo);
    
    void eliminar(Platillo platillo);
    
    List<Platillo> findAllNombres();
    
}
