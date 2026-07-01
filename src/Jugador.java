public class Jugador {
    //Atributos
    private String nombre;
    private int vida;
    private int armadura;
    private int velocidad;
    private int fila;
    private int columna;
    private int puntaje;
    private boolean poderActivo;
    public Jugador(String nombre, int fila, int columna){
        this.nombre= nombre;
        this.fila=fila;
        this.columna=columna;
        this.vida=3;
        this.velocidad=1;
        this.puntaje=0;
        this.poderActivo=false;

    }
    //Metodos
    public void usarPoder(Poder p) { }
    public void mostrarEstado() {  }
    public boolean estaVivo() { return vida > 0;}
    public void mover(String direccion) { }
    public void recibirDano(int cantidad) { }
    public void recibirArmadura(int cantidad) { }
    public void recogerPunto(Punto p) { }


    //Get
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setVida(int vida) { this.vida = vida; }
    public void setArmadura(int Armadura) { this.armadura = Armadura; }
    public void setVelocidad(int velocidad) { this.velocidad = velocidad; }
    public void setFila(int fila){this.fila=fila;}
    public void setColumna(int columna){this.columna=columna;}
    public void setPuntaje(int puntaje){this.puntaje=puntaje;}
    public void setPoderActivo(boolean poderActivo) {this.poderActivo = poderActivo;}

    public String getNombre() { return this.nombre; }
    public int getVida() { return this.vida; }
    public int getArmadura() { return this.armadura; }
    public int getVelocidad() { return this.velocidad; }
    public int getFila(){return this.fila;}
    public int getColumna() {return columna;}
    public int getPuntaje() {return puntaje;}
    public boolean isPoderActivo() {return poderActivo;}
}
