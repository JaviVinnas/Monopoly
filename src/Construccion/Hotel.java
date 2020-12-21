package Construccion;

import Casilla.Solar;
import Jugador.Jugador;
import Tablero.Tablero;

public class Hotel extends Edificio {

    public Hotel(Solar casilla, Jugador propietario, Tablero tablero){
        super(tablero,casilla, propietario);
        super.setPrecio(0.6*casilla.getPrecio());
        super.setId("HOTEL - " + tablero.getCuentaHoteles());
        tablero.setCuentaHoteles(tablero.getCuentaHoteles()+1);

    }

}