package Excepciones;

public abstract class Exception_crear_jugador extends Exception {
    public Exception_crear_jugador(String mensaje){
        super(mensaje);
    }
    public abstract String descripcion();
}
