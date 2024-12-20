/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Singleton;

/**
 *
 * @author sebas
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion conec1 = Conexion.obtenerInstancia();
        System.out.println(conec1);
        
        Conexion conec2 = Conexion.obtenerInstancia();
        System.out.println(conec2);
    }
    
}
