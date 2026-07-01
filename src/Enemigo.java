public class Enemigo {
    // Atributos
    private String tipo;
    private String nombre;
    private int vida;
    private int danodeAtaque;
    private int armadura;
    private int experiencia;
    private int fila;
    private int columna;
    private boolean activo;


    // Constructor
    public Enemigo(String tipo, String nombre, int fila, int columna, int danoDeAtaque) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.fila = fila;
        this.columna = columna;
        this.danodeAtaque = danoDeAtaque;
        this.experiencia = 0;
        this.activo = true;
        this.vida = 3;
        this.armadura = 0;

        // Stats iniciales según el tipo de enemigo
        switch (tipo) {
            case "Fantasma":
                // atraviesa muros
                break;
            case "Armadura":
                // no atraviesa muros, tiene escudo
                this.armadura = 1; //resiste un instakill antes de morir
                break;
            case "Perseguidor":
            case "Aleatorio":
            default:
                this.armadura = 0;
        }
    }


    // Metodos
    public void atacar(Jugador j) {
        if (this.activo && j.estaVivo()){
            j.recibirDano(this.danodeAtaque);
        }
    }
    public void mover(Jugador j) {
        if (!this.activo)return;
        switch (this.tipo) {
            case "Perseguidor":
                perseguirJugador(j);
                break;
            case "Aleatorio":
                aleatorio();
                break;
            case "Fantasma":
                atravesar(j);
                break;
            case "Armadura":
                aleatorio();
                break;
        }
    }
    public void mostrarEstado() {
        System.out.println("Tipo: " + tipo + " | Nombre: " + nombre + " | Vida: " + vida + " | Posicion: (" + fila + ", " + columna + ")" + " | Activo: " + activo);
    }
    public boolean verificarColision(Jugador j) {
        return this.activo && this.fila == j.getFila() && this.columna == j.getColumna();
    }
    public void morir() {
        this.activo = false;
    }
    public void perseguirJugador(Jugador j) {
        if (this.fila < j.getFila()) this.fila++;
        else if (this.fila > j.getFila()) this.fila--;

        if (this.columna < j.getColumna()) this.columna++;
        else if (this.columna > j.getColumna()) this.columna--;
    }
    public void aleatorio() {
        int direccion = (int) (Math.random() * 4); // 0=arriba,1=abajo,2=izq,3=der
        switch (direccion) {
            case 0: this.fila--; break;
            case 1: this.fila++; break;
            case 2: this.columna--; break;
            case 3: this.columna++; break;
        }
    }
    public void atravesar(Jugador j) {
        perseguirJugador(j);
    }
    public void recibirInstakill(){
        if (this.armadura > 0) {
            this.armadura--; //pierde la resistencia pero sobrevive
        } else {
            morir(); //sin resistencia, muere directo
        }
    }


    // Get
    public void setNombre (String nombre) { this.nombre = nombre; }
    public void setVida(int vida) { this.vida = vida; }
    public void setArmadura(int armadura) { this.armadura = armadura; }
    public void setDanodeAtaque(int danodeAtaque) {this.danodeAtaque = danodeAtaque; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public void setFila(int fila) { this.fila = fila; }
    public void setColumna(int columna) { this.columna = columna; }
    public void setTipo(String tipo) { this.tipo = tipo; }


    public String getNombre() {
        return this.nombre;
    }
    public int getVida() {
        return this.vida;
    }
    public int getArmadura() {
        return armadura;
    }
    public int getDanodeAtaque() {
        return danodeAtaque;
    }
    public boolean getActivo() {
        return activo;
    }
    public int getFila() {
        return this.fila;
    }
    public int getColumna() {
        return this.columna;
    }
    public String getTipo() {
        return this.tipo;
    }

}
