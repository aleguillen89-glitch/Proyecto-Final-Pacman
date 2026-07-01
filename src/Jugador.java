public class Jugador {
    //Atributos
    private String nombre;
    private String vida;
    private int danoataque;
    private String armadura;
    private String velocidad;
    private int posicion;
    private int fila;
    private int columna;
    private int puntaje;
    private boolean poderActivo;

    //Metodos
    public void usarPoder() { }
    public void mostrarEstado() { }
    public void estaVivo() { }
    public void mover() { }
    public void esquivar() { }
    public void recibirDaño() { }
    public void recibirArmadura() { }
    public void morir() { }
    public void recogerPunto() { }


    //Get
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setVida(String vida) { this.vida = vida; }
    public void setDanoAtaque(int danoAtaque) { this.danoataque = danoAtaque; }
    public void setArmadura(String Armadura) { this.armadura = Armadura; }
    public void setVelocidad(String velocidad) { this.velocidad = velocidad; }
    public void setPosicion(int Posicion) { this.posicion = Posicion; }

    public String getNombre() { return this.nombre; }
    public String getVida() { return this.vida; }
    public int getDanoAtaque() { return this.danoataque; }
    public String getArmadura() { return this.armadura; }
    public String getVelocidad() { return this.velocidad; }
    public int getPosicion() { return this.posicion; }
}
