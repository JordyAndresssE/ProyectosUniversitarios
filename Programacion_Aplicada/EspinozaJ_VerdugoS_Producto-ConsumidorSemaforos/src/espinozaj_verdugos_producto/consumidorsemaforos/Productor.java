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

public class Productor extends Thread {
    private final Buffer buffer;
    private int sleepTime;
    private final JTextArea area;

    public Productor(Buffer buffer, int sleepTime, JTextArea area) {
        this.buffer = buffer;
        this.sleepTime = sleepTime;
        this.area = area;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        int item = 0;
        try {
            while (true) {
                Thread.sleep(sleepTime);
                buffer.producir(item);
                area.append("Producido: " + item + "\n");
                item++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

