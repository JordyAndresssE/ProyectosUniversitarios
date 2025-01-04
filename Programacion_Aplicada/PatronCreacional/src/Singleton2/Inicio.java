/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Singleton2;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author sebas
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        RandomAccessFile conexionFichero = Conexion.obtenerInstancia();
        System.out.println(conexionFichero);
        
        Operaciones op = new Operaciones();
        op.escribirFichero(conexionFichero, "prueba1");
        
        RandomAccessFile conexionFicheroExtra = Conexion.obtenerInstancia();
        System.out.println(conexionFicheroExtra);
        op.escribirFichero(conexionFicheroExtra, "prueba2");
    }
    
}
