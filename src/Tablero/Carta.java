package Tablero;

public abstract class Carta {
    private int numero_de_carta;
    private String descripcion_carta;

    public int getNumero_de_carta() {
        return numero_de_carta;
    }

    public String getDescripcion() {
        return this.descripcion_carta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion_carta = descripcion;
    }

    public Carta (int numero_de_carta){
        this.numero_de_carta = numero_de_carta;
        this.descripcion_carta = "Descripción de carta por defecto";
    }

    public abstract void accion(int dados, Tablero tablero) throws Exception;
}
