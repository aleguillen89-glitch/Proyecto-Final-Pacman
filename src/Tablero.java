import java.util.Random;
public class Tablero {
    private int filas;
    private int columnas;
    private char[][] matriz;
    private Muro[] muros;
    private Punto[] puntos;
    private Poder[] poderes;
    private Random rand = new Random();


    public Tablero(int fila, int columna, int cantidadMuros, int cantidadPoderes, int cantidadPuntos){
        this.filas=fila;
        this.columnas=columna;
        matriz=new char [fila][columna];
        muros=new Muro[cantidadMuros];
        poderes=new Poder[cantidadPoderes];
        puntos=new Punto[cantidadPuntos];
    }
    public void  generarTablero(){
        for (int i=0; i<filas;i++){
            for (int j=0; j<columnas;j++){
                if (i==0 || i== filas-1 || j==0 || j==columnas-1) {
                    matriz[i][j] = '#';
                }else{
                    matriz[i][j]='.';
                }
            }
        }
    }
    public void agregarMuros() {
        for(int i=0; i< muros.length;i++) {
            int filaRandom = rand.nextInt(filas - 2) + 1;
            int columnaRandom = rand.nextInt(columnas - 2) + 1;
            while (filaRandom == 1 && columnaRandom == 1) {
                filaRandom = rand.nextInt(filas - 2) + 1;
                columnaRandom = rand.nextInt(columnas - 2) + 1;
            }
            muros[i] = new Muro(filaRandom, columnaRandom);
            matriz[filaRandom][columnaRandom]='#';
        }
    }
    public void agregarPuntos() {
        for (int i = 0; i < puntos.length; i++) {
            int filaRandom = rand.nextInt(filas - 2) + 1;
            int columnasRandom = rand.nextInt(columnas- 2) + 1;
            while ((filaRandom == 1 && columnasRandom == 1) || matriz[filaRandom][columnasRandom] == '#') {
                filaRandom = rand.nextInt(filas - 2) + 1;
                columnasRandom = rand.nextInt(columnas - 2) + 1;
            }
            puntos[i] = new Punto(filaRandom, columnasRandom, 5);
            matriz[filaRandom][columnasRandom] = '*';
        }
    }
    public void agregarPoderes(){
       for(int i=0; i< poderes.length;i++){
           int filaRandom = rand.nextInt(filas -2)+1;
           int columnaRandom = rand.nextInt(columnas -2)+1;
           while ((filaRandom==1 && columnaRandom==1)|| matriz[filaRandom][columnaRandom]=='#'|| matriz[filaRandom][columnaRandom]=='*'){
               filaRandom= rand.nextInt(filas -2)+1;
               columnaRandom =rand.nextInt(columnas -2)+1;
           }
           String tipo;
           if (i % 3 == 0){
               tipo="Velocidad";
           } else if (i % 3 == 1) {
               tipo="Congelar";
           }else {
               tipo="Vida";
           }
           poderes[i]=new Poder(tipo, 3, filaRandom, columnaRandom);
           matriz[filaRandom][columnaRandom]= 'O';
       }
    }
    public void mostrarTablero (Jugador jugador){
        for (int i=0; i< matriz.length;i++){
            for (int j=0; j< matriz[i].length;j++){
                if ( i== jugador.getFila() && j== jugador.getColumna()){
                    System.out.print('P');
                }else{
                    System.out.print(matriz[i][j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public boolean movimientoValido (int fila, int columna){
        if ( fila<0 || fila>=filas || columna<0 || columna>=columnas) {
            return false;
        }
        if (matriz[fila][columna]=='#'){
            return false;
        }
        return true;
    }
}

