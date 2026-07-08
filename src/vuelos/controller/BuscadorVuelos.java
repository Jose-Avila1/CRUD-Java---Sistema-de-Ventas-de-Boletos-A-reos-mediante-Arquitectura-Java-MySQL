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
     * MÉTODO TRASLADADO AQUÍ: Verifica si un asiento específico de un vuelo
     * está ocupado.
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
     * Renderiza las etiquetas de vuelos y maneja el evento clic para incrustar
     * la cabina.
     */
    public void actualizarPanelVuelos(JPanel panelAnclaVuelos, List<VueloInfo> vuelosEncontrados, JPanel panelContenedorCabina, ProgressBar barraProgresoReal, JPanel Siguiente, JButton BtnSiguiente) {

        // 1. Limpieza total y segura del panel izquierdo de NetBeans
        panelAnclaVuelos.removeAll();
        panelAnclaVuelos.setLayout(new java.awt.BorderLayout());

        if (vuelosEncontrados.isEmpty()) {
            JLabel lblVacio = new JLabel("No se encontraron vuelos.");
            lblVacio.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panelAnclaVuelos.add(lblVacio, java.awt.BorderLayout.CENTER);
        } else {
            // 2. Creamos el panel interno auxiliar donde se van a apilar tus JLabels naranjas
            JPanel panelListaVuelos = new JPanel();
            panelListaVuelos.setLayout(new BoxLayout(panelListaVuelos, BoxLayout.Y_AXIS));
            panelListaVuelos.setBackground(panelAnclaVuelos.getBackground());

            // Ciclo para rellenar los vuelos con el índice 'pos'
            for (int i = 0; i < vuelosEncontrados.size(); i++) {
                final int pos = i;
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
                        BuscadorVuelos.indiceVueloSeleccionado = pos;

                        // Limpiamos los colores de fondo de las demás etiquetas
                        for (Component c : panelListaVuelos.getComponents()) {
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

                        //Hacer una ventana para saber el precio de boletos en el vuelo seleccionado
                        String nmrVuelo = vuelo.numeroVuelo;
                        String sql = "SELECT precio_base from vuelos where numero_vuelo = ?";
                        float precio_vuelo = 0;

                        try (Connection con = Conexion.conectar();
                                PreparedStatement pstmt = con.prepareStatement(sql)) {

                            pstmt.setString(1, nmrVuelo);

                            try (ResultSet rs = pstmt.executeQuery()) {
                                if (rs.next()) { // Usamos 'if' en lugar de 'while' porque sabemos que es un solo resultado
                                    precio_vuelo = rs.getFloat(1);

                                }
                            }
                        } catch (SQLException er) {
                            System.out.println("Error al encontrar el precio: " + er.getMessage());
                        }
                        
                        System.out.println(precio_vuelo);
                        
                        
                        JOptionPane.showMessageDialog(
                            null, 
                            "<html><div style='text-align: center; font-family: Arial; font-size: 12px;'>"
                            + "El precio base por cada asiento seleccionado para el vuelo <b>" + nmrVuelo + "</b> es de:<br><br>"
                            + "<span style='font-size: 16px; color: #4CAF50; font-weight: bold;'>$" + String.format("%.2f", precio_vuelo) + " USD</span>"
                            + "</div></html>", 
                            "Información de Tarifa", 
                            JOptionPane.INFORMATION_MESSAGE
                        );

                        // Reemplazar el contenedor central con el avión y blindar el panel izquierdo
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                // 1. Limpiamos y cargamos el mapa del avión en la derecha
                                panelContenedorCabina.removeAll();
                                MapaCabina mapa = new MapaCabina(BuscadorVuelos.this, vuelo.numeroVuelo, BtnSiguiente);
                                panelContenedorCabina.setLayout(new BorderLayout());
                                panelContenedorCabina.add(mapa, BorderLayout.CENTER);

                                // 2. Refrescamos el contenedor del avión
                                panelContenedorCabina.revalidate();
                                panelContenedorCabina.repaint();

                                // =======================================================================
                                // 3. EL TRUCO CLAVE: Forzamos el re-renderizado del panel izquierdo
                                // justo después del avión para evitar que NetBeans lo colapse a cero
                                // =======================================================================
                                panelAnclaVuelos.revalidate();
                                panelAnclaVuelos.repaint();

                                // 4. Refrescamos la ventana completa de NetBeans para sincronizar layouts
                                java.awt.Window ventanaPadre = SwingUtilities.getWindowAncestor(panelAnclaVuelos);
                                if (ventanaPadre != null) {
                                    ventanaPadre.validate();
                                    ventanaPadre.repaint();
                                }
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

                panelListaVuelos.add(lblVuelo);
                panelListaVuelos.add(Box.createRigidArea(new Dimension(0, 5)));
            }

            // =======================================================================
            // 3. INYECCIÓN DEL SCROLL CON CAPA DE MEDIDAS MANUALES DE SEGURIDAD
            // =======================================================================
            JScrollPane scrollPane = new JScrollPane(panelListaVuelos);

            // Forzamos a que el scroll horizontal nunca salga y el vertical aparezca automáticamente
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            // Medida de seguridad: Si NetBeans reporta 0, usamos los 230x410 píxeles reales del diseño
            int anchoReal = panelAnclaVuelos.getWidth() > 0 ? panelAnclaVuelos.getWidth() : 230;
            int altoReal = panelAnclaVuelos.getHeight() > 0 ? panelAnclaVuelos.getHeight() : 410;
            java.awt.Dimension dimensionesScroll = new java.awt.Dimension(anchoReal, altoReal);

            scrollPane.setPreferredSize(dimensionesScroll);
            scrollPane.setSize(dimensionesScroll);
            scrollPane.setBorder(null);
            scrollPane.getVerticalScrollBar().setUnitIncrement(14); // Deslizamiento rápido

            // Agregamos el scroll al panel ancla izquierdo usando BorderLayout
            panelAnclaVuelos.add(scrollPane, java.awt.BorderLayout.CENTER);
        }

        // 4. Refresco estructural definitivo en caliente de la pantalla
        panelAnclaVuelos.revalidate();
        panelAnclaVuelos.repaint();
    }
}
