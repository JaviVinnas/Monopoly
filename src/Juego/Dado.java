package Juego;

import java.util.Random;

public class Dado {
    public Dado(){}
    public int lanzardado(){
        Random rnd = new Random();
        return rnd.nextInt(6)+1;
    }
}
