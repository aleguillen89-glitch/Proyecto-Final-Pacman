
public class Perseguidor extends Enemigo {
    public Perseguidor(String nombre,int fila, int columna) {
        super(nombre,fila,columna, 1);
        this.experiencia= 10;
    }
    @Override
    public void mover(Jugador j, Tablero tablero){
        if(!this.activo) return;
        int nuevaFila= this.fila;
        int nuevaColumna = this.columna;
        //se mueve directo hacia el jugaor
        if(nuevaFila < j.getFila()) nuevaFila++;
        else if (nuevaFila > j.getFila()) nuevaFila--;

        if(nuevaColumna < j.getColumna()) nuevaColumna++;
        else if (nuevaColumna > j.getColumna()) nuevaColumna--;

        if (tablero.movimientoValido( nuevaFila,nuevaColumna)){
        this.fila = nuevaFila;
        this.columna = nuevaColumna;


        }

    }
}
