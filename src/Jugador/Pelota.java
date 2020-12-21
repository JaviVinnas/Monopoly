package Jugador;

import Casilla.Casilla;
import Juego.Juego;
import Tablero.Tablero;
import org.jetbrains.annotations.NotNull;

public class Pelota extends Avatar {

    public Pelota(Jugador jug){
        super(jug);
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
                "|\tTipo --> pelota\n" +
                "|\tCasilla donde está --> " + getCasillaAvatar().getNombre() + "\n" +
                "|\tModo de movimiento --> " + modo_mov;

    }

    @Override
    public void mover_en_avanzado(int pos_que_avanza, @NotNull Tablero tablero, Juego juego) throws Exception {
        Jugador jug = tablero.jug_q_tiene_turno();
        //en cualquier caso quitamos al jugador de la casilla y guardamos su posición inicial
        int pos_inicial = jug.eliminar_de_su_casilla();
        int pos_final;
        int fin = 0;
        getCasillaAvatar().eliminar_jugador_de_casilla(getJugador());
        if(pos_que_avanza > 4){

            Juego.consola.imprimir("Como " + pos_que_avanza + " es mayor o igual que 5 no retrocedes");
            pos_final = pos_inicial + pos_que_avanza;
            if (pos_final > 40) pos_final-=40;
            for (int i = 4; i <= pos_que_avanza; i++) {
                int pos_iterable = pos_inicial + i;
                if (pos_iterable > 40) pos_iterable-=40;
                if(i%2!=0){
                    if (i != 5) {
                        pos_iterable = jug.getAvatar().getCasillaAvatar().getPosicion() + 2;
                        if (pos_iterable > 40) pos_iterable -= 40;
                    }
                    jug.meter_en_casilla_de_numero(pos_iterable,tablero);
                    Casilla cas_iterable = jug.donde_esta();
                    Juego.consola.imprimir("Caes en la casilla " + i + " de " + pos_que_avanza + " de tu tirada: " + cas_iterable.getNombre());
                    cas_iterable.accion_casilla(jug,tablero,pos_que_avanza);
                    if(jug.getAvatar().getCasillaAvatar().getPosicion() < pos_inicial) jug.cobrar_salida(tablero);
                    if(jug.estaenlacarcel()) throw new Exception("El jugador deja de mover porque está en la cárcel");
                    if(i!=pos_que_avanza){
                        juego.ver_tablero();
                        menu(jug.getAvatar().getCasillaAvatar(),juego);
                    }
                    fin = jug.eliminar_de_su_casilla();
                }
            }
            if(pos_que_avanza%2==0){
                Juego.consola.imprimir("Te colocas en la última posición de tirada: " + tablero.casilla_a_partir_de(fin+1).getNombre());
                jug.meter_en_casilla_de_numero(fin+1,tablero);
                Juego.consola.imprimir("No realizas la acción de esta casilla");
            }else {
                jug.meter_en_casilla_de_numero(fin,tablero);
            }
        } else {
            Juego.consola.imprimir("Como " + pos_que_avanza + " es menor que 5 retrocedes " + pos_que_avanza + " casillas");
            pos_final = pos_inicial - pos_que_avanza;
            if (pos_final < 0) pos_final+=40;
            Casilla cas_final = jug.meter_en_casilla_de_numero(pos_final,tablero);
            Juego.consola.imprimir("Caes en " + cas_final.getNombre());
            cas_final.accion_casilla(jug,tablero,pos_que_avanza);


        }
    }

    private void menu(Casilla cas, Juego juego)  {
        char op;
        do{
            Juego.consola.imprimir("Que quieres hacer?");
            Juego.consola.imprimir("a) Comprar la casilla");
            Juego.consola.imprimir("b) Ver su información");
            Juego.consola.imprimir("c) Ver el tablero");
            Juego.consola.imprimir("s) Seguir avanzando");
            op = Juego.consola.leer_letra('k');
            switch (op){
                case 'a':
                    try {
                        juego.comprar(cas.getNombre());
                    }catch (Exception ex){
                        Juego.consola.imprimir(ex.getMessage());
                    }

                    break;
                case 'b':
                    try {
                        juego.describir_casilla(cas.getNombre());
                    }catch (Exception ex){
                        Juego.consola.imprimir(ex.getMessage());
                    }
                    break;
                case 'c':
                    juego.ver_tablero();
                    break;
                case 's':
                    op = 's';
                    break;
                default:
            }
        }while (op != 's');


    }

}
