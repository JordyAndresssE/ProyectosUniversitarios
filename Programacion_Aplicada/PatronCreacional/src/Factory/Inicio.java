/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Factory;

/**
 *
 * @author sebas
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FabricaProductos fabProd = null;
        String motor = "textil";
        
        fabProd = inicializar(fabProd,motor);
        fabProd.calcularPrecio();
    }
    
    public static FabricaProductos inicializar(FabricaProductos fabProd, String motor){
        if(motor.equalsIgnoreCase("textil")){
            
            return fabProd = new FabricaProductoTextil();
        
        }else if(motor.equalsIgnoreCase("electronico")){
            
            return fabProd = new FabricaProductoElectronico();
            
        }
        
    return null;
    }
}
