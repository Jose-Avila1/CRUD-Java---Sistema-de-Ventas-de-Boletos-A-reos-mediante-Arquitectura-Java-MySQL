/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuelos.view;

import java.awt.Image;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import vuelos.controller.BuscadorVuelos;
import vuelos.controller.BuscadorVuelos.VueloInfo;
import vuelos.controller.RegistroBoleto;

/**
 *
 * @author Jose
 */
public class Panel4 extends javax.swing.JPanel {
    
    private RegistroBoleto registro = new RegistroBoleto();
    private String nVuelo;
    private String origen;
    private String destino;
    private String fecha;
    private String precioText;
    private double totalPago;
    private String asientosFinales;
    
    private MapaCabina ventanaMapa;
    /**
     * Creates new form Panel4
     */
    public Panel4() {
        initComponents();
        resumenvuelo.requestFocusInWindow();
            try {
                // 1. Crear el margen interno exacto (Arriba, Izquierda, Abajo, Derecha)
                javax.swing.border.Border margenInterno = javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8);

                // 2. Obtener el borde original que ya tienen tus componentes para no perderlo
                javax.swing.border.Border bordeOriginal = NtarjetaF.getBorder();

                // 3. Fusionar ambos bordes (Borde original por fuera, margen por dentro)
                javax.swing.border.CompoundBorder bordeModerno = new javax.swing.border.CompoundBorder(bordeOriginal, margenInterno);

                // 4. Aplicar el nuevo borde compuesto a cada campo
                NtarjetaF.setBorder(bordeModerno);
                FechaN.setBorder(bordeModerno);
                Cvv.setBorder(bordeModerno);
                NombreTarjeta.setBorder(bordeModerno); // Recuerda verificar que estos sean tus nombres reales de variable

            } catch (Exception e) {
                System.err.println("Error al aplicar los bordes: " + e.getMessage());
            }
            
                        // Supongamos que "ventanaMapa" es el objeto o instancia de tu pantalla de asientos
                this.asientosFinales = MapaCabina.getAsientosParaEnviar();
                 asientosSelec.setText(asientosFinales);

            // Esta variable 'asientosFinales' ya contiene el formato "B-3,B-4,B-5" 
            // Lista para meterla directo en tu INSERT de la base de datos
            System.out.println("Asientos a registrar: " + asientosFinales);
            
                        // Validamos primero que la búsqueda no haya quedado vacía
            if (!BuscadorVuelos.listaVuelosEncontrados.isEmpty()) {

                // Obtenemos el primer vuelo de la lista (posición 0)
                VueloInfo vueloSeleccionado = BuscadorVuelos.listaVuelosEncontrados.get(BuscadorVuelos.indiceVueloSeleccionado);

                // ¡Aquí tienes tus variables del rs listas para usar!
              // 1. Extraemos los textos directamente de las variables públicas (sin usar paréntesis)
                   // 1. Extraemos los textos directamente de las variables públicas
                this.nVuelo  = vueloSeleccionado.numeroVuelo;   //
                this.origen  = vueloSeleccionado.origen;        //
                this.destino = vueloSeleccionado.destino;       //
                this.fecha   = vueloSeleccionado.fechaSalida;    //
                this.precioText = vueloSeleccionado.precioBase; //

                // 2. Convertimos el texto del precio a un número decimal (double)
                double precioIndividual = Double.parseDouble(precioText);

                // 3. Contamos cuántos asientos se seleccionaron en el mapa
                int cantidadAsientos = 0;
                String asientosSeleccionados = MapaCabina.getAsientosParaEnviar(); //

                if (asientosSeleccionados != null && !asientosSeleccionados.trim().isEmpty()) {
                    // Separa por comas ("B-3,B-4") y cuenta los elementos
                    cantidadAsientos = asientosSeleccionados.split(",").length;
                }

                // 4. Calculamos el total matemático
                double total = precioIndividual * cantidadAsientos;
                double impuesto = total * 0.05;
                this.totalPago = total + impuesto;
                
                // 5. Asignamos los datos corregidos a tus JLabels de la interfaz
                labelcodigovuelo.setText(nVuelo); //
                labelruta.setText(origen + "-" + destino); //
                labelsalida.setText(fecha); //

                // Mostramos el total de la multiplicación en tu etiqueta de total
                labeltotal.setText(String.valueOf(total+"$")); //
                labelbase.setText(String.valueOf(total+"$"));
                labelimpuesto.setText(String.valueOf(impuesto+"$"));
                labeltotalpago.setText(String.valueOf(totalPago+"$"));

                

            } else {
                System.out.println("No se encontraron vuelos en la búsqueda.");
}
            
            
    }
      public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel4().setVisible(true);
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        resumenvuelo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labeltotal = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        asientosSelec = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        labelcodigovuelo = new javax.swing.JLabel();
        labelruta = new javax.swing.JLabel();
        labelsalida = new javax.swing.JLabel();
        preciovuelo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Formulario = new javax.swing.JPanel();
        Ntarjeta = new javax.swing.JLabel();
        NtarjetaF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Cvv = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        NombreTarjeta = new javax.swing.JTextField();
        BtnComprar = new vuelos.controller.BotonEstilizado("Comprar");
        ;
        FechaN = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        BtnVisa = new javax.swing.JButton();
        BtnMasterCard = new javax.swing.JButton();
        labelbase = new javax.swing.JLabel();
        labelimpuesto = new javax.swing.JLabel();
        labeltotalpago = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(850, 550));
        setPreferredSize(new java.awt.Dimension(850, 550));
        setVerifyInputWhenFocusTarget(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        resumenvuelo.setBackground(new java.awt.Color(255, 255, 255));
        resumenvuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 204, 204)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Resumen del Vuelo: ");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/images.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setText("¡UNEFACITY!");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labeltotal.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jPanel2.add(labeltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 100, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("---------------------------------------------------------");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 288, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Ruta:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel20.setText("Salida:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, 20));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel21.setText("Asientos:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel22.setText("---------------------------------------------------------");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 288, 10));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel23.setText("Total neto:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));
        jPanel2.add(asientosSelec, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 210, 20));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel25.setText("Código Vuelo:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        labelcodigovuelo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jPanel2.add(labelcodigovuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 80, 20));

        labelruta.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jPanel2.add(labelruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 230, 20));

        labelsalida.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jPanel2.add(labelsalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 120, 20));

        javax.swing.GroupLayout resumenvueloLayout = new javax.swing.GroupLayout(resumenvuelo);
        resumenvuelo.setLayout(resumenvueloLayout);
        resumenvueloLayout.setHorizontalGroup(
            resumenvueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resumenvueloLayout.createSequentialGroup()
                .addGroup(resumenvueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(resumenvueloLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel14))
                    .addGroup(resumenvueloLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(resumenvueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(resumenvueloLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        resumenvueloLayout.setVerticalGroup(
            resumenvueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resumenvueloLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel14)
                .addGap(39, 39, 39)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        add(resumenvuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 550));

        preciovuelo.setBackground(new java.awt.Color(255, 255, 255));
        preciovuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("DETALLES DE PAGO Y CONFIRMACIÓN");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tarifa Base: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tasas e Impuestos(5%): ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("------------------------------------------");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel9.setText("Total a pagar:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel10.setText("Método de Pago:");

        Formulario.setBackground(new java.awt.Color(255, 255, 255));

        Ntarjeta.setBackground(new java.awt.Color(0, 0, 0));
        Ntarjeta.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Ntarjeta.setText("Número de tarjeta: ");

        NtarjetaF.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        NtarjetaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NtarjetaFActionPerformed(evt);
            }
        });
        NtarjetaF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NtarjetaFKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel11.setText("Fecha de vencimiento:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("CVV:");

        Cvv.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        Cvv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CvvActionPerformed(evt);
            }
        });
        Cvv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CvvKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel13.setText("Nombre en la Tarjeta: ");

        NombreTarjeta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        NombreTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreTarjetaActionPerformed(evt);
            }
        });
        NombreTarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombreTarjetaKeyTyped(evt);
            }
        });

        BtnComprar.setBackground(new java.awt.Color(11, 29, 58));
        BtnComprar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnComprar.setForeground(new java.awt.Color(255, 255, 255));
        BtnComprar.setText("Comprar");
        BtnComprar.setBorder(null);
        BtnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FormularioLayout = new javax.swing.GroupLayout(Formulario);
        Formulario.setLayout(FormularioLayout);
        FormularioLayout.setHorizontalGroup(
            FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(FormularioLayout.createSequentialGroup()
                            .addComponent(Ntarjeta)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(NtarjetaF, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(FormularioLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(FechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Cvv, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FormularioLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        FormularioLayout.setVerticalGroup(
            FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormularioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NtarjetaF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ntarjeta))
                .addGap(34, 34, 34)
                .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(Cvv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(NombreTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(BtnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        BtnVisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Visa_logo.png"))); // NOI18N
        BtnVisa.setBorderPainted(false);
        BtnVisa.setContentAreaFilled(false);
        BtnVisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnVisa.setFocusPainted(false);
        BtnVisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVisaActionPerformed(evt);
            }
        });

        BtnMasterCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/MasterCard_Logo.png"))); // NOI18N
        BtnMasterCard.setBorderPainted(false);
        BtnMasterCard.setContentAreaFilled(false);
        BtnMasterCard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnMasterCard.setFocusPainted(false);
        BtnMasterCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnMasterCardMouseClicked(evt);
            }
        });
        BtnMasterCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMasterCardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnVisa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(BtnMasterCard, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnVisa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnMasterCard))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        labelbase.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelimpuesto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labeltotalpago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout preciovueloLayout = new javax.swing.GroupLayout(preciovuelo);
        preciovuelo.setLayout(preciovueloLayout);
        preciovueloLayout.setHorizontalGroup(
            preciovueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, preciovueloLayout.createSequentialGroup()
                .addGroup(preciovueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(preciovueloLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, preciovueloLayout.createSequentialGroup()
                        .addContainerGap(89, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel7)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(preciovueloLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, preciovueloLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(preciovueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(preciovueloLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(labeltotalpago, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(preciovueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(preciovueloLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(labelbase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(preciovueloLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelimpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, preciovueloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        preciovueloLayout.setVerticalGroup(
            preciovueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(preciovueloLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGroup(preciovueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(preciovueloLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(preciovueloLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(preciovueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(labelbase, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(preciovueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelimpuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(preciovueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(labeltotalpago, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        add(preciovuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 430, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void BtnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnComprarActionPerformed
                 String numeroTarjeta = NtarjetaF.getText().trim();
                 String codigoCvv = Cvv.getText().trim();
                // Pasamos por .getText() antes de evaluar si está vacío
            if (NtarjetaF.getText().trim().isEmpty() || 
                FechaN.getDate() == null || 
                Cvv.getText().trim().isEmpty() || 
                NombreTarjeta.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Complete todos los campos del vuelo.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
                if (numeroTarjeta.length() != 16) {
                    JOptionPane.showMessageDialog(null, 
                        "El número de tarjeta debe tener exactamente 16 dígitos.", 
                        "Tarjeta Inválida", 
                        JOptionPane.ERROR_MESSAGE);
                    return; // Detiene la operación de compra
                }
                else if(codigoCvv.length() != 3){
                     JOptionPane.showMessageDialog(null, 
                        "El Cvv debe tener exactamente 3 dígitos.", 
                        "Tarjeta Inválida", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                
                }
                
        //Mostramos mensaje de compra exitosa
        JOptionPane.showMessageDialog(
            Panel4.this, 
            "¡Su compra ha sido exitosa!\nGracias por viajar con UNEFACITY AIRLINES.", 
            "Compra Completada", 
            JOptionPane.INFORMATION_MESSAGE
        );
            registro.registrar(nVuelo, totalPago, asientosFinales);
            
            
        //volvemos a la interfaz principal
        
        // 2. Localizamos la ventana JFrame principal en la memoria del programa
        Window ventana = SwingUtilities.getWindowAncestor(Panel4.this);
        if (ventana instanceof InterfazPrincipal) {
            // 3. Ordenamos la restauración del panel inferior y reinicio de la barra
            ((InterfazPrincipal) ventana).restaurarTodoAlEstadoInicial();
        
        }
        
    }//GEN-LAST:event_BtnComprarActionPerformed

    private void NtarjetaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NtarjetaFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NtarjetaFActionPerformed

    private void CvvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CvvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CvvActionPerformed

    private void NombreTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreTarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreTarjetaActionPerformed

    private void BtnMasterCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMasterCardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnMasterCardActionPerformed

    private void BtnMasterCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMasterCardMouseClicked

        BtnMasterCard.setBorderPainted(true);
        BtnMasterCard.setBorder(bordeSeleccionado);

        // Le quitamos el borde a Visa para desmarcarla
        BtnVisa.setBorderPainted(false);
        System.out.println("Método de pago seleccionado: MASTERCARD");

    }//GEN-LAST:event_BtnMasterCardMouseClicked

    private void BtnVisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVisaActionPerformed
        BtnVisa.setBorderPainted(true);
        BtnVisa.setBorder(bordeSeleccionado);

        // Le quitamos el borde a Mastercard para desmarcarla
        BtnMasterCard.setBorderPainted(false);
        System.out.println("Método de pago seleccionado: VISA");
    }//GEN-LAST:event_BtnVisaActionPerformed

    private void NtarjetaFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NtarjetaFKeyTyped
        // TODO add your handling code here:
            char c = evt.getKeyChar();

        // 1. Si no es un número entre 0 y 9, cancelamos la pulsación de la tecla
        if (!Character.isDigit(c)) {
            evt.consume();
            return;
        }

        // 2. Si ya hay 16 caracteres escritos, bloqueamos la entrada de más dígitos
        if (NtarjetaF.getText().length() >= 16) {
            evt.consume();
        }
    }//GEN-LAST:event_NtarjetaFKeyTyped

    private void CvvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CvvKeyTyped
                char c = evt.getKeyChar();

          // 1. Si NO es un dígito (0-9), cancelamos la pulsación inmediatamente
          if (!Character.isDigit(c)) {
              evt.consume();
              return;
          }

          // 2. Tu validación existente: bloquear la entrada si ya alcanzó los 3 caracteres
          if (Cvv.getText().length() >= 3) {
              evt.consume();
          }
    }//GEN-LAST:event_CvvKeyTyped

    private void NombreTarjetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreTarjetaKeyTyped
             char c = evt.getKeyChar();

            // Si NO es una letra Y tampoco es un espacio en blanco, cancelamos la pulsación
            if (!Character.isLetter(c) && c != ' ') {
                evt.consume(); // Bloquea números y caracteres especiales
            }
    }//GEN-LAST:event_NombreTarjetaKeyTyped
    javax.swing.border.Border bordeSeleccionado = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(20, 50, 95), 2, true);

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnComprar;
    private javax.swing.JButton BtnMasterCard;
    private javax.swing.JButton BtnVisa;
    private javax.swing.JPasswordField Cvv;
    private com.toedter.calendar.JDateChooser FechaN;
    private javax.swing.JPanel Formulario;
    private javax.swing.JTextField NombreTarjeta;
    private javax.swing.JLabel Ntarjeta;
    private javax.swing.JTextField NtarjetaF;
    private javax.swing.JLabel asientosSelec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelbase;
    private javax.swing.JLabel labelcodigovuelo;
    private javax.swing.JLabel labelimpuesto;
    private javax.swing.JLabel labelruta;
    private javax.swing.JLabel labelsalida;
    private javax.swing.JLabel labeltotal;
    private javax.swing.JLabel labeltotalpago;
    private javax.swing.JPanel preciovuelo;
    private javax.swing.JPanel resumenvuelo;
    // End of variables declaration//GEN-END:variables
}
