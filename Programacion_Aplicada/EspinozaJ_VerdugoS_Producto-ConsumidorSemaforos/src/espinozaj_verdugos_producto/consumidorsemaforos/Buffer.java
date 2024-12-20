/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espinozaj_verdugos_producto.consumidorsemaforos;

/**
 *
 * @author jordy
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Buffer {
    private final Queue<Integer> buffer;
    private final int maxSize;
    private final Semaphore items;
    private final Semaphore spaces;

    public Buffer(int size) {
        this.maxSize = size;
        this.buffer = new LinkedList<>();
        this.items = new Semaphore(0);
        this.spaces = new Semaphore(size);
    }

    public void producir(int item) throws InterruptedException {
        spaces.acquire();
        synchronized (this) {
            buffer.add(item);
        }
        System.out.println("Producido: " + item);
        items.release();
    }

    public int consumir() throws InterruptedException {
        items.acquire();
        int item;
        synchronized (this) {
            item = buffer.remove();
        }
        System.out.println("Consumido: " + item);
        spaces.release();
        return item;
    }
}
