package Modelo;

import java.util.ArrayList;
import java.util.Collections;

import Modelo.Cartas.*;
public class Pruebas {

    public static void main(String[] args) {
        ArrayList <Jugador> jugadores = new ArrayList<>();
        Juego juego = new Juego (jugadores);
        jugadores.add(new Jugador("Tomas", juego));
        jugadores.add(new Jugador("Pablo", juego));
        jugadores.add(new Jugador("Nahuel", juego));
        jugadores.add(new Jugador("Bautista", juego));
        jugadores.add(new Jugador("Santiago", juego));
        jugadores.add(new Jugador("Valentin", juego));
        jugadores.add(new Jugador("Jorge", juego));
        jugadores.add(new Jugador("Jose", juego));
        jugadores.add(new Jugador("Candela", juego));

        CartaAccion romperCarro = new CartaAccionRomper("Romper Carro", "carro");
        CartaAccion arreglarCarro = new CartaAccionArreglar("Arreglar Carro", "carro");
        CartaAccion romperLuz = new CartaAccionRomper("Romper Luz", "luz");
        CartaAccion arreglarLuz = new CartaAccionArreglar("Arreglar Luz", "luz");
        CartaAccion romperPico = new CartaAccionRomper("Romper Pico", "pico");
        CartaAccion arreglarPico = new CartaAccionArreglar("Arreglar Pico", "pico");

        jugadores.getFirst().estadoHerramientas();
        romperCarro.usar(jugadores.getFirst());
        jugadores.getFirst().estadoHerramientas();
        arreglarCarro.usar(jugadores.getFirst());
        jugadores.getFirst().estadoHerramientas();

        juego.mostrarTablero();
        CartaTunel carta1 = (new CartaTunel(false,false,false, true, true));
        CartaTunel carta2 = (new CartaTunel(false,true,false, true, true));
        juego.jugarCartaTunel(carta1,1,2);
        juego.jugarCartaTunel(carta2,2,2);
        juego.mostrarTablero();

    }

}
