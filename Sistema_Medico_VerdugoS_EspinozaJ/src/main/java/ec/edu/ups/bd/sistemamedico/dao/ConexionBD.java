package ec.edu.ups.bd.sistemamedico.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    // URL de conexión a Oracle
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Cambia según tu configuración
    private static final String USUARIO = "SISMEDICO"; // Usuario de la BD
    private static final String CONTRASENA = "sismedico123"; // Contraseña de la BD

    
    // Método para obtener la conexión
    public static Connection getConexion() { // Cambio de nombre para coincidir con la llamada en Login.java
        Connection conexion = null;
        try {
            // Cargar el driver de Oracle JDBC
            Class.forName("oracle.jdbc.OracleDriver");
            
            // Intentar la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("✅ Conexión exitosa a Oracle Database.");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: No se encontró el driver de Oracle JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar a la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }

    // Método para cerrar la conexión
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("✅ Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("❌ Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}
