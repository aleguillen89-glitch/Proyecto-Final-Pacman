public class Aleatorio extends Enemigo {

    public Aleatorio(String nombre, int columna, int fila) {
        super(nombre,columna,fila, 1);
        this.experiencia = 10;
    }

    @Override
    public void mover(Jugador j ){
        if (!this.activo) return;
        //Se mueve en direccion aleatoria ignorando al jugador
        int direccion = (int) (Math.random() * 4);
        switch (direccion){
            case 0: this.fila--; break;
            case 1: this.fila++; break;
            case 2: this.columna--; break;
            case 3: this.columna++; break;
        }
    }
}
