package ec.com.ib.controller;

import ec.com.ib.model.entity.Platillo;
import ec.com.ib.service.IPlatilloService;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import lombok.*;
import org.primefaces.PrimeFaces;

@Getter @Setter
@Named(value = "platilloMB")
@ViewScoped
public class PlatilloController implements Serializable{
    
   @EJB 
   private IPlatilloService platilloService;
   
   private Platillo platillo;
   private List<Platillo> platillos;
   
   public void nuevo(){
       platillo = new Platillo();
   }
   
   public List<Platillo> obtenerPlatillos(){
       return platillos = platilloService.listar();
   }
    
   public void guardar(){
       if(platillo.getIdPlatillo() == null){
           platilloService.guardar(platillo);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Platillo de Comida Rapida Agregado"));
       }
       else{
           platilloService.editar(platillo);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Platillo de Comida Rapida Editado"));
       }
       nuevo();
       PrimeFaces.current().executeScript("PF('dlgPlatilloRegistro').hide()");
       PrimeFaces.current().ajax().update("form:messages","form:dt-platillo");
   }
}
