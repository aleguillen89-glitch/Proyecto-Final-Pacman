// El abstract va aquí, en la declaración de la clase
public abstract class Enemigo {

    // Atributos — todos protected para que los hijos accedan
    protected String nombre;
    protected int vida;
    protected int danodeAtaque;
    protected int armadura;
    protected int experiencia;
    protected int fila;
    protected int columna;
    protected boolean activo;

    // Constructor
    public Enemigo(String nombre, int fila, int columna, int danoDeAtaque) {
        this.nombre = nombre;
        this.fila = fila;
        this.columna = columna;
        this.danodeAtaque = danoDeAtaque;
        this.activo = true;
        this.vida = 3;
        this.armadura = 0;
        this.experiencia = 10;
    }

    //  Metodo abstracto - va dentro de la clase
    public abstract void mover(Jugador j,Tablero tablero);

    // Métodos normales
    public void atacar(Jugador j) {
        if (this.activo && j.estaVivo()) {
            j.recibirDano(this.danodeAtaque);
        }
    }

    public void mostrarEstado() {
        System.out.println("Tipo: " + this.getClass().getSimpleName() +
                " | Nombre: " + nombre +
                " | Vida: " + vida +
                " | Posicion: (" + fila + ", " + columna + ")" +
                " | Activo: " + activo);
    }

    public boolean verificarColision(Jugador j) {
        return this.activo && this.fila == j.getFila() && this.columna == j.getColumna();
    }

    public void morir() {
        this.activo = false;
    }

    public void recibirInstakill() {
        if (this.armadura > 0) {
            this.armadura--;
        } else {
            morir();
        }
    }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setVida(int vida) { this.vida = vida; }
    public void setArmadura(int armadura) { this.armadura = armadura; }
    public void setDanodeAtaque(int danodeAtaque) { this.danodeAtaque = danodeAtaque; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public void setFila(int fila) { this.fila = fila; }
    public void setColumna(int columna) { this.columna = columna; }
    public void setExperiencia(int experiencia) { this.experiencia = experiencia; }

    // Getters
    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getArmadura() { return armadura; }
    public int getDanodeAtaque() { return danodeAtaque; }
    public boolean getActivo() { return activo; }
    public int getFila() { return fila; }
    public int getColumna() { return columna; }
    public int getExperiencia() { return experiencia; }
}
