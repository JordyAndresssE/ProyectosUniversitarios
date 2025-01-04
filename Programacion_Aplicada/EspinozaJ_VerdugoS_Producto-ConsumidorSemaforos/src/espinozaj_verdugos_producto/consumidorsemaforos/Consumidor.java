/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espinozaj_verdugos_producto.consumidorsemaforos;

/**
 *
 * @author jordy
 */
import javax.swing.JTextArea;
import java.util.Random;

public class Consumidor extends Thread {
    private final Buffer buffer;
    private int sleepTime;
    private final JTextArea area;
    private final Random random;

    public Consumidor(Buffer buffer, int sleepTime, JTextArea area) {
        this.buffer = buffer;
        this.sleepTime = sleepTime;
        this.area = area;
        this.random = new Random();
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(sleepTime);
                int item = buffer.consumir();
                area.append("Consumido: " + item + "\n");
                Thread.sleep(random.nextInt(500) + 500);
                buffer.producir(item);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

