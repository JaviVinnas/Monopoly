package Casilla;
import Juego.Juego;
import Jugador.*;
import Tablero.*;

public final class Transporte extends Propiedad {


    public Transporte (int posicion, String nombre, Jugador propietario, double precio){
        super(posicion, nombre, propietario, precio);
    }

    @Override
    public void describir_casilla(Tablero tablero) {
        Juego.consola.imprimir("Tipo de casilla --> Estación");
        if(getPropietario().getTipo_jugador().equals(Tipo_jugador.banca)){
            Juego.consola.imprimir("Propietario --> a la venta");
        } else {
            Juego.consola.imprimir("Propietario --> " + getPropietario().getNombre());
        }
        Juego.consola.imprimir("Precio de compra --> " + getPrecio());
        Juego.consola.imprimir("Alquiler teniendo 1 estación --> " + Math.round(tablero.getPasa_por_salida()*.25*100.0)*100.0);
        Juego.consola.imprimir("Alquiler teniendo 2 estaciones --> " + Math.round(tablero.getPasa_por_salida()*.5*100.0)*100.0);
        Juego.consola.imprimir("Alquiler teniendo 3 estaciones --> " + Math.round(tablero.getPasa_por_salida()*.75*100.0)*100.0);
        Juego.consola.imprimir("Alquiler teniendo 4 estaciones --> " + Math.round(tablero.getPasa_por_salida()*100.0)*100.0);

    }

    @Override
    public void accion_casilla(Jugador jugador, Tablero tablero, int dados) throws Exception{
        numvecesquesecayoencasilla_masmas();
        if(getPropietario().getTipo_jugador().equals(Tipo_jugador.banca)){
            Juego.consola.imprimir("La casilla no tiene dueño por lo que no pagas nada");
        }else{
            if(jugador.equals(getPropietario())) throw new Exception("Has caído en tu propiedad!");
            if(isHipotecada()) throw new Exception("El solar está hipotecado por lo que no se te cobra nada");
            getPropietario().setFortuna(getPropietario().getFortuna() + getPropietario().de_cuantas_estaciones_es_propietario() * .25 * tablero.getPasa_por_salida());
            jugador.setFortuna( jugador.getFortuna() - getPropietario().de_cuantas_estaciones_es_propietario() * .25 * tablero.getPasa_por_salida());
            getPropietario().setDin_ganadopor_alquileres(getPropietario().getDin_ganadopor_alquileres() + getPropietario().de_cuantas_estaciones_es_propietario() * .25 * tablero.getPasa_por_salida());
            jugador.setDin_gastadoen_alquileres(jugador.getDin_gastadoen_alquileres() + getPropietario().de_cuantas_estaciones_es_propietario() * .25 * tablero.getPasa_por_salida());
            actualizar_rentabilidad(getPropietario().de_cuantas_estaciones_es_propietario() * .25 * tablero.getPasa_por_salida(), tablero);
            Juego.consola.imprimir(jugador.getNombre() + " paga " + (getPropietario().de_cuantas_estaciones_es_propietario() * .25 * tablero.getPasa_por_salida()) + "€ a " + getPropietario().getNombre() + ".Su fortuna desciende a " + jugador.getFortuna());

        }
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Jugador jugador : this.getJugadores_en_casilla()) {
            char c = jugador.getAvatar().getId();
            s.append("&").append(c).append(" ");
        }
        String col = Colores_Casilla.BLACK + Colores_Casilla.BLACK_BACKGROUND_BRIGHT;
        StringBuilder esp = new StringBuilder();
        int i = Tablero.getNombre_mas_largo() + 18 - getNombre().length()  - s.length(); //48 es la longitud del nombre de casilla mas largo (30) + la longitud de la cadena de ids de avatares mas larga (6 jugadores + 3 caracteres por jugador = 18)
        while (i>0){                                    //hay una función en tablero que devuelve el nombre de casilla más largo
            esp.append(" ");
            i--;
        }
        return col + this.getNombre() + esp + s + Colores_Casilla.RESET;
    }

    public void actualizar_rentabilidad (double alquiler, Tablero tablero){
        this.setDinero_pagado_en_alquileres(this.getDinero_pagado_en_alquileres()  + alquiler);
        tablero.getGrupos_de_solares().get(Color_grupo.Estacion).setDinero_pagado_en_alquileres_grupo(tablero.getGrupos_de_solares().get(Color_grupo.Estacion).getDinero_pagado_en_alquileres_grupo() + alquiler);
    }
}
