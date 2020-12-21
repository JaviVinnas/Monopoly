package Tablero;


import Juego.Juego;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo_cartas {
    private ArrayList<Carta> cartas_de_la_baraja;

    public ArrayList<Carta> getCartas_de_la_baraja() { return cartas_de_la_baraja; }

    public Mazo_cartas (String tipo_de_mazo){
        cartas_de_la_baraja = new ArrayList<Carta>();
        for(int i = 1 ; i<= 6; i++){
            if(tipo_de_mazo.equals("Suerte")){
                cartas_de_la_baraja.add(new Suerte(i));
            }else{
                cartas_de_la_baraja.add(new Comunidad(i));
            }
        }
    }

    public void barajar_mazo(){
        Collections.shuffle(cartas_de_la_baraja);
    }

    public void escoger_carta(int i, int dados, Tablero tablero) throws Exception{
        Carta cartaescogida = cartas_de_la_baraja.get(i-1);
        Juego.consola.imprimir("Acción: " + cartaescogida.getDescripcion());
        cartaescogida.accion(dados,tablero);
    }
}
