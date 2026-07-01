public class Poder {
    private int duracion;
    private String tipo;
    private boolean activo ;
    private int columna;
    private int fila;

    public Poder (String tipo, int duracion, int fila, int columna){
        this.fila=fila;
        this.columna=columna;
        this.tipo=tipo;
        this.duracion=duracion;
    }
    public void activar(Jugador j){}
    public String descripcion(){
        return "";
    }
    public boolean estaActivo(){
        return activo;
    }

    public String getTipo() {
        return tipo;
    }
    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }
    public int getDuracion() {
        return duracion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
