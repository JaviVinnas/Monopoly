package Casilla;

import Consola.ConsolaNormal;
import Juego.Juego;
import Jugador.Jugador;
import Tablero.Tablero;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public final class Especial extends Casilla {

    private double bote;
    private Tipo_Especial tipo_especial;

    public double getBote() {
        return bote;
    }

    public void setBote(double bote) {
        this.bote = bote;
    }

    public Especial(int posicion, String nombre, Tipo_Especial tipo_especial){
        super(posicion, nombre);
        this.tipo_especial = tipo_especial;
        switch (this.tipo_especial){
            case CARCEL:
                break;
            case PARKING:
                bote = 0.0;
                break;
        }
    }

    @Override
    public void describir_casilla( Tablero tab) {
        switch (this.tipo_especial){
            case CARCEL:
                Juego.consola.imprimir("CÁRCEL:");
                Juego.consola.imprimir("Jugadores en la carcel " + this.jugadores_encarcelados());
                break;
            case PARKING:
                Juego.consola.imprimir("PÁRKING:");
                Juego.consola.imprimir("Bote del parking --> " + this.bote);
                break;
            case SALIDA:
                Juego.consola.imprimir("SALIDA:");
                Juego.consola.imprimir("Pasa por salida --> " + tab.getPasa_por_salida());
                break;
            default:
                Juego.consola.imprimir("No es una casilla con información relevante");
                break;
        }

    }

    @Override
    public void accion_casilla(Jugador jugador, Tablero tablero, int dado) throws Exception{
        numvecesquesecayoencasilla_masmas();
        switch (tipo_especial){
            case SUERTE:
                Juego.consola.imprimir(tablero.toString());
                tablero.getMazo_suerte().barajar_mazo();
                int num;
                do{
                    try {
                        num = Juego.consola.pregutar_por_numero("Introduce un número entre 1 y 6");
                    } catch (NumberFormatException nfe){num = 999;}
                }while (num < 1 || num > 6);
                tablero.getMazo_suerte().escoger_carta(num,dado,tablero);
                break;
            case COMUNIDAD:
                Juego.consola.imprimir(tablero.toString());
                tablero.getMazo_comunidad().barajar_mazo();
                do{
                    try {
                        num = Juego.consola.pregutar_por_numero("Introduce un número entre 1 y 6");
                    } catch (NumberFormatException nfe){num = 999;}
                }while (num < 1 || num > 6);
                tablero.getMazo_comunidad().escoger_carta(num,dado,tablero);
                break;
            case IR_A_LA_CARCEL:
                jugador.meter_en_carcel(tablero);
                break;
            case PARKING:
                if(bote>0){
                    jugador.setFortuna(jugador.getFortuna() + bote);
                    Juego.consola.imprimir(jugador.getNombre() + " se lleva todo el dinero del parking (" + bote + "€) y su fortuna asciende a " + jugador.getFortuna());
                    bote = 0.0;
                }else {
                    Juego.consola.imprimir("Parece que no hay bote que te puedas llevar");
                }
                break;

        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Jugador jugador : this.getJugadores_en_casilla()) {
            char c = jugador.getAvatar().getId();
            s.append("&").append(c).append(" ");
        }
        String col = "";
        switch (tipo_especial){
            case COMUNIDAD:
                col = Colores_Casilla.BLUE_BACKGROUND_BRIGHT + Colores_Casilla.BLACK_BOLD;
                break;
            case CARCEL:
                col =  Colores_Casilla.WHITE_BOLD + Colores_Casilla.BLACK_BACKGROUND;
                break;
            case SALIDA:
                col =  Colores_Casilla.BLACK + Colores_Casilla.YELLOW_BACKGROUND;
                break;
            case SUERTE:
                col = Colores_Casilla.WHITE_BACKGROUND_BRIGHT + Colores_Casilla.BLACK_BOLD;
                break;
            case PARKING:
                col =  Colores_Casilla.BLACK_BOLD + Colores_Casilla.GREEN_BACKGROUND;
                break;
            case IR_A_LA_CARCEL:
                col =  Colores_Casilla.BLACK_BOLD + Colores_Casilla.RED_BACKGROUND;
                break;
        }

        StringBuilder esp = new StringBuilder();
        int i = Tablero.getNombre_mas_largo() + 18 - getNombre().length() - s.length(); //48 es la longitud del nombre de casilla mas largo (30) + la longitud de la cadena de ids de avatares mas larga (6 jugadores + 3 caracteres por jugador = 18)
        while (i>0){                                    //hay una función en tablero que devuelve el nombre de casilla más largo
            esp.append(" ");
            i--;
        }
        return col + this.getNombre() + esp + s + Colores_Casilla.RESET;
    }

    public ArrayList<String> jugadores_encarcelados(){
        ArrayList<String> jugs_encarcelados = new ArrayList<String>();
        for(Jugador jug : super.getJugadores_en_casilla()){
            if(jug.getVuelta_en_la_q_sale_d_la_carcel() != 0) jugs_encarcelados.add(jug.getNombre());
        }
        return jugs_encarcelados;
    }
}
