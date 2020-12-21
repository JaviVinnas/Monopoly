package Excepciones;

public class ErrAvatar extends Exception_crear_jugador {
    public ErrAvatar(String avatar_mal){
        super(avatar_mal);
    }

    @Override
    public String descripcion() {
        return ("No hay un avatar de nombre " + getMessage() + ". Prueba con coche, pelota, esfinge o sombrero");
    }

}
