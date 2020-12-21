package Jugador;

import Casilla.*;
import Construccion.*;
import Juego.Juego;
import Tablero.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Jugador {

    private String nombre;
    private Avatar avatar;
    private Tipo_jugador tipo_jugador;
    private double fortuna;
    private ArrayList<Propiedad> propiedades;
    private ArrayList<Casilla> hipotecas;
    private HashMap<Tipo_Edificio, ArrayList<Edificio>> edificios_jug;
    private boolean es_su_turno;
    private int vuelta_en_la_q_sale_d_la_carcel;
    private boolean ha_lanzado_dados;
    private int veces_dobles;
    //estadisticas jugador
    private double din_gastadoen_comprarpropedif;
    private double din_gastadoen_impuestossuertecomunidad;
    private double din_gastadoen_alquileres;
    private double din_ganadopor_alquileres;
    private double din_ganadopor_pasaporsalida;
    private double din_ganadopor_suertecomunidad;
    private int numveces_quecayoencarcel;
    //estadisticas partida
    private int numvueltas;
    private int numvecesquelanzadados;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Tipo_jugador getTipo_jugador() {
        return tipo_jugador;
    }

    public void setTipo_jugador(Tipo_jugador tipo_jugador) {
        this.tipo_jugador = tipo_jugador;
    }

    public double getFortuna() {
        return Math.round(fortuna * 100.0)/100.0;
    }

    public void setFortuna(double fortuna) {
        this.fortuna = fortuna;
    }

    public ArrayList<Propiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(ArrayList<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    public ArrayList<Casilla> getHipotecas() {
        return hipotecas;
    }

    public void setHipotecas(ArrayList<Casilla> hipotecas) {
        this.hipotecas = hipotecas;
    }

    public boolean isEs_su_turno() {
        return es_su_turno;
    }

    public void setEs_su_turno(boolean es_su_turno) {
        this.es_su_turno = es_su_turno;
    }

    public int getVuelta_en_la_q_sale_d_la_carcel() {
        return vuelta_en_la_q_sale_d_la_carcel;
    }

    public void setVuelta_en_la_q_sale_d_la_carcel(int vuelta_en_la_q_sale_d_la_carcel) {
        this.vuelta_en_la_q_sale_d_la_carcel = vuelta_en_la_q_sale_d_la_carcel;
    }

    public boolean isHa_lanzado_dados() {
        return ha_lanzado_dados;
    }

    public void setHa_lanzado_dados(boolean ha_lanzado_dados) {
        this.ha_lanzado_dados = ha_lanzado_dados;
    }

    public int getVeces_dobles() {
        return veces_dobles;
    }

    public void setVeces_dobles(int veces_dobles) {
        this.veces_dobles = veces_dobles;
    }

    public double getDin_gastadoen_comprarpropedif() {
        return din_gastadoen_comprarpropedif;
    }

    public void setDin_gastadoen_comprarpropedif(double din_gastadoen_comprarpropedif) {
        this.din_gastadoen_comprarpropedif = din_gastadoen_comprarpropedif;
    }

    public double getDin_gastadoen_impuestossuertecomunidad() {
        return din_gastadoen_impuestossuertecomunidad;
    }

    public void setDin_gastadoen_impuestossuertecomunidad(double din_gastadoen_impuestossuertecomunidad) {
        this.din_gastadoen_impuestossuertecomunidad = din_gastadoen_impuestossuertecomunidad;
    }

    public double getDin_gastadoen_alquileres() {
        return din_gastadoen_alquileres;
    }

    public void setDin_gastadoen_alquileres(double din_gastadoen_alquileres) {
        this.din_gastadoen_alquileres = din_gastadoen_alquileres;
    }

    public double getDin_ganadopor_alquileres() {
        return din_ganadopor_alquileres;
    }

    public void setDin_ganadopor_alquileres(double din_ganadopor_alquileres) {
        this.din_ganadopor_alquileres = din_ganadopor_alquileres;
    }

    public double getDin_ganadopor_pasaporsalida() {
        return din_ganadopor_pasaporsalida;
    }

    public void setDin_ganadopor_pasaporsalida(double din_ganadopor_pasaporsalida) {
        this.din_ganadopor_pasaporsalida = din_ganadopor_pasaporsalida;
    }

    public double getDin_ganadopor_suertecomunidad() {
        return din_ganadopor_suertecomunidad;
    }

    public void setDin_ganadopor_suertecomunidad(double din_ganadopor_suertecomunidad) {
        this.din_ganadopor_suertecomunidad = din_ganadopor_suertecomunidad;
    }

    public int getNumveces_quecayoencarcel() {
        return numveces_quecayoencarcel;
    }

    public void setNumveces_quecayoencarcel(int numveces_quecayoencarcel) {
        this.numveces_quecayoencarcel = numveces_quecayoencarcel;
    }

    public int getNumvueltas() {
        return numvueltas;
    }

    public void setNumvueltas(int numvueltas) {
        this.numvueltas = numvueltas;
    }

    public int getNumvecesquelanzadados() {
        return numvecesquelanzadados;
    }

    public void setNumvecesquelanzadados(int numvecesquelanzadados) {
        this.numvecesquelanzadados = numvecesquelanzadados;
    }

    public HashMap<Tipo_Edificio, ArrayList<Edificio>> getEdificios_jug() {
        return edificios_jug;
    }

    public void setEdificios_jug(HashMap<Tipo_Edificio, ArrayList<Edificio>> edificios_jug) {
        this.edificios_jug = edificios_jug;
    }




    public Jugador() {
        this.nombre = "BANCA";
        this.tipo_jugador = Tipo_jugador.banca;
        this.propiedades = new ArrayList<Propiedad>();
    }

    public Jugador(String nombre, Tipo_avatar tipoAvatar, Tablero tablero) {  //CONSTRUCTOR DE LOS JUGADORES QUE NO SON BANCA
        this.nombre = nombre;
        switch (tipoAvatar){
            case coche:
                this.avatar = new Coche(this);
                break;
            case pelota:
                this.avatar = new Pelota(this);
                break;
            case esfinge:
                this.avatar = new Esfinge(this);
                break;
            case sombrero:
                this.avatar = new Sombrero(this);
        }
        this.tipo_jugador = Tipo_jugador.no_banca;
        this.fortuna = Math.round(tablero.getPasa_por_salida() * 22 * 33.3333) / 100.0;
        this.propiedades = new ArrayList<Propiedad>();
        this.hipotecas = new ArrayList<Casilla>();
        this.es_su_turno = false;
        this.edificios_jug = new HashMap<Tipo_Edificio, ArrayList<Edificio>>();
        this.getEdificios_jug().put(Tipo_Edificio.CASA, new ArrayList<Edificio>());
        this.getEdificios_jug().put(Tipo_Edificio.HOTEL, new ArrayList<Edificio>());
        this.getEdificios_jug().put(Tipo_Edificio.PISCINA, new ArrayList<Edificio>());
        this.getEdificios_jug().put(Tipo_Edificio.PISTA_DE_DEPORTE, new ArrayList<Edificio>());
        this.vuelta_en_la_q_sale_d_la_carcel = 0;
        this.ha_lanzado_dados = false;
        this.veces_dobles = 0;
        this.din_gastadoen_comprarpropedif = 0;
        this.din_gastadoen_impuestossuertecomunidad = 0;
        this.din_gastadoen_alquileres = 0;
        this.din_ganadopor_alquileres = 0;
        this.din_ganadopor_pasaporsalida = 0;
        this.din_ganadopor_suertecomunidad = 0;
        this.numveces_quecayoencarcel = 0;
        this.numvueltas = 0;
        this.numvecesquelanzadados = 0;

    }

    @Override
    public String toString() {

        ArrayList<String> propiedadess = new ArrayList<>();
        for (Casilla cas : this.getPropiedades()) {
            propiedadess.add(cas.getNombre());
        }

        ArrayList<String> hipotecass = new ArrayList<>();
        for (Casilla cas : this.getHipotecas()) {
            hipotecass.add(cas.getNombre());
        }

        return "Jugador de nombre " + nombre + "\n" +
                "|\tAvatar --> " + avatar.getId() + '\n' +
                "|\tfortuna --> " + getFortuna() + '€' + '\n' +
                "|\tpropiedades --> " + propiedadess + '\n' +
                "|\thipotecas --> " + hipotecass + '\n' +
                "|\tedificios --> " + mostrarEdificiosJug();
    }

    @Override
    public boolean equals(Object o) {
        if( o instanceof Jugador ){
            return ((Jugador) o).getNombre().equals(this.nombre);
        }else {
            return false;
        }
    }

    public int de_cuantas_estaciones_es_propietario(){
        return (int) propiedades.stream().filter(prop -> prop instanceof Transporte).count();
    }

    public void cobrar_salida(Tablero tablero) {
        this.setFortuna(this.getFortuna() + tablero.getPasa_por_salida());
        din_ganadopor_pasaporsalida =  din_ganadopor_pasaporsalida + tablero.getPasa_por_salida();
        numvueltas++;
        System.out.println("El jugador " + getNombre() + " con avatar " + getAvatar().getId() + " pasa por la salida y cobra " + tablero.getPasa_por_salida() + "€");
    }

    public String mostrarEdificiosJug(){
        String lista = "";
        Iterator<ArrayList<Edificio>> ite = this.edificios_jug.values().iterator();
        while (ite.hasNext()){
            for (Edificio i : ite.next())
                lista = lista + i.getId() + " , ";
        }
        return lista;
    }

    public double patrimonio(){
        double patrimonio = fortuna;
        for(Propiedad propiedad : propiedades){
            patrimonio = patrimonio + propiedad.getPrecio();
        }
        return patrimonio;
    }

    public String estadisticas_jugador(){
        return ("|\tDinero invertido: " + getDin_gastadoen_comprarpropedif() + "\n" +
                "|\tDinero gastado en tasas e impuestos: " + getDin_gastadoen_impuestossuertecomunidad() + "\n" +
                "|\tDinero gastado en alquileres: " + getDin_gastadoen_alquileres() + "\n" +
                "|\tDinero ganado por alquileres: " + getDin_ganadopor_alquileres() + "\n" +
                "|\tDinero ganado por pasar por salida: " + getDin_ganadopor_pasaporsalida() +"\n" +
                "|\tDinero ganado por inversiones o bote: " + getDin_ganadopor_suertecomunidad() + "\n" +
                "|\tVeces que se cayó en la cárcel: " + numveces_quecayoencarcel + "\n");
    }

    public void edificar( Solar solar, Tipo_Edificio edif, Tablero tablero) throws Exception{
        Grupo grupo = tablero.getGrupos_de_solares().get(solar.colorcasilla_to_colorgrupo(solar.getColor_solar()));
        switch (edif){
            case CASA:
                //Comprobamos que en el solar no se hayan construido ya cuatro casas
                if(solar.getEdificios_del_solar().get(Tipo_Edificio.CASA).size() >= 4 ) throw new Exception("Ya hay cuatro casas en " + solar.getNombre());
                //comprobamos que el jugador tiene dinero para pagar la casa
                if(fortuna < 0.6*solar.getPrecio()) throw new Exception("No tienes dinero para construir una casa");
                Casa casa = new Casa(solar,this,tablero);
                tablero.getEdificios().get(Tipo_Edificio.CASA).add(casa);
                solar.getEdificios_del_solar().get(Tipo_Edificio.CASA).add(casa);
                solar.getEdificios_del_grupo().get(Tipo_Edificio.CASA).add(casa);
                this.getEdificios_jug().get(Tipo_Edificio.CASA).add(casa);
                grupo.getEdificios_del_grupo().add(casa);
                //Configuramos la fortuna del usuario
                this.setFortuna(this.getFortuna() - casa.getPrecio());
                Juego.consola.imprimir("Se ha edificado una casa en " + solar.getNombre() + " por " + casa.getPrecio() + "€. La fortuna de " + this.getNombre() + " se reduce a " + this.getFortuna() + "€.");
                break;
            case HOTEL:
                if (solar.getEdificios_del_solar().get(Tipo_Edificio.CASA).size() != 4) throw new Exception("No hay 4 casas en el solar por lo que no se puede construir un hotel");
                if(fortuna < .6* solar.getPrecio())  throw new Exception("No tienes dinero para construir un hotel");
                //Eliminamos las casas a sustituir en diferentes listas
                tablero.getEdificios().get(Tipo_Edificio.CASA).removeAll(solar.getEdificios_del_solar().get(Tipo_Edificio.CASA));
                solar.getEdificios_del_solar().get(Tipo_Edificio.CASA).removeAll(solar.getEdificios_del_solar().get(Tipo_Edificio.CASA));
                solar.getEdificios_del_grupo().get(Tipo_Edificio.CASA).removeAll(solar.getEdificios_del_solar().get(Tipo_Edificio.CASA));
                this.getEdificios_jug().get(Tipo_Edificio.CASA).subList(0, 4).clear();
                //creamos el hotel
                Hotel h = new Hotel(solar,this,tablero);
                //añadimos el hotel
                tablero.getEdificios().get(Tipo_Edificio.HOTEL).add(h);
                solar.getEdificios_del_solar().get(Tipo_Edificio.HOTEL).add(h);
                solar.getEdificios_del_grupo().get(Tipo_Edificio.HOTEL).add(h);
                this.getEdificios_jug().get(Tipo_Edificio.HOTEL).add(h);
                grupo.getEdificios_del_grupo().add(h);
                //configuramos la fortuna del usuario
                this.setFortuna(this.getFortuna() - h.getPrecio());
                Juego.consola.imprimir("Se ha edificado un hotel en " + solar.getNombre() + " por " + h.getPrecio() + "€. La fortuna de " + this.getNombre() + " se reduce a " + this.getFortuna() + "€.");
                break;
            case PISCINA:
                if(solar.getEdificios_del_solar().get(Tipo_Edificio.CASA).size() < 2 ) throw new Exception("Debe haber al menos dos casas en "  + solar.getNombre() + " para construir una piscina");
                if(solar.getEdificios_del_solar().get(Tipo_Edificio.HOTEL).size() < 1) throw new Exception("Debe haber al menos un hotel en " + solar.getNombre() + " para construir una piscina");
                if(fortuna < .4*solar.getPrecio()) throw new Exception("No tienes dinero para construir una piscina");
                //creamos la piscina
                Piscina p = new Piscina(solar,this,tablero);
                //añadimos la piscina
                tablero.getEdificios().get(Tipo_Edificio.PISCINA).add(p);
                solar.getEdificios_del_solar().get(Tipo_Edificio.PISCINA).add(p);
                solar.getEdificios_del_grupo().get(Tipo_Edificio.PISCINA).add(p);
                this.getEdificios_jug().get(Tipo_Edificio.PISCINA).add(p);
                grupo.getEdificios_del_grupo().add(p);
                //configuramos la fortuna del usuario
                this.setFortuna(this.getFortuna() - p.getPrecio());
                Juego.consola.imprimir("Se ha edificado una piscina en " + solar.getNombre() + " por " + p.getPrecio() + "€. La fortuna de " + this.getNombre() + " se reduce a " + this.getFortuna() + "€.");
                break;
            case PISTA_DE_DEPORTE:
                if(solar.getEdificios_del_solar().get(Tipo_Edificio.HOTEL).size() < 2) throw new Exception("No se puede construir una pista de deporte en " + solar.getNombre() + " ya que aún no se han edificado dos hoteles.");
                if (fortuna < 1.25*solar.getPrecio()) throw new Exception("No tienes dinero suficiente para construir una piscina");
                //Añadimos la pista de deporte
                PistaDeporte pista = new PistaDeporte(solar,this,tablero);
                //Añadimos la pista de deporte
                tablero.getEdificios().get(Tipo_Edificio.PISTA_DE_DEPORTE).add(pista);
                solar.getEdificios_del_solar().get(Tipo_Edificio.PISTA_DE_DEPORTE).add(pista);
                solar.getEdificios_del_grupo().get(Tipo_Edificio.PISTA_DE_DEPORTE).add(pista);
                this.getEdificios_jug().get(Tipo_Edificio.PISTA_DE_DEPORTE).add(pista);
                grupo.getEdificios_del_grupo().add(pista);
                //configuramos la fortuna del usuario
                this.setFortuna(this.getFortuna() - pista.getPrecio());
                Juego.consola.imprimir("Se ha edificado una pista de deporte en " + solar.getNombre() + " por " + pista.getPrecio() + "€. La fortuna de " + this.getNombre() + " se reduce a " + this.getFortuna() + "€.");
                break;
        }
    }

    public void vender(Solar solar, @NotNull Tipo_Edificio tipo, Tablero tablero, ArrayList<Edificio> edificios, int numEdf){
       ArrayList<Edificio> edificios_a_eliminar = new ArrayList<>();
       double valorRecibido = 0.0;
       int edificiosRestantes = 0;
       switch (tipo){
           case CASA:
               //añadimos a un arraylist los edificios a eliminar
               for(int i = 0; i < numEdf; i++){
                   edificios_a_eliminar.add(edificios.get(i));
               }
               //eliminamos los edificios
               tablero.getEdificios().get(Tipo_Edificio.CASA).removeAll(edificios_a_eliminar);
               solar.getEdificios_del_solar().get(Tipo_Edificio.CASA).removeAll(edificios_a_eliminar);
               solar.getEdificios_del_grupo().get(Tipo_Edificio.CASA).removeAll(edificios_a_eliminar);
               this.getEdificios_jug().get(Tipo_Edificio.CASA).removeAll(edificios_a_eliminar);
               //recogemos las casas que quedan
               edificiosRestantes = this.getEdificios_jug().get(Tipo_Edificio.CASA).size();
               //Configuramos fortuna de usuario
               fortuna += valorVentaEdificios(edificios_a_eliminar);
               if (edificios_a_eliminar.size()>1){
                   Juego.consola.imprimir(this.getNombre() + " ha vendido " + numEdf + " casas en " + solar.getNombre() + ", recibiendo " + valorVentaEdificios(edificios_a_eliminar) + "€. En la propiedad quedan " + edificiosRestantes + " casas.");
               }else {
                   Juego.consola.imprimir(this.getNombre() + " ha vendido una casa en " + solar.getNombre() + ", recibiendo " + valorVentaEdificios(edificios_a_eliminar) + "€. En la propiedad quedan " + edificiosRestantes + " casas.");
               }
               break;
           case HOTEL:
               //añadimos a un arraylist los edificios a eliminar
               for (int i = 0; i < numEdf; i++) {
                   edificios_a_eliminar.add(edificios.get(i));
               }
               //Eliminamos los edificios
               tablero.getEdificios().get(Tipo_Edificio.HOTEL).removeAll(edificios_a_eliminar);
               solar.getEdificios_del_solar().get(Tipo_Edificio.HOTEL).removeAll(edificios_a_eliminar);
               solar.getEdificios_del_grupo().get(Tipo_Edificio.HOTEL).removeAll(edificios_a_eliminar);
               this.getEdificios_jug().get(Tipo_Edificio.HOTEL).removeAll(edificios_a_eliminar);
                //recogemos los hoteles que quedan
               edificiosRestantes = this.getEdificios_jug().get(Tipo_Edificio.HOTEL).size();
                //configuramos la fortuna del usuario
               fortuna += valorVentaEdificios(edificios_a_eliminar);
                if(edificios_a_eliminar.size()>1){
                    Juego.consola.imprimir(this.getNombre() + " ha vendido " + numEdf + " hoteles en " + solar.getNombre() + ", recibiendo " + valorVentaEdificios(edificios_a_eliminar) + "€. En la propiedad quedan " + edificiosRestantes + " hoteles.");
                }else{
                    Juego.consola.imprimir(this.getNombre() + " ha vendido un hotel en " + solar.getNombre() + ", recibiendo " + valorVentaEdificios(edificios_a_eliminar) + "€. En la propiedad quedan " + edificiosRestantes + " hoteles.");
                }
                break;
           case PISCINA:
               //añadimos a un arraylist los edificios a eliminar
               for (int i = 0; i < numEdf; i++) {
                   edificios_a_eliminar.add(edificios.get(i));
               }
               //Eliminamos os edificios
               tablero.getEdificios().get(Tipo_Edificio.PISCINA).removeAll(edificios_a_eliminar);
               solar.getEdificios_del_solar().get(Tipo_Edificio.PISCINA).removeAll(edificios_a_eliminar);
               solar.getEdificios_del_grupo().get(Tipo_Edificio.PISCINA).removeAll(edificios_a_eliminar);
               this.getEdificios_jug().get(Tipo_Edificio.PISCINA).removeAll(edificios_a_eliminar);
               //Recogemos as piscinas que quedan
               edificiosRestantes = this.getEdificios_jug().get(Tipo_Edificio.PISCINA).size();
               //Configuramos fortuna de usuario
               fortuna+= valorVentaEdificios(edificios_a_eliminar);
               if (edificios_a_eliminar.size()>1)
                   Juego.consola.imprimir(this.getNombre() + " ha vendido " + numEdf + " piscinas en " + solar.getNombre() + ", recibiendo " + valorVentaEdificios(edificios_a_eliminar) + "€. En la propiedad quedan " + edificiosRestantes + " piscinas.");
               else
                   Juego.consola.imprimir(this.getNombre() + " ha vendido una piscina en " + solar.getNombre() + ", recibiendo " + valorVentaEdificios(edificios_a_eliminar) + "€. En la propiedad quedan " + edificiosRestantes + " piscinas.");
               break;
           case PISTA_DE_DEPORTE:
               //añadimos a un arraylist los edificios a eliminar
               for (int i = 0; i < numEdf; i++) {
                   edificios_a_eliminar.add(edificios.get(i));
               }
               //Eliminamos os edificios
               tablero.getEdificios().get(Tipo_Edificio.PISTA_DE_DEPORTE).removeAll(edificios_a_eliminar);
               solar.getEdificios_del_solar().get(Tipo_Edificio.PISTA_DE_DEPORTE).removeAll(edificios_a_eliminar);
               solar.getEdificios_del_grupo().get(Tipo_Edificio.PISTA_DE_DEPORTE).removeAll(edificios_a_eliminar);
               this.getEdificios_jug().get(Tipo_Edificio.PISTA_DE_DEPORTE).removeAll(edificios_a_eliminar);
               //Recollemos as pistas que quedan
               edificiosRestantes = this.getEdificios_jug().get(Tipo_Edificio.PISTA_DE_DEPORTE).size();
               //Configuramos fortuna de usuario
               fortuna += valorVentaEdificios(edificios_a_eliminar);
               if (edificios_a_eliminar.size()>1)
                   Juego.consola.imprimir(this.getNombre() + " ha vendido " + numEdf + " pistas de deporte en " + solar.getNombre() + ", recibiendo " + valorVentaEdificios(edificios_a_eliminar) + "€. En la propiedad quedan " + edificiosRestantes + " pistas de deporte.");
               else
                   Juego.consola.imprimir(this.getNombre() + " ha vendido una pista de deporte en " + solar.getNombre() + ", recibiendo " + valorVentaEdificios(edificios_a_eliminar) + "€. En la propiedad quedan " + edificiosRestantes + " pistas de deporte.");
               break;
       }

    }

    public double valorVentaEdificios(ArrayList<Edificio> edificios) {
        double sumatorio = 0.0;
        for (Edificio ed : edificios){
            sumatorio = sumatorio + ed.getPrecio()/2;
        }
        return sumatorio;
    }

    public void numvecesquelanzadados_masmas(){
        numvecesquelanzadados++;
    }
    public void vecesdobles_masmas(){
        veces_dobles++;
    }
    public boolean estaenlacarcel(){
        return vuelta_en_la_q_sale_d_la_carcel != 0;
    }


    public void meter_en_carcel(Tablero tablero) throws Exception{
        tablero.jug_q_tiene_turno().getAvatar().getCasillaAvatar().eliminar_jugador_de_casilla(tablero.jug_q_tiene_turno());
        for(Casilla cas : tablero.getCasillaArrayList()){
            if(cas.getNombre().equals("Cárcel/Visitas")){
                cas.setNum_veces_que_se_cayo_en_casilla(cas.getNum_veces_que_se_cayo_en_casilla() + 1);
                tablero.jug_q_tiene_turno().getAvatar().setCasillaAvatar(cas);
                cas.getJugadores_en_casilla().add(tablero.jug_q_tiene_turno());
                tablero.jug_q_tiene_turno().setVuelta_en_la_q_sale_d_la_carcel(tablero.getVuelta() + 4);
                tablero.jug_q_tiene_turno().setVeces_dobles(0);
                tablero.jug_q_tiene_turno().setNumveces_quecayoencarcel(tablero.jug_q_tiene_turno().getNumveces_quecayoencarcel() + 1 );
                tablero.jug_q_tiene_turno().setHa_lanzado_dados(true);
                break;
            }
        }
    }

    public  boolean tiene_prop_de_nombre(String nombre, Tablero tablero ) throws Exception{
        Casilla cas = tablero.casilla_a_partir_de(nombre);
        if( cas instanceof Propiedad){
            for (Propiedad prop : propiedades){
                if(prop.equals(cas)){
                    return true;
                }
            }
        }
        return false;
    }
    public  boolean tiene_hipotecado_de_nombre(String nombre, Tablero tablero ) throws Exception{
        Casilla cas = tablero.casilla_a_partir_de(nombre);
        if( cas instanceof Propiedad){
            for (Casilla prop : hipotecas){
                if(prop.equals(cas)){
                    return true;
                }
            }
        }
        return false;
    }
    //devuelve la casilla donde estaba antes
    public int eliminar_de_su_casilla(){
        int pos = avatar.getCasillaAvatar().getPosicion();
        avatar.getCasillaAvatar().eliminar_jugador_de_casilla(this);
        return pos;
    }

    public Casilla meter_en_casilla_de_numero(int posicion, Tablero tablero) throws Exception{
        if(posicion < 0 ) throw new Exception("No se puede meter un jugador en una casilla con una posición menor que 0");
        if(posicion > 39) throw new Exception("No se puede meter un jugador en una casilla con una posición mayor a 39");
        for(Casilla casilla : tablero.getCasillaArrayList()){
            if(casilla.getPosicion() == posicion){
                casilla.getJugadores_en_casilla().add(this);
                avatar.setCasillaAvatar(casilla);
                return casilla;
            }
        }
        throw new Exception("No se ha encontrado la casilla en la que meter al jugador");
    }

    public Casilla donde_esta(){
        return avatar.getCasillaAvatar();
    }

    public boolean es_coche_avanzado(){
        return avatar instanceof Coche && avatar.isMov_avanzado();
    }

    public boolean coche_avanzado_y_puede_seguir_tirando(){
        return (es_coche_avanzado()  && ((Coche)avatar).getVeces_que_ha_tirado() < 4 && ((Coche) avatar).isVuelta_cuando_vuelve_a_tirar_coche() == 0);
    }

    public boolean coche_avanzado_y_tiro_menos_de_cinco(){
        return es_coche_avanzado() && ((Coche) avatar).isVuelta_cuando_vuelve_a_tirar_coche() != 0;
    }

    public int vueltas_que_faltan_para_que_tire_coche(Tablero tablero){
        if(es_coche_avanzado()){
            if((((Coche) avatar).isVuelta_cuando_vuelve_a_tirar_coche()- tablero.getVuelta()) == 3) {
                return 2;
            }else {
                return (((Coche) avatar).isVuelta_cuando_vuelve_a_tirar_coche() - tablero.getVuelta());
            }

        }
        else return -9;
    }

}
