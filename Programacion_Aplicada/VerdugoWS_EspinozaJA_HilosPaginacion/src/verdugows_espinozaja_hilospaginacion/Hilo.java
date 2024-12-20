package verdugows_espinozaja_hilospaginacion;

import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Hilo implements Runnable {
    private Contador contador;
    private JTextPane textPane;
    private int[] referencias;
    private int numMarcos;
    private JSlider speedSlider;
    private String algoritmo;
    private int fallosDePagina = 0;
    private volatile boolean running = true;
    private final Object pauseLock = new Object();
    private volatile boolean paused = false;

    public Hilo(Contador contador, JTextPane textPane, int[] referencias, int numMarcos, JSlider speedSlider, String algoritmo) {
        this.contador = contador;
        this.textPane = textPane;
        this.referencias = referencias;
        this.numMarcos = numMarcos;
        this.speedSlider = speedSlider;
        this.algoritmo = algoritmo;
    }

    @Override
    public void run() {
        switch (algoritmo) {
            case "FCFS":
                simularFCFS();
                break;
            case "OPTIMAL":
                simularOPTIMAL();
                break;
            case "LRU":
                simularLRU();
                break;
        }
    }

    private void simularFCFS() {
        int[] marcos = new int[numMarcos];
        Arrays.fill(marcos, -1); // Inicializar marcos vacíos con -1
        Queue<Integer> cola = new LinkedList<>();

        for (int ref : referencias) {
            if (!cola.contains(ref)) {
                fallosDePagina++;
                if (cola.size() == numMarcos) {
                    int toRemove = cola.poll();
                    for (int i = 0; i < marcos.length; i++) {
                        if (marcos[i] == toRemove) {
                            marcos[i] = ref;
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < marcos.length; i++) {
                        if (marcos[i] == -1) {
                            marcos[i] = ref;
                            break;
                        }
                    }
                }
                cola.add(ref);
            }
            actualizarTextPane(marcos, ref);
            if (!esperar()) return;
        }
        mostrarFallosDePagina();
    }

    private void simularOPTIMAL() {
        List<Integer> marcos = new ArrayList<>();

        for (int i = 0; i < referencias.length; i++) {
            int ref = referencias[i];
            if (!marcos.contains(ref)) {
                fallosDePagina++;
                if (marcos.size() == numMarcos) {
                    int farthest = i + 1;
                    int indexToReplace = 0;
                    for (int j = 0; j < marcos.size(); j++) {
                        int futureIndex = Arrays.stream(referencias, i + 1, referencias.length).boxed().collect(Collectors.toList()).indexOf(marcos.get(j));
                        if (futureIndex == -1) {
                            indexToReplace = j;
                            break;
                        } else if (futureIndex > farthest) {
                            farthest = futureIndex;
                            indexToReplace = j;
                        }
                    }
                    marcos.remove(indexToReplace);
                }
                marcos.add(ref);
            }
            actualizarTextPane(marcos, ref);
            if (!esperar()) return;
        }
        mostrarFallosDePagina();
    }

    private void simularLRU() {
        List<Integer> marcos = new ArrayList<>();
        Map<Integer, Integer> lastUsed = new HashMap<>();

        for (int i = 0; i < referencias.length; i++) {
            int ref = referencias[i];

            if (!marcos.contains(ref)) {
                fallosDePagina++;

                if (marcos.size() == numMarcos) {
                    int lru = Collections.min(lastUsed.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
                    marcos.remove((Integer) lru);
                    lastUsed.remove(lru);
                }

                marcos.add(ref);
            }

            lastUsed.put(ref, i);

            actualizarTextPane(marcos, ref);

            if (!esperar()) return;
        }

        mostrarFallosDePagina();
    }

    private void actualizarTextPane(int[] marcos, int referenciaActual) {
        SwingUtilities.invokeLater(() -> {
            try {
                StyledDocument doc = textPane.getStyledDocument();
                Style defaultStyle = textPane.addStyle("DefaultStyle", null);
                Style highlightStyle = textPane.addStyle("HighlightStyle", null);
                StyleConstants.setBackground(highlightStyle, Color.YELLOW);

                doc.remove(0, doc.getLength()); // Limpiar el contenido previo

                for (int i = 0; i < marcos.length; i++) {
                    int ref = marcos[i];

                    boolean isNewReference = (ref == referenciaActual);

                    doc.insertString(doc.getLength(), "[", defaultStyle);

                    if (ref != -1) {
                        doc.insertString(doc.getLength(), String.valueOf(ref), isNewReference ? highlightStyle : defaultStyle);
                    } else {
                        doc.insertString(doc.getLength(), " ", defaultStyle);
                    }

                    doc.insertString(doc.getLength(), "]", defaultStyle);

                    if (i < marcos.length - 1) {
                        doc.insertString(doc.getLength(), " ", defaultStyle);
                    }
                }

                doc.insertString(doc.getLength(), "\n", defaultStyle);

            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        });
    }

    private void mostrarFallosDePagina() {
        SwingUtilities.invokeLater(() -> {
            textPane.setText(textPane.getText() + "Número de fallos de página: " + fallosDePagina + "\n\n");
        });
    }

    private boolean esperar() {
        try {
            Thread.sleep(speedSlider.getValue());
            synchronized (pauseLock) {
                while (paused) {
                    pauseLock.wait();
                }
            }
        } catch (InterruptedException e) {
            return false;
        }
        return true;
    }

    public void pausar() {
        paused = true;
    }

    public void reanudar() {
        synchronized (pauseLock) {
            paused = false;
            pauseLock.notifyAll();
        }
    }

    public void detener() {
        running = false;
    }
}
