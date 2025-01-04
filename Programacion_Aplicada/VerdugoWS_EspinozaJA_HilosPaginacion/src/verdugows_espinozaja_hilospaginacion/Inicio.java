package verdugows_espinozaja_hilospaginacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

public class Inicio extends JFrame {
    private JButton startButton, stopButton;
    private JSlider speedSlider;
    private JLabel speedLabel;
    private JTextPane fcfsPane, optimalPane, lruPane;
    private JLabel fcfsLabel, optimalLabel, lruLabel;
    private Thread fcfsThread, optimalThread, lruThread;
    private Hilo fcfsHilo, optimalHilo, lruHilo;
    private int speed = 1000;

    private int numReferencias;
    private int numMarcos;
    private int[] referencias;

    public Inicio() {
        setTitle("Simulación de Algoritmos de Reemplazo de Página");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        startButton = new JButton("Iniciar");
        stopButton = new JButton("Parar");
        speedSlider = new JSlider(200, 3000, 1000);
        speedLabel = new JLabel("Velocidad: 1000 ms");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fcfsThread != null && fcfsThread.isAlive()) {
                    fcfsHilo.reanudar();
                    optimalHilo.reanudar();
                    lruHilo.reanudar();
                } else {
                    startSimulation();
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fcfsThread != null && fcfsThread.isAlive()) {
                    fcfsHilo.pausar();
                    optimalHilo.pausar();
                    lruHilo.pausar();
                }
            }
        });

        speedSlider.addChangeListener(e -> {
            speed = speedSlider.getValue();
            speedLabel.setText("Velocidad: " + speed + " ms");
        });

        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(speedSlider);
        controlPanel.add(speedLabel);

        add(controlPanel, BorderLayout.NORTH);

        fcfsPane = new JTextPane();
        optimalPane = new JTextPane();
        lruPane = new JTextPane();

        fcfsLabel = new JLabel("FCFS:");
        optimalLabel = new JLabel("OPTIMAL:");
        lruLabel = new JLabel("LRU:");

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(3, 2));

        resultPanel.add(fcfsLabel);
        resultPanel.add(new JScrollPane(fcfsPane));
        resultPanel.add(optimalLabel);
        resultPanel.add(new JScrollPane(optimalPane));
        resultPanel.add(lruLabel);
        resultPanel.add(new JScrollPane(lruPane));

        add(resultPanel, BorderLayout.CENTER);

        obtenerDatosUsuario();
    }

    private void obtenerDatosUsuario() {
        try {
            numReferencias = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el número de referencias:"));
            numMarcos = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el número de marcos:"));
            referencias = new int[numReferencias];

            for (int i = 0; i < numReferencias; i++) {
                referencias[i] = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la referencia " + (i + 1) + ":"));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Entrada inválida. Por favor, ingrese solo números.");
            obtenerDatosUsuario();
        }
    }

    private void startSimulation() {
        fcfsHilo = new Hilo(new Contador(), fcfsPane, referencias, numMarcos, speedSlider, "FCFS");
        optimalHilo = new Hilo(new Contador(), optimalPane, referencias, numMarcos, speedSlider, "OPTIMAL");
        lruHilo = new Hilo(new Contador(), lruPane, referencias, numMarcos, speedSlider, "LRU");

        fcfsThread = new Thread(fcfsHilo);
        optimalThread = new Thread(optimalHilo);
        lruThread = new Thread(lruHilo);

        fcfsThread.start();
        optimalThread.start();
        lruThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Inicio().setVisible(true);
        });
    }
}
