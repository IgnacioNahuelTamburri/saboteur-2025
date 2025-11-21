package Vista;

import Controlador.Controlador;
import Modelo.Juego;
import jdk.jfr.ContentType;

public class Iniciar {
    public static void main(String[] args) {
        Juego juego = new Juego();
        Controlador controlador = new Controlador(juego);
        VistaConsola vistaConsola = new VistaConsola(controlador);
        controlador.setVistaConsola(vistaConsola);
    }


}
