/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototype2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jordy
 */

public class RegistroPersonajes {
    private Map<String, Personaje> prototipos = new HashMap<>();

    public void registrarPrototipo(String tipo, Personaje prototipo) {
        prototipos.put(tipo, prototipo);
    }

    public Personaje clonarPersonaje(String tipo) throws CloneNotSupportedException {
        return prototipos.get(tipo).clone();
    }
}