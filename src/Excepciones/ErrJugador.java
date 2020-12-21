package Excepciones;

public class ErrJugador extends Exception_crear_jugador {

    public ErrJugador(String mensaje){
        super(mensaje);
    }
    @Override
    public String descripcion() {
        return "Ya hay un jugador de nombre " + getMessage() + ", prueba con otro";
    }
}
