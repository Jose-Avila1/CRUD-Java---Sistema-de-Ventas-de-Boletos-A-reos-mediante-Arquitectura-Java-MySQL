package vuelos.controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminController {

    // =======================================================================
    // METODO DE ENLACE DE CONEXIÓN A LA BASE DE DATOS
    // =======================================================================
    /**
     * IMPORTANTE: Aquí debes invocar tu método actual de conexión.
     * Reemplaza el "return null;" por la llamada a tu clase de conexión real.
     * Ejemplo: return vuelos.modelo.Conexion.getConexion();
     */
    private Connection obtenerConexion() {
        try {
            // REEMPLAZA ESTA LÍNEA por tu conexión real cuando vayas a conectar
            // return vuelos.modelo.Conexion.conectar(); 
            return null; 
        } catch (Exception e) {
            System.out.println("Error al enlazar con tu clase de conexión: " + e.getMessage());
            return null;
        }
    }

    // =======================================================================
    // 1. FUNCIONALIDAD: LOGIN DEL ADMINISTRADOR (Contenido en MainLogin)
    // =======================================================================
    /**
     * COLOCAR EN: El evento del botón "Ingresar" del panel de Login de Administrador.
     */
    public void procesarLoginAdmin(String txtCorreo, String txtPassword, JFrame ventanaLoginActual) {
        String correo = txtCorreo;
        String password = txtPassword;

        

        /* =======================================================================
        // CONSULTA SQL: LOGIN DE ADMINISTRADOR (Descomentar al crear tu tabla)
        // =======================================================================
        String sql = "SELECT * FROM administradores WHERE correo = ? AND contrasena = ?";
        
        try (Connection con = obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setString(1, correo);
            pstmt.setString(2, password);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(ventanaLoginActual, "¡Bienvenido al Panel de Control!", "Login Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    ventanaLoginActual.dispose(); // Cierra el login actual
                    
                    // Abre tu nueva ventana de administración diseñada por ti
                    new vuelos.view.InterfazAdmin().setVisible(true); 
                    return;
                } else {
                    JOptionPane.showMessageDialog(ventanaLoginActual, "Correo o contraseña de administrador incorrectos.", "Error de Acceso", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(ventanaLoginActual, "Error en la BD: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        ======================================================================= */

        // SIMULACIÓN TEMPORAL (Eliminar al activar el bloque SQL de arriba)
        if (correo.equals("1") && password.equals("1")) {
            JOptionPane.showMessageDialog(ventanaLoginActual, "¡Bienvenido al Panel de Control! (Simulación)");
            ventanaLoginActual.dispose();
            new vuelos.view.InterfazAdmin().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(ventanaLoginActual, "Credenciales incorrectas (Simulación).");
        }
    }

    // =======================================================================
    // 2. SECCIÓN 1: ADMINISTRACIÓN DE BOLETOS COMPRADOS (PÁGINA 2)
    // =======================================================================
    /**
     * Llena la JTable de boletos basándose estrictamente en las columnas de tu boceto.
     * COLOCAR EN: Al inicializar el Panel de la Sección 1 o en su botón correspondiente.
     */
    public void cargarTablaBoletos(JTable tablaBoletos) {
        DefaultTableModel modelo = (DefaultTableModel) tablaBoletos.getModel();
        modelo.setRowCount(0); // Limpia la tabla

        /* =======================================================================
        // CONSULTA SQL: SELECCIONAR BOLETOS RESERVADOS (Descomentar al crear tu tabla)
        // Columnas mapeadas: id_usuario, nombre_usuario, id_vuelo, numero_asiento
        // =======================================================================
        String sql = "SELECT id_usuario, nombre_usuario, id_vuelo, numero_asiento FROM boletos_reservados";
        
        try (Connection con = obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id_usuario"),
                    rs.getString("nombre_usuario"),
                    rs.getString("id_vuelo"),
                    rs.getString("numero_asiento")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar la tabla de boletos: " + e.getMessage());
        }
        ======================================================================= */
        
        // DATOS DE PRUEBA SIMULADOS (Coincidentes con tus columnas)
        for (int i = 1; i <= 20; i++) {
            int idSimulado = 4000 + i;
            String usuarioSimulado = "Pasajero Prueba " + i;
            String vueloSimulado = (i % 2 == 0) ? "MAD-102" : "BOG-747";
            String asientoSimulado = (i + "A");

            // Añadimos la fila al modelo coincidiendo con tus columnas (ID_USU, NOMBRE_USU, ID_VUELO, NUMERO_ASIENTO)
            modelo.addRow(new Object[]{idSimulado, usuarioSimulado, vueloSimulado, asientoSimulado});
}
    }

    /**
     * Elimina el boleto seleccionado utilizando el identificador de la primera columna.
     * COLOCAR EN: El evento del botón "ELIMINAR" de la Sección 1.
     */
    public void eliminarBoletoSeleccionado(JTable tablaBoletos) {
        int filaSel = tablaBoletos.getSelectedRow();
        if (filaSel == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un boleto de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Extraemos el ID_USU (Columna 0) para ejecutar el borrado
        int idUsuario = (int) tablaBoletos.getValueAt(filaSel, 0);

        int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el boleto del usuario ID: " + idUsuario + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar != JOptionPane.YES_OPTION) return;

        /* =======================================================================
        // CONSULTA SQL: ELIMINAR BOLETO (Descomentar al crear tu tabla)
        // =======================================================================
        String sql = "DELETE FROM boletos_reservados WHERE id_usuario = ?";
        
        try (Connection con = obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setInt(1, idUsuario);
            if (pstmt.executeUpdate() > 0) {
                ((DefaultTableModel) tablaBoletos.getModel()).removeRow(filaSel);
                JOptionPane.showMessageDialog(null, "Boleto eliminado de la base de datos.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar boleto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        ======================================================================= */
        
        // SIMULACIÓN TEMPORAL
        ((DefaultTableModel) tablaBoletos.getModel()).removeRow(filaSel);
        JOptionPane.showMessageDialog(null, "Boleto eliminado visualmente (Simulación).");
    }

    // =======================================================================
    // 3. SECCIÓN 2: ADMINISTRACIÓN DE VUELOS (PÁGINA 3)
    // =======================================================================
    /**
     * Carga los vuelos disponibles en la JTable de la Sección 2.
     */
    public void cargarTablaVuelos(JTable tablaVuelos) {
        DefaultTableModel modelo = (DefaultTableModel) tablaVuelos.getModel();
        modelo.setRowCount(0);

        /* =======================================================================
        // CONSULTA SQL: SELECCIONAR VUELOS (Descomentar al crear tu tabla)
        // Columnas mapeadas: numero_vuelo, origen, destino, fecha_salida
        // =======================================================================
        String sql = "SELECT numero_vuelo, origen, destino, fecha_salida FROM vuelos_disponibles";
        
        try (Connection con = obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("numero_vuelo"),
                    rs.getString("origen"),
                    rs.getString("destino"),
                    rs.getString("fecha_salida")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar vuelos: " + e.getMessage());
        }
        ======================================================================= */
        modelo.addRow(new Object[]{"MAD-102", "Madrid", "Paris", "15/10/2026"});
    }

    /**
     * Inserta un nuevo vuelo leyendo los 4 cuadros de texto de tu diseño.
     * COLOCAR EN: El botón "AGREGAR" (Agregar Vuelo) de la Sección 2.
     */
    

     public void agregarNuevoVuelo(JTextField txtNum, JTextField txtOrig, JTextField txtDest, JTextField txtFecha, JTable tablaVuelos) {
        String num = txtNum.getText().trim();
        String orig = txtOrig.getText().trim();
        String dest = txtDest.getText().trim();
        String fecha = txtFecha.getText().trim();
        
        if (num.isEmpty() || orig.isEmpty() || dest.isEmpty() || fecha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos del vuelo.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        /* =======================================================================
        // CONSULTA SQL: INSERTAR VUELO (Descomentar al crear tu tabla)
        // =======================================================================
        String sql = "INSERT INTO vuelos_disponibles (numero_vuelo, origen, destino, fecha_salida) VALUES (?, ?, ?, ?)";
        try (Connection con = obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, num);
            pstmt.setString(2, orig);
            pstmt.setString(3, dest);
            pstmt.setString(4, fecha);
            
            if (pstmt.executeUpdate() > 0) {
                ((DefaultTableModel) tablaVuelos.getModel()).addRow(new Object[]{num, orig, dest, fecha});
                JOptionPane.showMessageDialog(null, "Vuelo registrado exitosamente.");
                // Limpieza automática de tus cuadros de texto
                txtNum.setText(""); txtOrig.setText(""); txtDest.setText(""); txtFecha.setText("");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar vuelo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        ======================================================================= */
        
        // SIMULACIÓN TEMPORAL (Eliminar al activar el bloque SQL de arriba)
        ((DefaultTableModel) tablaVuelos.getModel()).addRow(new Object[]{num, orig, dest, fecha});
        JOptionPane.showMessageDialog(null, "Vuelo agregado visualmente (Simulación).");
        txtNum.setText("");
        txtOrig.setText("");
        txtDest.setText("");
        txtFecha.setText("");
    }

    /**
     * Elimina el vuelo seleccionado basándose en su número único.
     * COLOCAR EN: El botón "ELIMINAR" (Botón eliminar vuelo) de la Sección 2.
     */
    public void eliminarVueloSeleccionado(JTable tablaVuelos) {
        int filaSel = tablaVuelos.getSelectedRow();
        if (filaSel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un vuelo de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        String numVuelo = (String) tablaVuelos.getValueAt(filaSel, 0); // Columna 0: numero_vuelo
        
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el vuelo con numero de vuelo: " + numVuelo + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar != JOptionPane.YES_OPTION) return;
        
        /* =======================================================================
        // CONSULTA SQL: ELIMINAR VUELO (Descomentar al crear tu tabla)
        // =======================================================================
        String sql = "DELETE FROM vuelos_disponibles WHERE numero_vuelo = ?";
        try (Connection con = obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, numVuelo);
            if (pstmt.executeUpdate() > 0) {
                ((DefaultTableModel) tablaVuelos.getModel()).removeRow(filaSel);
                JOptionPane.showMessageDialog(null, "Vuelo eliminado correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar vuelo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        ======================================================================= */
        
        ((DefaultTableModel) tablaVuelos.getModel()).removeRow(filaSel);
    }

    // =======================================================================
    // 4. SECCIÓN 3: ADMINISTRACIÓN DE ORÍGENES Y DESTINOS (PÁGINA 4)
    // =======================================================================
    
    /**
     * Carga de forma independiente la JTable de Orígenes y la JTable de Destinos.
     * COLOCAR EN: Al abrir la Sección 3 para rellenar ambas tablas a la vez.
     */
    public void cargarTablasOrigenYDestino(JTable tablaOrigenes, JTable tablaDestinos) {
        DefaultTableModel modOrig = (DefaultTableModel) tablaOrigenes.getModel();
        DefaultTableModel modDest = (DefaultTableModel) tablaDestinos.getModel();
        
        modOrig.setRowCount(0);
        modDest.setRowCount(0);
        
        /* =======================================================================
        // CONSULTA SQL: LEER CIUDADES DE ORIGEN (Descomentar al crear tu tabla)
        // =======================================================================
        String sqlOrig = "SELECT nombre_origen FROM ciudades_origen";
        try (Connection con = obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement(sqlOrig);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                modOrig.addRow(new Object[]{ rs.getString("nombre_origen") });
            }
        } catch (SQLException e) { System.out.println("Error en orígenes: " + e.getMessage()); }
        
        // CONSULTA SQL: LEER CIUDADES DE DESTINO (Descomentar al crear tu tabla)
        // =======================================================================
        String sqlDest = "SELECT nombre_destino FROM ciudades_destino";
        try (Connection con = obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement(sqlDest);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                modDest.addRow(new Object[]{ rs.getString("nombre_destino") });
            }
        } catch (SQLException e) { System.out.println("Error en destinos: " + e.getMessage()); }
        ======================================================================= */
        
        // DATOS DE PRUEBA SIMULADOS
        modOrig.addRow(new Object[]{"Maracaibo"});
        modOrig.addRow(new Object[]{"Bogotá"});
        modDest.addRow(new Object[]{"Miami"});
        modDest.addRow(new Object[]{"París"});
    }

    /**
     * Agrega un origen a la BD y a su tabla correspondiente.
     * COLOCAR EN: El botón "AGREGAR" de la izquierda (Origen) en la Sección 3.
     */
    public void agregarNuevoOrigen(JTextField txtOrigen, JTable tablaOrigenes) {
        String origen = txtOrigen.getText().trim();
        if (origen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escriba el nombre de la ciudad de origen.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea agregar el origen: " + origen + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar != JOptionPane.YES_OPTION) return;
        /* =======================================================================
        // CONSULTA SQL: INSERTAR ORIGEN (Descomentar al crear tu tabla)
        // =======================================================================
        String sql = "INSERT INTO ciudades_origen (nombre_origen) VALUES (?)";
        try (Connection con = obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, origen);
            if (pstmt.executeUpdate() > 0) {
                ((DefaultTableModel) tablaOrigenes.getModel()).addRow(new Object[]{origen});
                txtOrigen.setText("");
            }
        } catch (SQLException e) { JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); }
        ======================================================================= */
        
        ((DefaultTableModel) tablaOrigenes.getModel()).addRow(new Object[]{origen});
        txtOrigen.setText("");
    }

    /**
     * Elimina el origen seleccionado.
     * COLOCAR EN: El botón "ELIMINAR" de la izquierda (Origen) en la Sección 3.
     */
    public void eliminarOrigenSeleccionado(JTable tablaOrigenes) {
        int filaSel = tablaOrigenes.getSelectedRow();
        String origen = (String) tablaOrigenes.getValueAt(filaSel, 0);
        if (filaSel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un origen para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el origen: " + origen + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar != JOptionPane.YES_OPTION) return;
        
        /* =======================================================================
        // CONSULTA SQL: ELIMINAR ORIGEN (Descomentar al crear tu tabla)
        // =======================================================================
        String city = (String) tablaOrigenes.getValueAt(filaSel, 0);
        String sql = "DELETE FROM ciudades_origen WHERE nombre_origen = ?";
        try (Connection con = obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, city);
            if (pstmt.executeUpdate() > 0) { ((DefaultTableModel) tablaOrigenes.getModel()).removeRow(filaSel); }
        } catch (SQLException e) { JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); }
        ======================================================================= */
        
        ((DefaultTableModel) tablaOrigenes.getModel()).removeRow(filaSel);
    }

    /**
     * Agrega un destino a la BD y a su tabla correspondiente.
     * COLOCAR EN: El botón "AGREGAR" de la derecha (Destino) en la Sección 3.
     */
    public void agregarNuevoDestino(JTextField txtDestino, JTable tablaDestinos) {
        String destino = txtDestino.getText().trim();
        if (destino.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escriba el nombre de la ciudad de destino.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea agregar el destino: " + destino + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar != JOptionPane.YES_OPTION) return;
        
        /* =======================================================================
        // CONSULTA SQL: INSERTAR DESTINO (Descomentar al crear tu tabla)
        // =======================================================================
        String sql = "INSERT INTO ciudades_destino (nombre_destino) VALUES (?)";
        try (Connection con = obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, destino);
            if (pstmt.executeUpdate() > 0) {
                ((DefaultTableModel) tablaDestinos.getModel()).addRow(new Object[]{destino});
                txtDestino.setText("");
            }
        } catch (SQLException e) { JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); }
        ======================================================================= */
        
        ((DefaultTableModel) tablaDestinos.getModel()).addRow(new Object[]{destino});
        txtDestino.setText("");
    }

    /**
     * Elimina el destino seleccionado.
     * COLOCAR EN: El botón "ELIMINAR" (Botón eliminar destino) de la derecha en la Sección 3.
     */
    public void eliminarDestinoSeleccionado(JTable tablaDestinos) {
        int filaSel = tablaDestinos.getSelectedRow();
        String destino = (String) tablaDestinos.getValueAt(filaSel, 0);
        if (filaSel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un destino para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el destino: " + destino + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar != JOptionPane.YES_OPTION) return;
        /* =======================================================================
        // CONSULTA SQL: ELIMINAR DESTINO (Descomentar al crear tu tabla)
        // =======================================================================
        String city = (String) tablaDestinos.getValueAt(filaSel, 0);
        String sql = "DELETE FROM ciudades_destino WHERE nombre_destino = ?";
        try (Connection con = obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, city);
            if (pstmt.executeUpdate() > 0) { ((DefaultTableModel) tablaDestinos.getModel()).removeRow(filaSel); }
        } catch (SQLException e) { JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); }
        ======================================================================= */
        
        ((DefaultTableModel) tablaDestinos.getModel()).removeRow(filaSel);
    }

    // =======================================================================
    // 5. FUNCIONALIDAD: BOTÓN SALIR / CERRAR SESIÓN (PÁGINA 1)
    // =======================================================================
    
    /**
     * Destruye la interfaz de administración y te redirige de vuelta al login principal.
     * COLOCAR EN: El evento del botón "BOTON SALIR" alojado en el PANEL DE LOGO superior.
     */
    public void cerrarSesionAdministrador(JPanel panelDeLaInterfazAdmin) {
        Window ventanaAdmin = SwingUtilities.getWindowAncestor(panelDeLaInterfazAdmin);
        if (ventanaAdmin != null) {
            int respuesta = JOptionPane.showConfirmDialog(ventanaAdmin, "¿Realmente desea cerrar la sesión de administrador?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                ventanaAdmin.dispose(); // Cierra e invalida la ventana del administrador
                // Abre el login original llamando a tu clase principal de login
                // new vuelos.view.MainLogin().setVisible(true);
                System.out.println("Redirección exitosa a MainLogin.");
            }
        }
    }
}