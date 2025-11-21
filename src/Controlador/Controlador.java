package Controlador;

import Modelo.Juego;
import Vista.VistaConsola;

import java.util.ArrayList;

public class Controlador {

    private Juego juego;
    private VistaConsola vistaConsola;

    public Controlador (Juego juego){
        this.juego = juego;
    }

    public void setVistaConsola (VistaConsola vistaConsola){
        this.vistaConsola = vistaConsola;
    }

    public void agregarJugador (String nombre){
        juego.agregarJugador(nombre);
    }

    public int cantJugadores (){
        return juego.getCantJugadores();
    }

    public String getJugadores () {
        return juego.getJugadores();
    }

    public void iniciarJuego (){
        juego.iniciarJuego();
    }

    public ArrayList<String> getCartasJugador (String nombre){
        return juego.getCartasJugador(nombre);
    }

    public String getRolJugador (String nombre){
        return juego.getRolJugador(nombre);
    }
}
