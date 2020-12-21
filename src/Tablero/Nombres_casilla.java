package Tablero;

import java.util.ArrayList;
public class Nombres_casilla {
    private ArrayList<String> nombre_casilla;

    public ArrayList<String> getNombre_casilla() {
        return nombre_casilla;
    }


    public Nombres_casilla(){
        nombre_casilla = new ArrayList<>();
        nombre_casilla.add("Salida"); //1
        nombre_casilla.add("Ronda_de_Valencia"); //2
        nombre_casilla.add("Caja_de_Comunidad"); //3
        nombre_casilla.add("Plaza_de_lavapies"); //4
        nombre_casilla.add("Impuesto_sobre_el_Capital"); //5
        nombre_casilla.add("Estación_de_Goya"); //6
        nombre_casilla.add("Glorieta_de_4_Caminos");
        nombre_casilla.add("Suerte"); //7
        nombre_casilla.add("Avenida_Reina_Victoria"); //8
        nombre_casilla.add("Calle_Bravo_Murillo"); //9
        nombre_casilla.add("Cárcel/Visitas"); //10
        nombre_casilla.add("Glorieta_de_Bilbao");//11
        nombre_casilla.add("Compañía_de_Electricidad"); //12
        nombre_casilla.add("Calle_Alberto_Aguilera"); //13
        nombre_casilla.add("Calle_Fuencarral"); //14
        nombre_casilla.add("Estación_de_las_Delicias"); ////15
        nombre_casilla.add("Avenida_Felipe_II"); ////16
        nombre_casilla.add("Caja_de_Comunidad"); //17
        nombre_casilla.add("Calle_Velazquez");//18
        nombre_casilla.add("Calle_Serrano");//19
        nombre_casilla.add("Parking");//20
        nombre_casilla.add("Avenida_de_America"); //21
        nombre_casilla.add("Suerte");//22
        nombre_casilla.add("Calle_Maria_de_Molina");//23
        nombre_casilla.add("Calle_cea_Bermúdez"); //24
        nombre_casilla.add("Estación_del_Mediodía"); //25
        nombre_casilla.add("Avenida_de_los_Reyes_Católicos");///26
        nombre_casilla.add("Calle_Bailen");///27
        nombre_casilla.add("Compañía_de_aguas");///28
        nombre_casilla.add("Plaza_España");//29
        nombre_casilla.add("Ir_a_la_cárcel"); //30
        nombre_casilla.add("Puerta_del_Sol");//31
        nombre_casilla.add("Calle_de_Alcalá");//32
        nombre_casilla.add("Caja_de_Comunidad");//33
        nombre_casilla.add("Gran_Vía");//34
        nombre_casilla.add("Estación_del_Norte");//35
        nombre_casilla.add("Suerte");//36
        nombre_casilla.add("Paseo_de_la_castellana");//37
        nombre_casilla.add("Impuesto_de_Lujo");//38
        nombre_casilla.add("Paseo_del_Prado");//39
    }
    public int mas_largo(){
        int longitud = -1;
        for(String nombre : this.nombre_casilla){
            if (nombre.length() > longitud){
                longitud = nombre.length();
            }
        }
        return longitud;
    }
}
