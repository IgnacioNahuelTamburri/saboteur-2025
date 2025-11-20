package Modelo;

import Modelo.Cartas.*;

import java.util.ArrayList;
import java.util.Collections;

public class Juego {

    private final Tablero tablero = new Tablero();
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<Carta> mazo = new ArrayList<>();

    public Juego (ArrayList <Jugador> jugadores){
        this.jugadores = jugadores;
        setRoles();
        mazo.addAll(crearCartaTunel());
        mazo.addAll(crearCartaAccion());
        Collections.shuffle(mazo);
        repartirCartas();
    }

    public void setRoles (){
        int cantSabo = switch (jugadores.size()) {
            case 3, 4 -> 1;
            case 5, 6 -> 2;
            case 7, 8, 9 -> 3;
            case 10 -> 4;
            default -> throw new RuntimeException("No puede haber menos de 3 o más de 10 jugadores");
        };

        ArrayList <Carta> mineros = new ArrayList<>();
        for(int i = 0; i<=jugadores.size(); i++){
            if(cantSabo > 0){
                mineros.add(new CartaMinero(true));
                cantSabo--;
            }else{
                mineros.add(new CartaMinero(false));
            }
        }
        Collections.shuffle(mineros);
        for (Jugador j:jugadores){
            j.setTipo(mineros.removeFirst());
        }
    }

    public ArrayList<Carta> crearCartaTunel (){
        ArrayList <Carta> cartasTunel = new ArrayList<>();
        cartasTunel.add(new CartaTunel(false,false,false, true, true));
        cartasTunel.add(new CartaTunel(true, true, false, true, false));
        cartasTunel.add(new CartaTunel(true,false,false, true, false));
        cartasTunel.add(new CartaTunel(false, true,true, true, true));
        cartasTunel.add(new CartaTunel(false, true, false, true, false));
        cartasTunel.add(new CartaTunel(true, true, true, true, false));
        cartasTunel.add(new CartaTunel(false, true, false, false, true));
        cartasTunel.add(new CartaTunel(true, true, true, false, false));
        cartasTunel.add(new CartaTunel(false, true, true, false, false));
        cartasTunel.add(new CartaTunel(false, false, true, true, false));

        for (int i = 0; i < 2; i++){
            cartasTunel.add(new CartaTunel(true, true, false, true, true));
            cartasTunel.add(new CartaTunel(true, true, false, false, true));
        }

        for (int i = 0; i < 3; i++) {
            cartasTunel.add(new CartaTunel(true, false, true, true, true));
            cartasTunel.add(new CartaTunel(false, true, true, false, true));
            cartasTunel.add(new CartaTunel(false, false, true, true, true));
            cartasTunel.add(new CartaTunel(false, true, false, true, true));
            cartasTunel.add(new CartaTunel(true, false, true, false, true));
        }

        for (int i = 0; i < 4; i++) {
            cartasTunel.add(new CartaTunel(true, true, true, false, true));
            cartasTunel.add(new CartaTunel(true, false, false, true, true));
        }

        for (int i = 0; i < 6; i++) {
            cartasTunel.add(new CartaTunel(true, true, true, true, true));
        }
        return cartasTunel;
    }

    public ArrayList <Carta> crearCartaAccion (){
        ArrayList <Carta> cartas = new ArrayList<>();
        for (int i = 0; i < 3; i ++){
            cartas.add(new CartaAccionRomper("", "pico"));
            cartas.add(new CartaAccionRomper("", "carro"));
            cartas.add(new CartaAccionRomper("", "lampara"));
            cartas.add(new CartaAccionArreglar("", "pico"));
            cartas.add(new CartaAccionArreglar("", "carro"));
            cartas.add(new CartaAccionArreglar("", "lampara"));
            cartas.add(new CartaAccionDerrumbe(""));
        }
        for (int i = 0; i < 6; i ++){
            cartas.add(new CartaAccionMapa(""));
        }
        return cartas;
    }

    public void repartirCartas (){
        int cantCartas = switch (jugadores.size()) {
            case 3, 4, 5 -> 6;
            case 6, 7 -> 5;
            case 8, 9, 10 -> 4;
            default -> throw new RuntimeException("No puede haber menos de 3 o más de 10 jugadores");
        };
        ArrayList <Carta> cartasj = new ArrayList<>();
        for (Jugador j : jugadores){
            cartasj.clear();
            for (int i=0; i<cantCartas; i++){
                cartasj.add(mazo.removeFirst());
            }
            j.darCartas(cartasj);
        }
    }

    public boolean puedeJugarTunel (Carta c, int fila, int col){
        return tablero.evaluarCartaTunel(c, fila, col);
    }

    public void jugarCartaTunel (Carta c, int fila, int col){
        tablero.ponerCarta(c, fila, col);
    }

    public void mostrarTablero (){
        tablero.mostrarTablero();
    }
}
