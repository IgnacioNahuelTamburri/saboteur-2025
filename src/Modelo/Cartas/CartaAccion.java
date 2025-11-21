package Modelo.Cartas;

import Modelo.Juego;
import Modelo.Jugador;

public abstract class CartaAccion implements Carta {
    protected String nombre;

    public CartaAccion (String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public abstract void usar (Jugador j);
}
