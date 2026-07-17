public class Fantasma extends Enemigo {

    public Fantasma(String nombre, int fila, int columna) {
        super(nombre, fila, columna, 1);
        this.experiencia = 20;
    }

    @Override
    public void mover(Jugador j, Tablero tablero) {
        if (!this.activo) return;
        int nuevaFila= this.fila;
        int nuevaColumna = this.columna;
        // Igual que perseguidor pero atraviesa muros
        // (la lógica de muros se ignora para este tipo)
        if (nuevaFila < j.getFila()) nuevaFila++;
        else if (nuevaFila > j.getFila()) nuevaFila--;
        if (nuevaColumna < j.getColumna()) nuevaColumna++;
        else if (nuevaColumna > j.getColumna()) nuevaColumna--;

        if (nuevaFila < 0) nuevaFila = tablero.getFilas() - 1;
        else if (nuevaFila >= tablero.getFilas()) nuevaFila = 0;
        if (nuevaColumna < 0) nuevaColumna = tablero.getColumnas() - 1;
        else if (nuevaColumna >= tablero.getColumnas()) nuevaColumna = 0;
        this.fila = nuevaFila;
        this.columna = nuevaColumna;
    }

    // Metodo propio del Fantasma para saber si puede atravesar
    public boolean puedeAtravesarMuro() {
        return true;
    }
}