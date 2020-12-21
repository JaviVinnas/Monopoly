package Excepciones;
import Jugador.Jugador;

public class Bancarrota extends Exception {
    private Jugador jugador;

    public Bancarrota(Jugador jugador){
        super("");
        this.jugador = jugador;
    }

    @Override
    public String getMessage() {
        return "El jugador " + jugador.getNombre() + "No puede pagar la cárcel";
    }
}
