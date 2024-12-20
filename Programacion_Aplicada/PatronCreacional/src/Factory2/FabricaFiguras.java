/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory2;

/**
 *
 * @author sebas
 */
public abstract class FabricaFiguras {
    public abstract FiguraGeometrica crearFigura(double... medidas);
    
    public void calcularPropiedades(double... medidas) {
        FiguraGeometrica figura = crearFigura(medidas);
        System.out.println("Area: " + figura.calcularArea());
        System.out.println("Perimetro: " + figura.calcularPerimetro());
    }
}
