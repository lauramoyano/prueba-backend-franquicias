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
@Table(name = TABLA_FRANQUICIA)
public class FranquiciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = FRANQUICIA_ID)
    private Long id;

    @Column(name = NOMBRE, nullable = false)
    private String nombre;

}
