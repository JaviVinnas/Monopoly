package Consola;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class ConsolaNormal implements Consola{

    public ConsolaNormal(){

    }

    @Override
    public void imprimir(@NotNull String mensaje) {
        if(mensaje.equals("x")){
            System.out.println("Comando incorrecto");
        }else {
            System.out.println(mensaje);
        }

    }

    public void imprimir(String mensaje, int num) {
        if(num == 0) System.out.print(mensaje);

    }

    @Override
    public String leer(String descripcion) {
        System.out.println(descripcion);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int pregutar_por_numero(String descripcion) throws NumberFormatException{
        imprimir(descripcion);
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
    //se le pasa por argumento la letra que devuelve si no tiene un caracter el string
    public char leer_letra(char letra){
        Scanner scanner = new Scanner(System.in);
        String escrito = scanner.nextLine();
        if(escrito.length() != 1){
            return letra;
        }else{
            return escrito.charAt(0);

        }
    }





}
