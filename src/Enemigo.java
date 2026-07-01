public class Enemigo {
    // Atributos
    private String tipo;
    private String nombre;
    private String vida;
    private int DanodeAtaque;
    private String Armadura;
    private String Aleatorio;
    private int Experiencia;
    private int Fila;
    private int Columna;
    private boolean Activo;
    private String Atravesar;

    // Metodos
    public void atacar() { }
    public void mover() { }
    public void mostrarEstado() { }
    public void verificarColision() { }
    public void esquivar() { }
    public void recibirDano() { }
    public void recibirArmadura() { }
    public void morir() { }
    public void perseguirJugador() { }
    public void patrullar() { }

    // Get
    public void setnombre (String nombre) { this.nombre = nombre; }
    public void setvida(String vida) { this.vida = vida; }
    public void setArmadura(String Armadura) { this.Armadura = Armadura; }
    public void setDanodeAtaque(int DanodeAtaque) {this.DanodeAtaque = DanodeAtaque; }
    public void setActivo(boolean Activo) { this.Activo = Activo; }
    public void setAleatorio(String Aleatorio) { this.Aleatorio = Aleatorio; }
    public void setAtravesar(String Atravesar) { this.Atravesar = Atravesar; }

    public String getnombre() {
        return this.nombre;
    }
    public String getvida() {
        return this.vida;
    }
    public String getArmadura() {
        return Armadura;
    }
    public int getDanodeAtaque() {
        return DanodeAtaque;
    }
    public boolean getActivo() {
        return Activo;
    }
    public String getAleatorio() {
        return Aleatorio;
    }
    public String getAtravesar() {
        return Atravesar;
    }

}
