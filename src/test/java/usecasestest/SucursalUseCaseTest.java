package usecasestest;

import com.prueba.backend.domain.models.Franquicia;
import com.prueba.backend.domain.models.Sucursal;
import com.prueba.backend.domain.spi.IFranquiciaPersistencePort;
import com.prueba.backend.domain.spi.ISucursalPersistencePort;
import com.prueba.backend.domain.useCases.SucursalUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SucursalUseCaseTest {

    @Mock
    private ISucursalPersistencePort sucursalPersistencePort;

    @Mock
    private IFranquiciaPersistencePort franquiciaPersistencePort;

    @InjectMocks
    private SucursalUseCase sucursalUseCase;

    @Test
    public void testCreate_ValidSucursal_ShouldReturnSucursal() {
        // Arrange
        Sucursal sucursal = Sucursal.builder().nombre("Sucursal Test").idFranquicia(1L).build();
        Franquicia franquicia = new Franquicia(1L, "Franquicia Test");
        Sucursal sucursalCreada = Sucursal.builder().nombre("Sucursal Test").idFranquicia(1L).build();

        when(franquiciaPersistencePort.obtenerFranquiciaPorId(sucursal.getIdFranquicia())).thenReturn(franquicia);
        when(sucursalPersistencePort.save(any(Sucursal.class))).thenReturn(sucursalCreada);

        // Act
        Sucursal result = sucursalUseCase.create(sucursal);

        // Assert
        assertNotNull(result);
        assertEquals(sucursal.getNombre(), result.getNombre());
        verify(franquiciaPersistencePort, times(1)).obtenerFranquiciaPorId(sucursal.getIdFranquicia());
        verify(sucursalPersistencePort, times(1)).save(any(Sucursal.class));
    }

    @Test
    public void testCreate_InvalidSucursal_ShouldThrowException() {
        // Arrange
        Sucursal sucursal = Sucursal.builder().nombre("").idFranquicia(1L).build();

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sucursalUseCase.create(sucursal);
        });
        assertEquals("El nombre de la sucursal no puede ser nulo o vacío", exception.getMessage());
        verifyNoInteractions(franquiciaPersistencePort, sucursalPersistencePort);
    }

    @Test
    public void testCreate_NonExistentFranquicia_ShouldThrowException() {
        // Arrange
        Sucursal sucursal = Sucursal.builder().nombre("Sucursal Test").idFranquicia(2L).build();

        when(franquiciaPersistencePort.obtenerFranquiciaPorId(sucursal.getIdFranquicia())).thenReturn(null);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sucursalUseCase.create(sucursal);
        });
        assertEquals("La franquicia no existe", exception.getMessage());
        verify(franquiciaPersistencePort, times(1)).obtenerFranquiciaPorId(sucursal.getIdFranquicia());
        verifyNoInteractions(sucursalPersistencePort);
    }

    @Test
    public void testModificarNombre_ValidInputs_ShouldReturnSucursal() {
        // Arrange
        Long idSucursal = 1L;
        String nuevoNombre = "Sucursal Modificada";
        Sucursal sucursalModificada = Sucursal.builder().idSucursal(idSucursal).nombre(nuevoNombre).build();

        when(sucursalPersistencePort.modificarNombre(idSucursal, nuevoNombre)).thenReturn(sucursalModificada);

        // Act
        Sucursal result = sucursalUseCase.modificarNombre(idSucursal, nuevoNombre);

        // Assert
        assertNotNull(result);
        assertEquals(nuevoNombre, result.getNombre());
        verify(sucursalPersistencePort, times(1)).modificarNombre(idSucursal, nuevoNombre);
    }

    @Test
    public void testModificarNombre_InvalidName_ShouldThrowException() {
        // Arrange
        Long idSucursal = 1L;
        String nombreInvalido = "";

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sucursalUseCase.modificarNombre(idSucursal, nombreInvalido);
        });
        assertEquals("El nombre de la sucursal no puede ser nulo o vacío", exception.getMessage());
        verifyNoInteractions(sucursalPersistencePort);
    }
}
