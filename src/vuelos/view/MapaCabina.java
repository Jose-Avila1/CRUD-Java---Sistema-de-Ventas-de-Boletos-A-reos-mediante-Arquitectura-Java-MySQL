package vuelos.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vuelos.controller.BuscadorVuelos; 

public class MapaCabina extends JPanel {

    private BuscadorVuelos controladorVuelos;
    private String numeroVueloActual;
    
    // NUEVOS ATRIBUTOS: Referencia al botón real y contador de asientos elegidos
    private JButton btnSiguienteReal;
    private int asientosSeleccionadosContador = 0;

    // EL CONSTRUCTOR AHORA RECIBE TAMBIÉN EL BOTÓN SIGUIENTE DE LA INTERFAZ PRINCIPAL
    public MapaCabina(BuscadorVuelos controlador, String numeroVuelo, JButton btnSiguiente) {
        this.controladorVuelos = controlador;
        this.numeroVueloActual = numeroVuelo;
        this.btnSiguienteReal = btnSiguiente;

        // Forzamos que empiece deshabilitado hasta que el usuario marque un asiento
        if (this.btnSiguienteReal != null) {
            this.btnSiguienteReal.setEnabled(false);
        }

        // 1. Configuración del panel base contenedor
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(680, 380));

        // 2. Crear el contenedor por capas (JLayeredPane)
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(680, 380));

        // 4. CAPA SUPERIOR: Cuadrícula de asientos (GridLayout)
        JPanel panelAsientos = new JPanel(new GridLayout(7, 7, 5, 5));
        panelAsientos.setOpaque(false); // IMPORTANTE: Transparente
        panelAsientos.setBounds(160, 55, 380, 260);

        // 5. Llenar la cuadrícula (Letras y Botones)
        inicializarMatrizAsientos(panelAsientos);

        // Agregamos los asientos AL FRENTE (Capa 2) para que floten sobre el avión
        layeredPane.add(panelAsientos, Integer.valueOf(2));

        // Agregar todo al panel principal
        add(layeredPane, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. Pintamos un fondo limpio para el panel
        g2.setColor(new Color(240, 240, 240));
        g2.fillRect(0, 0, getWidth(), getHeight());

        // 2. Cargamos y dibujamos la imagen estirada al tamaño total del panel
        try {
            java.net.URL imgURL = getClass().getResource("/imagenes/avion_cabina.png");
            if (imgURL != null) {
                ImageIcon icono = new ImageIcon(imgURL);
                g2.drawImage(icono.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen del avión: " + e.getMessage());
        }
    }

    private void inicializarMatrizAsientos(JPanel panel) {
        ImageIcon originalVerde = new ImageIcon(getClass().getResource("/imagenes/asiento_avion_verde.png"));
        ImageIcon originalAzul = new ImageIcon(getClass().getResource("/imagenes/asiento_avion_azul.png"));
        ImageIcon originalRojo = new ImageIcon(getClass().getResource("/imagenes/asiento_avion_rojo.png"));

        Image imgVerdeEscalada = originalVerde.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image imgAzulEscalada = originalAzul.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        Image imgRojoEscalada = originalRojo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon ocupIcon = new ImageIcon(imgRojoEscalada);
        ImageIcon dispIcon = new ImageIcon(imgVerdeEscalada);
        ImageIcon selIcon = new ImageIcon(imgAzulEscalada);

        String[] cabecera = {"A", "B", "C", "[aislado]", "D", "E", "F"};
        int[] filasNum = {1, 2, 3, 4, 5, 6};

        // Fila 0: Letras
        for (String letra : cabecera) {
            if (letra.equals("[aislado]")) {
                panel.add(new JLabel("PASILLO")).setFont(new Font("Arial", Font.BOLD, 12));
            } else {
                JLabel lbl = new JLabel(letra, SwingConstants.CENTER);
                lbl.setFont(new Font("Arial", Font.BOLD, 12));
                panel.add(lbl);
            }
        }

        // Filas de asientos
        for (int f = 0; f < filasNum.length; f++) {
            for (int c = 0; c < 7; c++) {
                if (c == 3) {
                    JLabel lblFila = new JLabel(String.valueOf(filasNum[f]), SwingConstants.CENTER);
                    lblFila.setFont(new Font("Arial", Font.BOLD, 12));
                    panel.add(lblFila);
                } else {
                    final int numeroFila = filasNum[f];
                    final String letraColumna = cabecera[c];
                    
                    JButton botonAsiento = new JButton();
                    botonAsiento.setPreferredSize(new Dimension(60, 60));

                    botonAsiento.setContentAreaFilled(false);
                    botonAsiento.setBorderPainted(false);
                    botonAsiento.setFocusPainted(false);

                    boolean estaOcupado = controladorVuelos.estaAsientoOcupado(numeroFila, letraColumna, numeroVueloActual);

                    if (estaOcupado) {
                        botonAsiento.setIcon(ocupIcon);
                        botonAsiento.setDisabledIcon(ocupIcon); 
                        botonAsiento.setEnabled(false); 
                    } else {
                        botonAsiento.setIcon(dispIcon);

                        botonAsiento.addActionListener(new ActionListener() {
                            private boolean seleccionado = false;

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!seleccionado) {
                                    botonAsiento.setIcon(selIcon);
                                    seleccionado = true;
                                    asientosSeleccionadosContador++; // Añade asiento
                                    System.out.println("Asiento seleccionado: " + numeroFila + letraColumna + " para el vuelo " + numeroVueloActual);
                                } else {
                                    botonAsiento.setIcon(dispIcon);
                                    seleccionado = false;
                                    asientosSeleccionadosContador--; // Quita asiento
                                }
                                
                                // EVALUACIÓN DINÁMICA: Modifica el estado del botón Siguiente en tiempo real
                                if (btnSiguienteReal != null) {
                                    btnSiguienteReal.setEnabled(asientosSeleccionadosContador > 0);
                                }
                            }
                        });
                    }
                    panel.add(botonAsiento);
                }
            }
        }
    }
}


