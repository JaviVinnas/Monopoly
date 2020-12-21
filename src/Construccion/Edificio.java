package Construccion;

import Casilla.Solar;
import Jugador.Jugador;
import Tablero.Grupo;
import Tablero.Tablero;

public class Edificio {

    private String id;
    private Jugador propietario;
    private Double precio;
    private Grupo grupo;
    private Solar casilla;

    public Edificio(Tablero tablero, Solar casilla, Jugador propietario) {
        this.propietario = propietario;
        this.casilla = casilla;
        this.grupo = tablero.getGrupos_de_solares().get(casilla.colorcasilla_to_colorgrupo(casilla.getColor_solar()));
    }

    public String getId() {
        return id;
    }

    public Jugador getPropietario() {
        return  propietario;
    }

    public Solar getCasilla() {
        return casilla;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo (Grupo grupo) {
        this.grupo = grupo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrecio(double precio) {
        this.precio = Math.round(precio * 100.0)/100.0;
    }

}
