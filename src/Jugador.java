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

    //Constructor
    public Jugador(String nombre,int fila,int columna) {
        this.nombre = nombre;
        this.fila = fila;
        this.columna = columna;
        this.vida = 3;
        this.danoataque = 1;
        this.armadura = 0;
        this.velocidad = 1;
        this.puntaje = 0;
        this.poderActivo = false;
    }
    //Metodos
    //Poder especil
    public void usarPoder() {
        if (!poderActivo){
            System.out.println(" No tienes poder activo!");
            return;
        }
        System.out.println(nombre + " Activo el poder especial! Los enemigos son vulnerable!");
        this.poderActivo = false;
    }
    //Muestra estado en consola
    public void mostrarEstado() {
        System.out.println("=== JUGADOR ===");
        System.out.println("Nombre  : " + nombre);
        System.out.println("Vida    : " + vida);
        System.out.println("Armadura: " + armadura);
        System.out.println("Puntaje : " + puntaje);
        System.out.println("Posición: (" + fila + ", " + columna + ")");
        System.out.println("Poder   : " + (poderActivo ? "ACTIVO" : "sin poder"));
    }
    //Verificar si esta vivo
    public boolean estaVivo() {
        return this.vida > 0;
    }
    //El jugador se mueve con W/A/S/D
    public void mover(char direccion) {
        switch (direccion) {
            case 'w': this.fila -= this.velocidad; break;
            case 's': this.fila += this.velocidad; break;
            case 'a': this.columna -= this.velocidad; break;
            case 'd': this.columna += this.velocidad; break;
            default:
                System.out.println("Direccion incorrecto. Usa W/A/S/D");
        }
    }
    //recibe daño de un enemigo al colisionar
    public void recibirDano(int danodeAtaque) {
        if (this.armadura > 0) {
            this.armadura--; //la armadura absorbe el golpe
            System.out.println(nombre + " Bloqueó el ataque con armadura!");
        } else {
            this.vida -= danodeAtaque;
            System.out.println(nombre + " recibio " + danodeAtaque + " de daño. Vida restante: " + vida);
            if (!estaVivo()) {
                morir();
            }
        }
    }
    //Recoge armadura del mapa(como power-up)
    public void recibirArmadura() {
        this.armadura++;
        System.out.println(nombre + " recogio armadura! Armadura : " + armadura);
    }
    //Muere
    public void morir() {
        System.out.println("GAME OVER! " + nombre + " ha muerto. ");
    }
    //Recoge un punto del mapa
    public void recogerPunto() {
        this.puntaje += 5;
        System.out.println(nombre + " recogio un punto! Puntaje: " + puntaje);
    }
    //Suma a experiencia del enemigo al puntaje
    public void sumarPuntaje(int puntos) {
        this.puntaje += puntos;
        System.out.println("+" + puntos + " puntos! Puntaje total: " + puntaje);
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
