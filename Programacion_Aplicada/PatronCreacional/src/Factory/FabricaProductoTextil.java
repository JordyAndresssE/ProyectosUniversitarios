/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

/**
 *
 * @author sebas
 */
public class FabricaProductoTextil extends FabricaProductos{

    @Override
    public IProducto crearProducto() {
        return new ProductoTextil();
            
    }
}
