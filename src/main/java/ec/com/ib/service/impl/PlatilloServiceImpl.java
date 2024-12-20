package ec.com.ib.service.impl;

import ec.com.ib.model.entity.Platillo;
import ec.com.ib.repository.PlatilloRepository;
import ec.com.ib.service.IPlatilloService;
import java.util.List;

public class PlatilloServiceImpl implements IPlatilloService{
    
    private PlatilloRepository platilloRepository;

    @Override
    public List<Platillo> listar() {
       return platilloRepository.findAll();
    }

    @Override
    public Platillo guardar(Platillo platillo) {
       return platilloRepository.save(platillo);
    }

    @Override
    public Platillo editar(Platillo platillo) {
        return platilloRepository.update(platillo);
    }

    @Override
    public void eliminar(Platillo platillo) {
        platilloRepository.delete(platillo);
    }
    
}
