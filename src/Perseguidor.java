public class Perseguidor extends Enemigo {
    public Perseguidor(String nombre,int fila, int columna) {
        super(nombre,fila,columna, 1);
        this.experiencia= 10;
    }
    @Override
    public void mover(Jugador j){
        if(!this.activo) return;
        //se mueve directo hacia el jugaor
        if(this.fila < j.getFila()) this.fila++;
        else if (this.fila > j.getFila()) this.fila--;

        if(this.columna < j.getColumna()) this.columna++;
        else if (this.columna > j.getColumna()) this.columna--;
    }
}
