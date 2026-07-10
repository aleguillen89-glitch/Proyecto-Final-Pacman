import java.util.Scanner;
import java.util.Random;
public class Juego {
    private Jugador jugador;
    private Tablero tablero;
    private Enemigo[] enemigos;
    private boolean juegoTerminado;
    private Random rand= new Random();

    public Juego(){
        juegoTerminado=false;
    }
    public void iniciarJuego(){
        Scanner sc =new Scanner(System.in);

        System.out.println("Ingrese el Nombre del jugador");
        String nombre=sc.nextLine();
        int fila = 0;
        while (fila < 3) {
            System.out.print("Ingresa el número de filas (mínimo 3): ");
            fila = sc.nextInt();
            if (fila < 3) System.out.println("Debe ser mínimo 3.");
        }
        int columna=0;
        while (columna < 3){
            System.out.print("Ingresa el número de columna (mínimo 3): ");
            columna = sc.nextInt();
            if (columna < 3) System.out.println("Debe ser mínimo 3.");
        }
        System.out.println("¿Cuántos muros interiores quiere?");
        int cantMuro= sc.nextInt();

        tablero =new Tablero(fila, columna, cantMuro, 3, 5);
        tablero.generarTablero();
        tablero.agregarMuros();
        tablero.agregarPuntos();
        tablero.agregarPoderes();

        int filaJugador = rand.nextInt(fila-2)+1;
        int columnaJugador = rand.nextInt(columna-2)+1;

        while (!tablero.movimientoValido(filaJugador,columnaJugador)){
            filaJugador=rand.nextInt(fila-2)+1;
            columnaJugador = rand.nextInt(columna-2)+1;
        }
        jugador = new Jugador(nombre , filaJugador , columnaJugador);
        tablero.mostrarTablero(jugador);
        while (!juegoTerminado){
            ejecutarTurno();
        }

    }
    public void ejecutarTurno(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Movimiento (w/a/s/d):");
        char tecla = sc.next().charAt(0);

        int nuevaFila = jugador.getFila();
        int nuevaColumna = jugador.getColumna();

        switch (tecla) {
            case 'w' : nuevaFila--;break;
            case 's' : nuevaFila++;break;
            case 'a' : nuevaColumna--;break;
            case 'd' : nuevaColumna++;break;
            default: System.out.println("Tecla inválida"); return;
        }

        if (tablero.movimientoValido(nuevaFila,nuevaColumna)){
            jugador.setFila(nuevaFila);
            jugador.setColumna(nuevaColumna);

        }else{
            System.out.println("!hay una pared ahí");
        }
        tablero.mostrarTablero(jugador);

    }
}
