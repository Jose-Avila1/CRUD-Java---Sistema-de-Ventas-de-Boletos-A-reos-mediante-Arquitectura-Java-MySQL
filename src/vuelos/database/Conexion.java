/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuelos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jose
 */
public class Conexion {
    
    // Configuración de los datos de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/unefavuelos";
    private static final String USER = "root";
    private static final String PASSWORD = "";  //contraseña

    public static Connection conectar() {
        Connection conexion = null;
        try {
            // Registrar el driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
           // System.out.println("¡Conexión exitosa a MySQL!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }
    
        //para encriptar la contraseña
    
    public static String encriptarSHA256(String password) {
    try {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
}
    
}
