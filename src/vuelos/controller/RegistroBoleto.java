package vuelos.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import vuelos.database.Conexion;
import vuelos.model.Usuario; // Importamos tu clase Usuario para traer el id global

public class RegistroBoleto {

    /**
     * Registra un nuevo boleto en la Base de Datos asociándolo al usuario activo
     */
    public void registrar(String nVuelo, double totalPago, String asientosFinales) {
        
        // 1. Jalamos el ID del usuario que se logueó de forma exitosa
        int idUsuarioLogueado = Usuario.idUsuarioLogueado;
        
        // 2. Obtenemos la fecha actual usando nuestro método separado
        String fechaCompra = obtenerFechaActual();
        
        // Tu consulta SQL de inserción con exactamente 5 parámetros (?)
        String sql = "INSERT INTO boletos (id_usu, numero_vuelo, precio_pagado, numero_asiento, fecha_compra) VALUES (?, ?, ?, ?, ?)";
        
        // Abrimos la conexión de forma segura
        try (Connection con = Conexion.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            // 3. Pasamos los parámetros al PreparedStatement en estricto orden secuencial
            pstmt.setInt(1, idUsuarioLogueado);      // id_usu
            pstmt.setString(2, nVuelo);             // numero_vuelo
            pstmt.setDouble(3, totalPago);          // precio_pagado
            pstmt.setString(4, asientosFinales);     // numero_asiento
            pstmt.setString(5, fechaCompra);         // fecha_compra
            
            // 4. Ejecutamos la acción en MySQL
            int filasAfectadas = pstmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("¡Boleto guardado exitosamente en la base de datos!");
                JOptionPane.showMessageDialog(null, "¡Compra registrada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al registrar el boleto en la BD: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error crítico al guardar en la base de datos: " + e.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método aparte que genera y retorna la fecha actual del sistema en formato YYYY-MM-DD
     */
    private String obtenerFechaActual() {
        LocalDate fechaHoy = LocalDate.now(); 
        DateTimeFormatter formatoMySQL = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fechaHoy.format(formatoMySQL); // Devuelve ej: "2026-06-26"
    }
}