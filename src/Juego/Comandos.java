package Juego;

import Consola.ConsolaNormal;
import Construccion.Tipo_Edificio;
import Excepciones.Exception_crear_jugador;

public interface Comandos {
    
    int MAX_JUGADORES = 6;

    ConsolaNormal consola = new ConsolaNormal();
    //SALIR
    //se le pasa el argumento que sale del bucle de turnos
    //se sale de la partida
    void salir();
    //CREAR JUGADOR
    //se crea un jugador en la partida con el nombre y avatar que se pasan por comandos
    void crear_jugador( String nombre, String avatar) throws Exception_crear_jugador;
    //LISTAR JUGADORES
    //devuelve una lista con los jugadores y su información
    void listar_jugadores() throws Exception;
    //LISTAR AVATARES
    //devuelve una lista con los jugadores y su información
    void listar_avatares() throws Exception;
    //LISTAR ENVENTA
    //devuelve una lista con las propiedades en venta
    void listar_enventa() throws Exception;
    //LISTAR_EDIFICIOS
    //devuelve una lista con los edificios y su información
    void listar_edificios() throws Exception;
    //LISTAR_EDIFICIOS_CASILLa
    //devuelve una lista con los edificios de una casilla y su información
    void listar_edificios_casilla(String nombre) throws Exception;
    //CAMBIAR TURNO
    //pasa el turno al siguiente jugador una vez este haya tirado los dados
    void cambiar_turno() throws Exception;
    //JUGADOR
    //devuelve el jugador que tenga el turno en ese momento
    void jugador() throws Exception;
    //DESCRIBIR CASILLA
    //devuelve la información de un nombre de casilla que se le pase como parámetro
    void describir_casilla(String nombre) throws Exception;
    //DESCRIBIR JUGADOR
    //devuelve la información de un jugador con nombre el q se pasa por argumento
    void describir_jugador(String nombre) throws Exception;
    //DESCRIBIR AVATAR
    //devuelve la información de un AVATAR con nombre el q se pasa por argumento
    void describir_avatar(String id) throws Exception;
    //VER TABLERO
    //muestra el tablero por pantalla
    void ver_tablero();
    //CAMBIAR MODO
    //cambia el modo del jugador que tiene el turno
    void cambiar_modo() throws Exception;
    //COMPRAR
    //El jugador que tiene el turno compra la propiedad d nombre el argumento que se le pasa
    void comprar(String nombre) throws Exception;
    //STOP
    //para cuando leemos por fichero
    void stop();
    //SALIR CÁRCEL
    //Sala al jugador que tiene el turno de la cárcel si este lo está y tiene dinero
    void salir_carcel() throws Exception;
    //ESTADÍSTICAS
    //muestra por pantalla las estadísticas de la partida
    void estadisticas();
    //ESTADÍSTICAS JUGADOR
    //muestra por pantalla las estadísticas de un jugador cuyo nombre se pasa por argumentos
    void estadisticas_jugador(String nombre) throws Exception;
    //EDIFICAR EDIFICIO
    //el jugador que tenga el turno construye un edificio en la casilla donde esté
    void edificar_edificio(Tipo_Edificio tipo) throws Exception;
    //VENDER EDIFICIOS
    //el jugador recibe la mitad de dinero que cuesta un edificio al vender una cantidad de edificios indicada por argumentos
    void vender_edificio(Tipo_Edificio tipo, int numero) throws Exception;
    //LANZAR DADOS
    //El jugador que tiene el turno tira los dados, avanza por el tablero y realiza la acción que toque al caer en una casilla
    void lanzar_dados() throws Exception;
    //HIPOTECAR
    //El jugador hipoteca una de sus propiedades, que se le pasa como argumento
    void hipotecar(String nombre) throws Exception;
    //DESHIPOTECAR
    //el jugador deshipoteca una propiedad que puede volver a
    void deshipotecar(String nombre) throws Exception;
}
