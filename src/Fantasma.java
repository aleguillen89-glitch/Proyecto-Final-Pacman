public class Fantasma extends Enemigo {

    public Fantasma(String nombre, int fila, int columna) {
        super(nombre, fila, columna, 1);
        this.experiencia = 20;
    }

    @Override
    public void mover(Jugador j) {
        if (!this.activo) return;
        // Igual que perseguidor pero atraviesa muros
        // (la lógica de muros se ignora para este tipo)
        if (this.fila < j.getFila()) this.fila++;
        else if (this.fila > j.getFila()) this.fila--;

        if (this.columna < j.getColumna()) this.columna++;
        else if (this.columna > j.getColumna()) this.columna--;
    }

    // Metodo propio del Fantasma para saber si puede atravesar
    public boolean puedeAtravesarMuro() {
        return true;
    }
}