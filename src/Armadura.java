public class Armadura extends Enemigo {

    public Armadura(String nombre, int fila, int columna) {
        super(nombre, fila, columna, 2); // más daño
        this.experiencia = 30;
        this.armadura = 1; // resiste un instakill
    }

    @Override
    public void mover(Jugador j,Tablero tablero) {
        if (!this.activo) return;
        int nuevaFila=this.fila;
        int nuevaColumna = this.columna;
        // Se mueve aleatoriamente
        int direccion = (int) (Math.random() * 4);
        switch (direccion) {
            case 0: nuevaFila--; break;
            case 1: nuevaFila++; break;
            case 2: nuevaColumna--; break;
            case 3: nuevaColumna++; break;
        }
        if (tablero.movimientoValido(nuevaFila,nuevaColumna)){
            this.fila = nuevaFila;
            this.columna = nuevaColumna;
        }
    }

    // Metodo propido de Armadura
    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("  → Armadura restante: " + armadura);
    }
}