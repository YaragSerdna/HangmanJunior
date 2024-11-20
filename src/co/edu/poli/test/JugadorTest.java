package co.edu.poli.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.poli.modelo.Palabra;

class PalabraTest {

    private Palabra palabra;

    @BeforeEach
    void setUp() {
        // Inicializa la palabra antes de cada prueba
        palabra = new Palabra("gato", "animales");
    }

    @Test
    void testConstructorYEstadoInicial() {
        // Assert
        assertEquals("____", palabra.getEstadoActual(), "El estado inicial debe ser '____'.");
        assertEquals("gato", palabra.getTexto(), "El texto de la palabra debe ser 'gato'.");
        assertEquals("animales", palabra.getCategoria(), "La categoría debe ser 'animales'.");
    }

    @Test
    void testValidarLetraCorrecta() {
        // Act
        boolean resultado = palabra.validarLetra('g');

        // Assert
        assertTrue(resultado, "La letra 'g' debería estar en la palabra.");
        assertEquals("g___", palabra.getEstadoActual(), "El estado actual debería actualizarse correctamente.");
    }

    @Test
    void testValidarLetraIncorrecta() {
        // Act
        boolean resultado = palabra.validarLetra('z');

        // Assert
        assertFalse(resultado, "La letra 'z' no debería estar en la palabra.");
        assertEquals("____", palabra.getEstadoActual(), "El estado actual no debería cambiar.");
    }

    @Test
    void testPalabraAdivinadaParcialmente() {
        // Arrange
        palabra.validarLetra('g');
        palabra.validarLetra('a');

        // Act
        boolean adivinada = palabra.palabraAdivinada();

        // Assert
        assertFalse(adivinada, "La palabra no debería considerarse adivinada aún.");
        assertEquals("ga__", palabra.getEstadoActual(), "El estado actual debería ser 'ga__'.");
    }

    @Test
    void testPalabraCompletamenteAdivinada() {
        // Arrange
        palabra.validarLetra('g');
        palabra.validarLetra('a');
        palabra.validarLetra('t');
        palabra.validarLetra('o');

        // Act
        boolean adivinada = palabra.palabraAdivinada();

        // Assert
        assertTrue(adivinada, "La palabra debería considerarse completamente adivinada.");
        assertEquals("gato", palabra.getEstadoActual(), "El estado actual debería coincidir con la palabra original.");
    }

    @Test
    void testToString() {
        // Assert
        String esperado = "Palabra [texto=gato, categoria=animales, estadoActual=____]";
        assertEquals(esperado, palabra.toString(), "El método toString no devuelve el formato esperado.");
    }
}
