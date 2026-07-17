
public class Aleatorio extends Enemigo {
    ;
    public Aleatorio(String nombre, int fila, int columna) {
        super(nombre,columna,fila, 1);
        this.experiencia = 10;

    }

    @Override
    public void mover(Jugador j, Tablero tablero  ){
        if (!this.activo) return;
        int nuevaFila= this.fila;
        int nuevaColumna= this.columna;
        //Se mueve en direccion aleatoria ignorando al jugador
        int direccion = (int) (Math.random() * 4);
        switch (direccion){
            case 0: this.fila--; break;
            case 1: this.fila++; break;
            case 2: this.columna--; break;
            case 3: this.columna++; break;
        }
        if (tablero.movimientoValido(nuevaFila,nuevaColumna)){
            this.fila = nuevaFila;
            this.columna = nuevaColumna;
        }
    }
}
