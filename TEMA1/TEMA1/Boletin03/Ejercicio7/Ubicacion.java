package TEMA1.Boletin03.Ejercicio7;

public class Ubicacion {
    private int pasillo;
    private String estante;

    public Ubicacion(int pasillo, String estante) {
        this.pasillo = pasillo;
        this.estante = estante;
    }

    public int getPasillo() {
        return pasillo;
    }

    public void setPasillo(int pasillo) {
        this.pasillo = pasillo;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    @Override
    public String toString() {
        return "Pasillo: " + pasillo + ", Estante: " + estante;
    }

}
