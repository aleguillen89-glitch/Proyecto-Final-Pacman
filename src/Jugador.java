public class Jugador {
    //Atributos
    private String nombre;
    private int vida;
    private int danoataque;
    private int armadura;
    private int velocidad;
    private int fila;
    private int columna;
    private int puntaje;
    private boolean poderActivo;

    //Metodos
    public void usarPoder() { }
    public void mostrarEstado() { }
    public boolean estaVivo() { return vida > 0; }
    public void mover() { }
    public void esquivar() { }
    public void recibirDano(int danodeAtaque) { }
    public void recibirArmadura() { }
    public void morir() { }
    public void recogerPunto() { }
    public Jugador (String nombre, int fila, int columna) {
        vida=3;
        velocidad=1;
        puntaje=0;
        poderActivo=false;
    }

    //Get
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setVida(int vida) { this.vida = vida; }
    public void setDanoAtaque(int danoAtaque) { this.danoataque = danoAtaque; }
    public void setArmadura(int armadura) { this.armadura = armadura; }
    public void setVelocidad(int velocidad) { this.velocidad = velocidad; }
    public void setFila(int fila) { this.fila = fila; }
    public void setColumna(int columna) { this.columna = columna; }
    public void setPuntaje(int puntaje) { this.puntaje = puntaje; }
    public void setPoderActivo(boolean poderActivo) { this.poderActivo = poderActivo; }

    public String getNombre() { return this.nombre; }
    public int getVida() { return this.vida; }
    public int getDanoAtaque() { return this.danoataque; }
    public int getArmadura() { return this.armadura; }
    public int getVelocidad() { return this.velocidad; }
    public int getFila() { return this.fila; }
    public int getColumna() { return this.columna; }
    public int getPuntaje() { return this.puntaje; }
    public boolean getPoderActivo() { return this.poderActivo; }

}
