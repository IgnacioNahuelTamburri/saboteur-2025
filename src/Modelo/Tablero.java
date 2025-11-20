package Modelo;

import Modelo.Cartas.Carta;
import Modelo.Cartas.CartaPepita;
import Modelo.Cartas.CartaTunel;

public class Tablero {

    public static final int ANCHO_TABLERO = 11;
    public static final int ALTO_TABLERO = 5;

    private Carta[][] tablero = new Carta[ALTO_TABLERO][ANCHO_TABLERO];

    public Tablero() {
        tablero[2][1] = new CartaTunel(true, true, true, true, true);
        tablero[0][9] = new CartaPepita();
        tablero[2][9] = new CartaPepita();
        tablero[4][9] = new CartaPepita();
    }

    public void mostrarTablero() {
        for (int fila = 0; fila < ALTO_TABLERO; fila++) {
            for (int col = 0; col < ANCHO_TABLERO; col++) {

                Carta c = tablero[fila][col];

                if (c == null) {
                    System.out.print(". ");      // casillero vacío
                } else if (c instanceof CartaTunel) {
                    System.out.print("T ");      // casillero con carta túnel
                } else if (c instanceof CartaPepita){
                    System.out.print("P ");
                } else {
                    System.out.print("? ");      // otro tipo de carta
                }
            }
            System.out.println(); // salto de línea
        }
    }

    public boolean evaluarCartaTunel (Carta carta, int fila, int col){
        Carta c = tablero[fila][col];
        if (c != null) {
            return false;
        }

        CartaTunel cartaTunel = (CartaTunel) carta;

        CartaTunel arriba = (CartaTunel) tablero[fila-1][col];
        if (arriba != null) {
            if (cartaTunel.isNorte() && arriba.isSur())
                return true;
        }
        CartaTunel abajo = (CartaTunel) tablero[fila+1][col];
        if (abajo != null) {
            if (cartaTunel.isSur() && abajo.isNorte())
                return true;
        }
        CartaTunel izquierda = (CartaTunel) tablero[fila][col-1];
        if (izquierda != null) {
            if (cartaTunel.isOeste() && izquierda.isEste())
                return true;
        }
        CartaTunel derecha = (CartaTunel) tablero[fila][col+1];
        if (derecha != null) {
            if (cartaTunel.isEste() && derecha.isOeste())
                return true;
        }
        return false;
    }

    public void ponerCarta (Carta carta, int fila, int col){
        if (evaluarCartaTunel(carta,fila,col)){
            tablero[fila][col] = carta;
        }
        else System.out.println("No se puede colocar carta!");
    }

    public boolean sacarCarta (Carta carta, int fila, int col){
        if ((fila == 0 && col == 9) || (fila == 2 && col == 9) || (fila == 4 && col == 9) || (fila == 2 && col == 1)){
            return false;
        }
        Carta c = tablero[fila][col];
        if (c == null) {
            return false;
        }
        tablero[fila][col] = null;
        return true;
    }
}

