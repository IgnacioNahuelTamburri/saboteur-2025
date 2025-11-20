package Modelo.Cartas;

import Modelo.Jugador;

public class CartaAccionArreglar extends CartaAccion {
    private String herramienta;

    public CartaAccionArreglar(String nombre, String herramienta) {
        super(nombre);
        this.herramienta = herramienta;
    }

    @Override
    public void usar(Jugador j) {
        j.arreglarHerramienta(herramienta);
    }
}
