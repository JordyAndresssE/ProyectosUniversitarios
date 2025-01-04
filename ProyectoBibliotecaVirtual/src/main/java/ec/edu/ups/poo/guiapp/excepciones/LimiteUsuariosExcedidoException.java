/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poo.guiapp.excepciones;

/**
 *
 * @author sebas
 */
public class LimiteUsuariosExcedidoException extends RuntimeException {

    public LimiteUsuariosExcedidoException() {
    }

    public LimiteUsuariosExcedidoException(String mensaje) {
        super(mensaje);
    }
}
