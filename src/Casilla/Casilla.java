package Casilla;

import Jugador.*;
import Tablero.Tablero;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public abstract class Casilla{
    private int posicion;
    private String nombre;
    private ArrayList<Jugador> jugadores_en_casilla;
    private double num_veces_que_se_cayo_en_casilla;

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Jugador> getJugadores_en_casilla() {
        return jugadores_en_casilla;
    }

    public void setJugadores_en_casilla(ArrayList<Jugador> jugadores_en_casilla) {
        this.jugadores_en_casilla = jugadores_en_casilla;
    }

    public double getNum_veces_que_se_cayo_en_casilla() {
        return num_veces_que_se_cayo_en_casilla;
    }

    public void setNum_veces_que_se_cayo_en_casilla(double num_veces_que_se_cayo_en_casilla) {
        this.num_veces_que_se_cayo_en_casilla = num_veces_que_se_cayo_en_casilla;
    }

    public Casilla(int posicion, String nombre){
        this.posicion = posicion;
        this.nombre = nombre;
        this.jugadores_en_casilla = new ArrayList<Jugador>();
        this.num_veces_que_se_cayo_en_casilla = 0.0;
    }

    public abstract void  describir_casilla(Tablero tablero);
    public abstract void  accion_casilla(Jugador jugador, Tablero tablero, int dados) throws Exception;

    @Override
    public boolean equals(Object o) {
        if(o instanceof Casilla){
            int i = ((Casilla) o).getPosicion();
            int j = this.posicion;
            String a = ((Casilla) o).getNombre();
            String b = this.nombre;
            return ((i == j) && (a.equals(b)));
        }else {
            return false;
        }
    }
    public boolean esta_avatar(@NotNull Avatar avatar ){
        for(Jugador jug : jugadores_en_casilla){
            if(jug.getAvatar().equals(avatar)){
                return true;
            }
        }
        return false;
    }

    public boolean esta_avatar(@NotNull Jugador jugador ){
        Avatar avatar = jugador.getAvatar();
        for(Jugador jug : jugadores_en_casilla){
            if(jug.getAvatar().equals(avatar)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Jugador jugador : this.jugadores_en_casilla) {
            char c = jugador.getAvatar().getId();
            s.append("&").append(c).append(" ");
        }
        StringBuilder esp = new StringBuilder();
        int i = Tablero.getNombre_mas_largo() + 18;; //48 es la longitud del nombre de casilla mas largo (30) + la longitud de la cadena de ids de avatares mas larga (6 jugadores + 3 caracteres por jugador = 18)
        while (i>0){                                    //hay una función en tablero que devuelve el nombre de casilla más largo
            esp.append(" ");
            i--;
        }
        return this.nombre + esp + s + "\t";
    }

    public void eliminar_jugador_de_casilla(Jugador jugador){
        for( int i = 0 ; i < jugadores_en_casilla.size(); i++){
            if(jugadores_en_casilla.get(i).equals(jugador)){
                jugadores_en_casilla.remove(i);
                break;
            }
        }
    }

    public void numvecesquesecayoencasilla_masmas(){
        num_veces_que_se_cayo_en_casilla++;
    }


}
