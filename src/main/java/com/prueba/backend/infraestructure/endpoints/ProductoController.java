package com.prueba.backend.infraestructure.endpoints;

import com.prueba.backend.application.dto.ProductoDto;
import com.prueba.backend.application.handler.impl.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.prueba.backend.infraestructure.utils.Constantes.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(PATH_SUCURSAL)
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping("/create")
    public ResponseEntity<ProductoDto> createProducto(ProductoDto productoDto) {
        return ResponseEntity.ok(productoService.createProducto(productoDto));
    }

    @PatchMapping("/name/{id}")
    public ResponseEntity<ProductoDto> updateProducto(@PathVariable Long id, @RequestParam String nombre) {
        return ResponseEntity.ok(productoService.cambiarNombreProducto(id, nombre));
    }

    @PatchMapping("/stock/{id}")
    public ResponseEntity<ProductoDto> updateStock(@PathVariable Long id, @RequestParam Integer stock) {
        return ResponseEntity.ok(productoService.cambiarStockProducto(id, stock));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productoService.deleteProduct(id);
    }
}
