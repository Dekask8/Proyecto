package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorBaseDeDatos {

    
    private static final String DRIVER_JDBC = "com.mysql.cj.jdbc.Driver";
    private static final String URL_BD = "jdbc:mysql://localhost:3306/tienda_skate";
    private static final String USUARIO = "root";
    private static final String CLAVE = ""; // (Contraseña vacía para XAMPP)

    
    public static Connection conectar() {
        Connection con = null;
        try {
           
            Class.forName(DRIVER_JDBC); 
            // ----------------------------------------
            
           
            con = DriverManager.getConnection(URL_BD, USUARIO, CLAVE);
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver de MySQL no encontrado. ¿Falta el .jar?");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error de SQL al conectar: " + e.getMessage());
            e.printStackTrace();
        }
        return con; 
    }

    
    public static void desconectar(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
    public static void main(String[] args) {
        try (Connection conexion = conectar()) {
            if (conexion != null) {
                System.out.println("¡Conexión exitosa! Base de datos: " + conexion.getMetaData().getDatabaseProductName());
            } else {
                System.out.println("Falló la conexión.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}