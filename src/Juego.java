import java.util.Scanner;
import java.util.Random;
public class Juego {
    private Jugador jugador;
    private Tablero tablero;
    private Enemigo[] enemigos;
    private boolean juegoTerminado;
    private Random rand= new Random();
    private int turnosPoder=0;
    private ControlEnemigos controlEnemigos;

    public Juego(){
        juegoTerminado=false;
    }
    public void mostrarMenu(){
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        while(opcion !=4){
            System.out.println("==============================");
            System.out.println("     BIENVENIDO A PAC-MAN    ");
            System.out.println("==============================");
            System.out.println("1. Iniciar juego (consola)");
            System.out.println("2. Iniciar juego (gráfico)");
            System.out.println("3. Ver instrucciones");
            System.out.println("4. Salir");
            System.out.println("==============================");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1: iniciarJuego(); break;
                case 2: iniciarVentana();break;
                case 3:mostrarInstrucciones();break;
                case 4: System.out.println("¡Hasta Luego!");break;
                default: System.out.println("Opcion invalida");
            }
        }
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

        int maxMuros = (int)((fila - 2) * (columna - 2) * 0.2);
        System.out.println("¿Cuántos muros interiores quiere? (máximo " + maxMuros + ")");
        int cantMuro = sc.nextInt();
        if (cantMuro > maxMuros) {
            cantMuro = maxMuros;
        }
        System.out.println("¿Cuantos enemigos quieres?");
        int cantEnemigo = sc.nextInt();
        enemigos =new Enemigo[cantEnemigo];

        tablero =new Tablero(fila, columna, cantMuro, 3, 5);
        tablero.generarTablero();
        tablero.agregarMuros();
        tablero.agregarPoderes();

        int filaJugador = rand.nextInt(fila-2)+1;
        int columnaJugador = rand.nextInt(columna-2)+1;

        while (!tablero.movimientoValido(filaJugador,columnaJugador)){
            filaJugador=rand.nextInt(fila-2)+1;
            columnaJugador = rand.nextInt(columna-2)+1;
        }
        jugador = new Jugador(nombre , filaJugador , columnaJugador);
        generarEnemigos();
        controlEnemigos = new ControlEnemigos(enemigos,jugador);
        tablero.mostrarTablero(jugador,enemigos);
        while (!juegoTerminado){
            ejecutarTurno();
        }
    }
    public void ejecutarTurno(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Movimiento (w/a/s/d):");
        char tecla = sc.next().charAt(0);
        boolean movimientoOk = true;
        int filaTemp = jugador.getFila();
        int columnaTemp = jugador.getColumna();

        if (turnosPoder > 0) {
            turnosPoder--;
            if (turnosPoder == 0) {
                jugador.setPoderActivo(false);
                jugador.setVelocidad(1);
                System.out.println("¡El poder ha terminado!");
            }
        }

        for (int paso = 0; paso < jugador.getVelocidad(); paso++) {
            switch (tecla) {
                case 'w': filaTemp--; break;
                case 's': filaTemp++; break;
                case 'a': columnaTemp--; break;
                case 'd': columnaTemp++; break;
                default: System.out.println("Tecla inválida"); return;
            }
            if (!tablero.movimientoValido(filaTemp, columnaTemp)) {
                movimientoOk = false;
                break;
            }
        }

        if (movimientoOk) {
            jugador.setFila(filaTemp);
            jugador.setColumna(columnaTemp);

            for (Enemigo e : enemigos) {
                if (e.getActivo() && e.verificarColision(jugador)) {
                    if (jugador.getPoderActivo()) {
                        e.morir();
                        jugador.sumarPuntaje(e.getExperiencia());
                    } else {
                        e.atacar(jugador);
                        int repoFila = 0, repoColumna = 0;
                        do {
                            repoFila = rand.nextInt(tablero.getFilas()-2)+1;
                            repoColumna = rand.nextInt(tablero.getColumnas()-2)+1;
                        } while (!tablero.movimientoValido(repoFila, repoColumna) ||
                                (repoFila == jugador.getFila() && repoColumna == jugador.getColumna()));
                        e.setFila(repoFila);
                        e.setColumna(repoColumna);
                    }
                }
            }

            if (jugador.estaVivo()) {
                if (tablero.hayPunto(filaTemp, columnaTemp)) {
                    jugador.recogerPunto();
                    tablero.eliminarPunto(filaTemp, columnaTemp);
                }
                if (tablero.hayPoder(filaTemp, columnaTemp)) {
                    Poder p = tablero.obtenerPoder(filaTemp, columnaTemp);
                    if (p != null) {
                        p.activar(jugador);
                        turnosPoder = p.getDuracion();
                        System.out.println("¡Recogiste un poder: " + p.descripcion() + "!");
                        tablero.eliminarPoder(filaTemp, columnaTemp);
                    }
                }
            }

            if (!jugador.estaVivo()) {
                System.out.println("¡Game Over! Puntaje: " + jugador.getPuntaje());
                juegoTerminado = true;
            }

            if (!tablero.quedanPuntos()) {
                System.out.println("¡Ganaste! Puntaje: " + jugador.getPuntaje());
                juegoTerminado = true;
            }

        } else {
            System.out.println("¡Hay una pared ahí!");
        }

        controlEnemigos.moverEnemigos(tablero);
        tablero.mostrarTablero(jugador, enemigos);
        controlEnemigos.eliminarEnemigosInactivos();
    }
    public void generarEnemigos() {
        for (int i=0; i< enemigos.length;i++){
            int filaEnemigo = rand.nextInt(tablero.getFilas()-2)+1;
            int columnaEnemigo = rand.nextInt(tablero.getColumnas()-2)+1;
            while (!tablero.movimientoValido(filaEnemigo,columnaEnemigo) || (filaEnemigo==jugador.getFila()&& columnaEnemigo==jugador.getColumna())){
                filaEnemigo= rand.nextInt(tablero.getFilas()-2)+1;
                columnaEnemigo= rand.nextInt(tablero.getColumnas()-2)+1;
            }
            if (i % 4==0){
                enemigos[i]=new Perseguidor("Perseguidor",filaEnemigo,columnaEnemigo);
            } else if (i % 4 == 1) {
                enemigos[i]=new Aleatorio("Aleatorio",filaEnemigo,columnaEnemigo);
            } else if (i % 4 == 2) {
                enemigos[i]=new Armadura("Armadura",filaEnemigo,columnaEnemigo);
            }else{
                enemigos[i]=new Fantasma("Fantasma",filaEnemigo,columnaEnemigo);
            }
        }
    }
    public void mostrarInstrucciones(){
        System.out.println("==============================");
        System.out.println("        INSTRUCCIONES        ");
        System.out.println("==============================");
        System.out.println("W = Arriba");
        System.out.println("S = Abajo");
        System.out.println("A = Izquierda");
        System.out.println("D = Derecha");
        System.out.println(". = Punto que debes recoger");
        System.out.println("O = Poder especial");
        System.out.println("E = Enemigo");
        System.out.println("P = Tu personaje");
        System.out.println("# = Pared");
        System.out.println("==============================");
    }
    public void iniciarVentana() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el Nombre del jugador");
        String nombre = sc.nextLine();
        int fila = 0;
        while (fila < 3) {
            System.out.print("Ingresa el número de filas (mínimo 3): ");
            fila = sc.nextInt();
            if (fila < 3) System.out.println("Debe ser mínimo 3.");
        }
        int columna = 0;
        while (columna < 3) {
            System.out.print("Ingresa el número de columnas (mínimo 3): ");
            columna = sc.nextInt();
            if (columna < 3) System.out.println("Debe ser mínimo 3.");
        }
        int maxMuros = (int)((fila - 2) * (columna - 2) * 0.2);
        System.out.println("¿Cuántos muros interiores quiere? (máximo " + maxMuros + ")");
        int cantMuro = sc.nextInt();
        if (cantMuro > maxMuros) {
            cantMuro = maxMuros;
        }
        System.out.println("¿Cuántos enemigos quieres?");
        int cantEnemigo = sc.nextInt();
        enemigos = new Enemigo[cantEnemigo];

        tablero = new Tablero(fila, columna, cantMuro, 3, 5);
        tablero.generarTablero();
        tablero.agregarMuros();
        tablero.agregarPoderes();

        int filaJugador = rand.nextInt(fila - 2) + 1;
        int columnaJugador = rand.nextInt(columna - 2) + 1;
        while (!tablero.movimientoValido(filaJugador, columnaJugador)) {
            filaJugador = rand.nextInt(fila - 2) + 1;
            columnaJugador = rand.nextInt(columna - 2) + 1;
        }
        jugador = new Jugador(nombre, filaJugador, columnaJugador);
        generarEnemigos();

        // Lanza la ventana gráfica
        new VentanaJuego(tablero, jugador, enemigos);
    }
}
