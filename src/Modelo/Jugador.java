package Modelo;

import Modelo.Cartas.Carta;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private Carta tipo;
    private Boolean pico;
    private Boolean luz;
    private Boolean carro;
    private ArrayList <Carta> cartas = new ArrayList();

    public Jugador (String nombre){
        this.nombre = nombre;
        this.pico = true;
        this.luz = true;
        this.carro = true;
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
}
