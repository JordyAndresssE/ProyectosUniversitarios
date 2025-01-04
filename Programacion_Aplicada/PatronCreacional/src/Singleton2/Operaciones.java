/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton2;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author sebas
 */
public class Operaciones {
    public void escribirFichero(RandomAccessFile conexionFichero, String texto) throws IOException{
        conexionFichero.writeBytes(texto);
    }
}
