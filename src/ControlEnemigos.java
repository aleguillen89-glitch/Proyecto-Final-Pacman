public class ControlEnemigos {
    private Enemigo[] enemigos;
    private Jugador jugador;
    public ControlEnemigos(Enemigo[]enemigos, Jugador jugador){
        this.enemigos=enemigos;
        this.jugador=jugador;

    }
    public  void moverEnemigos(Tablero tablero){
        for (Enemigo e : enemigos) {
            if (e.getActivo()) {
                e.mover(jugador, tablero);
            }
        }
    }
    public void verificarColisiones (){
        for (Enemigo e : enemigos) {
            if (e.getActivo()) {
                e.verificarColision(jugador);
            }
        }
    }
    public void eliminarEnemigosInactivos(){
        for (Enemigo e : enemigos) {
            if (!e.getActivo()) {
                System.out.println("Enemigo " + e.getNombre() + " eliminado.");
            }
        }
    }
    public void generarMovimiento(Tablero tablero){
        for (Enemigo e : enemigos) {
            if (e.getActivo()) {
                e.mover(jugador, tablero);
            }
        }
    }
}
