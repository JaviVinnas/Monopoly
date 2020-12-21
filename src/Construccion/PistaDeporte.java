package Construccion;

import Casilla.Solar;
import Jugador.Jugador;
import Tablero.Tablero;

public class PistaDeporte extends Edificio {

    public PistaDeporte(Solar casilla, Jugador propietario, Tablero tablero){
        super(tablero,casilla, propietario);
        super.setPrecio(1.25*casilla.getPrecio());
        super.setId("PISTA_DE_DEPORTE - " + tablero.getCuentaPistas());
        tablero.setCuentaPistas(tablero.getCuentaPistas()+1);
    }
}
