package Jugador;

import Juego.Juego;
import Tablero.Tablero;

public class Esfinge extends Avatar {

    public Esfinge(Jugador jugador){
        super(jugador);
    }

    @Override
    public String toString() {
        String modo_mov;
        if(isMov_avanzado()){
            modo_mov = "AVANZADO";
        } else {
            modo_mov = "NORMAL";
        }
        return "Avatar de nombre " + getId() + ":\n"+
                "|\tJugador al que pertenece --> " + getJugador().getNombre() + '\n' +
                "|\tTipo --> esfinge\n" +
                "|\tCasilla donde está --> " + getCasillaAvatar().getNombre() + "\n" +
                "|\tModo de movimiento --> " + modo_mov;

    }

    @Override
    public void mover_en_avanzado(int pos_que_avanza, Tablero tablero, Juego juego) throws Exception {
        throw new Exception("MOVIMIENTO AVANZADO NO DEFINIDO");
    }
}
