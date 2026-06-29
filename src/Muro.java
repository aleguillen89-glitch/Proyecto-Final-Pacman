public class Muro {
    // Atributos
    private int fila;
    private int columna;

    public Muro( int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }
    public String ObtenerPosicion () {
        return "(" + this.fila + "," + this.columna + ")";
    }
    public int getFila () {
        return this.fila;
    }
    public int getColumna () {
        return this.columna;
    }
}
