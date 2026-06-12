package vuelos.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import vuelos.view.*;

// Importaciones necesarias para la base de datos (descomentar cuando se use)
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;

public class BuscadorVuelos {

    // Clase interna para estructurar la información de cada vuelo
    public static class VueloInfo {
        public String numeroVuelo;
        public String origen;
        public String destino;
        public String fechaSalida;

        public VueloInfo(String numeroVuelo, String origen, String destino, String fechaSalida) {
            this.numeroVuelo = numeroVuelo;
            this.origen = origen;
            this.destino = destino;
            this.fechaSalida = fechaSalida;
        }
    }

    /**
     * Consulta los vuelos que coinciden con los criterios.
     */
    public List<VueloInfo> buscarVuelosEnBD(String origen, String destino, String fecha) {
        List<VueloInfo> listaVuelos = new ArrayList<>();

        /* =======================================================================
        // CÓDIGO PARA CONEXIÓN A BASE DE DATOS (Descomentar para usar)
        // =======================================================================
        String url = "jdbc:mysql://localhost:3306/tu_base_datos"; 
        String usuario = "root";
        String password = "tu_password";
        String sql = "SELECT numero_vuelo, origen, destino, fecha_salida FROM vuelos WHERE origen = ? AND destino = ?";
        
        if (fecha != null && !fecha.trim().isEmpty()) {
            sql += " AND fecha_salida = ?";
        }

        try (Connection con = DriverManager.getConnection(url, usuario, password);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setString(1, origen);
            pstmt.setString(2, destino);
            if (fecha != null && !fecha.trim().isEmpty()) {
                pstmt.setString(3, fecha);
            }
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    listaVuelos.add(new VueloInfo(
                        rs.getString("numero_vuelo"),
                        rs.getString("origen"),
                        rs.getString("destino"),
                        rs.getString("fecha_salida")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar vuelos en la BD: " + e.getMessage());
        }
        return listaVuelos;
        ======================================================================= */

        // LÓGICA DE SIMULACIÓN (DATOS DE PRUEBA)
        if (origen != null && destino != null) {
            if (origen.equalsIgnoreCase("Madrid") && destino.equalsIgnoreCase("Paris")) {
                listaVuelos.add(new VueloInfo("MAD-102", "Madrid", "Paris", "15/10/2026"));
                listaVuelos.add(new VueloInfo("MAD-508", "Madrid", "Paris", "16/10/2026"));
            } else if (origen.equalsIgnoreCase("Bogota") && destino.equalsIgnoreCase("Miami")) {
                listaVuelos.add(new VueloInfo("BOG-747", "Bogota", "Miami", "20/11/2026"));
            } else {
                listaVuelos.add(new VueloInfo("VUE-001", origen, destino, "Mañana"));
                listaVuelos.add(new VueloInfo("VUE-002", origen, destino, "Próxima semana"));
            }
        }
        return listaVuelos;
    }

    /**
     * MÉTODO TRASLADADO AQUÍ: Verifica si un asiento específico de un vuelo está ocupado.
     */
    public boolean estaAsientoOcupado(int fila, String columna, String numeroVuelo) {
        /* =======================================================================
        // CÓDIGO PARA CONEXIÓN A BASE DE DATOS (Descomentar para usar)
        // =======================================================================
        String url = "jdbc:mysql://localhost:3306/tu_base_datos"; 
        String usuario = "root";
        String password = "tu_password";
        String sql = "SELECT COUNT(*) FROM asientos_reservados WHERE fila = ? AND columna = ? AND numero_vuelo = ?";
        
        try (Connection con = DriverManager.getConnection(url, usuario, password);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setInt(1, fila);
            pstmt.setString(2, columna);
            pstmt.setString(3, numeroVuelo);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar asiento en la BD: " + e.getMessage());
        }
        return false;
        ======================================================================= */

        // LÓGICA DE SIMULACIÓN ACTUAL
        if (numeroVuelo.equals("MAD-102") || numeroVuelo.equals("VUE-001") || numeroVuelo.equals("VUE-002")) {
            if ((fila == 1 && columna.equals("A"))
                    || (fila == 3 && columna.equals("C"))
                    || (fila == 5 && columna.equals("F"))) {
                return true;
            }
        } else if (numeroVuelo.equals("BOG-747")) {
            // Simulamos otros asientos ocupados para otro vuelo
            if ((fila == 2 && columna.equals("B")) || (fila == 4 && columna.equals("E"))) {
                return true;
            }
        }
        return false; 
    }

    /**
     * Renderiza las etiquetas de vuelos y maneja el evento clic para incrustar la cabina.
     */
    public void actualizarPanelVuelos(JPanel panelVuelosDisponibles, List<VueloInfo> vuelosEncontrados, JPanel panelContenedorCabina,ProgressBar barraProgresoReal,JPanel Siguiente,JButton BtnSiguiente) {
        panelVuelosDisponibles.removeAll();
        panelVuelosDisponibles.setLayout(new BoxLayout(panelVuelosDisponibles, BoxLayout.Y_AXIS));
        

        if (vuelosEncontrados.isEmpty()) {
            JLabel lblVacio = new JLabel("No se encontraron vuelos.");
            lblVacio.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panelVuelosDisponibles.add(lblVacio);
        } else {
            for (VueloInfo vuelo : vuelosEncontrados) {
                String textoLabel = String.format("<html><b>Vuelo: %s</b><br> %s → %s<br>Fecha: %s<hr></html>", 
                        vuelo.numeroVuelo, vuelo.origen, vuelo.destino, vuelo.fechaSalida);
                
                JLabel lblVuelo = new JLabel(textoLabel);
                lblVuelo.setOpaque(true);
                lblVuelo.setBackground(Color.WHITE);
                lblVuelo.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
                lblVuelo.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                lblVuelo.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if (lblVuelo.getBackground() != Color.CYAN) {
                            lblVuelo.setBackground(new Color(230, 242, 255));
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        if (lblVuelo.getBackground() != Color.CYAN) {
                            lblVuelo.setBackground(Color.WHITE);
                        }
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        for (Component c : panelVuelosDisponibles.getComponents()) {
                            if (c instanceof JLabel) {
                                c.setBackground(Color.WHITE);
                            }
                        }
                        lblVuelo.setBackground(Color.CYAN);
                        System.out.println("Has seleccionado el vuelo: " + vuelo.numeroVuelo);
                        

                                if (barraProgresoReal != null) {
                                    barraProgresoReal.setPasoActual(3);
                                }
                                
                        Siguiente.setVisible(true);

                        // ACCIÓN: Reemplazar el contenedor con la cabina del avión de forma segura
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                panelContenedorCabina.removeAll();
                                
                                // Pasamos 'BuscadorVuelos.this' (este controlador) y el identificador del vuelo actual
                                MapaCabina mapa = new MapaCabina(BuscadorVuelos.this, vuelo.numeroVuelo,BtnSiguiente); 
                                
                                panelContenedorCabina.setLayout(new BorderLayout());
                                panelContenedorCabina.add(mapa, BorderLayout.CENTER);
                                
                                // Forzar re-renderizado absoluto del contenedor
                                panelContenedorCabina.revalidate();
                                panelContenedorCabina.repaint();
                            }
                        });
                    }
                });

                panelVuelosDisponibles.add(lblVuelo);
                panelVuelosDisponibles.add(Box.createRigidArea(new Dimension(0, 5))); 
            }
        }

        panelVuelosDisponibles.revalidate();
        panelVuelosDisponibles.repaint();
    }
}


