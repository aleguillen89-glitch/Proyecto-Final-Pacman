public class Armadura extends Enemigo {

    public Armadura(String nombre, int fila, int columna) {
        super(nombre, fila, columna, 2); // más daño
        this.experiencia = 30;
        this.armadura = 1; // resiste un instakill
    }

    @Override
    public void mover(Jugador j) {
        if (!this.activo) return;
        // Se mueve aleatoriamente
        int direccion = (int) (Math.random() * 4);
        switch (direccion) {
            case 0: this.fila--; break;
            case 1: this.fila++; break;
            case 2: this.columna--; break;
            case 3: this.columna++; break;
        }
    }

    // Metodo propido de Armadura
    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("  → Armadura restante: " + armadura);
    }
}