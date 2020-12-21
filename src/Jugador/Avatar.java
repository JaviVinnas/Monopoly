package Jugador;

import Casilla.Casilla;
import Juego.Juego;
import Tablero.Tablero;

import java.util.Random;

public abstract class Avatar {
    private char id;
    private Casilla casillaAvatar;
    private Jugador jugador;
    private boolean mov_avanzado;


    public char getId() { return id; }
    public void setId(char id) { this.id = id; }

    public Casilla getCasillaAvatar() { return casillaAvatar; }
    public void setCasillaAvatar(Casilla casillaAvatar) { this.casillaAvatar = casillaAvatar; }

    public Jugador getJugador() {return jugador;}

    public boolean isMov_avanzado() { return mov_avanzado; }
    public void setMov_avanzado(boolean mov_avanzado) {this.mov_avanzado = mov_avanzado;}

    public Avatar(Jugador jug ){
        Random random = new Random();
        this.id = (char) (random.nextInt(25) + 65);

        this.jugador = jug;
    }

    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if(o instanceof Avatar){
            return ((Avatar) o).getId() == this.getId();
        } else {
            return false;
        }
    }

    public void mover_en_basico(int pos_que_avanza, Tablero tablero){
        int pos_inicial = casillaAvatar.getPosicion();
        casillaAvatar.eliminar_jugador_de_casilla(jugador);
        int pos_final = pos_inicial + pos_que_avanza;
        if(pos_final>=40){
            pos_final = pos_final - 40;
            jugador.cobrar_salida(tablero);
        }
        for (Casilla cas : tablero.getCasillaArrayList()){
            if(cas.getPosicion() == pos_final){
                cas.getJugadores_en_casilla().add(jugador);
                casillaAvatar = cas;

            }
        }
    }

    public abstract void mover_en_avanzado(int dados, Tablero tablero, Juego juego) throws Exception;
}
