/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prototype;

import java.util.*;

/**
 *
 * @author sebas
 */
public class FiguraGeometricaCache {
    private static Map<String, FiguraGeometrica> mapaFiguras = new HashMap<>();
    
    public static void loadCache(){
        Circulo c = new Circulo();
        c.setTipo("Prototipo de Circulo");
        mapaFiguras.put(c.getTipo(), c);
        
        Rectangulo r = new Rectangulo();
        r.setTipo("Prototipo de Rectangulo");
        mapaFiguras.put(r.getTipo(), r);
    }
    
    public static FiguraGeometrica getFiguraGeometrica(String idFiguraGeometrica) throws CloneNotSupportedException{
        FiguraGeometrica mapFigura = mapaFiguras.get(idFiguraGeometrica);
        return mapFigura.clone();
        
    }
}
