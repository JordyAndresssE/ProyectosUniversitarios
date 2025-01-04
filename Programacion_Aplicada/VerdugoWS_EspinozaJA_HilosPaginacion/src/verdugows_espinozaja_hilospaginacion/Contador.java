/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package verdugows_espinozaja_hilospaginacion;

/**
 *
 * @author sebas
 */
public class Contador {
    private int contador = 0;
    private final Object lock = new Object();

    public void incrementar() {
        synchronized (lock) {
            contador++;
        }
    }

    public int obtenerValor() {
        synchronized (lock) {
            return contador;
        }
    }

    public void reset() {
        synchronized (lock) {
            contador = 0;
        }
    }
}

