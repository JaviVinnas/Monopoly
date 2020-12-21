package Juego;

import Casilla.*;
import Consola.*;
import Construccion.Edificio;
import Construccion.Tipo_Edificio;
import Excepciones.*;
import Jugador.*;
import Tablero.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Juego implements Comandos {
    //public static ConsolaNormal consola;
    private Tablero tablero;
    private Dado dado;
    private boolean salir;

    public Juego(){
        //consola = new ConsolaNormal();
        tablero = new Tablero(new Jugador());
        dado = new Dado();
        Scanner comandos_fichero = new Scanner(System.in);
        char op_comandos_fichero = 'y';
        BufferedReader buffRead = null;
        try {
            String directorio = "C:\\Users\\javiv\\IdeaProjects\\Monopoly__pruebas\\";
            FileReader fileRead = new FileReader(directorio + "comandos.txt");
            buffRead = new BufferedReader(fileRead);
        } catch (FileNotFoundException notFound) {
            System.out.print(notFound.getMessage());
            System.exit(0);
        }
        Scanner scanner = new Scanner(System.in);
        do {
            String respuesta = consola.leer("Quieres ejecutar por comandos (c) o por fichero (f)");
            if(respuesta.length() > 1)continue;
            try {
                op_comandos_fichero = respuesta.charAt(0);
            }catch (StringIndexOutOfBoundsException ignored){}
        } while (op_comandos_fichero != 'c' && op_comandos_fichero != 'f');
        String orden = "";
        salir = false;
        while (!salir) {
            consola.imprimir("$> ",0);
            switch (op_comandos_fichero) {
                case 'c':
                    orden = scanner.nextLine();
                    break;
                case 'f':
                    try {
                        orden = buffRead.readLine();
                    } catch (IOException io) {
                        consola.imprimir(io.getMessage());
                    }
                    break;
            }
            String[] partes = orden.split(" ");
            String comando = partes[0];
            switch (comando) {
                case "salir":
                    switch (partes.length) {
                        case 1:
                            salir();
                            break;
                        case 2:
                            if (partes[1].equals("cárcel") || partes[1].equals("carcel")) {
                               try { salir_carcel(); }catch (Exception ex){ consola.imprimir(ex.getMessage()); }
                            } else { consola.imprimir("x"); }
                            break;
                    }
                    break;
                case "crear":
                    if (partes.length == 4 && partes[1].equals("jugador")) {
                        try {
                            crear_jugador(partes[2], partes[3]);
                        } catch (Exception_crear_jugador exceptionCrearJugador) {
                            consola.imprimir(exceptionCrearJugador.descripcion());
                        }

                    } else {
                        consola.imprimir("x");
                    }
                    break;
                case "listar":
                    switch (partes.length) {
                        case 2:
                            switch (partes[1]) {
                                case "jugadores":
                                    try {
                                        listar_jugadores();
                                    } catch (Exception ex) {
                                        consola.imprimir(ex.getMessage());
                                    }
                                    break;
                                case "avatares":
                                    try {
                                        listar_avatares();
                                    } catch (Exception ex) {
                                        consola.imprimir(ex.getMessage());
                                    }
                                    break;
                                case "enventa":
                                    try {
                                        listar_enventa();
                                    } catch (Exception ex) {
                                        consola.imprimir(ex.getMessage());
                                    }
                                    break;
                                case "edificios":
                                    try {
                                        listar_edificios();
                                    } catch (Exception ex) {
                                        consola.imprimir(ex.getMessage());
                                    }
                                    break;
                                default:
                                    consola.imprimir("x");
                            }
                            break;
                        case 3:
                            if (partes[1].equals("edificios")) {
                                try {
                                    listar_edificios_casilla(partes[2]);
                                } catch (Exception ex) {
                                    consola.imprimir(ex.getMessage());
                                }

                            } else {
                                consola.imprimir("x");
                            }
                            break;
                        default:
                            consola.imprimir("x");
                    }
                    break;
                case "acabar":
                    if (partes.length == 2 && partes[1].equals("turno")) {
                        try { cambiar_turno(); } catch (Exception ex) { consola.imprimir(ex.getMessage()); }
                    } else {
                        consola.imprimir("x");
                    }
                    break;
                case "jugador":
                    if (partes.length == 1){
                        try {
                            jugador();
                        }catch (Exception ex){
                            consola.imprimir(ex.getMessage());
                        }
                    }else{consola.imprimir("x");}
                    break;
                case "describir":
                    if(partes.length == 2){
                        try { describir_casilla(partes[1]); } catch (Exception ex) { consola.imprimir(ex.getMessage()); }
                    }else if(partes.length ==3 && partes[1].equals("jugador")){
                        try { describir_jugador(partes[2]); } catch (Exception ex) { consola.imprimir(ex.getMessage()); }
                    }else if(partes.length == 3 && partes[1].equals("avatar")) {
                        try { describir_avatar(partes[2]); } catch (Exception ex) { consola.imprimir(ex.getMessage()); }
                    }else{
                        consola.imprimir("x");
                    }
                    break;
                case "ver":
                    if(partes.length==2 && partes[1].equals("tablero")){
                        ver_tablero();
                    }else{
                        consola.imprimir("x");
                    }
                    break;
                case "cambiar":
                    if(partes.length==2 && partes[1].equals("modo")){
                        try {
                            cambiar_modo();
                        }catch (Exception ex){
                            consola.imprimir(ex.getMessage());
                        }
                    }else {
                        consola.imprimir("x");
                    }
                    break;
                case "comprar":
                    if(partes.length == 2){
                        try { comprar(partes[1]); } catch (Exception ex) { consola.imprimir(ex.getMessage()); }
                    }else {
                        consola.imprimir("x");
                    }
                    break;
                case "stop":
                    if(partes.length == 1 && op_comandos_fichero == 'f'){
                        stop();
                    }else{
                        consola.imprimir("x");
                    }
                    break;
                case "estadisticas":
                case "estadísticas":
                    switch (partes.length){
                        case 1:
                            estadisticas();
                            break;
                        case 2:
                            try {
                                estadisticas_jugador(partes[1]);
                            }catch (Exception ex){
                                consola.imprimir(ex.getMessage());
                            }
                            break;
                        default:
                            consola.imprimir("x");
                            break;
                    }
                    break;
                case "edificar":
                    if(partes.length == 2){
                        switch (partes[1]){
                            case "casa":
                                try { edificar_edificio(Tipo_Edificio.CASA); }catch (Exception ex ){ consola.imprimir(ex.getMessage()); }
                                break;
                            case "hotel":
                                try { edificar_edificio(Tipo_Edificio.HOTEL); }catch (Exception ex ){ consola.imprimir(ex.getMessage()); }
                                break;
                            case "piscina":
                                try { edificar_edificio(Tipo_Edificio.PISCINA); }catch (Exception ex ){ consola.imprimir(ex.getMessage()); }
                                break;
                            case "pista_de_deporte":
                                try { edificar_edificio(Tipo_Edificio.PISTA_DE_DEPORTE); }catch (Exception ex ){ consola.imprimir(ex.getMessage()); }
                                break;
                            default:
                                consola.imprimir("x");
                                break;
                        }
                    }else {
                        consola.imprimir("x");
                    }
                    break;
                case "vender":
                    if (partes.length == 3){
                        try{
                            switch (partes[1]){
                                case "casas":
                                case "casa":
                                    vender_edificio(Tipo_Edificio.CASA,Integer.parseInt(partes[2]));
                                    break;
                                case "hotel":
                                case "hoteles":
                                    vender_edificio(Tipo_Edificio.HOTEL,Integer.parseInt(partes[2]));
                                    break;
                                case "piscina":
                                case "piscinas":
                                    vender_edificio(Tipo_Edificio.PISCINA,Integer.parseInt(partes[2]));
                                    break;
                                case "pista_de_deporte":
                                case "pistas_de_deporte":
                                    vender_edificio(Tipo_Edificio.PISTA_DE_DEPORTE,Integer.parseInt(partes[2]));
                                    break;
                                default:
                                    consola.imprimir("x");
                            }
                        } catch (NumberFormatException nex){
                            consola.imprimir("'" + partes[2] + "' no es un número entero");
                        }catch (Exception ex){
                            consola.imprimir(ex.getMessage());
                        }

                    }else {
                        consola.imprimir("x");
                    }
                    break;
                case "lanzar":
                case "tirar":
                    if(partes.length == 2 && ( partes[1].equals("dado") || partes[1].equals("dados") ) ){
                        try {
                            lanzar_dados();
                        }catch (Exception ex){
                            consola.imprimir(ex.getMessage());
                        }
                    }else{
                        consola.imprimir("x");
                    }
                    break;
                case "hipotecar":
                    if(partes.length==2){
                        try {
                            hipotecar(partes[1]);
                        }catch (Exception ex){
                            consola.imprimir(ex.getMessage());
                        }
                    }else {
                        consola.imprimir("x");
                    }
                    break;
                case "deshipotecar":
                    if(partes.length==2){
                        try {
                            deshipotecar(partes[1]);
                        }catch (Exception ex){
                            consola.imprimir(ex.getMessage());
                        }
                    }else {
                        consola.imprimir("x");
                    }
                    break;
                default:
                    consola.imprimir("x");
            }
        }
    }

























    //-------------------------------------------------------------------------------------------------------------------
    @Override
    public void salir() {
        salir = true;
        consola.imprimir("Gracias por jugar");
    }
    //--------------------------------------------------------------------------------------------------------------------
    @Override
    public void crear_jugador(String nombre, String avatar) throws Exception_crear_jugador {
        if (nombre.equals("BANCA")) throw new ErrJugadorReservado(nombre);
        boolean encontrado = false;
        Tipo_avatar avatar2 = null;
        for (Tipo_avatar avatar1 : Tipo_avatar.values()) {
            if (avatar1.toString().equals(avatar)) {
                encontrado = true;
                avatar2 = avatar1;
                break;
            }
        }
        if (!encontrado) throw new ErrAvatar(avatar);
        encontrado = false;
        for (Jugador jug : tablero.getJugadorArrayList()) {
            if (jug.getNombre().equals(nombre)) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) throw new ErrJugador(nombre);

        if (tablero.getJugadorArrayList().size() == MAX_JUGADORES + 1) throw new ErrMuchosJugs(MAX_JUGADORES);

        Jugador jugador = new Jugador(nombre, avatar2,tablero);

        if (this.tablero.getJugadorArrayList().size() == 1) jugador.setEs_su_turno(true);

        for (Casilla cas : this.tablero.getCasillaArrayList()) {
            if (cas.getNombre().equals("Salida")) {
                cas.getJugadores_en_casilla().add(jugador);
                jugador.getAvatar().setCasillaAvatar(cas);
                break;
            }
        }
        ArrayList<Character> ids_partida = new ArrayList<>();
        for (Jugador jug_partida : this.tablero.getJugadorArrayList()) {
            if (jug_partida.getTipo_jugador().equals(Tipo_jugador.no_banca)) {
                ids_partida.add(jug_partida.getAvatar().getId());
            }
        }
        while (ids_partida.contains(jugador.getAvatar().getId())) {
            Random rnd = new Random();
            jugador.getAvatar().setId((char) (rnd.nextInt(25) + 65));
        }
        this.tablero.getJugadorArrayList().add(jugador);

        consola.imprimir("{\nNombre --> " + jugador.getNombre());
        consola.imprimir("Avatar --> " + jugador.getAvatar().getId() + "\n}");
        consola.imprimir(tablero.toString());
    }
    //----------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void listar_jugadores() throws Exception {
        if (tablero.getJugadorArrayList().size() == 1) throw new Exception("La partida no tiene jugadores aún");
        for (Jugador jug : tablero.getJugadorArrayList()) {
            if (jug.getTipo_jugador().equals(Tipo_jugador.no_banca)) {
                consola.imprimir(jug.toString());
            }

        }
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void listar_avatares() throws Exception {
        if (tablero.getJugadorArrayList().size() == 1) {
            throw new Exception("La partida no tiene jugadores aún");
        }
        for (Jugador jug : tablero.getJugadorArrayList()) {
            if (jug.getTipo_jugador().equals(Tipo_jugador.no_banca)) {
                consola.imprimir(jug.getAvatar().toString());
            }
        }
    }
    ///-------------------------------------------////////////////////-----------------------------------------------------------------------------------
    @Override
    public void listar_enventa() throws Exception {
        StringBuilder lista = new StringBuilder();
        consola.imprimir("---Lista de propiedades en venta---\n");
        for (Casilla cas : tablero.getCasillaArrayList()) {
            if (cas instanceof Propiedad) {
                Propiedad prop = (Propiedad) cas;
                if ((prop.getPropietario().getTipo_jugador().equals(Tipo_jugador.banca))) {
                    lista.append("\nNombre de la casilla -> ").append(prop.getNombre()).append("\n");
                    if (prop instanceof Solar) {
                        Solar s = (Solar) prop;
                        lista.append("Tipo de casilla -> Solar\n");
                        lista.append("Grupo de solares al que pertenece -> ").append(s.getColor_solar());
                    } else if (prop instanceof Servicio) {
                        lista.append("Tipo de casilla -> Servicio\n");
                    } else if (prop instanceof Transporte) {
                        lista.append("Tipo de casilla -> Transporte\n");
                    }
                    lista.append("Precio de compra ->").append(prop.getPrecio()).append("\n\n");
                }
            }
        }
        if (lista.toString().length() < 1) throw new Exception("No hay ninguna propiedad en venta");
        consola.imprimir(lista.toString());
    }
    //--------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void listar_edificios() throws Exception {
        StringBuilder s = new StringBuilder();
        for (ArrayList<Edificio> edificios : tablero.getEdificios().values()) {
            for (Edificio ed : edificios) {
                s.append("{\n id: ").append(ed.getId()).append("\n");
                s.append(" propietario: ").append(ed.getPropietario().getNombre());
                s.append("\n casilla: ").append(ed.getCasilla().getNombre()).append("\n");
                s.append(" grupo: ").append(ed.getGrupo().getColor_del_grupo());
                s.append("\n coste: ").append(ed.getPrecio()).append("\n} \n");
            }
        }
        if (s.toString().length() < 1) throw new Exception("No hay edificios en la partida aún");
        consola.imprimir(s.toString());
    }
    //---------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void listar_edificios_casilla(String nombre) throws Exception {
        StringBuilder string = new StringBuilder();
        boolean haysolar = false;
        for (Casilla cas : tablero.getCasillaArrayList()) {
            if (cas.getNombre().equals(nombre)) {
                if (cas instanceof Solar) {
                    haysolar = true;
                    Solar s = (Solar) cas;
                    for (ArrayList<Edificio> edificios : s.getEdificios_del_grupo().values()) {
                        for (Edificio ed : edificios) {
                            string.append(ed.toString());
                        }
                    }
                    if (string.toString().length() < 1) throw new Exception("El solar no tiene edificios");
                    consola.imprimir(string.toString());
                } else {
                    throw new Exception("La casilla " + nombre + " no es un solar por lo que no tiene ni tendrá edificios");
                }
            }
        }
        if (!haysolar) throw new Exception("No hay ningún solar llamado así");
    }
    //---------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void cambiar_turno() throws Exception {
        if(tablero.getJugadorArrayList().size() == 1) throw new Exception("No hay jugadores en la partida");
        if (!tablero.jug_q_tiene_turno().isHa_lanzado_dados() && !tablero.jug_q_tiene_turno().es_coche_avanzado()) throw new Exception("Aún puedes lanzar los dados");
        for (int i = 0; i < tablero.getJugadorArrayList().size(); i++) {
            Jugador jug = tablero.getJugadorArrayList().get(i);
            if (jug.getTipo_jugador().equals(Tipo_jugador.no_banca)) {
                if (jug.isEs_su_turno()) { //si es el jugador que tiene el turno
                    if(jug.coche_avanzado_y_puede_seguir_tirando()) throw new Exception("El coche todavía puede seguir tirando");
                    if(jug.es_coche_avanzado()) ((Coche)jug.getAvatar()).coche_daunavuelta();
                    if (jug.getVuelta_en_la_q_sale_d_la_carcel() == tablero.getVuelta() + 1) {
                        jug.setVuelta_en_la_q_sale_d_la_carcel(0);
                        if(jug.getFortuna() - tablero.getPasa_por_salida() < 0) throw new Bancarrota(jug);
                        jug.setFortuna(jug.getFortuna() - tablero.getPasa_por_salida() * .25);
                        consola.imprimir("El jugador " + jug.getNombre() + " puede salir de la cárcel.\nSu fortuna se reduce a " + jug.getFortuna() + "€.");
                    }
                    jug.setEs_su_turno(false);
                    jug.setHa_lanzado_dados(false);
                    if (i != tablero.getJugadorArrayList().size() - 1) { //jugador es el último del array
                        tablero.getJugadorArrayList().get(i + 1).setEs_su_turno(true);
                        consola.imprimir("El jugador que tiene el turno ahora es: " + tablero.getJugadorArrayList().get(i + 1).getNombre());
                        break;
                    } else {
                        tablero.setVuelta(tablero.getVuelta() + 1);
                        for (Jugador jugador : tablero.getJugadorArrayList()) {
                            if (jugador.getTipo_jugador().equals(Tipo_jugador.no_banca)) {
                                if (jugador.getVuelta_en_la_q_sale_d_la_carcel() != 0) {
                                    tablero.setVueltaparamas5porcent(tablero.getVueltaparamas5porcent() - 1);
                                    break;
                                }
                            }
                        }
                        tablero.setVueltaparamas5porcent(tablero.getVueltaparamas5porcent() + 1);
                        consola.imprimir("RONDA Nº " + tablero.getVuelta());
                        tablero.getJugadorArrayList().get(1).setEs_su_turno(true);
                        consola.imprimir("El jugador que tiene el turno ahora es: " + tablero.getJugadorArrayList().get(1).getNombre());
                        if (tablero.getVueltaparamas5porcent() % 4 == 0) {
                            tablero.aumentarcincoporcentsolaresnovendidos();
                        }
                        break;
                    }
                }
            }
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void jugador() throws Exception{
        if(tablero.jug_q_tiene_turno() == null) throw new Exception("No hay jugadores en la partida");
        consola.imprimir("Nombre del jugador que tiene el turno -> " + tablero.jug_q_tiene_turno().getNombre());
        consola.imprimir("Su avatar -> " + tablero.jug_q_tiene_turno().getAvatar().getId());
    }

    @Override
    public void describir_casilla(String nombre) throws Exception {
        boolean haecontradocasilla = false;
        for(Casilla cas : tablero.getCasillaArrayList()){
            if(cas.getNombre().equals(nombre)){
                haecontradocasilla = true;
                cas.describir_casilla(tablero);
            }
        }
        if(!haecontradocasilla) throw new Exception("No hay ninguna casilla con ese nombre");
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void describir_jugador(String nombre) throws Exception {
        boolean encontrado = false;
        for(Jugador jug : tablero.getJugadorArrayList()){
            if(jug.getNombre().equals(nombre) && !nombre.equals("BANCA")){
                encontrado = true;
                consola.imprimir(jug.toString());
            }
        }
        if(!encontrado) throw new Exception("No hay un jugador con ese nombre");

    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void describir_avatar(String id) throws Exception {
        if(id.length() > 1) throw new Exception("El id de los avatares solo tiene un caracter");
        boolean encontrado = false;
        for(Jugador jug : tablero.getJugadorArrayList()){
            if(jug.getTipo_jugador().equals(Tipo_jugador.no_banca) && jug.getAvatar().getId() == id.charAt(0)){
                encontrado = true;
                consola.imprimir(jug.getAvatar().toString());
            }
        }
        if(!encontrado) throw new Exception("No hay ningún avatar con el id '"+id+"'");
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void ver_tablero() {
        consola.imprimir(tablero.toString());
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void cambiar_modo() throws Exception{
        if(tablero.jug_q_tiene_turno() == null) throw new Exception("No hay un jugadores en la partida aún");
        if(tablero.jug_q_tiene_turno().getAvatar().isMov_avanzado()){
            tablero.jug_q_tiene_turno().getAvatar().setMov_avanzado(false);
            consola.imprimir("El jugador " + tablero.jug_q_tiene_turno().getNombre() +
                    " con avatar " + tablero.jug_q_tiene_turno().getAvatar().getId()+
                    " pasa a mover con movimiento NORMAL");
        }else{
            tablero.jug_q_tiene_turno().getAvatar().setMov_avanzado(true);
            consola.imprimir("El jugador " + tablero.jug_q_tiene_turno().getNombre() +
                    " con avatar " + tablero.jug_q_tiene_turno().getAvatar().getId()+
                    " pasa a mover con movimiento AVANZADO");
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void comprar(String nombre) throws Exception {
        if(tablero.getJugadorArrayList().size() == 1) throw new Exception("No hay jugadores en la partida");
        Jugador jug = tablero.jug_q_tiene_turno();
        Casilla cas = null;
        boolean encontrada = false;
        for(Casilla casilla : tablero.getCasillaArrayList()){
            if(casilla.getNombre().equals(nombre)){
                encontrada = true;
                cas = casilla;
            }
        }
        if(!encontrada)throw new Exception("No hay ninguna casilla con ese nombre");
        if(!(cas instanceof Propiedad)) throw new Exception("La casilla no es un solar/servicio/estación, por lo que no se puede comprar");
        if(!jug.getAvatar().getCasillaAvatar().equals(cas)) throw new Exception("No estás en la casilla, por lo que no puedes comprarla");
        Propiedad prop = (Propiedad) cas;
        if(prop.getPropietario().getTipo_jugador().equals(Tipo_jugador.no_banca)) throw new Exception("La casilla ya tiene dueño, por lo que no se puede comprar");
        if(prop.getPrecio() > jug.getFortuna()) throw new Exception("El jugador no tiene dinero para comprar la casilla");
        if(jug.es_coche_avanzado())if(((Coche)jug.getAvatar()).isCompro_propiedad()) {
            throw new Exception("Como tienes el avatar de tipo coche con movimiento avanzado y ya has comprado una vez en este turno no puedes comprar más");
        }else {
            ((Coche) jug.getAvatar()).setCompro_propiedad(true);
        }
        prop.setPropietario(jug);
        jug.getPropiedades().add(prop);
        jug.setFortuna(jug.getFortuna() - prop.getPrecio());
        jug.setDin_gastadoen_comprarpropedif(jug.getDin_gastadoen_comprarpropedif() + prop.getPrecio());

        consola.imprimir("El jugador " + jug.getNombre() + " compra " + prop.getNombre() + " por " + prop.getPrecio() + "€.\n"+
                "Su fortuna se reduce a " + jug.getFortuna() + "€.");
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void stop() {
        new Scanner(System.in).nextLine();
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void salir_carcel() throws Exception {
        if(tablero.jug_q_tiene_turno() == null) throw new Exception("No hay jugadores en la partida");
        if(tablero.jug_q_tiene_turno().getVuelta_en_la_q_sale_d_la_carcel() - tablero.getVuelta() == 4) throw new Exception("Puedes pagar para salir de la cárcel en la siguiente ronda");
        if(tablero.jug_q_tiene_turno().getVuelta_en_la_q_sale_d_la_carcel() == 0) throw new Exception("El jugador no está en la cárcel");
        if(tablero.jug_q_tiene_turno().getFortuna() - tablero.getPasa_por_salida()*.25 < 0) throw new Exception("El jugador no puede pagar la carcel\nHipoteca o al cabo de " + (tablero.jug_q_tiene_turno().getVuelta_en_la_q_sale_d_la_carcel() - tablero.getVuelta()) + "turnos se te eliminará de la partida");
        tablero.jug_q_tiene_turno().setFortuna(tablero.jug_q_tiene_turno().getFortuna() - tablero.getPasa_por_salida() * .25);
        tablero.jug_q_tiene_turno().setVuelta_en_la_q_sale_d_la_carcel(0);
        consola.imprimir("El jugador " + tablero.jug_q_tiene_turno().getNombre() + " paga " + Math.round(tablero.getPasa_por_salida() * .25 * 100.0) / 100.0 + "€ y sale de la cárcel");
        consola.imprimir("Puedes tirar los dados otra vez");
        tablero.jug_q_tiene_turno().setHa_lanzado_dados(false);

    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void estadisticas() {
        consola.imprimir(tablero.estadisticas_de_partida());
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void estadisticas_jugador(String nombre) throws Exception {
        if(nombre.equals("BANCA")) throw new Exception("No hay ningún jugador llamado así");
        boolean encontrado = false;
        for(Jugador jug : tablero.getJugadorArrayList()){
            if(jug.getNombre().equals(nombre)){
                encontrado = true;
                consola.imprimir(jug.estadisticas_jugador());
                break;
            }
        }
        if(!encontrado) throw new Exception("No hay ningún jugador con ese nombre");
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void edificar_edificio(Tipo_Edificio tipo) throws Exception {
        if(tablero.jug_q_tiene_turno() == null) throw new Exception("No hay jugadores en la partida todavía");
        Jugador jug = tablero.jug_q_tiene_turno();
        if(!(jug.getAvatar().getCasillaAvatar() instanceof Solar)) throw new Exception("La casilla en la que estás no es un solar (no se puede construir)");
        Solar solar = (Solar) jug.getAvatar().getCasillaAvatar();
        Grupo grupo = tablero.getGrupos_de_solares().get(solar.colorcasilla_to_colorgrupo(solar.getColor_solar()));
        boolean pertenece = false;
        for(Propiedad prop : jug.getPropiedades()){
            if(prop instanceof Solar){
                if(prop.getNombre().equals(solar.getNombre())){
                    pertenece = true;
                    break;
                }
            }
        }
        if(!pertenece) throw new Exception("El solar no te pertenece o está hipotecado, por lo que no puedes construir en el");
        if(!grupo.getPropietario_del_grupo().equals(jug)) throw new Exception("Como no eres propietario del grupo no puedes construir");
        solar.edificar(jug, tipo,tablero);
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public void vender_edificio(Tipo_Edificio tipo, int numero) throws Exception {
        if(numero <= 0) throw new Exception("No se pueden vender " + numero + " edificios.");
        ArrayList<Edificio> edificios = new ArrayList<Edificio>();
        Jugador jug = tablero.jug_q_tiene_turno();
        if(jug == null) throw new Exception("No hay jugadores en la partida aún");
        Casilla cas = jug.getAvatar().getCasillaAvatar();
        if(!(cas instanceof Solar)) throw new Exception("La casilla donde estás (" + cas.getNombre() + ") no es un solar.");
        Solar solar = (Solar) cas;
        boolean encontrado = false;
        for (Propiedad prop_jug : jug.getPropiedades()) {
            if (prop_jug.equals(solar)) {
                encontrado = true;
                break;
            }
        }
        if(!encontrado) throw new Exception("Aún no tienes ese solar en tu poder");
        switch (tipo){
            case CASA:
                edificios = jug.getEdificios_jug().get(Tipo_Edificio.CASA);
                break;
            case HOTEL:
                edificios = jug.getEdificios_jug().get(Tipo_Edificio.HOTEL);
                break;
            case PISCINA:
                edificios = jug.getEdificios_jug().get(Tipo_Edificio.PISCINA);
                break;
            case PISTA_DE_DEPORTE:
                edificios = jug.getEdificios_jug().get(Tipo_Edificio.PISTA_DE_DEPORTE);
                break;
        }
        if (edificios.size() < numero) throw new Exception("Solamente se podrá vender " + edificios.size() + " edificios de tipo " + tipo + ", recibiendo " + jug.valorVentaEdificios(edificios) + "€ por ello.\nPrueba a vender otro tipo de edificios.");
        jug.vender(solar,tipo,tablero,edificios,numero);
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void lanzar_dados() throws Exception {
        //creamos los dados
        int d1,d2,pos_inicial,pos_final;
        Integer turnos = -3;
        //excepciones por si el jugador no puede tirar
        Jugador jug = tablero.jug_q_tiene_turno();
        if(jug == null) throw new Exception("No hay todavía jugadores en la partida");
        pos_inicial = jug.getAvatar().getCasillaAvatar().getPosicion();
        if(!jug.es_coche_avanzado()) if(jug.isHa_lanzado_dados())throw new Exception("El jugador ha lanzado ya los dados");
        if(jug.es_coche_avanzado() && !jug.coche_avanzado_y_puede_seguir_tirando()) throw new Exception("El coche ya ha tirado dados 4 veces o bien ha sacado menos de 4");
        if(jug.es_coche_avanzado()) if(jug.coche_avanzado_y_tiro_menos_de_cinco()) throw new Exception("Al coche le faltan " + jug.vueltas_que_faltan_para_que_tire_coche(tablero) + " turnos para volver a tirar");
        //lanzamos los dados
        d1 = dado.lanzardado();
        d2 = dado.lanzardado();
        jug.numvecesquelanzadados_masmas();
        //si el jugador está en la cárcel
        if(jug.getVuelta_en_la_q_sale_d_la_carcel() != 0){
            //si ha sacado dobles
            if(d1==d2){
                consola.imprimir("Has sacado dados dobles!! (" +d1+","+d2+")");
                consola.imprimir("Sales de la cárcel y puedes volver a tirar");
                jug.setVuelta_en_la_q_sale_d_la_carcel(0);
                jug.vecesdobles_masmas();
            //si no ha sacado dobles
            }else{
                consola.imprimir("No has sacado dados dobles :( (" +d1+","+d2+")");
                consola.imprimir("Para salir teclea 'salir cárcel' o bien espera " + (jug.getVuelta_en_la_q_sale_d_la_carcel() - tablero.getVuelta()) + " turno(s) más para salir");
                jug.setHa_lanzado_dados(true);
            }
        //el jugador no está en la cárcel
        }else{
            //si saca dados dobles y no tiene movimiento avanzado
            if(d1 == d2 && !jug.getAvatar().isMov_avanzado()){
                consola.imprimir("Has sacado dados dobles!! (" +d1+","+d2+")");
                jug.vecesdobles_masmas();
                //si ha sacado menos de tres veces dobles
                if (jug.getVeces_dobles() < 3){
                    jug.getAvatar().mover_en_basico(d1+d2,tablero);
                    pos_final = pos_inicial + d1 + d2;
                    if(pos_final>40){pos_final -= 40;}
                    consola.imprimir("Caes en " + tablero.getCasillaArrayList().get(pos_final).getNombre());
                    jug.getAvatar().getCasillaAvatar().accion_casilla(jug,tablero,d1+d2);
                    //si el jugador no está en la cárcel
                    if(!jug.estaenlacarcel()){
                        consola.imprimir("Puedes lanzar hasta " + (3 - jug.getVeces_dobles()) +
                                " veces más el dado antes de ir a la cárcel ");
                    }
                //si ha sacado tres veces dados dobles
                } else {
                    consola.imprimir("Has sacado dados triples :( (" +d1+","+d2+")");
                    jug.meter_en_carcel(tablero);
                    consola.imprimir("El jugador " + jug.getNombre() + " va a la cárcel y estará tres turnos sin tirar");
                    jug.setHa_lanzado_dados(true);

                }
            //si no saca dados dobles
            } else {
                //si el jugador tiene movimiento avanzado
                if(jug.getAvatar().isMov_avanzado()){
                    consola.imprimir("Has sacado un " + (d1+d2));
                    jug.getAvatar().mover_en_avanzado(d1+d2,tablero,this);
                //si tiene modo de movimiento normal
                } else {
                    consola.imprimir("Has sacado un " + (d1+d2) + " (" +d1+"+"+d2+")");
                    jug.getAvatar().mover_en_basico(d1+d2,tablero);
                    pos_final = pos_inicial + d1 + d2;
                    if(pos_final>40){pos_final -= 40;}
                    consola.imprimir("Caes en " + tablero.getCasillaArrayList().get(pos_final).getNombre());
                    jug.getAvatar().getCasillaAvatar().accion_casilla(jug,tablero,d1+d2);
                }
                jug.setHa_lanzado_dados(true);
            }
            ver_tablero();
        }
    }

    @Override
    public void hipotecar(String nombre) throws Exception {
        if(!tablero.jug_q_tiene_turno().tiene_prop_de_nombre(nombre,tablero))throw new Exception("La casilla no pertenece al jugador");
        Casilla cas = tablero.casilla_a_partir_de(nombre);
        if(!(cas instanceof Solar)) throw new Exception("La casilla " + nombre + " no se puede hipotecar, por no ser un solar");
        Solar sol = (Solar) cas;
        if(sol.getEdificios_del_solar().get(Tipo_Edificio.CASA).size() == 0){
            if (sol.getEdificios_del_solar().get(Tipo_Edificio.HOTEL).size() == 0){
                if (sol.getEdificios_del_solar().get(Tipo_Edificio.PISCINA).size() == 0){
                    if (sol.getEdificios_del_solar().get(Tipo_Edificio.PISTA_DE_DEPORTE).size() == 0){

                    }else {throw new Exception("No se puede hipotecar el solar por tener pistas de deporte.\nVéndelas previamente");}
                }else {throw new Exception("No se puede hipotecar el solar por tener piscinas.\nVéndelas previamente");}
            }else {throw new Exception("No se puede hipotecar el solar por tener hoteles.\nVéndelas previamente");}
        }else {throw new Exception("No se puede hipotecar el solar por tener casas.\nVéndelas previamente");}

        if(sol.isHipotecada()) throw new Exception("La casilla ya está hipotecada");
        tablero.jug_q_tiene_turno().getPropiedades().remove(cas);
        tablero.jug_q_tiene_turno().getHipotecas().add(cas);
        sol.setHipotecada(true);
        tablero.jug_q_tiene_turno().setFortuna(tablero.jug_q_tiene_turno().getFortuna() + sol.getHipoteca());
        consola.imprimir(tablero.jug_q_tiene_turno().getNombre() + " recibe " + sol.getHipoteca() + " euros por la hipoteca de " + sol.getNombre() + ". No puede recibir alquileres ni edificar en el grupo " + sol.getColor_solar() + ".");
    }

    @Override
    public void deshipotecar(String nombre) throws Exception {
        Jugador jug = tablero.jug_q_tiene_turno();
        if(!jug.tiene_hipotecado_de_nombre(nombre,tablero)) throw new Exception("El jugador " + jug.getNombre() + " no tiene hipotecado el solar " + nombre);
        Solar solar = (Solar) tablero.casilla_a_partir_de(nombre);
        if(jug.getFortuna() < solar.getHipoteca()) throw new Exception("no tienes dinero suficiente para deshipotecar " + nombre);
        jug.getHipotecas().remove(solar);
        jug.getPropiedades().add(solar);
        solar.setHipotecada(false);
        jug.setFortuna( jug.getFortuna()-solar.getHipoteca());
        consola.imprimir(jug.getNombre() + " paga " + solar.getHipoteca() + " euros por deshipotecar " + solar.getNombre() + ". Ahora puede recibir alquileres y edificar en el grupo " + solar.getColor_solar() +".");
    }
}



















