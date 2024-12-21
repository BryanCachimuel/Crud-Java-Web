package ec.com.ib.service;

import ec.com.ib.model.entity.Platillo;
import java.util.List;

public interface IPlatilloService {
    
    List<Platillo> listar();
    
    Platillo guardar(Platillo platillo);
    
    Platillo editar(Platillo platillo);
    
    Platillo eliminar(Platillo platillo);
    
}
