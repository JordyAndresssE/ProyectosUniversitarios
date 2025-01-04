/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

/**
 *
 * @author sebas
 */
public class Conexion {
    private static Conexion instancia;
    
    private Conexion(){
        System.out.println("Se crea la instancia por primera vez");
    }
    
    public static Conexion obtenerInstancia(){
        if(instancia == null){
            instancia = new Conexion();
        }else{
            System.out.println("No se puede crear otra instancia");
        }
        return instancia;
    }
}
