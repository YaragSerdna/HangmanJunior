package co.edu.poli.modelo;

/**
 * Clase que representa a un jugador en el juego.
 */
public class Jugador {

    private String nombre;
    private int puntos;

    /**
     * Constructor para inicializar un jugador con su nombre.
     * 
     * @param nombre Nombre del jugador.
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0; // Inicialmente, el jugador tiene 0 puntos.
    }

    /**
     * Obtiene el nombre del jugador.
     * 
     * @return Nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del jugador.
     * 
     * @param nombre Nuevo nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los puntos acumulados del jugador.
     * 
     * @return Puntos del jugador.
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Suma puntos al total del jugador.
     * 
     * @param puntos Puntos a agregar.
     */
    public void agregarPuntos(int puntos) {
        this.puntos += puntos;
    }

    /**
     * Representación en cadena del jugador.
     * 
     * @return Información del jugador.
     */
    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + ", puntos=" + puntos + "]";
    }
}
