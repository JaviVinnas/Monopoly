package Construccion;

import Casilla.Solar;
import Jugador.Jugador;
import Tablero.Tablero;

public class Casa extends Edificio {

    public Casa(Solar casilla, Jugador propietario, Tablero tablero){
        super(tablero,casilla, propietario);
        super.setPrecio(0.6*casilla.getPrecio());
        super.setId("CASA - " + tablero.getCuentaCasas());
        tablero.setCuentaCasas(tablero.getCuentaCasas()+1);
    }

}
