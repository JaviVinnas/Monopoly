package Excepciones;

import Juego.Juego;
import Jugador.Coche;

public class Excepcion_carcel_coche_avanzado extends Exception_carcel {

    private Juego juego;
    private String mensaje;

    public Excepcion_carcel_coche_avanzado(String mensaje, Coche avatar, Juego juego){
        super(avatar);
        this.mensaje = mensaje;
        this.juego = juego;
    }

    @Override
    public String getMessage() {
        ((Coche)getAvatar()).setVuelta_cuando_vuelve_a_tirar_coche(0);
        ((Coche)getAvatar()).setVeces_que_ha_tirado(4);
        ((Coche)getAvatar()).setCompro_propiedad(false);
        juego.ver_tablero();
        return mensaje;
    }
}
