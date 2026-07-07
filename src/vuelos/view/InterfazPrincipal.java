package vuelos.view;
//import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vuelos.controller.ProgressBar;
import vuelos.controller.Fecha;
import java.util.Date;
import vuelos.controller.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import vuelos.model.Usuario;

/**
 *
 * @author Todos
 */
public class InterfazPrincipal extends javax.swing.JFrame {

    private ControladorRutas controladorRutas;
    private ProgressBar barra;

    public InterfazPrincipal() {
        initComponents();

        Fecha hola = new Fecha();
        hola.obtenerFecha();
        jLabelFecha.setText(hola.FechaFormateada);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("hh:mm:ss");
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String horaActual = LocalDateTime.now().format(formato);
                jLabelHora.setText(horaActual);
            }
        });
        timer.start();

        // Cambiamos su tipografía y color de letras para que combine con el estilo nuevo
        jButtonSiguiente.setForeground(Color.WHITE);
        jButtonSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));
        barra = new ProgressBar();
        jPanelProgreso.setLayout(new java.awt.BorderLayout());
        jPanelProgreso.add(barra, java.awt.BorderLayout.CENTER);
        jPanelProgreso.validate();
        jPanelProgreso.repaint();

        panelAnclaVuelos.setVisible(false);
        jPanelSeleccionDeVuelos.setVisible(true);

        jPanelSiguiente.setVisible(false);
        controladorRutas = new ControladorRutas(jComboBoxOrigen, jComboBoxDestino);
        Date fechaActual = new Date();
        jDateChooserIda.setMinSelectableDate(fechaActual);
        String nombre = Usuario.nombreUsu;
        bienvenida.setText(nombre + "!");

// =======================================================================
// BLINDAJE DE COORDENADAS: CONGELAR TAMAÑO DEL CONTENEDOR DE VUELOS
// =======================================================================
// Si NetBeans colapsa el panel izquierdo a cero, le inyectamos a la fuerza
// el tamaño real que tiene en tu pantalla (230 píxeles de ancho por 410 de alto).
        if (panelAnclaVuelos != null) {
            java.awt.Dimension tamanoFijoVuelos = new java.awt.Dimension(180, 410);

            // Forzamos las tres dimensiones de Swing para que el Layout no pueda aplastarlo
            panelAnclaVuelos.setPreferredSize(tamanoFijoVuelos);
            panelAnclaVuelos.setMinimumSize(tamanoFijoVuelos);
            panelAnclaVuelos.setMaximumSize(tamanoFijoVuelos);
            panelAnclaVuelos.setSize(tamanoFijoVuelos);
        }
    }

    public void restaurarTodoAlEstadoInicial() {
        // 1. Cerramos la ventana actual que está alterada y sin los componentes en su sitio
        this.dispose();

        // 2. Creamos una ventana completamente nueva desde cero 
        // Esto llamará a initComponents() y cargará el diseño limpio de NetBeans
        InterfazPrincipal nuevaInterfaz = new InterfazPrincipal();

        // 3. La hacemos visible en el centro de la pantalla
        nuevaInterfaz.setVisible(true);
    }

    // Contenedor del menú lateral
    private javax.swing.JPanel contenedorTickets;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        PanelLogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelProgreso = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        PanelOrigenDestino = new javax.swing.JPanel();
        jPanelSeleccionDeDatos = new javax.swing.JPanel();
        jComboBoxOrigen = new javax.swing.JComboBox<>();
        jComboBoxDestino = new javax.swing.JComboBox<>();
        jLabelDestino = new javax.swing.JLabel();
        btnBuscar = new vuelos.controller.BotonEstilizado();
        jLabelFechaAbor = new javax.swing.JLabel();
        jLabelOrigen = new javax.swing.JLabel();
        jDateChooserIda = new com.toedter.calendar.JDateChooser();
        jPanelInformacion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        bienvenida = new javax.swing.JLabel();
        jPanelSeleccionDeVuelos = new javax.swing.JPanel();
        jPanelSiguiente = new javax.swing.JPanel();
        jLabelLeyendaAD = new javax.swing.JLabel();
        jPanellLeyendaAD = new javax.swing.JPanel();
        jLabelLeyendaAS = new javax.swing.JLabel();
        jPanellLeyendaAND = new javax.swing.JPanel();
        jPanellLeyendaAS = new javax.swing.JPanel();
        jLabelLeyendaAND = new javax.swing.JLabel();
        jButtonSiguiente = new vuelos.controller.BotonEstilizado("Siguiente")
        ;
        panelAnclaVuelos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoAvion.png")).getImage());
        setMinimumSize(new java.awt.Dimension(500, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));

        PanelLogo.setBackground(new java.awt.Color(11, 29, 58));
        PanelLogo.setPreferredSize(new java.awt.Dimension(150, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/avionProyecto.PNG"))); // NOI18N

        jPanelProgreso.setMinimumSize(new java.awt.Dimension(409, 45));

        javax.swing.GroupLayout jPanelProgresoLayout = new javax.swing.GroupLayout(jPanelProgreso);
        jPanelProgreso.setLayout(jPanelProgresoLayout);
        jPanelProgresoLayout.setHorizontalGroup(
            jPanelProgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );
        jPanelProgresoLayout.setVerticalGroup(
            jPanelProgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenLogout.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLogoLayout = new javax.swing.GroupLayout(PanelLogo);
        PanelLogo.setLayout(PanelLogoLayout);
        PanelLogoLayout.setHorizontalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(122, 122, 122)
                .addComponent(jPanelProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        PanelLogoLayout.setVerticalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogoLayout.createSequentialGroup()
                .addGroup(PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(PanelLogoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanelProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLogoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelOrigenDestino.setBackground(new java.awt.Color(255, 255, 255));

        jPanelSeleccionDeDatos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSeleccionDeDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detalle de salida"));

        jComboBoxOrigen.setEditable(true);

        jComboBoxDestino.setEditable(true);

        jLabelDestino.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabelDestino.setText("Destino:");

        btnBuscar.setBackground(new java.awt.Color(11, 29, 58));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabelFechaAbor.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabelFechaAbor.setText("Fecha de abordaje (Opcional)");

        jLabelOrigen.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabelOrigen.setText("Origen:");

        javax.swing.GroupLayout jPanelSeleccionDeDatosLayout = new javax.swing.GroupLayout(jPanelSeleccionDeDatos);
        jPanelSeleccionDeDatos.setLayout(jPanelSeleccionDeDatosLayout);
        jPanelSeleccionDeDatosLayout.setHorizontalGroup(
            jPanelSeleccionDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeleccionDeDatosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelSeleccionDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOrigen))
                .addGap(30, 30, 30)
                .addGroup(jPanelSeleccionDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDestino)
                    .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanelSeleccionDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFechaAbor)
                    .addGroup(jPanelSeleccionDeDatosLayout.createSequentialGroup()
                        .addComponent(jDateChooserIda, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSeleccionDeDatosLayout.setVerticalGroup(
            jPanelSeleccionDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeleccionDeDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSeleccionDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelSeleccionDeDatosLayout.createSequentialGroup()
                        .addComponent(jLabelFechaAbor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelSeleccionDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserIda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelSeleccionDeDatosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelSeleccionDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDestino)
                            .addComponent(jLabelOrigen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelSeleccionDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanelInformacion.setBackground(new java.awt.Color(255, 255, 255));
        jPanelInformacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Información"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Hora:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Fecha:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Bienvenido/a");

        jLabelHora.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabelHora.setText("00:00 PM");

        jLabelFecha.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabelFecha.setText("00 / 00 / 0000");

        bienvenida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bienvenida.setText("nombre");

        javax.swing.GroupLayout jPanelInformacionLayout = new javax.swing.GroupLayout(jPanelInformacion);
        jPanelInformacion.setLayout(jPanelInformacionLayout);
        jPanelInformacionLayout.setHorizontalGroup(
            jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInformacionLayout.createSequentialGroup()
                        .addGroup(jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHora)
                            .addComponent(jLabelFecha)))
                    .addGroup(jPanelInformacionLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanelInformacionLayout.setVerticalGroup(
            jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformacionLayout.createSequentialGroup()
                .addGroup(jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(bienvenida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHora, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelFecha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelSeleccionDeVuelos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSeleccionDeVuelos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSeleccionDeVuelos.setToolTipText("");
        jPanelSeleccionDeVuelos.setMaximumSize(new java.awt.Dimension(693, 415));
        jPanelSeleccionDeVuelos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSiguiente.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSiguiente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelLeyendaAD.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelLeyendaAD.setText("Asientos Disponibles:");

        jPanellLeyendaAD.setBackground(new java.awt.Color(110, 169, 74));

        javax.swing.GroupLayout jPanellLeyendaADLayout = new javax.swing.GroupLayout(jPanellLeyendaAD);
        jPanellLeyendaAD.setLayout(jPanellLeyendaADLayout);
        jPanellLeyendaADLayout.setHorizontalGroup(
            jPanellLeyendaADLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanellLeyendaADLayout.setVerticalGroup(
            jPanellLeyendaADLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabelLeyendaAS.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelLeyendaAS.setText("Asientos Selecionado:");

        jPanellLeyendaAND.setBackground(new java.awt.Color(210, 48, 54));

        javax.swing.GroupLayout jPanellLeyendaANDLayout = new javax.swing.GroupLayout(jPanellLeyendaAND);
        jPanellLeyendaAND.setLayout(jPanellLeyendaANDLayout);
        jPanellLeyendaANDLayout.setHorizontalGroup(
            jPanellLeyendaANDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanellLeyendaANDLayout.setVerticalGroup(
            jPanellLeyendaANDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanellLeyendaAS.setBackground(new java.awt.Color(18, 92, 173));

        javax.swing.GroupLayout jPanellLeyendaASLayout = new javax.swing.GroupLayout(jPanellLeyendaAS);
        jPanellLeyendaAS.setLayout(jPanellLeyendaASLayout);
        jPanellLeyendaASLayout.setHorizontalGroup(
            jPanellLeyendaASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanellLeyendaASLayout.setVerticalGroup(
            jPanellLeyendaASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabelLeyendaAND.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelLeyendaAND.setText("Asientos No Disponibles:");

        jButtonSiguiente.setBackground(new java.awt.Color(51, 51, 255));
        jButtonSiguiente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSiguiente.setText("Siguiente");
        jButtonSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSiguienteLayout = new javax.swing.GroupLayout(jPanelSiguiente);
        jPanelSiguiente.setLayout(jPanelSiguienteLayout);
        jPanelSiguienteLayout.setHorizontalGroup(
            jPanelSiguienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSiguienteLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabelLeyendaAD, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanellLeyendaAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelLeyendaAS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanellLeyendaAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelLeyendaAND)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanellLeyendaAND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButtonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelSiguienteLayout.setVerticalGroup(
            jPanelSiguienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSiguienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSiguienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelSiguienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelLeyendaAND, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(jPanellLeyendaAND, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanellLeyendaAD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelLeyendaAS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanellLeyendaAS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelLeyendaAD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelAnclaVuelos.setBackground(new java.awt.Color(255, 255, 255));
        panelAnclaVuelos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Vuelos disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        javax.swing.GroupLayout panelAnclaVuelosLayout = new javax.swing.GroupLayout(panelAnclaVuelos);
        panelAnclaVuelos.setLayout(panelAnclaVuelosLayout);
        panelAnclaVuelosLayout.setHorizontalGroup(
            panelAnclaVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 151, Short.MAX_VALUE)
        );
        panelAnclaVuelosLayout.setVerticalGroup(
            panelAnclaVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelOrigenDestinoLayout = new javax.swing.GroupLayout(PanelOrigenDestino);
        PanelOrigenDestino.setLayout(PanelOrigenDestinoLayout);
        PanelOrigenDestinoLayout.setHorizontalGroup(
            PanelOrigenDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOrigenDestinoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PanelOrigenDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelOrigenDestinoLayout.createSequentialGroup()
                        .addComponent(jPanelSeleccionDeDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelOrigenDestinoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(panelAnclaVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PanelOrigenDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelOrigenDestinoLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jPanelSeleccionDeVuelos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelOrigenDestinoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        PanelOrigenDestinoLayout.setVerticalGroup(
            PanelOrigenDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOrigenDestinoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelOrigenDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSeleccionDeDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelOrigenDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelOrigenDestinoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelAnclaVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelOrigenDestinoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanelSeleccionDeVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
                        .addComponent(jPanelSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelOrigenDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(PanelOrigenDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Realmente desea cerrar la sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            this.dispose();
            new vuelos.view.MainLogin().setVisible(true);
            System.out.println("Redirección exitosa a MainLogin.");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        
        //eliminar el mapa de la cabina actual
        eliminarMapaCabinaDeCualquierContenedor(this.getContentPane());

        // 2. Apagamos el panel y el botón inferior
        if (this.jPanelSiguiente != null) {
            this.jPanelSiguiente.setVisible(false);
        }

        // 3. Refresco gráfico profundo
        this.revalidate();
        this.repaint();

        //Inicializar metodo para busqueda de vuelos
        BuscadorVuelos buscador = new BuscadorVuelos();

        // Validar primero las rutas
        boolean rutasOk = ValidarCampos.validar(controladorRutas, jComboBoxOrigen, jComboBoxDestino);

        if (rutasOk) {
            //javax.swing.JOptionPane.showMessageDialog(this, "¡Ruta, Fechas y Pasajeros procesados con éxito!");
            mostrarResumenConsola();

            //cargamos paneles
            panelAnclaVuelos.setVisible(true);

            //llamamos el objeto de buscador de Vuelos
            String origenSeleccionado = jComboBoxOrigen.getSelectedItem().toString();
            String destinoSeleccionado = jComboBoxDestino.getSelectedItem().toString();
            String fechaSeleccionada = "";

            // Reemplaza "jDateChooser" por el nombre real de tu variable de calendario
            if (jDateChooserIda.getDate() != null) {
                // Solo si el usuario eligió una fecha, la formateamos
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // O el formato que uses
                fechaSeleccionada = sdf.format(jDateChooserIda.getDate());
            } else {
                // Si no seleccionó fecha, queda vacía o puedes asignarle null si tu BD lo prefiere
                fechaSeleccionada = null;
            }

            // 2. Ejecutamos la consulta (por ahora simulará con los datos de prueba)
            List<BuscadorVuelos.VueloInfo> resultados = buscador.buscarVuelosEnBD(origenSeleccionado, destinoSeleccionado, fechaSeleccionada);

            // 3. Enviamos los resultados y el contenedor izquierdo para que se actualice solo
            // 'panelVuelosDisponibles' hace referencia al JPanel que está dentro del recuadro "Vuelos Disponibles"
            buscador.actualizarPanelVuelos(panelAnclaVuelos, resultados, jPanelSeleccionDeVuelos, barra, jPanelSiguiente, jButtonSiguiente);

            barra.setPasoActual(2);
        } else {
            System.out.println("No se pudo procesar: Datos de las ciudades incorrectos.");
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void eliminarMapaCabinaDeCualquierContenedor(java.awt.Container contenedor) {
        if (contenedor == null) {
            return;
        }

        // Caminamos componente por componente dentro del panel recibido
        for (java.awt.Component comp : contenedor.getComponents()) {

            // ¡LO ENCONTRAMOS! No importa en qué sub-panel de NetBeans estaba escondido
            if (comp instanceof vuelos.view.MapaCabina) {
                comp.setVisible(false); // Lo apagamos por completo
                contenedor.remove(comp); // Lo expulsamos de ese contenedor específico
                System.out.println("¡Clase MapaCabina localizada y destruida con éxito!");
            } // Si el componente actual es un panel que contiene más cosas adentro (un sub-panel)
            else if (comp instanceof java.awt.Container) {
                // Nos metemos de forma recursiva a buscar ahí adentro
                eliminarMapaCabinaDeCualquierContenedor((java.awt.Container) comp);
            }
        }
    }


    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed

        // 1. Mostrar ventana de confirmación (JOptionPane)
        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Desea continuar realmente con la reserva o prefiere elegir más asientos?, LUEGO NO PODRAS REGRESAR",
                "Confirmar Selección de Asientos",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Si el usuario presiona "Sí" (YES_OPTION)
        if (respuesta == JOptionPane.YES_OPTION) {
            PanelLogo.revalidate();
            PanelLogo.repaint();
            barra.setPasoActual(4);

            Panel4 nuevoPanel = new Panel4();

            cambiarDePanel(nuevoPanel);

            // 9. Forzar actualización de la ventana principal completa
            Window ventanaPadre = SwingUtilities.getWindowAncestor(PanelOrigenDestino);
            if (ventanaPadre != null) {
                ventanaPadre.validate();
                ventanaPadre.repaint();
            }
        }
    }//GEN-LAST:event_jButtonSiguienteActionPerformed

    private void mostrarResumenConsola() {
        System.out.println("\n=================================================");
        System.out.println("        RESUMEN DE RESERVA - UNEFA CITY AIRLINES  ");
        System.out.println("=================================================");
        System.out.println(" RUTA SELECCIONADA:");
        System.out.println("   - Origen:  " + (jComboBoxOrigen != null ? jComboBoxOrigen.getSelectedItem() : "N/A"));
        System.out.println("   - Destino: " + (jComboBoxDestino != null ? jComboBoxDestino.getSelectedItem() : "N/A"));

        String fechaSeleccionada = "No Selecionada";

        // Validamos que el componente exista y que el usuario haya seleccionado una fecha
        if (jDateChooserIda != null && jDateChooserIda.getDate() != null) {
            // Creamos el formato deseado (Ejemplo: 15/08/2026)
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
            // Aplicamos el formato a la fecha capturada
            fechaSeleccionada = formatoFecha.format(jDateChooserIda.getDate());
        }
        System.out.println("   - Fecha:   " + fechaSeleccionada);
        System.out.println("=================================================\n");
    }

    public static void InterfazPrincipal() {
        try {
            // Establece el Look and Feel nativo del sistema operativo (Windows en tu caso)
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new InterfazPrincipal().setVisible(true);
        });
    }

    public void cambiarDePanel(JPanel nuevoPanel) {
        // 1. Limpieza absoluta

        PanelOrigenDestino.removeAll();

        // 2. Le asignamos un diseño de cuadrícula simple (ocupa el 100% del espacio)
        PanelOrigenDestino.setLayout(new java.awt.GridLayout(1, 1));

        // 3. Agregamos el nuevo panel
        PanelOrigenDestino.add(nuevoPanel);

        // 4. Ciclo de refresco estructural profundo
        PanelOrigenDestino.revalidate();
        PanelOrigenDestino.repaint();

        // 5. Forzar actualización de la ventana completa
        this.pack(); // Reajusta el contenedor a la pantalla
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelLogo;
    private javax.swing.JPanel PanelOrigenDestino;
    private javax.swing.JLabel bienvenida;
    private javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JComboBox<String> jComboBoxDestino;
    private javax.swing.JComboBox<String> jComboBoxOrigen;
    private com.toedter.calendar.JDateChooser jDateChooserIda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelDestino;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFechaAbor;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelLeyendaAD;
    private javax.swing.JLabel jLabelLeyendaAND;
    private javax.swing.JLabel jLabelLeyendaAS;
    private javax.swing.JLabel jLabelOrigen;
    private javax.swing.JPanel jPanelInformacion;
    public static javax.swing.JPanel jPanelProgreso;
    private javax.swing.JPanel jPanelSeleccionDeDatos;
    private javax.swing.JPanel jPanelSeleccionDeVuelos;
    private javax.swing.JPanel jPanelSiguiente;
    private javax.swing.JPanel jPanellLeyendaAD;
    private javax.swing.JPanel jPanellLeyendaAND;
    private javax.swing.JPanel jPanellLeyendaAS;
    private javax.swing.JPanel panelAnclaVuelos;
    // End of variables declaration//GEN-END:variables
}
