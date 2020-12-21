package Excepciones;

public class ErrMuchosJugs extends Exception_crear_jugador {

    int MAX_JUGADORES;

    public ErrMuchosJugs(int MAX_JUGADORES){
        super("");
        this.MAX_JUGADORES = MAX_JUGADORES;
    }

    @Override
    public String descripcion() {
        return "Hay "+  MAX_JUGADORES +" jugadores en la partida, por lo que no se puede crear más";
    }


}
