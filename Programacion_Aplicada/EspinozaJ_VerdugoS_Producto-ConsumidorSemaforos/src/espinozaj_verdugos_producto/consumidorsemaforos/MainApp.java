/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package espinozaj_verdugos_producto.consumidorsemaforos;

/**
 *
 * @author jordy
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainApp extends JFrame {
    private final JSlider sliderProductor;
    private final JSlider sliderConsumidor;
    private final JTextArea areaProductor;
    private final JTextArea areaConsumidor;
    private final Productor productor;
    private final Consumidor consumidor;

    public MainApp() {
        Buffer buffer = new Buffer(10);

        areaProductor = new JTextArea(10, 30);
        areaConsumidor = new JTextArea(10, 30);
        areaProductor.setEditable(false);
        areaConsumidor.setEditable(false);

        productor = new Productor(buffer, 1000, areaProductor);
        consumidor = new Consumidor(buffer, 1000, areaConsumidor);

        sliderProductor = new JSlider(0, 2000, 1000);
        sliderConsumidor = new JSlider(0, 2000, 1000);

        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        panel.add(new JLabel("Productor Sleep Time:"));
        panel.add(sliderProductor);
        panel.add(new JLabel("Consumidor Sleep Time:"));
        panel.add(sliderConsumidor);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(areaProductor), BorderLayout.WEST);
        add(new JScrollPane(areaConsumidor), BorderLayout.EAST);

        sliderProductor.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                productor.setSleepTime(sliderProductor.getValue());
            }
        });

        sliderConsumidor.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                consumidor.setSleepTime(sliderConsumidor.getValue());
            }
        });

        productor.start();
        consumidor.start();

        setTitle("Simulación Productor-Consumidor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainApp();
    }
}