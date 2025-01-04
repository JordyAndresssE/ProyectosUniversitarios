/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Factory2;

/**
 *
 * @author sebas
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FabricaFiguras fabricaCirculo = new FabricaCirculo();
        fabricaCirculo.calcularPropiedades(12);

        FabricaFiguras fabricaCuadrado = new FabricaCuadrado();
        fabricaCuadrado.calcularPropiedades(3);

        FabricaFiguras fabricaRectangulo = new FabricaRectangulo();
        fabricaRectangulo.calcularPropiedades(2.5, 6);
    }
    
}
