package co.edu.poli.modelo;

/**
 * Clase que representa una palabra dentro del juego.
 */
public class Palabra {

    private String texto;
    private String categoria;
    private String estadoActual;

    /**
     * Constructor para inicializar una palabra con su texto y categoría.
     * 
     * @param texto    Texto de la palabra.
     * @param categoria Categoría de la palabra.
     */
    public Palabra(String texto, String categoria) {
        this.texto = texto;
        this.categoria = categoria != null ? categoria : "Sin categoría";
        this.estadoActual = "_".repeat(texto.length());
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
     * Valida si una letra está en la palabra y actualiza el estado actual.
     * 
     * @param letra Letra a validar.
     * @return true si la letra está en la palabra, false en caso contrario.
     */
    public boolean validarLetra(char letra) {
        boolean encontrada = false;
        StringBuilder nuevoEstado = new StringBuilder(estadoActual);

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == letra) {
                nuevoEstado.setCharAt(i, letra);
                encontrada = true;
            }
        }

        estadoActual = nuevoEstado.toString();
        return encontrada;
    }

    /**
     * Indica si la palabra ha sido adivinada completamente.
     * 
     * @return true si la palabra ha sido adivinada, false en caso contrario.
     */
    public boolean palabraAdivinada() {
        return estadoActual.equals(texto);
    }

    /**
     * Obtiene la categoría de la palabra.
     * 
     * @return Categoría de la palabra.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría de la palabra.
     * 
     * @param categoria Nueva categoría de la palabra.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene el estado actual de la palabra.
     * 
     * @return Estado actual de la palabra.
     */
    public String getEstadoActual() {
        return estadoActual;
    }

    /**
     * Representación en cadena de la palabra.
     * 
     * @return Texto de la palabra, categoría y estado actual.
     */
    @Override
    public String toString() {
        return "Palabra [texto=" + texto + ", categoria=" + categoria + ", estadoActual=" + estadoActual + "]";
    }
}
