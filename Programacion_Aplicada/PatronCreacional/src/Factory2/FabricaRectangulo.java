/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory2;

/**
 *
 * @author sebas
 */
public class FabricaRectangulo extends FabricaFiguras {
    @Override
    public FiguraGeometrica crearFigura(double... medidas) {
        return new Rectangulo(medidas[0], medidas[1]);
    }  
}
