package Casilla;
import Construccion.*;
import Construccion.*;
import Juego.*;
import Jugador.*;
import Tablero.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public final class Solar extends Propiedad {
    private Color_Solar color_solar;
    private HashMap<Tipo_Edificio, ArrayList<Edificio>> edificios_del_solar;
    private HashMap<Tipo_Edificio, ArrayList<Edificio>> edificios_del_grupo;


    public Color_Solar getColor_solar() {
        return color_solar;
    }

    public void setColor_solar(Color_Solar color_solar) {
        this.color_solar = color_solar;
    }

    public HashMap<Tipo_Edificio, ArrayList<Edificio>> getEdificios_del_solar() {
        return edificios_del_solar;
    }

    public void setEdificios_del_solar(HashMap<Tipo_Edificio, ArrayList<Edificio>> edificios_del_solar) {
        this.edificios_del_solar = edificios_del_solar;
    }

    public HashMap<Tipo_Edificio, ArrayList<Edificio>> getEdificios_del_grupo() {
        return edificios_del_grupo;
    }

    public void setEdificios_del_grupo(HashMap<Tipo_Edificio, ArrayList<Edificio>> edificios_del_grupo) {
        this.edificios_del_grupo = edificios_del_grupo;
    }


    @Override
    public double getAlquiler(@NotNull String s) {
        if(!s.equals("final")) return super.getAlquiler(s);

        double finall = 0;

        switch (getEdificios_del_solar().get(Tipo_Edificio.CASA).size()){
            case 1:
                finall+=5*getAlquiler("sin_redondear");
                break;
            case 2:
                finall+=15*getAlquiler("sin_redondear");
                break;
            case 3:
                finall+=35*getAlquiler("sin_redondear");
                break;
            case 4:
                finall+=50*getAlquiler("sin_redondear");
                break;
            default:
                break;
        }
        if(getEdificios_del_solar().get(Tipo_Edificio.HOTEL).size() >= 1) finall += 70*getAlquiler("sin_redondear");
        if(getEdificios_del_solar().get(Tipo_Edificio.PISCINA).size() >= 1) finall += 25*getAlquiler("sin_redondear");
        if(getEdificios_del_solar().get(Tipo_Edificio.PISTA_DE_DEPORTE).size() >= 1) finall += 25*getAlquiler("sin_redondear");

        return Math.round(finall*100.0)/100.0;

    }

    public Solar (int posicion, String nombre, Jugador propietario, double precio, Color_Solar color_solar){
        super(posicion, nombre, propietario, precio);
        this.color_solar = color_solar;
        this.edificios_del_grupo = new HashMap<>();
        this.edificios_del_grupo.put(Tipo_Edificio.CASA, new ArrayList<>());
        this.edificios_del_grupo.put(Tipo_Edificio.HOTEL, new ArrayList<>());
        this.edificios_del_grupo.put(Tipo_Edificio.PISCINA, new ArrayList<>());
        this.edificios_del_grupo.put(Tipo_Edificio.PISTA_DE_DEPORTE, new ArrayList<>());
        this.edificios_del_solar = new HashMap<>();
        this.edificios_del_solar.put(Tipo_Edificio.CASA, new ArrayList<>());
        this.edificios_del_solar.put(Tipo_Edificio.HOTEL, new ArrayList<>());
        this.edificios_del_solar.put(Tipo_Edificio.PISCINA, new ArrayList<>());
        this.edificios_del_solar.put(Tipo_Edificio.PISTA_DE_DEPORTE, new ArrayList<>());

    }

    public ArrayList<String> edificioss (){
        ArrayList<String> nom_edificios = new ArrayList<>();
        for(ArrayList<Edificio> eds : edificios_del_solar.values()){
            for(Edificio ed : eds){
                nom_edificios.add(ed.getId());
            }
        }
        return nom_edificios;
    }

    @Override
    public void describir_casilla( Tablero tablero) {
        Juego.consola.imprimir("Tipo de casilla --> Solar");
        if(getPropietario().getTipo_jugador().equals(Tipo_jugador.banca)){
            Juego.consola.imprimir("Propietario --> a la venta");
        }else {
            Juego.consola.imprimir("Propietario --> " + getPropietario().getNombre());
        }
        Juego.consola.imprimir("Edificios del solar --> " + edificioss());
        Juego.consola.imprimir("Precio de compra --> " + getPrecio());
        Juego.consola.imprimir("Alquiler --> " + getAlquiler(""));
        Juego.consola.imprimir("Precio por construir una casa --> " + Math.round(.6* getPrecio() * 100.0)/100.0);
        Juego.consola.imprimir("Precio por construir un hotel --> " + Math.round(.6* getPrecio() * 100.0)/100.0);
        Juego.consola.imprimir("Precio por construir una piscina --> " + Math.round(.4* getPrecio() * 100.0)/100.0);
        Juego.consola.imprimir("Precio por construir una pista de deporte --> " + Math.round(.125* getPrecio() * 100.0)/100.0);
        Juego.consola.imprimir("Alquiler con 1 casa construida --> " + 5* getAlquiler(""));
        Juego.consola.imprimir("Alquiler con 2 casas construida --> " + 15* getAlquiler(""));
        Juego.consola.imprimir("Alquiler con 3 casas construida --> " + 35* getAlquiler(""));
        Juego.consola.imprimir("Alquiler con 4 casas construida --> " + 50* getAlquiler(""));
        Juego.consola.imprimir("Alquiler con 1 hotel construido --> " + 70* getAlquiler(""));
        Juego.consola.imprimir("Alquiler con 1 piscina construido --> " + 25* getAlquiler(""));
        Juego.consola.imprimir("Alquiler con 1 pista de deporte --> " + 25* getAlquiler(""));
    }

    @Override
    public void accion_casilla(Jugador jugador, Tablero tablero, int dados) throws Exception {
        numvecesquesecayoencasilla_masmas();
        if(getPropietario().getTipo_jugador().equals(Tipo_jugador.no_banca)){
            if(jugador.equals(getPropietario())) throw new Exception("Has caído en tu propiedad!");
            if(isHipotecada()) throw new Exception("El solar está hipotecado por lo que no se te cobra nada");
            if(jugador.getFortuna() > this.getAlquiler("final")){
                this.getPropietario().setFortuna( this.getPropietario().getFortuna() + this.getAlquiler("final"));
                jugador.setFortuna(jugador.getFortuna() - this.getAlquiler("final"));
                getPropietario().setDin_ganadopor_alquileres(getPropietario().getDin_ganadopor_alquileres()+this.getAlquiler("final"));
                jugador.setDin_gastadoen_alquileres(jugador.getDin_gastadoen_alquileres() + this.getAlquiler("final") );
                actualizar_rentabilidad( this.getAlquiler("final"),tablero);
                Juego.consola.imprimir("Pagas " + this.getAlquiler("final") + "€ a " + this.getPropietario().getNombre() + ". Tu fortuna se reduce a " + jugador.getFortuna() + "€.");
            }else {
                Juego.consola.imprimir("No puedes pagar el alquiler de la casilla (BANCARROTA)");
            }
        } else {
            Juego.consola.imprimir("El solar no tiene dueño por lo que no pagas nada. Podrías comprarlo si quisieras");
        }
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        for (Jugador jugador : this.getJugadores_en_casilla()) {
            char c = jugador.getAvatar().getId();
            s.append("&").append(c).append(" ");
        }
        String col;
        switch (this.color_solar){
            case Amarillo:
                col = Colores_Casilla.YELLOW;
                break;
            case Azul_claro:
                col = Colores_Casilla.BLUE_BRIGHT;
                break;
            case Azul_oscuro:
                col = Colores_Casilla.BLUE ;
                break;
            case Marron:
                col = Colores_Casilla.PURPLE_BRIGHT ;
                break;
            case Morado:
                col = Colores_Casilla.PURPLE ;
                break;
            case Naranja:
                col = Colores_Casilla.RED_BRIGHT ;
                break;
            case Rojo:
                col = Colores_Casilla.RED ;
                break;
            case Verde:
                col = Colores_Casilla.GREEN ;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.color_solar);

        }
        StringBuilder esp = new StringBuilder();
        int i = Tablero.getNombre_mas_largo() + 18 - getNombre().length()  - s.length(); //48 es la longitud del nombre de casilla mas largo (30) + la longitud de la cadena de ids de avatares mas larga (6 jugadores + 3 caracteres por jugador = 18)
        while (i>0){                                    //hay una función en tablero que devuelve el nombre de casilla más largo
            esp.append(" ");
            i--;
        }
        return col + this.getNombre() + esp + s + Colores_Casilla.RESET;
    }

    public void edificar( Jugador jug, Tipo_Edificio tipo, Tablero tablero) throws Exception {

        jug.edificar(this,tipo,tablero);
    }


    public Color_grupo colorcasilla_to_colorgrupo(Color_Solar color_solar){
        for(Color_grupo colgr : Color_grupo.values()){
            if(colgr.toString().equals(color_solar.toString())){
                return colgr;
            }
        }
        return null;
    }

    public void actualizar_rentabilidad (double alquiler, Tablero tablero){
        this.setDinero_pagado_en_alquileres(this.getDinero_pagado_en_alquileres() + alquiler);
        tablero.getGrupos_de_solares().get(colorcasilla_to_colorgrupo(this.color_solar)).setDinero_pagado_en_alquileres_grupo(tablero.getGrupos_de_solares().get(colorcasilla_to_colorgrupo(this.color_solar)).getDinero_pagado_en_alquileres_grupo() + alquiler);
    }
}
