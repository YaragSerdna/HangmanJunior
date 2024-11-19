package co.edu.poli.modelo;

/**
 * Clase que representa una palabra dentro del juego.
 */
public class Palabra {

    private String texto;

    /**
     * Constructor para inicializar una palabra con su texto.
     * 
     * @param texto Texto de la palabra.
     */
    public Palabra(String texto) {
        this.texto = texto;
    }

    /**
     * Obtiene el texto de la palabra.
     * 
     * @return Texto de la palabra.
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Establece el texto de la palabra.
     * 
     * @param texto Nuevo texto de la palabra.
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Representación en cadena de la palabra.
     * 
     * @return Texto de la palabra.
     */
    @Override
    public String toString() {
        return "Palabra [texto=" + texto + "]";
    }
}
