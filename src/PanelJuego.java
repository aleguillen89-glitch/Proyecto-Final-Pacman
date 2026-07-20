import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PanelJuego extends JPanel implements KeyListener{
    private Tablero tablero;
    private Jugador jugador;
    private Enemigo[]enemigos;
    private static final int CELDA =40;
    private int turnosPoder;


    public PanelJuego (Tablero tablero, Jugador jugador, Enemigo[]enemigos){
        this.tablero=tablero;
        this.jugador=jugador;
        this.enemigos=enemigos;
        setPreferredSize(new Dimension(
                tablero.getColumnas() * CELDA,
                tablero.getFilas() * CELDA + 60
        ));
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        char tecla;
        if (turnosPoder > 0) {
            turnosPoder--;
            if (turnosPoder == 0) {
                jugador.setPoderActivo(false);
                jugador.setVelocidad(1);
            }
        }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: tecla = 'w'; break;
            case KeyEvent.VK_S: tecla = 's'; break;
            case KeyEvent.VK_A: tecla = 'a'; break;
            case KeyEvent.VK_D: tecla = 'd'; break;
            default: return;
        }

        int filaTemp = jugador.getFila();
        int columnaTemp = jugador.getColumna();
        switch (tecla) {
            case 'w': filaTemp--; break;
            case 's': filaTemp++; break;
            case 'a': columnaTemp--; break;
            case 'd': columnaTemp++; break;
        }

        if (tablero.movimientoValido(filaTemp, columnaTemp)) {
            jugador.setFila(filaTemp);
            jugador.setColumna(columnaTemp);

            for (Enemigo en : enemigos) {
                if (en.getActivo() && en.verificarColision(jugador)) {
                    if (jugador.getPoderActivo()) {
                        en.morir();
                        jugador.sumarPuntaje(en.getExperiencia());
                    } else {
                        en.atacar(jugador);
                        int repoFila, repoColumna;
                        do {
                            repoFila = (int)(Math.random() * (tablero.getFilas() - 2)) + 1;
                            repoColumna = (int)(Math.random() * (tablero.getColumnas() - 2)) + 1;
                        } while (!tablero.movimientoValido(repoFila, repoColumna) ||
                                (repoFila == jugador.getFila() && repoColumna == jugador.getColumna()));
                        en.setFila(repoFila);
                        en.setColumna(repoColumna);
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
                        tablero.eliminarPoder(filaTemp, columnaTemp);
                    }
                }
            }

            if (!jugador.estaVivo()) {
                JOptionPane.showMessageDialog(this,
                        "¡Game Over!\nPuntaje: " + jugador.getPuntaje(),
                        "Game Over",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

            if (!tablero.quedanPuntos()) {
                JOptionPane.showMessageDialog(this,
                        "¡Ganaste!\nPuntaje: " + jugador.getPuntaje(),
                        "Victoria",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        for (Enemigo en : enemigos) {
            if (en.getActivo()) {
                en.mover(jugador, tablero);
            }
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                char celda = tablero.getMatriz()[i][j];
                if (celda == '#') {
                    g.setColor(Color.BLUE);
                } else if (celda == '.') {
                    g.setColor(Color.BLACK);
                    g.fillRect(j * CELDA, i * CELDA, CELDA, CELDA);
                    g.setColor(Color.YELLOW);
                    g.fillOval(j * CELDA + 15, i * CELDA + 15, 10, 10);
                    continue;
                } else if (celda == 'O') {
                    g.setColor(Color.BLACK);
                    g.fillRect(j * CELDA, i * CELDA, CELDA, CELDA);
                    g.setColor(Color.CYAN);
                    g.fillOval(j * CELDA + 10, i * CELDA + 10, 20, 20);
                    continue;
                } else {
                    g.setColor(Color.BLACK); // camino vacío
                }
                g.fillRect(j * CELDA, i * CELDA, CELDA, CELDA);
            }
        }
        for (Enemigo en : enemigos) {
            if (en.getActivo()) {
                if (en.getFila() == jugador.getFila() && en.getColumna() == jugador.getColumna()) {
                    continue;
                }
                g.setColor(Color.RED);
                g.fillOval(en.getColumna() * CELDA + 5,
                        en.getFila() * CELDA + 5,
                        CELDA - 10, CELDA - 10);
            }
        }
        g.setColor(Color.YELLOW);
        g.fillOval(jugador.getColumna() * CELDA + 5,
                jugador.getFila() * CELDA + 5,
                CELDA - 10, CELDA - 10);
        g.setColor(new Color(30, 30, 30));
        g.fillRect(0, tablero.getFilas() * CELDA,
                tablero.getColumnas() * CELDA, 60);


        g.setColor(Color.WHITE);
        g.drawLine(0, tablero.getFilas() * CELDA,
                tablero.getColumnas() * CELDA, tablero.getFilas() * CELDA);

        g.setColor(Color.CYAN);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Jugador: " + jugador.getNombre(), 10, tablero.getFilas() * CELDA + 20);

        g.setColor(Color.YELLOW);
        g.drawString("Puntaje: " + jugador.getPuntaje(), 10, tablero.getFilas() * CELDA + 40);

        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        String vidas = "";
        for (int i = 0; i < jugador.getVida(); i++) {
            vidas += "♥ ";
        }
        g.drawString(vidas, tablero.getColumnas() * CELDA - 100, tablero.getFilas() * CELDA + 30);
    }
}


