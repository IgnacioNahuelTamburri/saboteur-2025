package Modelo;

import Modelo.Cartas.*;

import java.util.ArrayList;
import java.util.Collections;

public class Juego {
    public static void main(String[] args) {
        ArrayList <Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Tomas"));
        jugadores.add(new Jugador("Pablo"));
        jugadores.add(new Jugador("Nahuel"));
        jugadores.add(new Jugador("Bautista"));
        jugadores.add(new Jugador("Santiago"));
        jugadores.add(new Jugador("Valentin"));
        jugadores.add(new Jugador("Jorge"));
        jugadores.add(new Jugador("Jose"));
        jugadores.add(new Jugador("Candela"));

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
        for (Carta c:mineros){
            System.out.println(c.mostrar());
        }
        for (Jugador j:jugadores){
            j.setTipo(mineros.removeFirst());

            System.out.println("Jugador: " + j.getNombre() + (" ") + j.mostrarTipo());
        }
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

        Tablero tablero = new Tablero();
        tablero.mostrarTablero();
        CartaTunel carta1 = (new CartaTunel(false,false,false, true, true));
        CartaTunel carta2 = (new CartaTunel(false,true,false, true, true));
        tablero.ponerCarta(carta1,1,2);
        tablero.ponerCarta(carta2,2,2);
        tablero.mostrarTablero();
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

        Collections.shuffle(cartasTunel);
        return cartasTunel;
    }


}
