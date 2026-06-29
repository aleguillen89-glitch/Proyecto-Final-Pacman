public class Punto {
    //Atributos
    private int fila;
    private int columna;
    private int valor;
    private boolean recolectado;

    public Punto(int fila, int columna, int valor){
        this.fila=fila;
        this.columna=columna;
        this.valor=valor;
    }
    public int Obtenervalor(){
        return this.valor;
    }
    public boolean fueRecolectado(){
        return this.recolectado;
    }
    public void recolectar(){
        this.recolectado=true;
    }

    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}
