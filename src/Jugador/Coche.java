package Jugador;

import Casilla.*;
import Excepciones.Excepcion_carcel_coche_avanzado;
import Juego.Juego;
import Tablero.Tablero;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Coche extends Avatar{
    //si ha comprado a lo largo de los 4 posibles turnos
    private boolean compro_propiedad;
    //equivalente a vuelta en la q sale de la cárcel
    private int vuelta_cuando_vuelve_a_tirar_coche;
    //en cual de los 4 posibles tiradas está
    private int veces_que_ha_tirado;

    public boolean isCompro_propiedad() { return compro_propiedad; }
    public void setCompro_propiedad(boolean compro_propiedad) { this.compro_propiedad = compro_propiedad; }

    public int isVuelta_cuando_vuelve_a_tirar_coche() { return vuelta_cuando_vuelve_a_tirar_coche; }
    public void setVuelta_cuando_vuelve_a_tirar_coche(int vuelta_cuando_vuelve_a_tirar_coche) { this.vuelta_cuando_vuelve_a_tirar_coche = vuelta_cuando_vuelve_a_tirar_coche; }


    public int getVeces_que_ha_tirado() { return veces_que_ha_tirado; }
    public void setVeces_que_ha_tirado(int veces_que_ha_tirado) { this.veces_que_ha_tirado = veces_que_ha_tirado; }

    public Coche(Jugador jugador){
        super(jugador);
        compro_propiedad = false;
        vuelta_cuando_vuelve_a_tirar_coche = 0;
        veces_que_ha_tirado = 0;
    }

    @Override
    public String toString() {
        String modo_mov;
        if(isMov_avanzado()){
            modo_mov = "AVANZADO";
        } else {
            modo_mov = "NORMAL";
        }
        return "Avatar de nombre " + getId() + ":\n"+
                "|\tJugador al que pertenece --> " + getJugador().getNombre() + '\n' +
                "|\tTipo --> coche\n" +
                "|\tCasilla donde está --> " + getCasillaAvatar().getNombre() + "\n" +
                "|\tModo de movimiento --> " + modo_mov;

    }

    @Override
    public void mover_en_avanzado(int dados, Tablero tablero, Juego juego) throws Exception {
        //lo quitamos de la casilla y nos quedamos con su posicion inicial
        Jugador jug = tablero.jug_q_tiene_turno();
        int pos_inicial = jug.eliminar_de_su_casilla();
        int pos_final = 0;
        if (dados >= 5){
            Juego.consola.imprimir("Como " + dados + " es mayor o igual que 5 no retrocedes");
            pos_final= pos_inicial + dados;
            if(pos_final>39) pos_final-=40;
            Casilla cas = jug.meter_en_casilla_de_numero(pos_final,tablero);
            Juego.consola.imprimir("Caes en " + cas.getNombre());
            cas.accion_casilla(jug,tablero,dados);
            if (pos_final<pos_inicial) jug.cobrar_salida(tablero);
            if (jug.estaenlacarcel()) throw new Excepcion_carcel_coche_avanzado("El coche no puede seguir tirando porque está en la cárcel", this, juego);
            veces_que_ha_tirado++;
            if(veces_que_ha_tirado >= 4){
                Juego.consola.imprimir("Ya no puedes tirar más hasta el siguiente turno");
            } else {
                Juego.consola.imprimir("Puedes tirar hasta " + (4-veces_que_ha_tirado) + " veces más");
            }
        }else {
            Juego.consola.imprimir("Como " + dados + " es menor que 5 retrocedes " + dados + " posiciones");
            pos_final-=dados;
            if(pos_final<39) pos_final+=40;
            Casilla cas = jug.meter_en_casilla_de_numero(pos_final,tablero);
            Juego.consola.imprimir("Caes en " + cas.getNombre());
            cas.accion_casilla(jug,tablero,dados);
            if (jug.estaenlacarcel()) throw new Excepcion_carcel_coche_avanzado("El coche no puede seguir tirando porque está en la cárcel", this,juego);
            vuelta_cuando_vuelve_a_tirar_coche = tablero.getVuelta() + 2;
            Juego.consola.imprimir("No puedes volver a tirar hasta dentro de 2 turnos");
            veces_que_ha_tirado = 4;
        }

    }
    //se actualizan todos los parámetros del coche pasa una ronda
    public void coche_daunavuelta(){
        if(vuelta_cuando_vuelve_a_tirar_coche > 0) vuelta_cuando_vuelve_a_tirar_coche--;
        veces_que_ha_tirado = 0;
        compro_propiedad = false;
    }
}
