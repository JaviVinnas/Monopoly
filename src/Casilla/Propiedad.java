package Casilla;
import Juego.Juego;
import Jugador.*;
import Tablero.Tablero;


public abstract class Propiedad extends Casilla {
    private Jugador propietario;
    private double dinero_pagado_en_alquileres;
    private double precio;
    private double alquiler;
    private double hipoteca;
    private boolean hipotecada;

    public Jugador getPropietario() {
        return propietario;
    }

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }

    public double getDinero_pagado_en_alquileres() {

        return Math.round(dinero_pagado_en_alquileres * 100.0)/100.0;
    }

    public void setDinero_pagado_en_alquileres(double dinero_pagado_en_alquileres) {
        this.dinero_pagado_en_alquileres = dinero_pagado_en_alquileres;
    }

    public double getPrecio() {
        return Math.round(precio * 100.0)/100.0;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getAlquiler(String s) {
        if(s.equals("sin_redondear")){
            return alquiler;
        }else {
            return Math.round(alquiler * 100.0)/100.0;
        }
    }

    public void setAlquiler(double alquiler) {
        this.alquiler = alquiler;
    }

    public double getHipoteca() {
        return Math.round(hipoteca * 100.0)/100.0;
    }

    public void setHipoteca(double hipoteca) {
        this.hipoteca = hipoteca;
    }

    public boolean isHipotecada() {
        return hipotecada;
    }

    public void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }

    public Propiedad(int posicion, String nombre, Jugador propietario, double precio) {
        super(posicion, nombre);
        this.propietario = propietario;
        this.precio = precio;
        this.alquiler = precio * 0.1;
        this.hipoteca = precio * 0.5;
        this.dinero_pagado_en_alquileres = 0.0;
        this.hipotecada = false;
    }

    public abstract void describir_casilla( Tablero tablero);

    public abstract void accion_casilla(Jugador jugador, Tablero tablero, int dados) throws Exception;

    public boolean es_propietario(Jugador jugador) {
        return jugador.equals(this.propietario);
    }

    public void comprar(Jugador comprador) {
        if (propietario.getTipo_jugador().equals(Tipo_jugador.banca)) {
            if(comprador.getFortuna() >= precio){
                comprador.setFortuna(comprador.getFortuna()-precio);
                propietario = comprador;
                Juego.consola.imprimir("Has comprado la propiedad por" + precio +". Te quedan " + comprador.getFortuna() + "€");
            }else {
                Juego.consola.imprimir("No tienes dinero para comprar la propiedad");
            }
        } else {
            Juego.consola.imprimir("La propiedad pertenece a alguien ya, tendrás que negociar con él");
        }
    }

    public abstract void actualizar_rentabilidad (double alquiler, Tablero tablero);

}
