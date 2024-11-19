package co.edu.poli.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.poli.modelo.Jugador;
import co.edu.poli.modelo.Palabra;
import co.edu.poli.modelo.Partida;

class PartidaTest {

    private Partida partida;

    @BeforeEach
    void setUp() {
        // Inicializa la partida antes de cada prueba
        partida = new Partida();

        // Agrega palabras de prueba
        partida.agregarPalabra(new Palabra("apple"));
        partida.agregarPalabra(new Palabra("orange"));
        partida.agregarPalabra(new Palabra("banana"));

        // Agrega jugadores de prueba
        partida.agregarJugador(new Jugador("Alice"));
        partida.agregarJugador(new Jugador("Bob"));
    }

    @Test
    void testSeleccionarPalabraAleatoria() {
        // Act
        Palabra palabra = partida.seleccionarPalabraAleatoria();

        // Assert
        assertNotNull(palabra, "La palabra seleccionada no debe ser nula.");
        assertTrue(List.of("apple", "orange", "banana").contains(palabra.getTexto()),
                "La palabra seleccionada debe estar en la lista.");
    }

    @Test
    void testCambiarTurno() {
        // Act
        partida.cambiarTurno();
        Jugador jugadorActual = partida.obtenerJugadorActual();

        // Assert
        assertEquals("Bob", jugadorActual.getNombre(), "El siguiente turno debe corresponder a Bob.");
    }

    @Test
    void testRegistrarPuntosParaJugadorActual() {
        // Arrange
        Jugador jugadorInicial = partida.obtenerJugadorActual();

        // Act
        partida.registrarPuntosParaJugadorActual(10);

        // Assert
        assertEquals(10, jugadorInicial.getPuntos(), "El jugador inicial debe tener 10 puntos.");
    }
    /*
    @Test
    void testVerificarFinDeLaPartida() {
        // Act
        while (!partida.verificarFinDeLaPartida()) {
            partida.seleccionarPalabraAleatoria();
            partida.listaDePalabras.remove(partida.palabraActual);
        }

        // Assert
        assertFalse(partida.isPartidaEnCurso(), "La partida debe terminar cuando no hay más palabras.");
    }
    */
}
