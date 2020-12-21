package Casilla;

import Consola.ConsolaNormal;
import Juego.Juego;
import Jugador.Jugador;
import Tablero.Tablero;


public final class Impuesto extends Casilla {
    private double impuesto;

    public Impuesto(int posicion, String nombre, double impuesto){
        super(posicion,nombre);
        this.impuesto = impuesto;
    }

    @Override
    public void describir_casilla(Tablero tablero) {
        Juego.consola.imprimir("Tipo de casilla --> IMPUESTO");
        Juego.consola.imprimir("Si caes aquí pagarás " + impuesto);
    }

    @Override
    public void accion_casilla(Jugador jugador, Tablero tablero, int dados) {
        numvecesquesecayoencasilla_masmas();
            if(jugador.getFortuna() > this.impuesto){
                jugador.setFortuna( jugador.getFortuna() - this.impuesto);
                jugador.setDin_gastadoen_impuestossuertecomunidad(jugador.getDin_gastadoen_impuestossuertecomunidad() + impuesto);
                tablero.al_bote_del_parking(impuesto);
                Juego.consola.imprimir("Pagas " + this.impuesto + "€ a la banca. Tu fortuna se reduce a " + jugador.getFortuna() + "€.");
            }else {
                Juego.consola.imprimir("No puedes pagar el alquiler de la casilla (BANCARROTA)");
            }
        }



    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Jugador jugador : this.getJugadores_en_casilla()) {
            char c = jugador.getAvatar().getId();
            s.append("&").append(c).append(" ");
        }
        String col = Colores_Casilla.BLACK_BOLD +Colores_Casilla.PURPLE_BACKGROUND ;
        StringBuilder esp = new StringBuilder();
        int i = Tablero.getNombre_mas_largo() + 18 - getNombre().length()  - s.length(); //48 es la longitud del nombre de casilla mas largo (30) + la longitud de la cadena de ids de avatares mas larga (6 jugadores + 3 caracteres por jugador = 18)
        while (i>0){                                    //hay una función en tablero que devuelve el nombre de casilla más largo
            esp.append(" ");
            i--;
        }
        return col + this.getNombre() + esp + s + Colores_Casilla.RESET;
    }


}



