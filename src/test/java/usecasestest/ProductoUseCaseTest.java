package usecasestest;

import com.prueba.backend.domain.models.Producto;
import com.prueba.backend.domain.models.Sucursal;
import com.prueba.backend.domain.spi.IProductoPersistencePort;
import com.prueba.backend.domain.spi.ISucursalPersistencePort;
import com.prueba.backend.domain.useCases.ProductoUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductoUseCaseTest {

    @Mock
    private IProductoPersistencePort productoPersistencePort;

    @Mock
    private ISucursalPersistencePort sucursalPersistencePort;

    @InjectMocks
    private ProductoUseCase productoUseCase;

    @Test
    public void testCreate_ValidProducto_ShouldReturnProducto() {
        // Arrange
        Producto producto = Producto.builder().nombre("Producto Test").stock(10).idSucursal(1L).build();
        Sucursal sucursal = new Sucursal(1L, "Sucursal Test", 1L);
        Producto productoCreado = Producto.builder().nombre("Producto Test").stock(10).idSucursal(1L).build();

        when(sucursalPersistencePort.obtenerSucursalPorId(producto.getIdSucursal())).thenReturn(sucursal);
        when(productoPersistencePort.save(any(Producto.class))).thenReturn(productoCreado);

        // Act
        Producto result = productoUseCase.create(producto);

        // Assert
        assertNotNull(result);
        assertEquals(producto.getNombre(), result.getNombre());
        verify(sucursalPersistencePort, times(1)).obtenerSucursalPorId(producto.getIdSucursal());
        verify(productoPersistencePort, times(1)).save(any(Producto.class));
    }

    @Test
    public void testCreate_InvalidProducto_ShouldThrowException() {
        // Arrange
        Producto producto = Producto.builder().nombre("").stock(-1).idSucursal(null).build();

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            productoUseCase.create(producto);
        });
        assertEquals("Los campos del producto no pueden ser nulos o vacíos", exception.getMessage());
        verifyNoInteractions(sucursalPersistencePort, productoPersistencePort);
    }

    @Test
    public void testModificarStock_ValidInputs_ShouldReturnProducto() {
        // Arrange
        Long idProducto = 1L;
        int nuevaCantidad = 20;
        Producto productoModificado = Producto.builder().idProducto(idProducto).stock(nuevaCantidad).build();

        when(productoPersistencePort.modificarStock(idProducto, nuevaCantidad)).thenReturn(productoModificado);

        // Act
        Producto result = productoUseCase.modificarStock(idProducto, nuevaCantidad);

        // Assert
        assertNotNull(result);
        assertEquals(nuevaCantidad, result.getStock());
        verify(productoPersistencePort, times(1)).modificarStock(idProducto, nuevaCantidad);
    }

    @Test
    public void testModificarStock_NegativeStock_ShouldThrowException() {
        // Arrange
        Long idProducto = 1L;
        int cantidad = -5;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            productoUseCase.modificarStock(idProducto, cantidad);
        });
        assertEquals("La cantidad de stock del producto no puede ser nula o negativa", exception.getMessage());
        verifyNoInteractions(productoPersistencePort);
    }

    @Test
    public void testEliminarProducto_ShouldReturnProducto() {
        // Arrange
        Long idProducto = 1L;
        Producto productoEliminado = Producto.builder().idProducto(idProducto).build();

        when(productoPersistencePort.eliminarProducto(idProducto)).thenReturn(productoEliminado);

        // Act
        Producto result = productoUseCase.eliminarProducto(idProducto);

        // Assert
        assertNotNull(result);
        assertEquals(idProducto, result.getIdProducto());
        verify(productoPersistencePort, times(1)).eliminarProducto(idProducto);
    }

    @Test
    public void testListarProductosConMasStockPorFranquicia_ShouldReturnProductos() {
        // Arrange
        Long idFranquicia = 1L;
        Sucursal sucursal1 = new Sucursal(1L, "Sucursal 1", idFranquicia);
        Sucursal sucursal2 = new Sucursal(2L, "Sucursal 2", idFranquicia);
        Producto producto1 = Producto.builder().idProducto(1L).nombre("Producto 1").stock(50).build();
        Producto producto2 = Producto.builder().idProducto(2L).nombre("Producto 2").stock(30).build();

        when(sucursalPersistencePort.findByFranquiciaId(idFranquicia)).thenReturn(Arrays.asList(sucursal1, sucursal2));
        when(productoPersistencePort.findProductoConMasStockPorSucursal(sucursal1.getIdSucursal())).thenReturn(producto1);
        when(productoPersistencePort.findProductoConMasStockPorSucursal(sucursal2.getIdSucursal())).thenReturn(producto2);

        // Act
        List<Producto> result = productoUseCase.listarProductosConMasStockPorFranquicia(idFranquicia);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(sucursalPersistencePort, times(1)).findByFranquiciaId(idFranquicia);
        verify(productoPersistencePort, times(2)).findProductoConMasStockPorSucursal(anyLong());
    }

    @Test
    public void testModificarNombre_ValidInputs_ShouldReturnProducto() {
        // Arrange
        Long idProducto = 1L;
        String nuevoNombre = "Nuevo Producto";
        Producto productoModificado = Producto.builder().idProducto(idProducto).nombre(nuevoNombre).build();

        when(productoPersistencePort.modificarNombre(idProducto, nuevoNombre)).thenReturn(productoModificado);

        // Act
        Producto result = productoUseCase.modificarNombre(idProducto, nuevoNombre);

        // Assert
        assertNotNull(result);
        assertEquals(nuevoNombre, result.getNombre());
        verify(productoPersistencePort, times(1)).modificarNombre(idProducto, nuevoNombre);
    }
}
