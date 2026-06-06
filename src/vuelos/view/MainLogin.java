/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuelos.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kasey
 */
public class MainLogin extends javax.swing.JFrame {

    /**
     * Creates new form MainLogin
     */
    public MainLogin() {
        initComponents();
        javax.swing.ToolTipManager.sharedInstance().setInitialDelay(50);
        panelDerecha.requestFocusInWindow();
        this.setResizable(false);
       // 1. El borde exterior gris de 1px
        javax.swing.border.Border lineaGris = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 1);
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        javax.swing.border.Border bordeFinal = javax.swing.BorderFactory.createCompoundBorder(lineaGris, padding);
        //campos:
        campoCorreo.setBorder(bordeFinal);
        campoContrasena.setBorder(bordeFinal);
        campoNombreRegistro.setBorder(bordeFinal);
        campoApellidoRegistro.setBorder(bordeFinal);
        campoCorreoRegistro.setBorder(bordeFinal);
        campoCedulaRegistro.setBorder(bordeFinal);
        campoTelefonoRegistro.setBorder(bordeFinal);
        campoContrasenaRegistro.setBorder(bordeFinal);
        
        try {
    // 1. Buscamos la imagen dentro del paquete del proyecto usando la ruta relativa
    java.net.URL urlIcono = getClass().getResource("/imagenes/logoAvion.png");
    
    if (urlIcono != null) {
        // 2. Convertimos la URL en una imagen de Toolkit
        Image icono = Toolkit.getDefaultToolkit().getImage(urlIcono);
        
        // 3. Le asignamos el nuevo icono al JFrame
        setIconImage(icono);
    } else {
        System.err.println("No se pudo encontrar el archivo del icono. Verifica la ruta.");
    }
} catch (Exception e) {
    System.err.println("Error al cargar el icono de la ventana: " + e.getMessage());
}
    }
    
    public void Focusear(){
    
    this.requestFocusInWindow();
    
    }
    
    
    private void transicionCardLayout(javax.swing.JPanel contenedor, javax.swing.JPanel panelActual, javax.swing.JPanel panelNuevo, String nombreCartaNueva) {
    // 1. Crear imágenes en memoria de ambos paneles para la animación
    java.awt.image.BufferedImage imgActual = new java.awt.image.BufferedImage(panelActual.getWidth(), panelActual.getHeight(), java.awt.image.BufferedImage.TYPE_INT_ARGB);
    java.awt.image.BufferedImage imgNueva = new java.awt.image.BufferedImage(panelNuevo.getWidth(), panelNuevo.getHeight(), java.awt.image.BufferedImage.TYPE_INT_ARGB);
    
    panelActual.paint(imgActual.getGraphics());
    panelNuevo.setBounds(0, 0, panelActual.getWidth(), panelActual.getHeight());
    panelNuevo.doLayout();
    panelNuevo.paint(imgNueva.getGraphics());
    
    // 2. Creamos un arreglo de un solo elemento para poder modificar xOffset desde adentro del Timer sin errores de scope
    final int[] xOffset = {0};
    int velocidad = 20; // Modifica este número para cambiar la velocidad del slide
    
    // 3. Crear el panel temporal que dibujará el deslizamiento
    javax.swing.JPanel panelAnimacion = new javax.swing.JPanel() {
        @Override
        protected void paintComponent(java.awt.Graphics g) { // <- 'Graphics' con G mayúscula corregido
            super.paintComponent(g);
            // Dibuja el panel actual moviéndose a la izquierda
            g.drawImage(imgActual, -xOffset[0], 0, null);
            // Dibuja el panel nuevo entrando desde la derecha
            g.drawImage(imgNueva, panelActual.getWidth() - xOffset[0], 0, null);
        }
    };
    
    // 4. Añadir temporalmente el panel de animación al CardLayout
    contenedor.add(panelAnimacion, "temp_anim");
    java.awt.CardLayout layout = (java.awt.CardLayout) contenedor.getLayout();
    layout.show(contenedor, "temp_anim");
    
    // 5. Temporizador para controlar los cuadros de la animación
    javax.swing.Timer timer = new javax.swing.Timer(10, null);
    timer.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            xOffset[0] += velocidad; // Desplazamos los píxeles
            
            if (xOffset[0] < panelActual.getWidth()) {
                panelAnimacion.repaint(); // Redibuja el cuadro
            } else {
                timer.stop(); // Detiene la animación al llegar al final
                layout.show(contenedor, nombreCartaNueva); // Muestra la carta real definitiva
                contenedor.remove(panelAnimacion); // Elimina el panel temporal
                contenedor.repaint();
                contenedor.revalidate();
            }
        }
    });
    timer.start();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelIzquierda = new javax.swing.JPanel();
        labelBienvenida = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        panelDerecha = new javax.swing.JPanel();
        panelLogin = new javax.swing.JPanel();
        laberIniciarSesion = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        labelContrasena = new javax.swing.JLabel();
        campoCorreo = new javax.swing.JTextField();
        campoContrasena = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        panelRegistro = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        labelRegistro = new javax.swing.JLabel();
        labelNombreRegistro = new javax.swing.JLabel();
        labelApellidoRegistro = new javax.swing.JLabel();
        labelCedulaRegistro = new javax.swing.JLabel();
        labelTelefonoRegistro = new javax.swing.JLabel();
        labelCorreoRegistro = new javax.swing.JLabel();
        labelContrasenaRegistro = new javax.swing.JLabel();
        campoNombreRegistro = new javax.swing.JTextField();
        campoApellidoRegistro = new javax.swing.JTextField();
        campoCedulaRegistro = new javax.swing.JTextField();
        campoTelefonoRegistro = new javax.swing.JTextField();
        campoCorreoRegistro = new javax.swing.JTextField();
        campoContrasenaRegistro = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        labelAviso1 = new javax.swing.JLabel();
        labelAviso2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 450));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        panelIzquierda.setBackground(new java.awt.Color(11, 29, 58));
        panelIzquierda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelIzquierdaMouseClicked(evt);
            }
        });
        panelIzquierda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelIzquierdaKeyPressed(evt);
            }
        });

        labelBienvenida.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        labelBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBienvenida.setText("¡Bienvenido!");
        labelBienvenida.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelBienvenida.setAlignmentX(0.5F);

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("<html><center>Sistema de<br>ventas de boletos aereos</center></html>");
        labelTitulo.setAlignmentX(0.5F);
        labelTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/avionProyecto.PNG"))); // NOI18N
        labelLogo.setAlignmentX(0.5F);
        labelLogo.setAlignmentY(0.7F);

        javax.swing.GroupLayout panelIzquierdaLayout = new javax.swing.GroupLayout(panelIzquierda);
        panelIzquierda.setLayout(panelIzquierdaLayout);
        panelIzquierdaLayout.setHorizontalGroup(
            panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzquierdaLayout.createSequentialGroup()
                .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIzquierdaLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelLogo)
                            .addComponent(labelBienvenida)))
                    .addGroup(panelIzquierdaLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        panelIzquierdaLayout.setVerticalGroup(
            panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIzquierdaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(labelBienvenida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(labelLogo)
                .addGap(34, 34, 34)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );

        getContentPane().add(panelIzquierda);

        panelDerecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelDerechaMouseClicked(evt);
            }
        });
        panelDerecha.setLayout(new java.awt.CardLayout());

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelLoginMouseClicked(evt);
            }
        });

        laberIniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        laberIniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        laberIniciarSesion.setText("INICIAR SESIÓN ");
        laberIniciarSesion.setAlignmentX(0.5F);

        labelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelUsuario.setText("CORREO:");

        labelContrasena.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelContrasena.setText("CONTRASEÑA:");

        campoCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoCorreo.setPreferredSize(new java.awt.Dimension(30, 35));
        campoCorreo.setSelectionColor(new java.awt.Color(0, 51, 204));
        campoCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCorreoFocusLost(evt);
            }
        });
        campoCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoCorreoMouseClicked(evt);
            }
        });
        campoCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCorreoActionPerformed(evt);
            }
        });
        campoCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCorreoKeyTyped(evt);
            }
        });

        campoContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoContrasena.setEchoChar('\u2022');
        campoContrasena.setPreferredSize(new java.awt.Dimension(30, 35));
        campoContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoContrasenaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoContrasenaFocusLost(evt);
            }
        });
        campoContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoContrasenaActionPerformed(evt);
            }
        });

        btnIngresar.setBackground(new java.awt.Color(11, 29, 58));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setPreferredSize(new java.awt.Dimension(83, 50));
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarMouseClicked(evt);
            }
        });
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnRegistro.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistro.setForeground(new java.awt.Color(0, 102, 204));
        btnRegistro.setText("Si no tienes cuenta, click aqui");
        btnRegistro.setActionCommand("<html><u>¿No tienes cuenta? Regístrate aquí</u></html>");
        btnRegistro.setAlignmentX(0.5F);
        btnRegistro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRegistro.setBorderPainted(false);
        btnRegistro.setContentAreaFilled(false);
        btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistro.setFocusPainted(false);
        btnRegistro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(laberIniciarSesion)
                .addGap(79, 79, 79))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addComponent(btnRegistro)
                        .addGap(96, 96, 96))))
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelContrasena)
                    .addComponent(labelUsuario))
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(laberIniciarSesion)
                .addGap(97, 97, 97)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario)
                    .addComponent(campoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelContrasena)
                    .addComponent(campoContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistro)
                .addContainerGap())
        );

        panelDerecha.add(panelLogin, "panelLogin");

        panelRegistro.setBackground(new java.awt.Color(255, 255, 255));
        panelRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRegistroMouseClicked(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(11, 29, 58));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setPreferredSize(new java.awt.Dimension(85, 50));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        labelRegistro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelRegistro.setText("REGÍSTRATE!");

        labelNombreRegistro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNombreRegistro.setText("NOMBRE:");

        labelApellidoRegistro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelApellidoRegistro.setText("APELLIDO:");

        labelCedulaRegistro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCedulaRegistro.setText("CÉDULA:");

        labelTelefonoRegistro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTelefonoRegistro.setText("TELÉFONO:");

        labelCorreoRegistro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCorreoRegistro.setText("CORREO:");

        labelContrasenaRegistro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelContrasenaRegistro.setText("CONTRASEÑA:");

        campoNombreRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoNombreRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoNombreRegistroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNombreRegistroFocusLost(evt);
            }
        });
        campoNombreRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNombreRegistroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNombreRegistroKeyTyped(evt);
            }
        });

        campoApellidoRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoApellidoRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoApellidoRegistroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoApellidoRegistroFocusLost(evt);
            }
        });
        campoApellidoRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoApellidoRegistroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoApellidoRegistroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoApellidoRegistroKeyTyped(evt);
            }
        });

        campoCedulaRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoCedulaRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoCedulaRegistroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCedulaRegistroFocusLost(evt);
            }
        });
        campoCedulaRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoCedulaRegistroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCedulaRegistroKeyTyped(evt);
            }
        });

        campoTelefonoRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoTelefonoRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoTelefonoRegistroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoTelefonoRegistroFocusLost(evt);
            }
        });
        campoTelefonoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTelefonoRegistroActionPerformed(evt);
            }
        });
        campoTelefonoRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTelefonoRegistroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTelefonoRegistroKeyTyped(evt);
            }
        });

        campoCorreoRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoCorreoRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoCorreoRegistroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCorreoRegistroFocusLost(evt);
            }
        });
        campoCorreoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCorreoRegistroActionPerformed(evt);
            }
        });
        campoCorreoRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoCorreoRegistroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCorreoRegistroKeyTyped(evt);
            }
        });

        campoContrasenaRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoContrasenaRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoContrasenaRegistroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoContrasenaRegistroFocusLost(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(11, 29, 58));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setPreferredSize(new java.awt.Dimension(87, 50));
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
        });
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        labelAviso1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAviso1.setForeground(new java.awt.Color(11, 29, 58));
        labelAviso1.setText("[?]");
        labelAviso1.setToolTipText("<html><body style='font-family: \"Segoe UI\"; font-size: 11px; padding: 3px; color: #333333;'>Máximo 8 caracteres</body></html>");
        labelAviso1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelAviso2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAviso2.setForeground(new java.awt.Color(11, 29, 58));
        labelAviso2.setText("[?]");
        labelAviso2.setToolTipText("<html><body style='font-family: \"Segoe UI\"; font-size: 11px; padding: 3px; color: #333333;'>Máximo 11 caracteres</body></html>");
        labelAviso2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCorreoRegistro)
                    .addComponent(labelContrasenaRegistro)
                    .addComponent(labelTelefonoRegistro)
                    .addComponent(labelCedulaRegistro)
                    .addComponent(labelApellidoRegistro)
                    .addComponent(labelNombreRegistro))
                .addGap(29, 29, 29)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoContrasenaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCorreoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTelefonoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCedulaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoApellidoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombreRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAviso1)
                    .addComponent(labelAviso2))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelRegistro)
                .addGap(94, 94, 94))
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(labelRegistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreRegistro)
                    .addComponent(campoNombreRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelApellidoRegistro)
                    .addComponent(campoApellidoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCedulaRegistro)
                    .addComponent(campoCedulaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAviso1))
                .addGap(24, 24, 24)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefonoRegistro)
                    .addComponent(campoTelefonoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAviso2))
                .addGap(31, 31, 31)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCorreoRegistro)
                    .addComponent(campoCorreoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelContrasenaRegistro)
                    .addComponent(campoContrasenaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelDerecha.add(panelRegistro, "panelRegistro");

        getContentPane().add(panelDerecha);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panelIzquierdaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelIzquierdaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelIzquierdaKeyPressed

    private void panelIzquierdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelIzquierdaMouseClicked
        Focusear();
    }//GEN-LAST:event_panelIzquierdaMouseClicked

    private void panelDerechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDerechaMouseClicked
        Focusear();
    }//GEN-LAST:event_panelDerechaMouseClicked

    private void panelRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistroMouseClicked
        Focusear();
    }//GEN-LAST:event_panelRegistroMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        
        transicionCardLayout(panelDerecha, panelRegistro, panelLogin, "panelLogin");
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void campoTelefonoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelefonoRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTelefonoRegistroActionPerformed

    private void panelLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLoginMouseClicked
        Focusear();
    }//GEN-LAST:event_panelLoginMouseClicked

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
                                             
    // (Panel contenedor, panel que sale, panel que entra, "Nombre de la carta destino")
        transicionCardLayout(panelDerecha, panelLogin, panelRegistro, "panelRegistro");

    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        
        try {
            InterfazPrincipal principal = new InterfazPrincipal();
            principal.hola();
            System.out.println("Interfaz principal inicializada correctamente");
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        vuelos.model.UsuarioInicio usuarioInicio = new vuelos.model.UsuarioInicio(
                campoCorreo.getText(),
                new String(campoContrasena.getText()));
        
        System.out.println(usuarioInicio.getCorreo());
        System.out.println(usuarioInicio.getPassword());
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void campoContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoContrasenaActionPerformed

    private void campoCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCorreoActionPerformed

    }//GEN-LAST:event_campoCorreoActionPerformed

    private void campoCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoCorreoMouseClicked

    }//GEN-LAST:event_campoCorreoMouseClicked

    private void campoCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCorreoFocusLost
        
        
        java.awt.Color colorGris = new java.awt.Color(204, 204, 204);
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeGris = javax.swing.BorderFactory.createLineBorder(colorGris, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeGris, padding));
    
        
    }//GEN-LAST:event_campoCorreoFocusLost

    private void campoCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCorreoFocusGained
        java.awt.Color colorAzulLogo = new java.awt.Color(11,29,58); 
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeAzul = javax.swing.BorderFactory.createLineBorder(colorAzulLogo, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeAzul, padding));
    
    }//GEN-LAST:event_campoCorreoFocusGained

    private void campoContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoContrasenaFocusGained
       
        java.awt.Color colorAzulLogo = new java.awt.Color(11,29,58); 
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeAzul = javax.swing.BorderFactory.createLineBorder(colorAzulLogo, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeAzul, padding));
    }//GEN-LAST:event_campoContrasenaFocusGained

    private void campoContrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoContrasenaFocusLost
        
        
        java.awt.Color colorGris = new java.awt.Color(204, 204, 204);
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeGris = javax.swing.BorderFactory.createLineBorder(colorGris, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeGris, padding));
        
    }//GEN-LAST:event_campoContrasenaFocusLost

    private void campoNombreRegistroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombreRegistroFocusLost
        java.awt.Color colorGris = new java.awt.Color(204, 204, 204);
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeGris = javax.swing.BorderFactory.createLineBorder(colorGris, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeGris, padding));
    }//GEN-LAST:event_campoNombreRegistroFocusLost

    private void campoApellidoRegistroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoApellidoRegistroFocusLost
        java.awt.Color colorGris = new java.awt.Color(204, 204, 204);
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeGris = javax.swing.BorderFactory.createLineBorder(colorGris, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeGris, padding));
    }//GEN-LAST:event_campoApellidoRegistroFocusLost

    private void campoCedulaRegistroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCedulaRegistroFocusLost
        java.awt.Color colorGris = new java.awt.Color(204, 204, 204);
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeGris = javax.swing.BorderFactory.createLineBorder(colorGris, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeGris, padding));
    }//GEN-LAST:event_campoCedulaRegistroFocusLost

    private void campoTelefonoRegistroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoTelefonoRegistroFocusLost
        java.awt.Color colorGris = new java.awt.Color(204, 204, 204);
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeGris = javax.swing.BorderFactory.createLineBorder(colorGris, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeGris, padding));
    }//GEN-LAST:event_campoTelefonoRegistroFocusLost

    private void campoCorreoRegistroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCorreoRegistroFocusLost
        java.awt.Color colorGris = new java.awt.Color(204, 204, 204);
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeGris = javax.swing.BorderFactory.createLineBorder(colorGris, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeGris, padding));
    }//GEN-LAST:event_campoCorreoRegistroFocusLost

    private void campoContrasenaRegistroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoContrasenaRegistroFocusLost
        java.awt.Color colorGris = new java.awt.Color(204, 204, 204);
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeGris = javax.swing.BorderFactory.createLineBorder(colorGris, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeGris, padding));
    }//GEN-LAST:event_campoContrasenaRegistroFocusLost

    private void campoNombreRegistroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombreRegistroFocusGained
        java.awt.Color colorAzulLogo = new java.awt.Color(11,29,58); 
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeAzul = javax.swing.BorderFactory.createLineBorder(colorAzulLogo, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeAzul, padding));
    }//GEN-LAST:event_campoNombreRegistroFocusGained

    private void campoApellidoRegistroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoApellidoRegistroFocusGained
        java.awt.Color colorAzulLogo = new java.awt.Color(11,29,58); 
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeAzul = javax.swing.BorderFactory.createLineBorder(colorAzulLogo, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeAzul, padding));
    }//GEN-LAST:event_campoApellidoRegistroFocusGained

    private void campoCedulaRegistroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCedulaRegistroFocusGained
        java.awt.Color colorAzulLogo = new java.awt.Color(11,29,58); 
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeAzul = javax.swing.BorderFactory.createLineBorder(colorAzulLogo, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeAzul, padding));
    }//GEN-LAST:event_campoCedulaRegistroFocusGained

    private void campoTelefonoRegistroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoTelefonoRegistroFocusGained
        java.awt.Color colorAzulLogo = new java.awt.Color(11,29,58); 
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeAzul = javax.swing.BorderFactory.createLineBorder(colorAzulLogo, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeAzul, padding));
    }//GEN-LAST:event_campoTelefonoRegistroFocusGained

    private void campoCorreoRegistroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCorreoRegistroFocusGained
        java.awt.Color colorAzulLogo = new java.awt.Color(11,29,58); 
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeAzul = javax.swing.BorderFactory.createLineBorder(colorAzulLogo, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeAzul, padding));
    }//GEN-LAST:event_campoCorreoRegistroFocusGained

    private void campoContrasenaRegistroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoContrasenaRegistroFocusGained
        java.awt.Color colorAzulLogo = new java.awt.Color(11,29,58); 
        javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
        
        javax.swing.JTextField campo = (javax.swing.JTextField) evt.getSource();
        javax.swing.border.Border bordeAzul = javax.swing.BorderFactory.createLineBorder(colorAzulLogo, 1);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeAzul, padding));
    }//GEN-LAST:event_campoContrasenaRegistroFocusGained

    private void campoNombreRegistroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreRegistroKeyTyped
        
        char c = evt.getKeyChar();
        // Si no es una letra, ni un espacio, ni la tecla borrar se cancela el tipeo
        if (!Character.isLetter(c) && c != ' ' && c != java.awt.event.KeyEvent.VK_BACK_SPACE) {
            evt.consume(); // Destruye el evento (el carácter no se escribe)
        }
    }//GEN-LAST:event_campoNombreRegistroKeyTyped

    private void campoApellidoRegistroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoApellidoRegistroKeyTyped
        char c = evt.getKeyChar();
        // Si no es una letra, ni un espacio, ni la tecla borrar se cancela el tipeo
        if (!Character.isLetter(c) && c != ' ' && c != java.awt.event.KeyEvent.VK_BACK_SPACE) {
            evt.consume(); // Destruye el evento (el carácter no se escribe)
        }
    }//GEN-LAST:event_campoApellidoRegistroKeyTyped

    private void campoCedulaRegistroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCedulaRegistroKeyTyped
        char c = evt.getKeyChar();
        // 1. Validar que sea número
        if (!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
        // 2. Validar el tamaño máximo de 8 dígitos
        if (campoCedulaRegistro.getText().length() >= 8 && c != java.awt.event.KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_campoCedulaRegistroKeyTyped

    private void campoTelefonoRegistroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefonoRegistroKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
        if (campoTelefonoRegistro.getText().length() >= 11 && c != java.awt.event.KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_campoTelefonoRegistroKeyTyped

    private void campoCorreoRegistroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCorreoRegistroKeyTyped
        char c = evt.getKeyChar();
        // Permite letras, números, arroba, punto, guion y borrar
        if (!Character.isLetterOrDigit(c) && c != '@' && c != '.' && c != '-' && c != '_' && c != java.awt.event.KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_campoCorreoRegistroKeyTyped

    private void campoNombreRegistroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreRegistroKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            // Le transfiere automáticamente el foco al siguiente componente en orden
            ((javax.swing.JComponent) evt.getSource()).transferFocus();}
    }//GEN-LAST:event_campoNombreRegistroKeyPressed

    private void campoApellidoRegistroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoApellidoRegistroKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_campoApellidoRegistroKeyReleased

    private void campoApellidoRegistroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoApellidoRegistroKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            // Le transfiere automáticamente el foco al siguiente componente en orden
            ((javax.swing.JComponent) evt.getSource()).transferFocus();}
    }//GEN-LAST:event_campoApellidoRegistroKeyPressed

    private void campoCedulaRegistroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCedulaRegistroKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            // Le transfiere automáticamente el foco al siguiente componente en orden
            ((javax.swing.JComponent) evt.getSource()).transferFocus();}
    }//GEN-LAST:event_campoCedulaRegistroKeyPressed

    private void campoTelefonoRegistroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefonoRegistroKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            // Le transfiere automáticamente el foco al siguiente componente en orden
            ((javax.swing.JComponent) evt.getSource()).transferFocus();}
    }//GEN-LAST:event_campoTelefonoRegistroKeyPressed

    private void campoCorreoRegistroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCorreoRegistroKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            // Le transfiere automáticamente el foco al siguiente componente en orden
            ((javax.swing.JComponent) evt.getSource()).transferFocus();}
    }//GEN-LAST:event_campoCorreoRegistroKeyPressed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        vuelos.model.Usuario nuevoUsuario = new vuelos.model.Usuario(
            campoNombreRegistro.getText(),
            campoApellidoRegistro.getText(),
            campoCedulaRegistro.getText(),
            campoTelefonoRegistro.getText(),
            campoCorreoRegistro.getText(),
            campoContrasenaRegistro.getText());
        
        System.out.println(nuevoUsuario.getNombre());
        System.out.println(nuevoUsuario.getApellido());
        System.out.println(nuevoUsuario.getCedula());
        System.out.println(nuevoUsuario.getTelefono());
        System.out.println(nuevoUsuario.getCorreo());
        System.out.println(nuevoUsuario.getContrasena());
        

// ¡Listo! Ya tienes toda la información del pasajero compactada en un solo objeto 'nuevoUsuario'
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void campoCorreoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCorreoRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCorreoRegistroActionPerformed

    private void campoCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCorreoKeyTyped
        char c = evt.getKeyChar();
        // Permite letras, números, arroba, punto, guion y borrar
        if (!Character.isLetterOrDigit(c) && c != '@' && c != '.' && c != '-' && c != '_' && c != java.awt.event.KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_campoCorreoKeyTyped

    private void btnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseClicked
        java.awt.Color colorRojoError = new java.awt.Color(255, 51, 51);
    javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
    javax.swing.border.Border bordeRojo = javax.swing.BorderFactory.createCompoundBorder(
        javax.swing.BorderFactory.createLineBorder(colorRojoError, 1), padding
    );
    
    boolean faltanCampos = false;

    // 2. Validamos el campo de Correo
    if (campoCorreo.getText().trim().isEmpty()) {
        campoCorreo.setBorder(bordeRojo);
        faltanCampos = true;
    }

    // 3. Validamos la Contraseña
    if (new String(campoContrasena.getPassword()).trim().isEmpty()) {
        campoContrasena.setBorder(bordeRojo);
        faltanCampos = true;
    }

    // 4. Verificamos el resultado
    if (faltanCampos) {
        // Ventana flotante moderna de advertencia
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Por favor, complete todos los campos obligatorios.", 
            "Campos Incompletos", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
    } else {
        // ¡Todo está lleno! Aquí colocas tu lógica normal para iniciar sesión
        System.out.println("Procediendo al login...");
    }
    }//GEN-LAST:event_btnIngresarMouseClicked

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        java.awt.Color colorRojoError = new java.awt.Color(255, 51, 51);
    javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8);
    javax.swing.border.Border bordeRojo = javax.swing.BorderFactory.createCompoundBorder(
        javax.swing.BorderFactory.createLineBorder(colorRojoError, 1), padding
    );
    
    boolean faltanCampos = false;

    // Barrido de los 6 campos
    if (campoNombreRegistro.getText().trim().isEmpty()) { campoNombreRegistro.setBorder(bordeRojo); faltanCampos = true; }
    if (campoApellidoRegistro.getText().trim().isEmpty()) { campoApellidoRegistro.setBorder(bordeRojo); faltanCampos = true; }
    if (campoCedulaRegistro.getText().trim().isEmpty()) { campoCedulaRegistro.setBorder(bordeRojo); faltanCampos = true; }
    if (campoTelefonoRegistro.getText().trim().isEmpty()) { campoTelefonoRegistro.setBorder(bordeRojo); faltanCampos = true; }
    if (campoCorreoRegistro.getText().trim().isEmpty()) { campoCorreoRegistro.setBorder(bordeRojo); faltanCampos = true; }
    if (campoContrasenaRegistro.getText().trim().isEmpty()) { campoContrasenaRegistro.setBorder(bordeRojo); faltanCampos = true; }

    if (faltanCampos) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Faltan campos por rellenar en el formulario de registro.", 
            "Registro Incompleto", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
    } else {
        // ¡Espectacular! Todo está lleno. Aquí creas tu objeto Usuario y guardas
        System.out.println("Procediendo a registrar usuario...");
    }
    }//GEN-LAST:event_btnRegistrarMouseClicked

    /**
     * @param args the command line arguments
     */
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
                new MainLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JTextField campoApellidoRegistro;
    private javax.swing.JTextField campoCedulaRegistro;
    private javax.swing.JPasswordField campoContrasena;
    private javax.swing.JTextField campoContrasenaRegistro;
    private javax.swing.JTextField campoCorreo;
    private javax.swing.JTextField campoCorreoRegistro;
    private javax.swing.JTextField campoNombreRegistro;
    private javax.swing.JTextField campoTelefonoRegistro;
    private javax.swing.JLabel labelApellidoRegistro;
    private javax.swing.JLabel labelAviso1;
    private javax.swing.JLabel labelAviso2;
    private javax.swing.JLabel labelBienvenida;
    private javax.swing.JLabel labelCedulaRegistro;
    private javax.swing.JLabel labelContrasena;
    private javax.swing.JLabel labelContrasenaRegistro;
    private javax.swing.JLabel labelCorreoRegistro;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelNombreRegistro;
    private javax.swing.JLabel labelRegistro;
    private javax.swing.JLabel labelTelefonoRegistro;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel laberIniciarSesion;
    private javax.swing.JPanel panelDerecha;
    private javax.swing.JPanel panelIzquierda;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelRegistro;
    // End of variables declaration//GEN-END:variables
}
