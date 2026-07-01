public class Enemigo {
    // Atributos
    private String tipo;
    private String nombre;
    private int dano;
    private int fila;
    private int columna;
    private boolean activo;

    public Enemigo(String tipo, int fila, int columna, int dano){
        this.tipo=tipo;
        this.fila=fila;
        this.columna=columna;
        this.dano=dano;
        this.activo=true;
    }

    // Metodos
    public void atacar(Jugador j) { }
    public void mover(Jugador jugador, Tablero tablero) {

    }
    public void mostrarEstado() { }
    public void verificarColision(Jugador j) { }
    public void recibirDano() { }
    public void morir() { }

    // Get
    public void setNombre (String nombre) { this.nombre = nombre; }
    public void setDano(int DanodeAtaque) {this.dano= DanodeAtaque; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public void setFila(int fila){this.fila=fila;}
    public void setColumna(int columna){this.columna=columna;}


    public String getNombre() {
        return this.nombre;
    }
    public int getDano() {
        return dano;
    }
    public boolean isActivo() {
        return activo;
    }
    public int getFila(){return fila;}
    public int getColumna(){return columna;}
    public String getTipo(){return tipo;}

}
