package vuelos.controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vuelos.database.Conexion;

public class AdminController {
   
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
    modelo.setRowCount(0);
    
    // Consulta corregida con la coma necesaria después de b.id_boleto
    String sql = "SELECT b.id_boleto, b.id_usu, u.nombre, v.numero_vuelo, b.numero_asiento " +
                 "FROM boletos b " +
                 "INNER JOIN usuarios u ON b.id_usu = u.id_usu " +
                 "INNER JOIN vuelos v ON b.numero_vuelo = v.numero_vuelo";
    
    try (Connection con = Conexion.conectar();
         PreparedStatement pstmt = con.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
        
        while (rs.next()) {
            // Estructura exacta para las celdas de tu tabla:
            // Asegúrate de extraer "id_boleto" como getInt() si en tu BD es una llave primaria numérica (AUTO_INCREMENT)
            modelo.addRow(new Object[]{
                rs.getInt("id_boleto"),      // 1. ID Boleto
                rs.getInt("id_usu"),         // 2. ID Usuario
                rs.getString("nombre"),      // 3. Nombre de usuario
                rs.getString("numero_vuelo"), // 4. Número de vuelo
                rs.getString("numero_asiento") // 5. Número de asiento
            });
        }
        
    } catch (SQLException e) {
        System.out.println("Error al cargar la tabla de boletos: " + e.getMessage());
    }
}

    /**
     * Elimina el boleto seleccionado utilizando el identificador de la primera columna.
     * COLOCAR EN: El evento del botón "ELIMINAR" de la Sección 1.
     */
  public void eliminarBoletoSeleccionado(JTable tablaBoletos) {
    int filaSel = tablaBoletos.getSelectedRow();
    
    // 1. Validamos si hay una fila seleccionada
    if (filaSel == -1) {
        JOptionPane.showMessageDialog(null, "Por favor, seleccione un boleto de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // 2. Extraemos el ID del boleto (columna 0)
    int idBoleto = (int) tablaBoletos.getValueAt(filaSel, 0);
    
    // 3. Cuadro de confirmación
    int confirmar = JOptionPane.showConfirmDialog(
        null,
        "¿Está seguro de eliminar este boleto (ID: " + idBoleto + ")?",
        "Confirmar",
        JOptionPane.YES_NO_OPTION
    );
    
    if (confirmar != JOptionPane.YES_OPTION) return;
    
    // 4. Consulta SQL enfocada únicamente en la llave primaria de la tabla boletos
    String sql = "DELETE FROM boletos WHERE id_boleto = ?";
    
    // 5. Conexión y ejecución
    try (Connection con = Conexion.conectar();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
         
        pstmt.setInt(1, idBoleto);
        
        if (pstmt.executeUpdate() > 0) {
            // Remueve la fila de la pantalla de NetBeans
            ((DefaultTableModel) tablaBoletos.getModel()).removeRow(filaSel);
            JOptionPane.showMessageDialog(null, "Boleto eliminado de la base de datos.");
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar boleto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    // =======================================================================
    // 3. SECCIÓN 2: ADMINISTRACIÓN DE VUELOS (PÁGINA 3)
    // =======================================================================
    /**
     * Carga los vuelos disponibles en la JTable de la Sección 2.
     */
   public void cargarTablaVuelos (JTable tablaVuelos) {
    DefaultTableModel modelo = (DefaultTableModel) tablaVuelos.getModel();
    modelo.setRowCount(0);

    String sql = "SELECT numero_vuelo, id_origen, id_destino, fecha_salida, precio_base FROM vuelos ";

    // CAMBIO AQUÍ: Llamamos directamente a tu clase y método estático
    try (Connection con = Conexion.conectar();
         PreparedStatement pstmt = con.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getString("numero_vuelo"),
                rs.getString("id_origen"),   // CORREGIDO: Debe coincidir con el SELECT
                rs.getString("id_destino"),  // CORREGIDO: Debe coincidir con el SELECT
                rs.getString("fecha_salida"),
                rs.getString("precio_base")    
            });
        }
    } catch (SQLException e) {
        System.out.println("Error al cargar vuelos: " + e.getMessage());
    }
}

    /**
     * Inserta un nuevo vuelo leyendo los 4 cuadros de texto de tu diseño.
     * COLOCAR EN: El botón "AGREGAR" (Agregar Vuelo) de la Sección 2.
     */
    

     public void agregarNuevoVuelo(JTextField txtNum, JTextField txtOrig, JTextField txtDest, JTextField txtFecha, JTextField txtPrecio, JTable tablaVuelos) {
    String num = txtNum.getText().trim();
    String orig = txtOrig.getText().trim();
    String dest = txtDest.getText().trim();
    String fecha = txtFecha.getText().trim();
    String precio = txtPrecio.getText().trim();

    if (num.isEmpty() || orig.isEmpty() || dest.isEmpty() || fecha.isEmpty() || precio.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Complete todos los campos del vuelo.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // CORREGIDO: Añadido 'precio' a las columnas y su respectivo '?' en VALUES (ahora son 5)
    String sql = "INSERT INTO vuelos (numero_vuelo, id_origen, id_destino, fecha_salida, precio_base) VALUES (?, ?, ?, ?, ?)";
    
    // CAMBIO AQUÍ: Usamos tu clase Conexion
    try (Connection con = Conexion.conectar();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
        
        pstmt.setString(1, num);
        pstmt.setString(2, orig);
        pstmt.setString(3, dest);
        pstmt.setString(4, fecha);
        pstmt.setString(5, precio); // CORREGIDO: Ahora enviamos el precio a la base de datos

        if (pstmt.executeLargeUpdate() > 0) {
            // Añadido 'precio' también al modelo visual de la tabla
            ((DefaultTableModel) tablaVuelos.getModel()).addRow(new Object[]{num, orig, dest, fecha, precio});
            JOptionPane.showMessageDialog(null, "Vuelo registrado exitosamente.");
            
            // Limpieza automática de tus cuadros de texto
            txtNum.setText("");
            txtOrig.setText("");
            txtDest.setText("");
            txtFecha.setText("");
            txtPrecio.setText("");
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al insertar vuelo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
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

    int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el vuelo con numero de vuelo: " + numVuelo + "?", "Confirmar", JOptionPane.YES_OPTION);
    if (confirmar != JOptionPane.YES_OPTION) return;

    String sql = "DELETE FROM vuelos WHERE numero_vuelo = ?";
    
    // CAMBIO AQUÍ: Usamos tu clase Conexion
    try (Connection con = Conexion.conectar();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
        
        pstmt.setString(1, numVuelo);
        
        if (pstmt.executeUpdate() > 0) {
            ((DefaultTableModel) tablaVuelos.getModel()).removeRow(filaSel);
            JOptionPane.showMessageDialog(null, "Vuelo eliminado correctamente.");
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar vuelo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    // NOTA: Se eliminó la línea duplicada de removeRow que estaba aquí abajo
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

    // 1. CONSULTA SQL: LEER CIUDADES DE ORIGEN
    String sqlOrig = "SELECT ciudad FROM aeropuertos";
    // CAMBIO AQUÍ: Usamos tu clase Conexion
    try (Connection con = Conexion.conectar();
         PreparedStatement pstmt = con.prepareStatement(sqlOrig);
         ResultSet rs = pstmt.executeQuery()) {
        
        while (rs.next()) {
            modOrig.addRow(new Object[]{ rs.getString("ciudad") });
        }
    } catch (SQLException e) { 
        System.out.println("Error en orígenes: " + e.getMessage()); 
    }

    // 2. CONSULTA SQL: LEER CIUDADES DE DESTINO
    String sqlDest = "SELECT ciudad FROM aeropuertos";
    // CAMBIO AQUÍ: Usamos tu clase Conexion
    try (Connection con = Conexion.conectar();
         PreparedStatement pstmt = con.prepareStatement(sqlDest);
         ResultSet rs = pstmt.executeQuery()) {
        
        while (rs.next()) {
            modDest.addRow(new Object[]{ rs.getString("ciudad") });
        }
    } catch (SQLException e) { 
        System.out.println("Error en destinos: " + e.getMessage()); 
    }
    
    // NOTA: Se eliminaron los datos de prueba manuales (Maracaibo, Bogotá, etc.) 
    // para que no se dupliquen con los de la base de datos.
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

    // 1. Cuadro de confirmación corregido con YES_NO_OPTION
    int confirmar = JOptionPane.showConfirmDialog(
        null, 
        "¿Está seguro que desea agregar el origen: " + origen + "?", 
        "Confirmar", 
        JOptionPane.YES_NO_OPTION
    );
    if (confirmar != JOptionPane.YES_OPTION) return;

    // 2. Consulta SQL Corregida (se añadió el paréntesis que faltaba antes de 'ciudad')
    String sql = "INSERT INTO aeropuertos (ciudad) VALUES (?)";
    
    // 3. Conexión usando tu clase Conexion
    try (Connection con = Conexion.conectar();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
        
        pstmt.setString(1, origen);
        
        if (pstmt.executeUpdate() > 0) {
            // Inserta visualmente en la tabla solo si se guardó con éxito en MySQL
            ((DefaultTableModel) tablaOrigenes.getModel()).addRow(new Object[]{origen});
            txtOrigen.setText("");
            JOptionPane.showMessageDialog(null, "Origen agregado exitosamente.");
        }
        
    } catch (SQLException e) { 
        JOptionPane.showMessageDialog(null, "Error al insertar origen: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
  }
    
    // NOTA: Se eliminaron las líneas duplicadas de addRow y setText que estaban aquí abajo.
}

    /**
     * Elimina el origen seleccionado.
     * COLOCAR EN: El botón "ELIMINAR" de la izquierda (Origen) en la Sección 3.
     */
        public void eliminarOrigenSeleccionado(JTable tablaOrigenes) {
        int filaSel = tablaOrigenes.getSelectedRow();
    
         // 1. Validamos primero si hay una fila seleccionada antes de pedir datos
        if (filaSel == -1) {
        JOptionPane.showMessageDialog(null, "Seleccione un origen para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
         }

         // 2. Extraemos la ciudad de la fila seleccionada de forma segura
         String origen = (String) tablaOrigenes.getValueAt(filaSel, 0);

         // 3. Cuadro de confirmación corregido con YES_NO_OPTION
        int confirmar = JOptionPane.showConfirmDialog(
        null, 
        "¿Está seguro que desea eliminar el origen: " + origen + "?", 
        "Confirmar", 
        JOptionPane.YES_NO_OPTION
        );
    
        // Si el usuario no presiona "SÍ", detenemos la ejecución
        if (confirmar != JOptionPane.YES_OPTION) return;

        // 4. Consulta SQL para eliminar de la base de datos
        String sql = "DELETE FROM aeropuertos WHERE ciudad = ?";
    
        // 5. Conexión y ejecución mediante tu clase Conexion
         try (Connection con = Conexion.conectar();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
        
        pstmt.setString(1, origen);
        
        if (pstmt.executeUpdate() > 0) {
            // Remueve la fila de la tabla visual solo si se borró con éxito en MySQL
            ((DefaultTableModel) tablaOrigenes.getModel()).removeRow(filaSel);
            JOptionPane.showMessageDialog(null, "Origen eliminado correctamente.");
        }
        
     } catch (SQLException e) { 
        JOptionPane.showMessageDialog(null, "Error al eliminar en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
    }
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

    // 1. Cuadro de confirmación corregido con YES_NO_OPTION
    int confirmar = JOptionPane.showConfirmDialog(
        null, 
        "¿Está seguro que desea agregar el destino: " + destino + "?", 
        "Confirmar", 
        JOptionPane.YES_NO_OPTION
    );
    if (confirmar != JOptionPane.YES_OPTION) return;

    // 2. Consulta SQL Corregida (añadido el paréntesis antes de 'ciudad')
    String sql = "INSERT INTO aeropuertos (ciudad) VALUES (?)";
    
    // 3. Conexión usando tu clase Conexion
    try (Connection con = Conexion.conectar();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
        
        pstmt.setString(1, destino);
        
        if (pstmt.executeUpdate() > 0) {
            // Inserta visualmente en la tabla de destinos solo si se guardó en MySQL
            ((DefaultTableModel) tablaDestinos.getModel()).addRow(new Object[]{destino});
            txtDestino.setText("");
            JOptionPane.showMessageDialog(null, "Destino agregado exitosamente.");
        }
        
    } catch (SQLException e) { 
        JOptionPane.showMessageDialog(null, "Error al insertar destino: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
    }
    
    // NOTA: Se eliminaron las líneas duplicadas de addRow y setText que estaban sueltas al final.
}

    /**
     * Elimina el destino seleccionado.
     * COLOCAR EN: El botón "ELIMINAR" (Botón eliminar destino) de la derecha en la Sección 3.
     */
    public void eliminarDestinoSeleccionado(JTable tablaDestinos) {
    int filaSel = tablaDestinos.getSelectedRow();
    
    // 1. Validamos primero si hay una fila seleccionada antes de pedir datos
    if (filaSel == -1) {
        JOptionPane.showMessageDialog(null, "Seleccione un destino para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 2. Extraemos el destino de forma segura una vez confirmada la selección
    String destino = (String) tablaDestinos.getValueAt(filaSel, 0);

    // 3. Cuadro de confirmación corregido con YES_NO_OPTION
    int confirmar = JOptionPane.showConfirmDialog(
        null, 
        "¿Está seguro que desea eliminar el destino: " + destino + "?", 
        "Confirmar", 
        JOptionPane.YES_NO_OPTION
    );
    if (confirmar != JOptionPane.YES_OPTION) return;

    // 4. Consulta SQL para eliminar de la base de datos
    String sql = "DELETE FROM aeropuertos WHERE ciudad = ?";
    
    // 5. Conexión usando tu clase Conexion
    try (Connection con = Conexion.conectar();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
        
        pstmt.setString(1, destino);
        
        if (pstmt.executeUpdate() > 0) {
            // Remueve la fila de la interfaz solo si se borró con éxito en la BD
            ((DefaultTableModel) tablaDestinos.getModel()).removeRow(filaSel);
            JOptionPane.showMessageDialog(null, "Destino eliminado correctamente.");
        }
        
    } catch (SQLException e) { 
        JOptionPane.showMessageDialog(null, "Error al eliminar en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
    }
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