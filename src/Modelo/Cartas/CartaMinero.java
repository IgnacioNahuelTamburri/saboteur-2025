package Modelo.Cartas;

public class CartaMinero implements Carta{
    private boolean saboteador;

    public CartaMinero (boolean saboteador){
        this.saboteador = saboteador;
    }

    public boolean isSaboteador() {
        return saboteador;
    }

    @Override
    public String mostrar() {
        if (!saboteador){
            return "Soy un minero!";
        }
        return "Soy un saboteador!";
    }
}
