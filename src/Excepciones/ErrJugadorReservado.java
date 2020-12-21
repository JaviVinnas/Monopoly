package Excepciones;

public class ErrJugadorReservado extends Exception_crear_jugador {
    public ErrJugadorReservado(String nombre){
        super(nombre);
    }

    @Override
    public String descripcion() {
        return "El nombre " + getMessage() + " es un nombre reservado.\nPrueba con otro";
    }
}
