package Casilla;

import Consola.ConsolaNormal;
import Jugador.*;
import Tablero.*;


public final class Servicio extends Propiedad {

    public Servicio (int posicion, String nombre, Jugador propietario, double factor){
        super(posicion, nombre, propietario, factor);
    }

    @Override
    public void describir_casilla(Tablero tablero) {
        ConsolaNormal consola = new ConsolaNormal();
        consola.imprimir("Tipo de casilla --> Servicio");
        if(this.getPropietario().getTipo_jugador().equals(Tipo_jugador.banca)){
            consola.imprimir("Propietario --> a la venta");
        } else {
            consola.imprimir("Propietario --> " + getPropietario().getNombre());
        }
        consola.imprimir("Precio de compra --> " + getPrecio());
        consola.imprimir("Alquiler con 1 servicio --> 4 veces el valor de los dados que echó el jugador que cae ahi / 200");
        consola.imprimir("Alquiler con 2 servicio --> 10 veces el valor de los dados que echó el jugador que cae ahi / 200");
    }

    @Override
    public void accion_casilla(Jugador jugador, Tablero tablero, int dados) throws Exception{
        numvecesquesecayoencasilla_masmas();
        ConsolaNormal consola = new ConsolaNormal();
        if(getPropietario().getTipo_jugador().equals(Tipo_jugador.banca)){
            consola.imprimir("El servicio no tiene dueño por lo que no pagas nada");
        }else{
            if(jugador.equals(getPropietario())) throw new Exception("Has caído en tu propiedad!");
            if(isHipotecada()) throw new Exception("El solar está hipotecado por lo que no se te cobra nada");
            getPropietario().setFortuna(getPropietario().getFortuna() + this.getPrecio() * 4 * dados);
            jugador.setFortuna(jugador.getFortuna() - this.getPrecio() * 4 * dados);
            getPropietario().setDin_ganadopor_alquileres(getPropietario().getDin_ganadopor_alquileres() + this.getPrecio() * 4 * dados);
            jugador.setDin_gastadoen_alquileres(jugador.getDin_gastadoen_alquileres() + this.getPrecio() * 4 * dados);
            actualizar_rentabilidad(this.getPrecio() * 4 * dados, tablero);
            consola.imprimir(jugador.getNombre() + " paga " + (this.getPrecio() * 4 * dados) + " a " + getPropietario() + ". Su fortuna se reduce a " + jugador.getFortuna());
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Jugador jugador : this.getJugadores_en_casilla()) {
            char c = jugador.getAvatar().getId();
            s.append("&").append(c).append(" ");
        }
        String col = Colores_Casilla.CYAN_BOLD + Colores_Casilla.BLACK_BACKGROUND_BRIGHT;
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
        tablero.getGrupos_de_solares().get(Color_grupo.Servicio).setDinero_pagado_en_alquileres_grupo(tablero.getGrupos_de_solares().get(Color_grupo.Servicio).getDinero_pagado_en_alquileres_grupo() + alquiler);
    }
}
