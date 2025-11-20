package Modelo;

import Modelo.Cartas.Carta;
import Modelo.Cartas.CartaAccion;
import Modelo.Cartas.CartaTunel;

import java.util.ArrayList;

public class Jugador {
    private Juego juego;
    private String nombre;
    private Carta tipo;
    private Boolean pico;
    private Boolean luz;
    private Boolean carro;
    private int puntos;
    private ArrayList <Carta> cartas = new ArrayList();

    public Jugador (String nombre, Juego juego){
        this.nombre = nombre;
        this.pico = true;
        this.luz = true;
        this.carro = true;
        this.puntos = 0;
        this.juego = juego;
    }

    public void setTipo(Carta tipo){
        this.tipo = tipo;
    }

    public String mostrarTipo (){
        return tipo.mostrar();
    }

    public String getNombre() {
        return nombre;
    }

    public void romperHerramienta (String cual){
        if(cual.equals("pico")){
            this.pico=false;
        } else if (cual.equals("carro")) {
            this.carro = false;
        }else{
            this.luz = false;
        }

    }

    public void arreglarHerramienta (String cual){
        if(cual.equals("pico")){
            this.pico=true;
        } else if (cual.equals("carro")) {
            this.carro = true;
        }else{
            this.luz = true;
        }
    }

    public void estadoHerramientas (){
        if (pico){
            System.out.println("Pico funcional");
        }
        else {
            System.out.println("Pico dañado");
        }
        if (carro){
            System.out.println("Carro funcional");
        }
        else {
            System.out.println("Carro dañado");
        }
        if (luz){
            System.out.println("Luz funcional");
        }
        else {
            System.out.println("Luz dañada");
        }
    }

    public void darCartas (ArrayList <Carta> cartasJugador){
        cartas.addAll(cartasJugador);
    }

    public boolean jugarCartaTunel (int indice, int fila, int col){
        Carta c = cartas.get(indice);
        if (!(c instanceof CartaTunel)){
            return false;
        }
        if (juego.puedeJugarTunel(c, fila, col)){
            cartas.remove(c);
            juego.jugarCartaTunel(c, fila, col);
            return true;
        }
        return false;
    }
}
