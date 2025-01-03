package com.prueba.backend.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.prueba.backend.infrastructure.utils.Constantes.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = TABLA_PRODUCTO)
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = PRODUCTO_ID)
    private Long id;

    @Column(name = NOMBRE, nullable = false)
    private String nombre;

    @Column(name = STOCK, nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = SUCURSAL_ID, nullable = false)
    private SucursalEntity sucursal;


}
