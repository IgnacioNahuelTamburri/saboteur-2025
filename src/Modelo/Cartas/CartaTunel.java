package Modelo.Cartas;

public class CartaTunel implements Carta{

    private boolean norte;
    private boolean oeste;
    private boolean este;
    private boolean sur;
    private boolean centro;

    public CartaTunel (boolean norte, boolean oeste, boolean este, boolean sur, boolean centro){
        this.norte = norte;
        this.este = este;
        this.oeste = oeste;
        this.sur = sur;
        this.centro = centro;
    }

    @Override
    public String mostrar() {
        return "";
    }

    public boolean isNorte() {
        return norte;
    }

    public boolean isOeste() {
        return oeste;
    }

    public boolean isEste() {
        return este;
    }

    public boolean isSur() {
        return sur;
    }

    public boolean isCentro() {
        return centro;
    }
}
