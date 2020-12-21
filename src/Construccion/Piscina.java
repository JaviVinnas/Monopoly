package Construccion;

import Casilla.*;
import Jugador.Jugador;
import Tablero.Tablero;

public class Piscina extends Edificio {

    public Piscina(Solar casilla, Jugador propietario, Tablero tablero){
        super(tablero,casilla, propietario);
        super.setPrecio(0.4*casilla.getPrecio());
        super.setId("PISCINA - " + tablero.getCuentaPiscinas());
        tablero.setCuentaPiscinas(tablero.getCuentaPiscinas()+1);

    }
}
