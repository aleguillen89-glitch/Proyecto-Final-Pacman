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
    public void activar(Jugador j){
        switch (tipo){
            case "Velocidad":
                j.setVelocidad(j.getVelocidad()+1);
                System.out.println("¡Velocidad Aumentada!");
                break;
            case "Vulnerable":
                j.setPoderActivo(true);
                System.out.println("¡Enemigos Vulnerables!");
                break;
            case "Vida":
                j.setVida(j.getVida()+1);
                System.out.println("Vida Recuperada");
                break;
        }
        this.activo =true;
    }
    public String descripcion(){
        switch (tipo) {
            case "Velocidad": return "Aumenta tu velocidad temporalmente";
            case "Vulnerabilidad": return "Vulnerable todos los enemigos";
            case "Vida": return "Recupera 1 punto de vida";
            default: return "Poder desconocido";
        }
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
