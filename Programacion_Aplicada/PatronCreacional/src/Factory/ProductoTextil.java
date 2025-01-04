/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

/**
 *
 * @author sebas
 */
public class ProductoTextil implements IProducto{
    
    int codigo;
    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void calcularPrecio() {
        System.out.println("Mostrar precio producto:");
    }
    
}
