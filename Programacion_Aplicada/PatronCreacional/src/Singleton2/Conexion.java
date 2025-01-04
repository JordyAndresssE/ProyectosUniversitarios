/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author sebas
 */
public class Conexion {
    private static RandomAccessFile conexionFichero;

    public Conexion() {
        System.out.println("Se crea la instancia por primera vez");
    }
    
    public static RandomAccessFile obtenerInstancia() throws FileNotFoundException, IOException{
        if (conexionFichero == null){
            String ruta = "C:\\Users\\sebas\\OneDrive - Universidad Politecnica Salesiana\\Documentos\\UPS\\2DOSEMESTRE\\PROGRAMACIÓNAPLICADA\\PatronCreacional\\src\\Singleton2\\fichero1.txt";
            
            conexionFichero = new RandomAccessFile(ruta, "rw");
            conexionFichero.seek(conexionFichero.length());
            
            System.out.println("Se ha creado el fichero");
            
        }else{
            System.out.println("No se puede crear otra vez la conexion al fichero");
        }
        return conexionFichero;
    }
}
