package Modelo.Cartas;

import Modelo.Jugador;

public class CartaAccionRomper extends CartaAccion{
    private String herramienta;
    public CartaAccionRomper(String nombre, String herramienta) {
        super(nombre);
        this.herramienta = herramienta;
    }

    @Override
    public void usar(Jugador j) {
        j.romperHerramienta(herramienta);
    }
}
