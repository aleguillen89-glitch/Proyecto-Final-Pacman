import javax.swing.JFrame;
public class VentanaJuego extends JFrame {
    private PanelJuego panelJuego;

    public VentanaJuego(Tablero tablero, Jugador jugador, Enemigo[]enemigos){
        super("Pac-Man"); // título de la ventana
        panelJuego = new PanelJuego(tablero, jugador, enemigos);
        add(panelJuego);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        panelJuego.requestFocusInWindow();
    }

}
