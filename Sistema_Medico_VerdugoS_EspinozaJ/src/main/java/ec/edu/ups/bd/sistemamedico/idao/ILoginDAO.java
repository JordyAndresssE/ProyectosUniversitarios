/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.idao;

import ec.edu.ups.bd.sistemamedico.modelo.Usuario;
import java.sql.SQLException;

public interface ILoginDAO {
    Usuario autenticar(String nombre, String contrasena) throws SQLException;
}
