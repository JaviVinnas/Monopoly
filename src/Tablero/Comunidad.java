package Tablero;

import Casilla.Casilla;
import Jugador.*;

public class Comunidad extends Carta {



    public Comunidad(int numero_de_carta){
        super(numero_de_carta);
        String descrip = "descripcionpordefecto";
        switch (numero_de_carta){
            case 1:
                descrip = "Paga 350€ por un fin de semana en un balneario de 5 estrellas";
                break;
            case 2:
                descrip = "Te investigan por fraude de identidad. Ve a la Cárcel. Ve directamente sin pasar por la casilla de Salida y sin cobrar el pasa por salida correspondiente. \nEstarás los siguientes 3 turnos sin tirar";
                break;
            case 3:
                descrip = "Colócate en la casilla de Salida y cobra el pasa por salida correspondiente";
                break;
            case 4:
                descrip = "Tu compañía de Internet obtiene beneficios. Recibe 200€";
                break;
            case 5:
                descrip = "Alquilas a tus compañeros una ático en Paseo del Prado durante una semana. Paga 150€ a cada jugador";
                break;
            case 6:
                descrip = "Ve a la calle maria de molina a visitar a un amigo. Si pasas por la casilla de Salida, cobra el pasa por salida correspondiente.";
                break;
        }
        setDescripcion(descrip);
    }

    @Override
    public void accion(int dados, Tablero tablero) throws Exception{
        int pos_donde_estaba;
        int pos_final = 0;
        switch (getNumero_de_carta()){
            case 1:
                tablero.jug_q_tiene_turno().setFortuna(tablero.jug_q_tiene_turno().getFortuna() - 350.0);
                tablero.jug_q_tiene_turno().setDin_gastadoen_impuestossuertecomunidad(tablero.jug_q_tiene_turno().getDin_gastadoen_impuestossuertecomunidad() + 350.0);
                tablero.al_bote_del_parking(350.0);
                break;
            case 2:
                tablero.jug_q_tiene_turno().meter_en_carcel(tablero);
                break;
            case 3:
                pos_donde_estaba =  tablero.jug_q_tiene_turno().getAvatar().getCasillaAvatar().getPosicion();
                tablero.jug_q_tiene_turno().getAvatar().getCasillaAvatar().eliminar_jugador_de_casilla(tablero.jug_q_tiene_turno());
                for(Casilla cas : tablero.getCasillaArrayList()){
                    if(cas.getNombre().equals("Salida")){
                        cas.setNum_veces_que_se_cayo_en_casilla(cas.getNum_veces_que_se_cayo_en_casilla() + 1);
                        pos_final = cas.getPosicion();
                        cas.getJugadores_en_casilla().add(tablero.jug_q_tiene_turno());
                        tablero.jug_q_tiene_turno().getAvatar().setCasillaAvatar(cas);
                        cas.accion_casilla(tablero.jug_q_tiene_turno(), tablero, dados);
                        break;
                    }
                }
                tablero.jug_q_tiene_turno().cobrar_salida(tablero);
                break;
            case 4:
                tablero.jug_q_tiene_turno().setFortuna(tablero.jug_q_tiene_turno().getFortuna() + 200.0);
                tablero.jug_q_tiene_turno().setDin_ganadopor_suertecomunidad(tablero.jug_q_tiene_turno().getDin_ganadopor_suertecomunidad() +200.0);
                break;
            case 5:
                if((tablero.getJugadorArrayList().size()-2)*150 > tablero.jug_q_tiene_turno().getFortuna()){
                    System.out.println("HIPOTECAR");
                }else {
                    for (Jugador jug_a_pagar : tablero.getJugadorArrayList()){
                        if(jug_a_pagar.getTipo_jugador().equals(Tipo_jugador.no_banca)){
                            if(!jug_a_pagar.equals(tablero.jug_q_tiene_turno())){
                                jug_a_pagar.setFortuna(jug_a_pagar.getFortuna() +100);
                                tablero.jug_q_tiene_turno().setFortuna(tablero.jug_q_tiene_turno().getFortuna() - 100);
                            }
                        }
                    }
                    System.out.println("En total pagas " + (tablero.getJugadorArrayList().size()-2) + " * 100 = " + (tablero.getJugadorArrayList().size()-2)*100.0 + "€ a los demás jugadores");
                    tablero.al_bote_del_parking((tablero.getJugadorArrayList().size()-2)*100.0);
                    tablero.jug_q_tiene_turno().setDin_gastadoen_impuestossuertecomunidad(tablero.jug_q_tiene_turno().getDin_gastadoen_impuestossuertecomunidad() + (tablero.getJugadorArrayList().size()-2)*150.0);
                }
                break;
            case 6:
                pos_donde_estaba =  tablero.jug_q_tiene_turno().getAvatar().getCasillaAvatar().getPosicion();
                tablero.jug_q_tiene_turno().getAvatar().getCasillaAvatar().eliminar_jugador_de_casilla(tablero.jug_q_tiene_turno());
                for(Casilla cas : tablero.getCasillaArrayList()){
                    if(cas.getNombre().equals("Calle_Maria_de_Molina")){
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
        }
    }
}
