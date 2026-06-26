package vuelos.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vuelos.database.Conexion;
import vuelos.view.*;

public class BuscadorVuelos {
        
    
    
    
    // Coloca esto como variable global arriba en BuscadorVuelos.java
    public static List<VueloInfo> listaVuelosEncontrados = new ArrayList<>();
        
    public static int indiceVueloSeleccionado = 0;
    
    // Clase interna para estructurar la información de cada vuelo
    public static class VueloInfo {
        public String numeroVuelo;
        public String origen;
        public String destino;
        public String fechaSalida;
        public String precioBase;

        public VueloInfo(String numeroVuelo, String origen, String destino, String fechaSalida, String precioBase) {
            this.numeroVuelo = numeroVuelo;
            this.origen = origen;
            this.destino = destino;
            this.fechaSalida = fechaSalida;
            this.precioBase = precioBase;
        }
    }

    /**
     * Consulta los vuelos que coinciden con los criterios.
     */
   public List<VueloInfo> buscarVuelosEnBD(String origen, String destino, String fecha) {
    listaVuelosEncontrados.clear(); // Limpiamos búsquedas anteriores
    
    String sql = "SELECT numero_vuelo, id_origen, id_destino, fecha_salida, precio_base FROM vuelos WHERE id_origen = ? AND id_destino = ?";
    if (fecha != null && !fecha.trim().isEmpty()) {
        sql += " AND fecha_salida = ?";
    }
    
    try (Connection con = Conexion.conectar();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
         
        pstmt.setString(1, origen);
        pstmt.setString(2, destino);
        if (fecha != null && !fecha.trim().isEmpty()) {
            pstmt.setString(3, fecha);
        }
        
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                // Guardamos directamente en la lista global estática
                listaVuelosEncontrados.add(new VueloInfo(
                    rs.getString("numero_vuelo"),
                    rs.getString("id_origen"),   
                    rs.getString("id_destino"),  
                    rs.getString("fecha_salida"),
                    rs.getString("precio_base")   
                        
                        
                ));
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al buscar vuelos en la BD: " + e.getMessage());
    }
    
    return listaVuelosEncontrados;
}

    /**
     * MÉTODO TRASLADADO AQUÍ: Verifica si un asiento específico de un vuelo está ocupado.
     */
    public boolean estaAsientoOcupado(int fila, String columna, String numeroVuelo) {
    // 1. Armamos el asiento individual que el usuario está consultando (Ej: "B-3")
    String asientoBuscado = columna + "-" + fila;

    // 2. Consulta SQL simplificada: ya no requiere INNER JOIN porque numero_vuelo está en boletos
    String sql = "SELECT COUNT(*) FROM boletos WHERE FIND_IN_SET(?, numero_asiento) > 0 AND numero_vuelo = ?";

    try (Connection con = Conexion.conectar();
         PreparedStatement pstmt = con.prepareStatement(sql)) {

        // 3. Pasamos los parámetros
        pstmt.setString(1, asientoBuscado);
        pstmt.setString(2, numeroVuelo);

        // 4. Ejecutamos y verificamos si hay registros
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0; // Si el conteo es mayor a 0, el asiento está ocupado
            }
        }

    } catch (SQLException e) {
        System.out.println("Error al consultar asiento en la BD: " + e.getMessage());
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
            // Cambiamos a un for con índice para capturar la posición real del vuelo seleccionado
                for (int i = 0; i < vuelosEncontrados.size(); i++) {
                    final int pos = i; // Guardamos la posición fija para usarla dentro del evento
                    VueloInfo vuelo = vuelosEncontrados.get(pos);

                    String textoLabel = String.format("<html><b>Vuelo: %s</b><br> %s &rarr; %s<br>Fecha: %s<hr></html>",
                            vuelo.numeroVuelo, vuelo.origen, vuelo.destino, vuelo.fechaSalida);

                    JLabel lblVuelo = new JLabel(textoLabel);
                    lblVuelo.setOpaque(true);
                    lblVuelo.setBackground(Color.WHITE);
                    lblVuelo.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
                    lblVuelo.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    lblVuelo.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {

                            // === ¡AQUÍ ESTÁ LA MAGIA! Guardamos el índice dinámico global ===
                            BuscadorVuelos.indiceVueloSeleccionado = pos;

                            for (Component c : panelVuelosDisponibles.getComponents()) {
                                if (c instanceof JLabel) {
                                    c.setBackground(Color.WHITE);
                                }
                            }

                            lblVuelo.setBackground(Color.ORANGE);
                            System.out.println("Has seleccionado el vuelo: " + vuelo.numeroVuelo + " en la posición " + pos);

                            if (barraProgresoReal != null) {
                                barraProgresoReal.setPasoActual(3);
                            }

                            Siguiente.setVisible(true);

                            // ACCIÓN: Reemplazar el contenedor con la cabina del avión de forma segura
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    panelContenedorCabina.removeAll();

                                    // Pasamos 'BuscadorVuelos.this' y el identificador del vuelo actual
                                    MapaCabina mapa = new MapaCabina(BuscadorVuelos.this, vuelo.numeroVuelo, BtnSiguiente);

                                    panelContenedorCabina.setLayout(new BorderLayout());
                                    panelContenedorCabina.add(mapa, BorderLayout.CENTER);

                                    // Forzar re-renderizado absoluto del contenedor
                                    panelContenedorCabina.revalidate();
                                    panelContenedorCabina.repaint();
                                }
                            });
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            if (lblVuelo.getBackground() != Color.ORANGE) {
                                lblVuelo.setBackground(new Color(230, 242, 255));
                            }
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            if (lblVuelo.getBackground() != Color.ORANGE) {
                                lblVuelo.setBackground(Color.WHITE);
                            }
                        }
                    });

                    panelVuelosDisponibles.add(lblVuelo);
                }
        }

        panelVuelosDisponibles.revalidate();
        panelVuelosDisponibles.repaint();
    }
}


