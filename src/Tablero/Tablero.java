package Tablero;

import Casilla.*;
import Construccion.Edificio;
import Construccion.Tipo_Edificio;
import Jugador.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {
    private ArrayList<Casilla> casillaArrayList;
    private ArrayList<Jugador> jugadorArrayList;
    private double pasa_por_salida;
    private HashMap<Color_grupo, Grupo> grupos_de_solares;
    private int vuelta;
    private int vueltaparamas5porcent;
    private int cuentaCasas;
    private int cuentaHoteles;
    private int cuentaPiscinas;
    private int cuentaPistas;
    private Nombres_casilla nombres_casilla;
    private static int nombre_mas_largo;
    private HashMap<Tipo_Edificio, ArrayList<Edificio>> Edificios;
    private Mazo_cartas mazo_suerte;
    private Mazo_cartas mazo_comunidad;

    public Mazo_cartas getMazo_suerte() {
        return mazo_suerte;
    }

    public Mazo_cartas getMazo_comunidad() {
        return mazo_comunidad;
    }

    public ArrayList<Casilla> getCasillaArrayList() {
        return casillaArrayList;
    }

    public void setCasillaArrayList(ArrayList<Casilla> casillaArrayList) {
        this.casillaArrayList = casillaArrayList;
    }

    public ArrayList<Jugador> getJugadorArrayList() {
        return jugadorArrayList;
    }

    public void setJugadorArrayList(ArrayList<Jugador> jugadorArrayList) {
        this.jugadorArrayList = jugadorArrayList;
    }

    public double getPasa_por_salida() {
        return pasa_por_salida;
    }

    public void setPasa_por_salida(double pasa_por_salida) {
        this.pasa_por_salida = pasa_por_salida;
    }

    public HashMap<Color_grupo, Grupo> getGrupos_de_solares() {
        return grupos_de_solares;
    }

    public void setGrupos_de_solares(HashMap<Color_grupo, Grupo> grupos_de_solares) {
        this.grupos_de_solares = grupos_de_solares;
    }

    public int getVuelta() {
        return vuelta;
    }

    public void setVuelta(int vuelta) {
        this.vuelta = vuelta;
    }

    public int getVueltaparamas5porcent() {
        return vueltaparamas5porcent;
    }

    public void setVueltaparamas5porcent(int vueltaparamas5porcent) {
        this.vueltaparamas5porcent = vueltaparamas5porcent;
    }

    public int getCuentaCasas() {
        return cuentaCasas;
    }

    public void setCuentaCasas(int cuentaCasas) {
        this.cuentaCasas = cuentaCasas;
    }

    public int getCuentaHoteles() {
        return cuentaHoteles;
    }

    public void setCuentaHoteles(int cuentaHoteles) {
        this.cuentaHoteles = cuentaHoteles;
    }

    public int getCuentaPiscinas() {
        return cuentaPiscinas;
    }

    public void setCuentaPiscinas(int cuentaPiscinas) {
        this.cuentaPiscinas = cuentaPiscinas;
    }

    public int getCuentaPistas() {
        return cuentaPistas;
    }

    public void setCuentaPistas(int cuentaPistas) {
        this.cuentaPistas = cuentaPistas;
    }

    public Nombres_casilla getNombres_casilla() {
        return nombres_casilla;
    }

    public void setNombres_casilla(Nombres_casilla nombres_casilla) {
        this.nombres_casilla = nombres_casilla;
    }

    public static int getNombre_mas_largo() {
        return nombre_mas_largo;
    }

    public HashMap<Tipo_Edificio, ArrayList<Edificio>> getEdificios() {
        return Edificios;
    }

    public void setEdificios(HashMap<Tipo_Edificio, ArrayList<Edificio>> edificios) {
        Edificios = edificios;
    }

    public Tablero ( Jugador BANCA) {
        vuelta = 1;
        vueltaparamas5porcent = 1;
        this.cuentaCasas = 1;
        this.cuentaHoteles = 1;
        this.cuentaPiscinas = 1;
        this.cuentaPistas = 1;
        nombres_casilla = new Nombres_casilla();
        nombre_mas_largo = nombres_casilla.mas_largo();
        this.jugadorArrayList = new ArrayList<Jugador>();
        this.jugadorArrayList.add(BANCA);

        this.mazo_comunidad = new Mazo_cartas("Comunidad");
        this.mazo_suerte = new Mazo_cartas("Suerte");

        this.Edificios = new HashMap<Tipo_Edificio,ArrayList<Edificio>>();

        this.getEdificios().put(Tipo_Edificio.CASA, new ArrayList<Edificio>());
        this.getEdificios().put(Tipo_Edificio.HOTEL, new ArrayList<Edificio>());
        this.getEdificios().put(Tipo_Edificio.PISCINA, new ArrayList<Edificio>());
        this.getEdificios().put(Tipo_Edificio.PISTA_DE_DEPORTE, new ArrayList<Edificio>());


        HashMap<Color_grupo, Grupo> grupos_de_solares_transp_serv = new HashMap<Color_grupo, Grupo>();

        Grupo marrones = new Grupo(Color_grupo.Marron, BANCA);
        Grupo azclaros = new Grupo(Color_grupo.Azul_claro, BANCA);
        Grupo morados = new Grupo(Color_grupo.Morado, BANCA);
        Grupo naranjas = new Grupo(Color_grupo.Naranja, BANCA);
        Grupo rojos = new Grupo(Color_grupo.Rojo, BANCA);
        Grupo amarillos = new Grupo(Color_grupo.Amarillo, BANCA);
        Grupo verdes = new Grupo(Color_grupo.Verde, BANCA);
        Grupo azoscuros = new Grupo(Color_grupo.Azul_oscuro, BANCA);
        Grupo estaciones = new Grupo(Color_grupo.Estacion, BANCA);
        Grupo servicios = new Grupo(Color_grupo.Servicio, BANCA);


        ArrayList<Propiedad> casillasgrupomarron = new ArrayList<Propiedad>();
        ArrayList<Propiedad> casillasgrupoazclaro = new ArrayList<Propiedad>();
        ArrayList<Propiedad> casillasgrupomorado = new ArrayList<Propiedad>();
        ArrayList<Propiedad> casillasgruponaranja = new ArrayList<Propiedad>();
        ArrayList<Propiedad> casillasgruporojo = new ArrayList<Propiedad>();
        ArrayList<Propiedad> casillasgrupoamarillo = new ArrayList<Propiedad>();
        ArrayList<Propiedad> casillasgrupoverde = new ArrayList<Propiedad>();
        ArrayList<Propiedad> casillasgrupoazoscuro = new ArrayList<Propiedad>();
        ArrayList<Propiedad> casillasgrupoestacion = new ArrayList<Propiedad>();
        ArrayList<Propiedad> casillasgruposervicio = new ArrayList<Propiedad>();

        double prec_marrones = 100;
        double prec_azclaro = prec_marrones + (.3 * prec_marrones);
        double prec_morado = prec_azclaro + (.3 * prec_azclaro);
        double prec_naranja = prec_morado + (.3 * prec_morado);
        double prec_rojo = prec_naranja + (.3 * prec_naranja);
        double prec_amarillo = prec_rojo + (.3 * prec_rojo);
        double prec_verde = prec_amarillo + (.3 * prec_amarillo);
        double prec_azoscuro = prec_verde + (.3 * prec_verde);
        double aux = ((2 * prec_marrones) +
                      (3 * prec_azclaro) +
                      (3 * prec_morado) +
                      (3 * prec_naranja) +
                      (3 * prec_rojo) +
                      (3 * prec_amarillo) +
                      (3 * prec_verde) +
                      (2 * prec_azoscuro)) / 22;
        pasa_por_salida = Math.round(aux * 100.0) / 100.0;

        casillaArrayList = new ArrayList<Casilla>();
        //salida
        casillaArrayList.add(new Especial(0,nombres_casilla.getNombre_casilla().get(0),Tipo_Especial.SALIDA));
        //marron1
        Solar marron1 = new Solar(1,nombres_casilla.getNombre_casilla().get(1),BANCA,prec_marrones,Color_Solar.Marron);
        casillaArrayList.add(marron1);
        casillasgrupomarron.add(marron1);
        //caja de comunidad
        casillaArrayList.add(new Especial(2,nombres_casilla.getNombre_casilla().get(2),Tipo_Especial.COMUNIDAD));
        //marron2
        Solar marron2 = new Solar(3,nombres_casilla.getNombre_casilla().get(3),BANCA,prec_marrones,Color_Solar.Marron);
        casillaArrayList.add(marron2);
        casillasgrupomarron.add(marron2);
        //impuesto1
        casillaArrayList.add(new Impuesto(4,nombres_casilla.getNombre_casilla().get(4),pasa_por_salida * .5));
        //estacion1
        Transporte estacion1 = new Transporte(5, nombres_casilla.getNombre_casilla().get(5),BANCA, pasa_por_salida * .5);
        casillaArrayList.add(estacion1);
        casillasgrupoestacion.add(estacion1);
        //azclaro1
        Solar azclaro1 = new Solar(6,nombres_casilla.getNombre_casilla().get(6),BANCA,prec_azclaro,Color_Solar.Azul_claro);
        casillaArrayList.add(azclaro1);
        casillasgrupoazclaro.add(azclaro1);
        //suerte
        casillaArrayList.add(new Especial(7, nombres_casilla.getNombre_casilla().get(7), Tipo_Especial.SUERTE));
        //azclaro2
        Solar azclaro2 = new Solar(8,nombres_casilla.getNombre_casilla().get(8),BANCA,prec_azclaro,Color_Solar.Azul_claro);
        casillaArrayList.add(azclaro2);
        casillasgrupoazclaro.add(azclaro2);
        //azclaro3
        Solar azclaro3 = new Solar(9,nombres_casilla.getNombre_casilla().get(9),BANCA,prec_azclaro,Color_Solar.Azul_claro);
        casillaArrayList.add(azclaro3);
        casillasgrupoazclaro.add(azclaro3);
        //carcel
        casillaArrayList.add(new Especial(10, nombres_casilla.getNombre_casilla().get(10), Tipo_Especial.CARCEL));
        //morado1
        Solar morado1 = new Solar(11,nombres_casilla.getNombre_casilla().get(11),BANCA,prec_morado,Color_Solar.Morado);
        casillaArrayList.add(morado1);
        casillasgrupomorado.add(morado1);
        //servicio1
        Servicio serv1 = new Servicio(12,nombres_casilla.getNombre_casilla().get(12), BANCA,pasa_por_salida * .75);
        casillaArrayList.add(serv1);
        casillasgruposervicio.add(serv1);
        //morado2
        Solar morado2 = new Solar(13,nombres_casilla.getNombre_casilla().get(13),BANCA,prec_morado,Color_Solar.Morado);
        casillaArrayList.add(morado2);
        casillasgrupomorado.add(morado2);
        //morado3
        Solar morado3 = new Solar(14,nombres_casilla.getNombre_casilla().get(14),BANCA,prec_morado,Color_Solar.Morado);
        casillaArrayList.add(morado3);
        casillasgrupomorado.add(morado3);
        //estacion2
        Transporte estacion2 = new Transporte(15, nombres_casilla.getNombre_casilla().get(15),BANCA, pasa_por_salida * .5);
        casillaArrayList.add(estacion2);
        casillasgrupoestacion.add(estacion2);
        //naranj1
        Solar naranj1 = new Solar(16,nombres_casilla.getNombre_casilla().get(16),BANCA,prec_naranja,Color_Solar.Naranja);
        casillaArrayList.add(naranj1);
        casillasgruponaranja.add(naranj1);
        //caja de comunidad
        casillaArrayList.add(new Especial(17,nombres_casilla.getNombre_casilla().get(17),Tipo_Especial.COMUNIDAD));
        //naranj2
        Solar naranj2 = new Solar(18,nombres_casilla.getNombre_casilla().get(18),BANCA,prec_naranja,Color_Solar.Naranja);
        casillaArrayList.add(naranj2);
        casillasgruponaranja.add(naranj2);
        //naranj3
        Solar naranj3 = new Solar(19,nombres_casilla.getNombre_casilla().get(19),BANCA,prec_naranja,Color_Solar.Naranja);
        casillaArrayList.add(naranj3);
        casillasgruponaranja.add(naranj3);
        //parking
        casillaArrayList.add(new Especial(20,nombres_casilla.getNombre_casilla().get(20),Tipo_Especial.PARKING));
        //roj1
        Solar roj1 = new Solar(21,nombres_casilla.getNombre_casilla().get(21),BANCA,prec_rojo,Color_Solar.Rojo);
        casillaArrayList.add(roj1);
        casillasgruporojo.add(roj1);
        //suerte
        casillaArrayList.add(new Especial(22, nombres_casilla.getNombre_casilla().get(22), Tipo_Especial.SUERTE));
        //roj2
        Solar roj2 = new Solar(23,nombres_casilla.getNombre_casilla().get(23),BANCA,prec_rojo,Color_Solar.Rojo);
        casillaArrayList.add(roj2);
        casillasgruporojo.add(roj2);
        //roj3
        Solar roj3 = new Solar(24,nombres_casilla.getNombre_casilla().get(24),BANCA,prec_rojo,Color_Solar.Rojo);
        casillaArrayList.add(roj3);
        casillasgruporojo.add(roj3);
        //estacion3
        Transporte estacion3 = new Transporte(25, nombres_casilla.getNombre_casilla().get(25),BANCA, pasa_por_salida * .5);
        casillaArrayList.add(estacion3);
        casillasgrupoestacion.add(estacion3);
        //am1
        Solar am1 = new Solar(26,nombres_casilla.getNombre_casilla().get(26),BANCA,prec_amarillo,Color_Solar.Amarillo);
        casillaArrayList.add(am1);
        casillasgrupoamarillo.add(am1);
        //am2
        Solar am2 = new Solar(27,nombres_casilla.getNombre_casilla().get(27),BANCA,prec_amarillo,Color_Solar.Amarillo);
        casillaArrayList.add(am2);
        casillasgrupoamarillo.add(am2);
        //servicio1
        Servicio serv2 = new Servicio(28,nombres_casilla.getNombre_casilla().get(28), BANCA,pasa_por_salida * .75);
        casillaArrayList.add(serv2);
        casillasgruposervicio.add(serv2);
        //am3
        Solar am3 = new Solar(29,nombres_casilla.getNombre_casilla().get(29),BANCA,prec_amarillo,Color_Solar.Amarillo);
        casillaArrayList.add(am3);
        casillasgrupoamarillo.add(am3);
        //suerte
        casillaArrayList.add(new Especial(30, nombres_casilla.getNombre_casilla().get(30), Tipo_Especial.IR_A_LA_CARCEL));
        //verd1
        Solar verd1 = new Solar(31,nombres_casilla.getNombre_casilla().get(31),BANCA,prec_verde,Color_Solar.Verde);
        casillaArrayList.add(verd1);
        casillasgrupoverde.add(verd1);
        //verd2
        Solar verd2 = new Solar(32,nombres_casilla.getNombre_casilla().get(32),BANCA,prec_verde,Color_Solar.Verde);
        casillaArrayList.add(verd2);
        casillasgrupoverde.add(verd2);
        //comunidad
        casillaArrayList.add(new Especial(33, nombres_casilla.getNombre_casilla().get(33), Tipo_Especial.COMUNIDAD));
        //verd3
        Solar verd3 = new Solar(34,nombres_casilla.getNombre_casilla().get(34),BANCA,prec_verde,Color_Solar.Verde);
        casillaArrayList.add(verd3);
        casillasgrupoverde.add(verd3);
        //estacion4
        Transporte estacion4 = new Transporte(35, nombres_casilla.getNombre_casilla().get(35),BANCA, pasa_por_salida * .5);
        casillaArrayList.add(estacion4);
        casillasgrupoestacion.add(estacion4);
        //suerte
        casillaArrayList.add(new Especial(36, nombres_casilla.getNombre_casilla().get(36), Tipo_Especial.SUERTE));
        //azosc1
        Solar azosc1 = new Solar(37,nombres_casilla.getNombre_casilla().get(37),BANCA,prec_azoscuro,Color_Solar.Azul_oscuro);
        casillaArrayList.add(azosc1);
        casillasgrupoazoscuro.add(azosc1);
        //impuesto
        casillaArrayList.add(new Impuesto(38,nombres_casilla.getNombre_casilla().get(38),pasa_por_salida * .5));
        //azosc2
        Solar azosc2 = new Solar(39,nombres_casilla.getNombre_casilla().get(39),BANCA,prec_azoscuro,Color_Solar.Azul_oscuro);
        casillaArrayList.add(azosc2);
        casillasgrupoazoscuro.add(azosc2);

        marrones.setCasillas_del_grupo(casillasgrupomarron);
        azclaros.setCasillas_del_grupo(casillasgrupoazclaro);
        morados.setCasillas_del_grupo(casillasgrupomorado);
        naranjas.setCasillas_del_grupo(casillasgruponaranja);
        rojos.setCasillas_del_grupo(casillasgruporojo);
        amarillos.setCasillas_del_grupo(casillasgrupoamarillo);
        verdes.setCasillas_del_grupo(casillasgrupoverde);
        azoscuros.setCasillas_del_grupo(casillasgrupoazoscuro);
        estaciones.setCasillas_del_grupo(casillasgrupoestacion);
        servicios.setCasillas_del_grupo(casillasgruposervicio);

        grupos_de_solares_transp_serv.put(Color_grupo.Marron, marrones);
        grupos_de_solares_transp_serv.put(Color_grupo.Azul_claro, azclaros);
        grupos_de_solares_transp_serv.put(Color_grupo.Morado, morados);
        grupos_de_solares_transp_serv.put(Color_grupo.Naranja, naranjas);
        grupos_de_solares_transp_serv.put(Color_grupo.Rojo, rojos);
        grupos_de_solares_transp_serv.put(Color_grupo.Amarillo, amarillos);
        grupos_de_solares_transp_serv.put(Color_grupo.Verde, verdes);
        grupos_de_solares_transp_serv.put(Color_grupo.Azul_oscuro, azoscuros);
        grupos_de_solares_transp_serv.put(Color_grupo.Estacion, estaciones);
        grupos_de_solares_transp_serv.put(Color_grupo.Servicio, servicios);

        this.grupos_de_solares = grupos_de_solares_transp_serv;
    }
    @Override
    public String toString() {
        ArrayList<Casilla> arriba = new ArrayList<Casilla>();
        ArrayList<Casilla> abajo = new ArrayList<Casilla>();
        ArrayList<Casilla> izq = new ArrayList<Casilla>();
        ArrayList<Casilla> der = new ArrayList<Casilla>();
        for (Casilla cas : casillaArrayList) {
            if ((cas.getPosicion() > 30) && (cas.getPosicion() < 40)) {
                der.add(cas);
            } else if ((cas.getPosicion() > 19) && (cas.getPosicion() < 31)) {
                arriba.add(cas);
            }
        }
        for (int i = 19; i > 10; i--) {
            Casilla cas = casillaArrayList.get(i);
            izq.add(cas);
        }
        for (int i = 10; i > (-1); i--) {
            Casilla cas = casillaArrayList.get(i);
            abajo.add(cas);
        }
        String tab = "";
        for (Casilla cas : arriba) {
            tab = tab + cas;
        }
        tab = tab + "\n";
        for (int i = 0; i < der.size(); i++) {
            tab = tab + izq.get(i) + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + der.get(i) + "\n";
        }
        for (Casilla cas : abajo) {
            tab = tab + cas;
        }
        return tab;
    }

    public Jugador jug_q_tiene_turno() throws Exception{ //FUNCIÓN QUE DEVUELVE EL JUGADOR QUE TIENE EL TURNO Y UN JUGADOR LLAMADO ERROR SI NINGÚN JUGADOR TIENE EL TURNO
        for (Jugador jug : this.jugadorArrayList) {
            if (jug.getTipo_jugador().equals(Tipo_jugador.no_banca)) {
                if (jug.isEs_su_turno()) {
                    return jug;
                }
            }
        }
        throw new Exception("No hay jugadores en la partida");
    }

    public void aumentarcincoporcentsolaresnovendidos(){
        for (Casilla cas : casillaArrayList){
            if( cas instanceof Propiedad){
                if(((Propiedad)cas).getPropietario().getTipo_jugador().equals(Tipo_jugador.banca)){
                    ((Propiedad)cas).setPrecio(((Propiedad)cas).getPrecio() * (105.0/100));
                }
            }
        }
    }


    public String estadisticas_de_partida(){
        ArrayList<String> nombre_casilla_mas_visitada = new ArrayList<>();
        int numvecesquecaemax = 0;
        for(Casilla cas : casillaArrayList){
            if(cas.getNum_veces_que_se_cayo_en_casilla() >= numvecesquecaemax){
                numvecesquecaemax = (int) cas.getNum_veces_que_se_cayo_en_casilla();
            }
        }
        if(numvecesquecaemax == 0) {
            nombre_casilla_mas_visitada.add("Ninguna");
        } else {
            for (Casilla cas : casillaArrayList){
                if(cas.getNum_veces_que_se_cayo_en_casilla() == numvecesquecaemax){
                    nombre_casilla_mas_visitada.add(cas.getNombre());
                }
            }
        }


        String nombremasvueltas = "";
        int masvueltas = 0;
        for(Jugador jug : jugadorArrayList){
            if(jug.getTipo_jugador().equals(Tipo_jugador.no_banca) && jug.getNumvueltas() >= masvueltas){
                nombremasvueltas = jug.getNombre();
                masvueltas = jug.getNumvueltas();
            }
        }
        if(masvueltas == 0) nombremasvueltas = "Todavía ningún jugador ha completado una vuelta";

        String quien_lanzo_mas_veces_dados = "";
        int lanzo_mas_veces_dados = 0;
        for(Jugador jug : jugadorArrayList){
            if(jug.getTipo_jugador().equals(Tipo_jugador.no_banca) && jug.getNumvecesquelanzadados() >= lanzo_mas_veces_dados){
                quien_lanzo_mas_veces_dados = jug.getNombre();
                lanzo_mas_veces_dados = jug.getNumvecesquelanzadados();
            }
        }
        if(lanzo_mas_veces_dados == 0) quien_lanzo_mas_veces_dados = "Nadie lanzó los dados aún";

        String nom_mayor_patrimonio = "";
        double mayor_patrimonio = 0;
        for(Jugador jug : jugadorArrayList){
            if(jug.getTipo_jugador().equals(Tipo_jugador.no_banca) && jug.patrimonio() > mayor_patrimonio){
                mayor_patrimonio = jug.patrimonio();
                nom_mayor_patrimonio = jug.getNombre();
            }
        }
        if(nom_mayor_patrimonio.equals("")) nom_mayor_patrimonio = "no hay jugadores en la partida";

        String nom_casilla_mas_rentable = "";
        double dinero_casilla_mas_rentable = 0;
        for(Casilla cas : casillaArrayList){
            if(cas instanceof Propiedad){
                if(((Propiedad) cas).getDinero_pagado_en_alquileres() >= dinero_casilla_mas_rentable){
                    nom_casilla_mas_rentable = cas.getNombre();
                    dinero_casilla_mas_rentable =((Propiedad) cas).getDinero_pagado_en_alquileres();
                }
            }
        }
        if(dinero_casilla_mas_rentable == 0) nom_casilla_mas_rentable = "Nadie ha pagado ningún alquiler todavía";

        Color_grupo color_grupo_rentable = Color_grupo.Servicio;
        double dinero_grupo_mas_rentable = 0;
        for(Grupo grupo : grupos_de_solares.values()){
            if(grupo.getDinero_pagado_en_alquileres_grupo() > dinero_grupo_mas_rentable){
                color_grupo_rentable = grupo.getColor_del_grupo();
                dinero_grupo_mas_rentable = grupo.getDinero_pagado_en_alquileres_grupo();
            }
        }
        if(dinero_grupo_mas_rentable == 0){
            return("|\tCasilla más visitada: " + nombre_casilla_mas_visitada + "\n"+
                    "|\tJugador que más vueltas ha dado: " + nombremasvueltas + "\n"+
                    "|\tJugador que lanzó más veces dados: " + quien_lanzo_mas_veces_dados + "\n" +
                    "|\tJugador en cabeza: " + nom_mayor_patrimonio + "\n"+
                    "|\tCasilla más rentable: " + nom_casilla_mas_rentable + "\n" +
                    "|\tGrupo de propiedades mas rentable: " + nom_casilla_mas_rentable);
        } else {
            return("|\tCasilla más visitada: " + nombre_casilla_mas_visitada + "\n"+
                    "|\tJugador que más vueltas ha dado: " + nombremasvueltas + "\n"+
                    "|\tJugador que lanzó más veces dados: " + quien_lanzo_mas_veces_dados + "\n" +
                    "|\tJugador en cabeza: " + nom_mayor_patrimonio + "\n"+
                    "|\tCasilla más rentable: " + nom_casilla_mas_rentable + "\n" +
                    "|\tGrupo de propiedades mas rentable: " + color_grupo_rentable);
        }

    }

    public Casilla casilla_a_partir_de(String nombre) throws Exception{
        for(Casilla casilla :casillaArrayList){
            if(casilla.getNombre().equals(nombre)){
                return casilla;
            }
        }
        throw new Exception("Ninguna casilla se llama así");
    }

    public Casilla casilla_a_partir_de(int posicion) throws Exception{
        for(Casilla casilla : casillaArrayList){
            if(casilla.getPosicion() == posicion){
                return casilla;
            }
        }
        throw new Exception("Ninguna casilla se llama así");
    }

    public void al_bote_del_parking( double dinero){
        for(Casilla cas : casillaArrayList){
            if(cas.getNombre().equals("Parking")){
                ((Especial)cas).setBote( ((Especial)cas).getBote() + dinero);
            }
        }
    }



}
