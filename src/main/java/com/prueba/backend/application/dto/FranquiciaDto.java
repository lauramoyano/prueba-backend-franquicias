package com.prueba.backend.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.prueba.backend.application.utils.Constants.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FranquiciaDto {

    @NotBlank(message =  NOMBRE_NOT_FOUND)
    private String nombre;
}
