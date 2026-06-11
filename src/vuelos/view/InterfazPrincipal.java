package vuelos.view;
import java.awt.BorderLayout;
import vuelos.controller.ProgressBar;
import java.util.Date;
import vuelos.controller.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
/**
 *
 * @author Todos
 */
public class InterfazPrincipal extends javax.swing.JFrame {
    private ControladorRutas controladorRutas;
    private ProgressBar barra;
    
    public InterfazPrincipal() {
        initComponents();
        // Instancias tu nuevo componente de cabina
        
       

        /*// Buscas tu panel vacío de NetBeans donde irá el mapa (ej. jPanelContenedorAsientos)
        jPanelSeleccionDeVuelos.setLayout(new BorderLayout());
        jPanelSeleccionDeVuelos.add(cabina, BorderLayout.CENTER);
        jPanelSeleccionDeVuelos.validate();
        jPanelSeleccionDeVuelos.repaint();*/

        
        barra = new ProgressBar();
        jPanelProgreso.setLayout(new java.awt.BorderLayout()); 
        jPanelProgreso.add(barra, java.awt.BorderLayout.CENTER); 
        jPanelProgreso.validate();
        jPanelProgreso.repaint();

        jPanelVuelos.setVisible(false);
        jPanelSeleccionDeVuelos.setVisible(true);
        
        jPanelSiguiente.setVisible(false);
        controladorRutas = new ControladorRutas(jComboBoxOrigen, jComboBoxDestino);
        Date fechaActual = new Date();
        jDateChooserIda.setMinSelectableDate(fechaActual);
        
    }

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
        PanelOrigenDestino = new javax.swing.JPanel();
        jPanelSeleccionDeDatos = new javax.swing.JPanel();
        jComboBoxOrigen = new javax.swing.JComboBox<>();
        jComboBoxDestino = new javax.swing.JComboBox<>();
        jLabelDestino = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabelFechaAbor = new javax.swing.JLabel();
        jLabelOrigen = new javax.swing.JLabel();
        jDateChooserIda = new com.toedter.calendar.JDateChooser();
        jPanelVuelos = new javax.swing.JPanel();
        jPanelInformacion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jPanelSeleccionDeVuelos = new javax.swing.JPanel();
        jPanelSiguiente = new javax.swing.JPanel();
        jLabelLeyendaAD = new javax.swing.JLabel();
        jPanellLeyendaAD = new javax.swing.JPanel();
        jLabelLeyendaAS = new javax.swing.JLabel();
        jPanellLeyendaAND = new javax.swing.JPanel();
        jPanellLeyendaAS = new javax.swing.JPanel();
        jLabelLeyendaAND = new javax.swing.JLabel();
        jButtonSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoAvion.png")).getImage());
        setMinimumSize(new java.awt.Dimension(500, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 700));

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

        javax.swing.GroupLayout PanelLogoLayout = new javax.swing.GroupLayout(PanelLogo);
        PanelLogo.setLayout(PanelLogoLayout);
        PanelLogoLayout.setHorizontalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(122, 122, 122)
                .addComponent(jPanelProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelLogoLayout.setVerticalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogoLayout.createSequentialGroup()
                .addGroup(PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(PanelLogoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanelProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );

        jPanelSeleccionDeDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detalle de salida"));

        jComboBoxOrigen.setEditable(true);

        jComboBoxDestino.setEditable(true);

        jLabelDestino.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabelDestino.setText("Destino:");

        btnBuscar.setText("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabelFechaAbor.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabelFechaAbor.setText("Fecha de abordaje");

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
                    .addComponent(jDateChooserIda, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
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
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jDateChooserIda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelSeleccionDeDatosLayout.createSequentialGroup()
                        .addGroup(jPanelSeleccionDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDestino)
                            .addComponent(jLabelOrigen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelSeleccionDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        jPanelVuelos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Vuelos Disponibles"));

        javax.swing.GroupLayout jPanelVuelosLayout = new javax.swing.GroupLayout(jPanelVuelos);
        jPanelVuelos.setLayout(jPanelVuelosLayout);
        jPanelVuelosLayout.setHorizontalGroup(
            jPanelVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 184, Short.MAX_VALUE)
        );
        jPanelVuelosLayout.setVerticalGroup(
            jPanelVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelInformacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Información Del dia"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Hora:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Fecha:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel10.setText("Datos:");

        jLabelHora.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabelHora.setText("00:00 PM");

        jLabelFecha.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabelFecha.setText("00 / 00 / 0000");

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
                    .addComponent(jLabel10))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanelInformacionLayout.setVerticalGroup(
            jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHora, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelFecha))
                .addContainerGap())
        );

        jPanelSeleccionDeVuelos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelSeleccionDeVuelos.setToolTipText("background");

        javax.swing.GroupLayout jPanelSeleccionDeVuelosLayout = new javax.swing.GroupLayout(jPanelSeleccionDeVuelos);
        jPanelSeleccionDeVuelos.setLayout(jPanelSeleccionDeVuelosLayout);
        jPanelSeleccionDeVuelosLayout.setHorizontalGroup(
            jPanelSeleccionDeVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );
        jPanelSeleccionDeVuelosLayout.setVerticalGroup(
            jPanelSeleccionDeVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        jPanelSiguiente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        jLabelLeyendaAND.setText("Asientos No Disponibles:");

        jButtonSiguiente.setBackground(new java.awt.Color(11, 29, 58));
        jButtonSiguiente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSiguiente.setText("Siguente");

        javax.swing.GroupLayout jPanelSiguienteLayout = new javax.swing.GroupLayout(jPanelSiguiente);
        jPanelSiguiente.setLayout(jPanelSiguienteLayout);
        jPanelSiguienteLayout.setHorizontalGroup(
            jPanelSiguienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSiguienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLeyendaAD, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanellLeyendaAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelLeyendaAS, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanellLeyendaAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelLeyendaAND, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanellLeyendaAND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(jPanelVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelOrigenDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelSeleccionDeVuelos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        PanelOrigenDestinoLayout.setVerticalGroup(
            PanelOrigenDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOrigenDestinoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelOrigenDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelSeleccionDeDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(PanelOrigenDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelOrigenDestinoLayout.createSequentialGroup()
                        .addComponent(jPanelSeleccionDeVuelos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelOrigenDestinoLayout.createSequentialGroup()
                        .addComponent(jPanelVuelos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
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
                .addComponent(PanelOrigenDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       
        
        
        //Inicializar metodo para busqueda de vuelos
        
        BuscadorVuelos buscador = new BuscadorVuelos();

        // Validar primero las rutas
        boolean rutasOk = ValidarCampos.validar(controladorRutas, jComboBoxOrigen, jComboBoxDestino);
        
        if (rutasOk) {
                    //javax.swing.JOptionPane.showMessageDialog(this, "¡Ruta, Fechas y Pasajeros procesados con éxito!");
                    mostrarResumenConsola();
                    
                    //cargamos paneles
                    jPanelVuelos.setVisible(true);
                    
                    //llamamos el objeto de buscador de Vuelos
                    
                    String origenSeleccionado = jComboBoxOrigen.getSelectedItem().toString();
                    String destinoSeleccionado = jComboBoxDestino.getSelectedItem().toString();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                   
                    String fechaSeleccionada = ""; 
        
                    // Reemplaza "jDateChooser" por el nombre real de tu variable de calendario
                    if (jDateChooserIda.getDate() != null) {
                        // Solo si el usuario eligió una fecha, la formateamos
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // O el formato que uses
                        fechaSeleccionada = sdf.format(jDateChooserIda.getDate());
                    } else {
                        // Si no seleccionó fecha, queda vacía o puedes asignarle null si tu BD lo prefiere
                        fechaSeleccionada = null; 
                    }
                    
                     // 2. Ejecutamos la consulta (por ahora simulará con los datos de prueba)
                    List<BuscadorVuelos.VueloInfo> resultados = buscador.buscarVuelosEnBD(origenSeleccionado, destinoSeleccionado, fechaSeleccionada);


                    // 3. Enviamos los resultados y el contenedor izquierdo para que se actualice solo
                    // 'panelVuelosDisponibles' hace referencia al JPanel que está dentro del recuadro "Vuelos Disponibles"
                    buscador.actualizarPanelVuelos(jPanelVuelos, resultados,jPanelSeleccionDeVuelos,barra,jPanelSiguiente);
                                                                     
                     barra.setPasoActual(2); 



        } else {
            System.out.println("No se pudo procesar: Datos de las ciudades incorrectos.");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

   
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
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelLogo;
    private javax.swing.JPanel PanelOrigenDestino;
    private javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
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
    private javax.swing.JPanel jPanelVuelos;
    private javax.swing.JPanel jPanellLeyendaAD;
    private javax.swing.JPanel jPanellLeyendaAND;
    private javax.swing.JPanel jPanellLeyendaAS;
    // End of variables declaration//GEN-END:variables
}
