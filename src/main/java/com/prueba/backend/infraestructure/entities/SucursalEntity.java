package com.prueba.backend.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.prueba.backend.infraestructure.utils.Constantes.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = TABLA_SUCURSAL)
public class SucursalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = SUCURSAL_ID)
    private Long idProducto;

    @Column(name = NOMBRE, nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = FRANQUICIA_ID, nullable = false)
    private FranquiciaEntity franquicia;



}
