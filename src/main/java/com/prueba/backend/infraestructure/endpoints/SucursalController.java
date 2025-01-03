package com.prueba.backend.infraestructure.endpoints;

import com.prueba.backend.application.dto.SucursalDto;
import com.prueba.backend.application.handler.impl.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.prueba.backend.infraestructure.utils.Constantes.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(PATH_SUCURSAL)
public class SucursalController {

    private final SucursalService sucursalService;

    @PostMapping("/create")
    public ResponseEntity<SucursalDto> createSucursal(SucursalDto sucursalDto) {
        return ResponseEntity.ok(sucursalService.createSucursal(sucursalDto));
    }

    @PatchMapping("/name/{id}")
    public ResponseEntity<SucursalDto> updateSucursal(@PathVariable Long id, @RequestParam String nombre) {
        return ResponseEntity.ok(sucursalService.cambiarNombreSucursal(id, nombre));
    }


}
