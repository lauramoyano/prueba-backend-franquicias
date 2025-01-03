package com.prueba.backend.infrastructure.endpoints;

import com.prueba.backend.application.dto.FranquiciaDto;
import com.prueba.backend.application.handler.IFranquiciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.prueba.backend.infrastructure.utils.Constantes.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(PATH_FRANQUICIA)
public class FranquiciaController {


    private final IFranquiciaService franquiciaService;


    @PostMapping("/create")
    public ResponseEntity<FranquiciaDto> createFranquicia(@RequestBody FranquiciaDto franquiciaDto) {
        return ResponseEntity.ok(franquiciaService.createFranquicia(franquiciaDto));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<FranquiciaDto> updateFranquicia(@PathVariable Long id, @RequestParam String nombre) {
        return ResponseEntity.ok(franquiciaService.cambiarNombreFranquicia(id, nombre));
    }

}
