package Tablero;

import Casilla.Casilla;
import Juego.Juego;
import Jugador.*;


public class Suerte extends Carta {


    public Suerte(int numero_de_carta){
        super(numero_de_carta);
        String descrip = "descripcionpordefecto";
        switch (numero_de_carta){
            case 1:
                descrip = "Ve a la Estación de las Delicias para coger un tren. Si pasas por la casilla de Salida, cobra el pasa por salida correspondiente";
                break;
            case 2:
                descrip = "¡Hora punta de tráfico! Retrocedes tres casillas.";
                break;
            case 3:
                descrip = "Vendes tu billete de avión para Barcelona en una subasta por Internet. Cobras 150€.";
                break;
            case 4:
                descrip = "Los acreedores te persiguen por impago. Ve a la Cárcel. Ve directamente sin pasar por la casilla de Salida y sin cobrar el pasa por salida correspondiente. \nEstarás los siguientes 3 turnos sin tirar";
                break;
            case 5:
                descrip = "Paga 500€ por la matrícula del colegio privado";
                break;
            case 6:
                descrip = "Has sido elegido presidente de la junta directiva. Paga a cada jugador el pasa por salida correspondiente";
                break;
        }
        setDescripcion(descrip);
    }

    @Override
    public void accion(int dados, Tablero tablero) throws Exception{
        int pos_donde_estaba;
        int pos_final = -1;
        switch (getNumero_de_carta()){
            case 1:
                pos_donde_estaba =  tablero.jug_q_tiene_turno().getAvatar().getCasillaAvatar().getPosicion();
                tablero.jug_q_tiene_turno().getAvatar().getCasillaAvatar().eliminar_jugador_de_casilla(tablero.jug_q_tiene_turno());
                for(Casilla cas : tablero.getCasillaArrayList()){
                    if(cas.getNombre().equals("Estación_de_las_Delicias")){
                        cas.setNum_veces_que_se_cayo_en_casilla(cas.getNum_veces_que_se_cayo_en_casilla() + 1);
                        pos_final = cas.getPosicion();
                        cas.getJugadores_en_casilla().add(tablero.jug_q_tiene_turno());
                        tablero.jug_q_tiene_turno().getAvatar().setCasillaAvatar(cas);
                        cas.accion_casilla(tablero.jug_q_tiene_turno(), tablero, dados);
                        break;
                    }
                }
                if(pos_final<pos_donde_estaba){
                    tablero.jug_q_tiene_turno().cobrar_salida(tablero);
                }
                break;
            case 2:
                pos_donde_estaba =  tablero.jug_q_tiene_turno().getAvatar().getCasillaAvatar().getPosicion();
                tablero.jug_q_tiene_turno().getAvatar().getCasillaAvatar().eliminar_jugador_de_casilla(tablero.jug_q_tiene_turno());
                pos_final = pos_donde_estaba - 3;
                if(pos_final < 0) pos_final = 40 + pos_final;

                for(Casilla cas : tablero.getCasillaArrayList()){
                    if(cas.getPosicion() == pos_final){
                        cas.setNum_veces_que_se_cayo_en_casilla(cas.getNum_veces_que_se_cayo_en_casilla() + 1);
                        cas.getJugadores_en_casilla().add(tablero.jug_q_tiene_turno());
                        tablero.jug_q_tiene_turno().getAvatar().setCasillaAvatar(cas);
                        cas.accion_casilla(tablero.jug_q_tiene_turno(), tablero, dados);
                        break;
                    }
                }
                break;
            case 3:

                tablero.jug_q_tiene_turno().setFortuna(tablero.jug_q_tiene_turno().getFortuna() + 150.0);
                tablero.jug_q_tiene_turno().setDin_ganadopor_suertecomunidad(tablero.jug_q_tiene_turno().getDin_ganadopor_suertecomunidad() + 150);
                break;
            case 4:
                tablero.jug_q_tiene_turno().meter_en_carcel(tablero);
                break;
            case 5:
                if(tablero.jug_q_tiene_turno().getFortuna() - 500 < 0){
                    Juego.consola.imprimir("HIPOTECAR");
                }else{
                    tablero.jug_q_tiene_turno().setFortuna(tablero.jug_q_tiene_turno().getFortuna() - 500);
                    tablero.jug_q_tiene_turno().setDin_gastadoen_impuestossuertecomunidad(tablero.jug_q_tiene_turno().getDin_gastadoen_impuestossuertecomunidad() + 500);
                    tablero.al_bote_del_parking(500.0);
                }
                break;
            case 6:
                if((tablero.getJugadorArrayList().size()-2)*tablero.getPasa_por_salida() > tablero.jug_q_tiene_turno().getFortuna()){
                    Juego.consola.imprimir("HIPOTECAR");
                }else {
                    for (Jugador jug_a_pagar : tablero.getJugadorArrayList()){
                        if(jug_a_pagar.getTipo_jugador().equals(Tipo_jugador.no_banca)){
                            if(!jug_a_pagar.equals(tablero.jug_q_tiene_turno())){
                                jug_a_pagar.setFortuna(jug_a_pagar.getFortuna() + tablero.getPasa_por_salida());
                                tablero.jug_q_tiene_turno().setFortuna(tablero.jug_q_tiene_turno().getFortuna() - tablero.getPasa_por_salida());
                            }
                        }
                    }
                    Juego.consola.imprimir("En total pagas " + (tablero.getJugadorArrayList().size()-2) + " * " + tablero.getPasa_por_salida() + " = " + (tablero.getJugadorArrayList().size()-2)*tablero.getPasa_por_salida() + "€ a los demás jugadores");
                    tablero.al_bote_del_parking((tablero.getJugadorArrayList().size()-2)*tablero.getPasa_por_salida());
                    tablero.jug_q_tiene_turno().setDin_gastadoen_impuestossuertecomunidad(tablero.jug_q_tiene_turno().getDin_gastadoen_impuestossuertecomunidad() + (tablero.getJugadorArrayList().size()-2)*tablero.getPasa_por_salida());
                }
                break;
        }
    }
}
