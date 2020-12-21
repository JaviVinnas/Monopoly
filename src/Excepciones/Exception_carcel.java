package Excepciones;

import Jugador.Avatar;

public class Exception_carcel extends Exception {

    private Avatar avatar;

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Exception_carcel(Avatar avatar){
        this.avatar = avatar;
    }

    @Override
    public String getMessage() {
        return "El jugador " + avatar.getJugador().getNombre() + " está en la cárcel";
    }
}
