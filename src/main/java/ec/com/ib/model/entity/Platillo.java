package ec.com.ib.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "platillo")
public class Platillo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_platillo")
    private Integer IdPlatillo;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "precio")
    private double precio;
    
}
