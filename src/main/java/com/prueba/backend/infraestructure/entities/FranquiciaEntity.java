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
@Table(name = TABLA_FRANQUICIA)
public class FranquiciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = FRANQUICIA_ID)
    private Long idFranquicia;

    @Column(name = NOMBRE, nullable = false)
    private String nombre;

}
