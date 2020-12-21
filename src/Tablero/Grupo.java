package Tablero;

import Casilla.*;
import Casilla.Color_Solar;
import Construccion.*;
import Jugador.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Grupo {
    private Color_grupo color_del_grupo;
    private Jugador propietario_del_grupo;
    private ArrayList<Propiedad> casillas_del_grupo;
    private ArrayList<Edificio> edificios_del_grupo;
    private double dinero_pagado_en_alquileres_grupo;


    public ArrayList<Propiedad> getCasillas_del_grupo() {
        return casillas_del_grupo;
    }

    public void setCasillas_del_grupo(ArrayList<Propiedad> casillas_del_grupo) {
        this.casillas_del_grupo = casillas_del_grupo;
    }

    public Jugador getPropietario_del_grupo() {
        return propietario_del_grupo;
    }

    public void setPropietario_del_grupo(Jugador propietario_del_grupo) {
        this.propietario_del_grupo = propietario_del_grupo;
    }

    public ArrayList<Edificio> getEdificios_del_grupo() {
        return edificios_del_grupo;
    }

    public void setEdificios_del_grupo(ArrayList<Edificio> edificios_del_grupo) {
        this.edificios_del_grupo = edificios_del_grupo;
    }

    public Color_grupo getColor_del_grupo() {
        return color_del_grupo;
    }

    public double getDinero_pagado_en_alquileres_grupo() {
        return dinero_pagado_en_alquileres_grupo;
    }

    public void setDinero_pagado_en_alquileres_grupo(double dinero_pagado_en_alquileres_grupo) {
        this.dinero_pagado_en_alquileres_grupo = dinero_pagado_en_alquileres_grupo;
    }

    public int getNumSolares(){
        return this.getCasillas_del_grupo().size();
    }


    public  String listar_edificios() {
        String lista = "";
        for (Casilla cas : this.getCasillas_del_grupo()) {
            lista = lista + "{\n propiedad: " + cas.getNombre() + "\n";
            lista = lista + " hoteles: " + this.listaTipoEdificio(Tipo_Edificio.HOTEL);
            lista = lista + " casas: " + this.listaTipoEdificio(Tipo_Edificio.CASA);
            lista = lista + " piscinas: " + this.listaTipoEdificio(Tipo_Edificio.PISCINA);
            lista = lista + " pistaDeDeporte: " + this.listaTipoEdificio(Tipo_Edificio.HOTEL);
            lista = lista + " alquiler: " ;



            lista = lista + " grupo: " + "\n coste:  \n} \n";
        }

        return lista;
    }

    public int Precio;

    public String listaTipoEdificio(Tipo_Edificio tipo){

        String lista = "";
        switch (tipo) {
            case CASA:
                for (Edificio edif : this.getEdificios_del_grupo()) {
                    if (edif instanceof Casa)
                        lista = lista + ", " +edif.getId();
                }
                break;
            case HOTEL:
                for (Edificio edif : this.getEdificios_del_grupo()) {
                    if (edif instanceof Hotel)
                        lista = lista + ", " +edif.getId();
                }
                break;
            case PISCINA:
                for (Edificio edif : this.getEdificios_del_grupo()) {
                    if (edif instanceof Piscina)
                        lista = lista + ", " +edif.getId();
                }
                break;
            case PISTA_DE_DEPORTE:
                for (Edificio edif : this.getEdificios_del_grupo()) {
                    if (edif instanceof PistaDeporte)
                        lista = lista + ", " +edif.getId();
                }
                break;
        }
        if (lista.equals("")) {
            lista = "-";
        }
        return lista;
    }

    public Grupo(Color_grupo color_del_grupo, Jugador propietario_del_grupo){
        this.color_del_grupo = color_del_grupo;
        this.propietario_del_grupo = propietario_del_grupo;
        this.casillas_del_grupo = new ArrayList<Propiedad>();
        this.edificios_del_grupo = new ArrayList<Edificio>();
        this.dinero_pagado_en_alquileres_grupo = 0;
    }
}
