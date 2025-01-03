package usecasestest;

import com.prueba.backend.domain.models.Franquicia;
import com.prueba.backend.domain.spi.IFranquiciaPersistencePort;
import com.prueba.backend.domain.useCases.FranquiciaUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FranquiciaUseCaseTest {

    @Mock
    private IFranquiciaPersistencePort franquiciaPersistencePort;

    @InjectMocks
    private FranquiciaUseCase franquiciaUseCase;

    @Test
    public void testCreate_ValidFranquicia_ShouldReturnFranquicia() {
        // Arrange
        Franquicia franquicia = Franquicia.builder().nombre("Franquicia Test").build();
        Franquicia franquiciaCreada = Franquicia.builder().nombre("Franquicia Test").build();

        when(franquiciaPersistencePort.save(any(Franquicia.class))).thenReturn(franquiciaCreada);

        Franquicia result = franquiciaUseCase.create(franquicia);

        assertNotNull(result);
        assertEquals(franquicia.getNombre(), result.getNombre());
        verify(franquiciaPersistencePort, times(1)).save(any(Franquicia.class));
    }

    @Test
    public void testCreate_NullNombre_ShouldThrowException() {
        Franquicia franquicia = Franquicia.builder().nombre(null).build();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            franquiciaUseCase.create(franquicia);
        });
        assertEquals("El nombre de la franquicia no puede ser nulo o vacío", exception.getMessage());
        verifyNoInteractions(franquiciaPersistencePort);
    }

    @Test
    public void testModificarNombre_ValidInputs_ShouldReturnModifiedFranquicia() {
        Long idFranquicia = 1L;
        String nuevoNombre = "Nuevo Nombre";
        Franquicia franquiciaModificada = Franquicia.builder().nombre(nuevoNombre).build();

        when(franquiciaPersistencePort.modificarNombre(idFranquicia, nuevoNombre)).thenReturn(franquiciaModificada);

        Franquicia result = franquiciaUseCase.modificarNombre(idFranquicia, nuevoNombre);

        assertNotNull(result);
        assertEquals(nuevoNombre, result.getNombre());
        verify(franquiciaPersistencePort, times(1)).modificarNombre(idFranquicia, nuevoNombre);
    }

    @Test
    public void testModificarNombre_NullNombre_ShouldThrowException() {
        Long idFranquicia = 1L;
        String nuevoNombre = null;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            franquiciaUseCase.modificarNombre(idFranquicia, nuevoNombre);
        });
        assertEquals("El nombre de la franquicia no puede ser nulo o vacío", exception.getMessage());
        verifyNoInteractions(franquiciaPersistencePort);
    }
}
