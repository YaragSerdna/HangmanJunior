package co.edu.poli.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * La clase Partida gestiona la lógica principal del juego "Hangman Junior".
 * Se encarga de manejar la lista de palabras, los turnos de los jugadores, 
 * el estado actual del juego y las condiciones para finalizar la partida.
 */
public class Partida {

    // Atributos

    /**
     * Lista de palabras disponibles para la partida.
     */
    private List<Palabra> listaDePalabras;

    /**
     * Lista de jugadores que participan en la partida.
     */
    private List<Jugador> listaDeJugadores;

    /**
     * Palabra actual seleccionada para el turno en curso.
     */
    private Palabra palabraActual;

    /**
     * Índice del jugador que tiene el turno actual.
     */
    private int indiceJugadorActual;

    /**
     * Estado del juego, indica si la partida está en curso o ha finalizado.
     */
    private boolean partidaEnCurso;

    // Constructor

    /**
     * Constructor de la clase Partida.
     * Inicializa la lista de palabras y jugadores, y configura el estado inicial de la partida.
     */
    public Partida() {
        this.listaDePalabras = new ArrayList<>();
        this.listaDeJugadores = new ArrayList<>();
        this.partidaEnCurso = true; // La partida inicia activa por defecto
        this.indiceJugadorActual = 0; // El primer jugador comienza
    }

    // Métodos principales

    /**
     * Agrega una palabra a la lista de palabras disponibles para la partida.
     *
     * @param palabra Palabra a añadir a la lista.
     */
    public void agregarPalabra(Palabra palabra) {
        listaDePalabras.add(palabra);
    }

    /**
     * Agrega un jugador a la lista de jugadores participantes.
     *
     * @param jugador Jugador a añadir a la lista.
     */
    public void agregarJugador(Jugador jugador) {
        listaDeJugadores.add(jugador);
    }

    /**
     * Selecciona una palabra aleatoria de la lista de palabras para el turno actual.
     * 
     * @return La palabra seleccionada.
     */
    public Palabra seleccionarPalabraAleatoria() {
        if (listaDePalabras.isEmpty()) {
            throw new IllegalStateException("La lista de palabras está vacía.");
        }
        Random random = new Random();
        palabraActual = listaDePalabras.get(random.nextInt(listaDePalabras.size()));
        return palabraActual;
    }

    /**
     * Cambia el turno al siguiente jugador.
     */
    public void cambiarTurno() {
        indiceJugadorActual = (indiceJugadorActual + 1) % listaDeJugadores.size();
    }

    /**
     * Registra puntos para el jugador actual.
     *
     * @param puntos Cantidad de puntos a sumar.
     */
    public void registrarPuntosParaJugadorActual(int puntos) {
        Jugador jugadorActual = listaDeJugadores.get(indiceJugadorActual);
        jugadorActual.sumarPuntos(puntos);
    }

    /**
     * Verifica si las condiciones para finalizar la partida se han cumplido.
     *
     * @return true si la partida ha finalizado, false en caso contrario.
     */
    public boolean verificarFinDeLaPartida() {
        // Ejemplo: la partida termina cuando se usan todas las palabras
        if (listaDePalabras.isEmpty()) {
            partidaEnCurso = false;
        }
        return !partidaEnCurso;
    }

    // Métodos de acceso

    /**
     * Obtiene el jugador que tiene el turno actual.
     * 
     * @return Jugador actual.
     */
    public Jugador obtenerJugadorActual() {
        return listaDeJugadores.get(indiceJugadorActual);
    }

    /**
     * Obtiene el estado actual de la partida.
     * 
     * @return true si la partida está en curso, false si ha finalizado.
     */
    public boolean isPartidaEnCurso() {
        return partidaEnCurso;
    }

    // Documentación para pruebas unitarias
    // ----------------------------------------------------------
    // 1. Validar la selección de palabras.
    // 2. Probar la rotación de turnos.
    // 3. Verificar las condiciones de fin de la partida.
    // ----------------------------------------------------------
}
