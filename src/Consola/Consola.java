package Consola;

public interface Consola {
    //IMPRIMIR
    //Se le pasa un mensaje y te lo imprime en la consola
    void imprimir(String mensaje);
    //LEER
    //se le pasa lo que quieres que te escriba el usuario ej: "Imprime el nombre de la casilla que quieras comprar"
    //y devuelve un string con lo que escriba el usuario por pantalla
    String leer(String descripcion);
}
