/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuelos.view;

import vuelos.controller.AdminController;
import java.awt.CardLayout;
import java.awt.Window;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Kasey
 */
public class InterfazAdmin extends javax.swing.JFrame {
    private AdminController admin = new AdminController();
    private boolean modoEdicion = false;
    private int idSeleccionado = -1; // O String, dependiendo de tu llave primaria

    /**
     * Creates new form InterfazAdmin
     */
    public InterfazAdmin() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        panelDecorador.setVisible(true);
        Date fechaActual = new Date();
        campoFecha.setMinSelectableDate(fechaActual);
        
        
        
        
        javax.swing.border.Border lineaGris = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 1);
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        javax.swing.border.Border bordeFinal = javax.swing.BorderFactory.createCompoundBorder(lineaGris, padding);
        jTable3.getColumnModel().getColumn(0).setMaxWidth(100); 
        btnEliminar4.setBackground(new java.awt.Color(200, 0, 0));
        btnEditarOrigen.setBackground(new java.awt.Color(249, 198, 46));
        campoVuelo.setBorder(bordeFinal);
        campoOrigen.setBorder(bordeFinal);
        campoDestino.setBorder(bordeFinal);
        campoFecha.setBorder(bordeFinal);
        campoOrigen2.setBorder(bordeFinal);
        campoPrecio.setBorder(bordeFinal);
        
        
        //esto NO permite escribir numeros ni borrar VUEL- de campoVuelo
        
        String textoProtegido = "VUEL-"; 
        campoVuelo.setText(textoProtegido);

        javax.swing.text.AbstractDocument doc = (javax.swing.text.AbstractDocument) campoVuelo.getDocument();
        doc.setDocumentFilter(new javax.swing.text.DocumentFilter() {

            @Override
            public void remove(FilterBypass fb, int offset, int length) throws javax.swing.text.BadLocationException {
                if (offset < textoProtegido.length()) {return;}
                super.remove(fb, offset, length);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) 
                    throws javax.swing.text.BadLocationException {

                if (offset < textoProtegido.length()) {return;}

                if (text != null && !text.matches("\\d*")) {return; }

                int longitudActual = fb.getDocument().getLength();
                int longitudNueva = text != null ? text.length() : 0;

                if ((longitudActual - length + longitudNueva) > (textoProtegido.length() + 4)) {return;}
                super.replace(fb, offset, length, text, attrs);
            }
        });

        // VALIDACIÓN AL SALIR DEL CAMPO (Falta de números)
        campoVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                String textoCompleto = campoVuelo.getText();
                // Restamos el prefijo para saber cuántos números realmente escribió
                int numerosEscritos = textoCompleto.length() - textoProtegido.length();

                // Si escribió algo pero es menor a 4 dígitos, salta la ventana
                if (numerosEscritos > 0 && numerosEscritos < 4) {
                    javax.swing.JOptionPane.showMessageDialog(
                        null, 
                        "El número de vuelo debe tener exactamente 4 dígitos.", 
                        "Error de Validación", 
                        javax.swing.JOptionPane.ERROR_MESSAGE
                    );
                    campoVuelo.requestFocusInWindow(); // Devuelve el cursor al campo
                }
            }
        });    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogo = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        btnSeccion1 = new javax.swing.JButton();
        btnSeccion2 = new javax.swing.JButton();
        btnSeccion3 = new javax.swing.JButton();
        panelContenedor = new javax.swing.JPanel();
        panelDecorador = new javax.swing.JPanel();
        panelSeccion3 = new javax.swing.JPanel();
        labelSeccion5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        btnEliminar4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        campoOrigen2 = new javax.swing.JTextField();
        btnInsertarOrigen = new javax.swing.JButton();
        labelAyuda2 = new javax.swing.JLabel();
        btnEditarOrigen = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        labelSeccion6 = new javax.swing.JLabel();
        panelSeccion2 = new javax.swing.JPanel();
        labelSeccion2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnEliminar2 = new javax.swing.JButton();
        campoVuelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        labelAyuda1 = new javax.swing.JLabel();
        labelSeccion3 = new javax.swing.JLabel();
        labelSeccion4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnInsertarVuelos = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        campoPrecio = new javax.swing.JTextField();
        campoOrigen = new javax.swing.JComboBox<>();
        campoDestino = new javax.swing.JComboBox<>();
        campoFecha = new com.toedter.calendar.JDateChooser();
        panelSeccion1 = new javax.swing.JPanel();
        labelSeccion1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        labelAyuda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoAvion.png")).getImage());
        setSize(new java.awt.Dimension(900, 600));

        panelLogo.setBackground(new java.awt.Color(11, 29, 58));

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/avionProyecto.PNG"))); // NOI18N

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenLogout.png"))); // NOI18N
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setOpaque(true);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SALIR:");

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addComponent(labelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelLogo)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnSalir))
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1))
        );

        panelBotones.setBackground(new java.awt.Color(255, 255, 255));
        panelBotones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSeccion1.setText("Boletos Reservados");
        btnSeccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeccion1ActionPerformed(evt);
            }
        });

        btnSeccion2.setText("Vuelos");
        btnSeccion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeccion2ActionPerformed(evt);
            }
        });

        btnSeccion3.setText("Origen/destino");
        btnSeccion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeccion3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btnSeccion1)
                .addGap(203, 203, 203)
                .addComponent(btnSeccion3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeccion2)
                .addGap(80, 80, 80))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeccion1)
                    .addComponent(btnSeccion2)
                    .addComponent(btnSeccion3))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        panelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        panelContenedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContenedor.setLayout(new java.awt.CardLayout(1, 1));

        panelDecorador.setBackground(new java.awt.Color(255, 255, 255));
        panelDecorador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelDecoradorLayout = new javax.swing.GroupLayout(panelDecorador);
        panelDecorador.setLayout(panelDecoradorLayout);
        panelDecoradorLayout.setHorizontalGroup(
            panelDecoradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 874, Short.MAX_VALUE)
        );
        panelDecoradorLayout.setVerticalGroup(
            panelDecoradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );

        panelContenedor.add(panelDecorador, "card5");

        panelSeccion3.setBackground(new java.awt.Color(255, 255, 255));
        panelSeccion3.setPreferredSize(new java.awt.Dimension(875, 405));

        labelSeccion5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelSeccion5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSeccion5.setText("ORIGENES/DESTINOS");
        labelSeccion5.setAlignmentX(0.5F);

        jScrollPane3.setBorder(null);

        jTable3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID CIUDAD", "CIUDAD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setGridColor(new java.awt.Color(153, 153, 153));
        jTable3.setRowHeight(28);
        jTable3.setSelectionBackground(new java.awt.Color(153, 204, 255));
        jTable3.setShowHorizontalLines(false);
        jTable3.setShowVerticalLines(false);
        jTable3.getTableHeader().setResizingAllowed(false);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);

        btnEliminar4.setBackground(new java.awt.Color(11, 29, 58));
        btnEliminar4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar4.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar4.setText("Eliminar");
        btnEliminar4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11, 29, 58), 2));
        btnEliminar4.setFocusPainted(false);
        btnEliminar4.setMargin(new java.awt.Insets(8, 14, 8, 14));
        btnEliminar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("CIUDAD:");

        campoOrigen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoOrigen2ActionPerformed(evt);
            }
        });
        campoOrigen2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoOrigen2KeyTyped(evt);
            }
        });

        btnInsertarOrigen.setBackground(new java.awt.Color(11, 29, 58));
        btnInsertarOrigen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInsertarOrigen.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertarOrigen.setText("Insertar");
        btnInsertarOrigen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11, 29, 58), 2));
        btnInsertarOrigen.setFocusPainted(false);
        btnInsertarOrigen.setMargin(new java.awt.Insets(8, 14, 8, 14));
        btnInsertarOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarOrigenActionPerformed(evt);
            }
        });

        labelAyuda2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAyuda2.setText("[?]");
        labelAyuda2.setToolTipText("Selecciona un registro para eliminar\n");
        labelAyuda2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEditarOrigen.setBackground(new java.awt.Color(11, 29, 58));
        btnEditarOrigen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarOrigen.setText("Editar");
        btnEditarOrigen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11, 29, 58), 2));
        btnEditarOrigen.setFocusPainted(false);
        btnEditarOrigen.setMargin(new java.awt.Insets(8, 14, 8, 14));
        btnEditarOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarOrigenActionPerformed(evt);
            }
        });

        labelSeccion6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelSeccion6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSeccion6.setText("AGREGAR NUEVO");
        labelSeccion6.setAlignmentX(0.5F);

        javax.swing.GroupLayout panelSeccion3Layout = new javax.swing.GroupLayout(panelSeccion3);
        panelSeccion3.setLayout(panelSeccion3Layout);
        panelSeccion3Layout.setHorizontalGroup(
            panelSeccion3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeccion3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelSeccion3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSeccion3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelSeccion3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditarOrigen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInsertarOrigen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))
                    .addGroup(panelSeccion3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelSeccion3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelSeccion6)
                            .addGroup(panelSeccion3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator1)
                                .addGroup(panelSeccion3Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(campoOrigen2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(26, Short.MAX_VALUE))))
            .addGroup(panelSeccion3Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(labelSeccion5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAyuda2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelSeccion3Layout.setVerticalGroup(
            panelSeccion3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeccion3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSeccion3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelSeccion5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAyuda2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSeccion3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSeccion3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(23, 23, 23))
                    .addGroup(panelSeccion3Layout.createSequentialGroup()
                        .addComponent(labelSeccion6)
                        .addGap(18, 18, 18)
                        .addGroup(panelSeccion3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(campoOrigen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInsertarOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(90, Short.MAX_VALUE))))
        );

        panelContenedor.add(panelSeccion3, "panelSeccion3");
        panelSeccion3.getAccessibleContext().setAccessibleName("panelSeccion3");

        panelSeccion2.setBackground(new java.awt.Color(255, 255, 255));
        panelSeccion2.setPreferredSize(new java.awt.Dimension(876, 405));

        labelSeccion2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelSeccion2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSeccion2.setText("OBSERVAR/ELIMINAR");
        labelSeccion2.setAlignmentX(0.5F);

        jScrollPane2.setBorder(null);

        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NUMERO VUELO", "ORIGEN", "DESTINO", "FECHA SALIDA", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(153, 153, 153));
        jTable2.setRowHeight(28);
        jTable2.setSelectionBackground(new java.awt.Color(153, 204, 255));
        jTable2.setShowHorizontalLines(false);
        jTable2.setShowVerticalLines(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        btnEliminar2.setBackground(new java.awt.Color(11, 29, 58));
        btnEliminar2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar2.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar2.setText("Eliminar");
        btnEliminar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11, 29, 58), 2));
        btnEliminar2.setFocusPainted(false);
        btnEliminar2.setMargin(new java.awt.Insets(8, 14, 8, 14));
        btnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar2ActionPerformed(evt);
            }
        });

        campoVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoVueloActionPerformed(evt);
            }
        });
        campoVuelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoVueloKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Origen:");

        labelAyuda1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAyuda1.setText("[?]");
        labelAyuda1.setToolTipText("Selecciona un registro para eliminar\n");
        labelAyuda1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelSeccion3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelSeccion3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSeccion3.setText("VUELOS");
        labelSeccion3.setAlignmentX(0.5F);

        labelSeccion4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelSeccion4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSeccion4.setText("INSERTAR");
        labelSeccion4.setAlignmentX(0.5F);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Destino:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nº Vuelo:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Fecha salida:");

        btnInsertarVuelos.setBackground(new java.awt.Color(11, 29, 58));
        btnInsertarVuelos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInsertarVuelos.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertarVuelos.setText("Insertar");
        btnInsertarVuelos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11, 29, 58), 2));
        btnInsertarVuelos.setFocusPainted(false);
        btnInsertarVuelos.setMargin(new java.awt.Insets(8, 14, 8, 14));
        btnInsertarVuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarVuelosActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Precio:");

        campoPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPrecioKeyTyped(evt);
            }
        });

        campoOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        campoOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoOrigenActionPerformed(evt);
            }
        });

        campoDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelSeccion2Layout = new javax.swing.GroupLayout(panelSeccion2);
        panelSeccion2.setLayout(panelSeccion2Layout);
        panelSeccion2Layout.setHorizontalGroup(
            panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeccion2Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(labelSeccion3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelSeccion2Layout.createSequentialGroup()
                .addGroup(panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelSeccion2Layout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addComponent(labelSeccion4))
                        .addGroup(panelSeccion2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(campoOrigen, 0, 141, Short.MAX_VALUE)
                                .addComponent(campoVuelo))
                            .addGroup(panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelSeccion2Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addGroup(panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(campoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)))
                                .addGroup(panelSeccion2Layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(campoFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeccion2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                            .addComponent(btnInsertarVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelSeccion2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeccion2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAyuda1)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeccion2Layout.createSequentialGroup()
                        .addComponent(labelSeccion2)
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeccion2Layout.createSequentialGroup()
                        .addComponent(btnEliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(226, 226, 226))))
        );
        panelSeccion2Layout.setVerticalGroup(
            panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeccion2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSeccion3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSeccion2)
                    .addComponent(labelSeccion4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSeccion2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(labelAyuda1))
                    .addGroup(panelSeccion2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelSeccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInsertarVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addComponent(btnEliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        panelContenedor.add(panelSeccion2, "panelSeccion2");
        panelSeccion2.getAccessibleContext().setAccessibleName("panelSeccion2");

        panelSeccion1.setBackground(new java.awt.Color(255, 255, 255));

        labelSeccion1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelSeccion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSeccion1.setText("BOLETOS RESERVADOS");
        labelSeccion1.setAlignmentX(0.5F);

        jScrollPane1.setBorder(null);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "BOLETO", "ID_USU", "NOMBRE USUARIO", "ID_VUELO", "NUMERO ASIENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(153, 153, 153));
        jTable1.setRowHeight(28);
        jTable1.setSelectionBackground(new java.awt.Color(153, 204, 255));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        btnEliminar.setBackground(new java.awt.Color(11, 29, 58));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11, 29, 58), 2));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setMargin(new java.awt.Insets(8, 14, 8, 14));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        labelAyuda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAyuda.setText("[?]");
        labelAyuda.setToolTipText("Selecciona un registro para eliminar\n");
        labelAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panelSeccion1Layout = new javax.swing.GroupLayout(panelSeccion1);
        panelSeccion1.setLayout(panelSeccion1Layout);
        panelSeccion1Layout.setHorizontalGroup(
            panelSeccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeccion1Layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addGroup(panelSeccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeccion1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(labelAyuda)
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeccion1Layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(382, 382, 382))))
            .addGroup(panelSeccion1Layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(labelSeccion1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelSeccion1Layout.setVerticalGroup(
            panelSeccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeccion1Layout.createSequentialGroup()
                .addGroup(panelSeccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSeccion1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(labelAyuda))
                    .addGroup(panelSeccion1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelSeccion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        panelContenedor.add(panelSeccion1, "panelSeccion1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Realmente desea cerrar la sesión de administrador?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
             if (respuesta == JOptionPane.YES_OPTION) {
            this.dispose();
            new vuelos.view.MainLogin().setVisible(true);
            System.out.println("Redirección exitosa a MainLogin.");}
        
  
    }//GEN-LAST:event_btnSalirActionPerformed

    private void campoVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoVueloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoVueloActionPerformed

    private void campoOrigen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoOrigen2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoOrigen2ActionPerformed

    private void btnSeccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeccion1ActionPerformed
        
        admin.cargarTablaBoletos(jTable1);
        
        CardLayout card = (CardLayout) panelContenedor.getLayout();
        
        card.show(panelContenedor, "panelSeccion1");
    }//GEN-LAST:event_btnSeccion1ActionPerformed

    private void btnSeccion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeccion2ActionPerformed
        admin.cargarComboAeropuertos(campoOrigen);
        admin.cargarComboAeropuertos(campoDestino);
        admin.cargarTablaVuelos(jTable2);
        campoOrigen.setSelectedIndex(-1);
        campoDestino.setSelectedIndex(-1);
        CardLayout card = (CardLayout) panelContenedor.getLayout();
        
        card.show(panelContenedor, "panelSeccion2");
    }//GEN-LAST:event_btnSeccion2ActionPerformed

    private void btnSeccion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeccion3ActionPerformed
        
        admin.cargarTablasOrigenYDestino(jTable3);
        
        CardLayout card = (CardLayout) panelContenedor.getLayout();
        
        card.show(panelContenedor, "panelSeccion3");
    }//GEN-LAST:event_btnSeccion3ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        admin.eliminarBoletoSeleccionado(jTable1);
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnInsertarVuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarVuelosActionPerformed
        
        admin.agregarNuevoVuelo(campoVuelo, campoOrigen, campoDestino, campoFecha,campoPrecio, jTable2);
        
        
        
    }//GEN-LAST:event_btnInsertarVuelosActionPerformed

    private void btnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar2ActionPerformed

        
        admin.eliminarVueloSeleccionado(jTable2);
        
    }//GEN-LAST:event_btnEliminar2ActionPerformed

    private void btnInsertarOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarOrigenActionPerformed
        
        admin.agregarNuevoOrigen(campoOrigen2, jTable3);
        
        
    }//GEN-LAST:event_btnInsertarOrigenActionPerformed

    private void btnEliminar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar4ActionPerformed
        admin.eliminarOrigenSeleccionado(jTable3);
    }//GEN-LAST:event_btnEliminar4ActionPerformed

    private void campoOrigen2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoOrigen2KeyTyped
        char c = evt.getKeyChar();
        // Si no es una letra, ni un espacio, ni la tecla borrar se cancela el tipeo
        if (!Character.isLetter(c) && c != ' ' && c != java.awt.event.KeyEvent.VK_BACK_SPACE) {
            evt.consume(); // Destruye el evento (el carácter no se escribe)
        }
    }//GEN-LAST:event_campoOrigen2KeyTyped

    private void btnEditarOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarOrigenActionPerformed
        if (!modoEdicion) {
                // ver si se seleciono una fila
                int fila = jTable3.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila primero.");
                    return;
                }

                idSeleccionado = Integer.parseInt(jTable3.getValueAt(fila, 0).toString());
                admin.cargarDatosParaEditar(jTable3, campoOrigen2);
                // Deshabilitar botones para bloquear inserción/eliminación
                btnInsertarOrigen.setEnabled(false);
                btnEliminar4.setEnabled(false);
                
                
                modoEdicion = true;
                btnEditarOrigen.setText("Guardar Cambios");
                btnEditarOrigen.setBackground(new java.awt.Color(124, 186, 76));
            } else {
                // --- MODO: GUARDAR CAMBIOS --- 
                admin.guardarEdicion(idSeleccionado, campoOrigen2.getText(), jTable3);
                campoOrigen2.setText("");
                //Volver a habilitar los botones
                btnInsertarOrigen.setEnabled(true);
                btnEliminar4.setEnabled(true);
                
                modoEdicion = false;
                btnEditarOrigen.setText("Editar");
                btnEditarOrigen.setBackground(new java.awt.Color(249, 198, 100));
            }        
    }//GEN-LAST:event_btnEditarOrigenActionPerformed

    private void campoOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoOrigenActionPerformed

    private void campoVueloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoVueloKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_campoVueloKeyTyped

    private void campoPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPrecioKeyTyped
        char c = evt.getKeyChar();
    
    // Verificar si no es un número y si no es una coma
    if (!Character.isDigit(c) && c != '.') {
        // Consumir el evento para que no se escriba el carácter
        evt.consume();
    }
    
    // Opcional: Evitar que se escriba más de una coma
    if (c == '.' && ((javax.swing.JTextField)evt.getSource()).getText().contains(".")) {
        evt.consume();
    }
    }//GEN-LAST:event_campoPrecioKeyTyped

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarOrigen;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar2;
    private javax.swing.JButton btnEliminar4;
    private javax.swing.JButton btnInsertarOrigen;
    private javax.swing.JButton btnInsertarVuelos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeccion1;
    private javax.swing.JButton btnSeccion2;
    private javax.swing.JButton btnSeccion3;
    private javax.swing.JComboBox<String> campoDestino;
    private com.toedter.calendar.JDateChooser campoFecha;
    private javax.swing.JComboBox<String> campoOrigen;
    private javax.swing.JTextField campoOrigen2;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JTextField campoVuelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel labelAyuda;
    private javax.swing.JLabel labelAyuda1;
    private javax.swing.JLabel labelAyuda2;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelSeccion1;
    private javax.swing.JLabel labelSeccion2;
    private javax.swing.JLabel labelSeccion3;
    private javax.swing.JLabel labelSeccion4;
    private javax.swing.JLabel labelSeccion5;
    private javax.swing.JLabel labelSeccion6;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelDecorador;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JPanel panelSeccion1;
    private javax.swing.JPanel panelSeccion2;
    private javax.swing.JPanel panelSeccion3;
    // End of variables declaration//GEN-END:variables
}
