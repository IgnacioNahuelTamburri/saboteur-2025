package Modelo.Cartas;

public class CartaPepita implements Carta {

    private boolean esPepita;

    public CartaPepita (boolean esPepita){
        this.esPepita = esPepita;
    }

    @Override
    public String toString() {
        if (esPepita){
            return "pepita";
        }
        return "carbon";
    }
}
