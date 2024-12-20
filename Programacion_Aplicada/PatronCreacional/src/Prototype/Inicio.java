/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Prototype;

/**
 *
 * @author sebas
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        FiguraGeometricaCache.loadCache();
        
        FiguraGeometrica figuraClonada = FiguraGeometricaCache.getFiguraGeometrica("Prototipo de Circulo");
        System.out.println(figuraClonada.getTipo());
        figuraClonada.dibujar();
    }
    
}
