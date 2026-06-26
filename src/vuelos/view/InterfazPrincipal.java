package vuelos.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import vuelos.controller.ProgressBar;
import java.util.Date;
import vuelos.controller.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
/**
 *
 * @author Todos
 */
public class InterfazPrincipal extends javax.swing.JFrame {
    private ControladorRutas controladorRutas;
    private ProgressBar barra;
    
    // Variables para almacenar el respaldo de la pantalla de búsqueda
    private java.awt.Component[] componentesOrigenDestinoRespaldados;
    private java.awt.LayoutManager layoutOrigenDestinoOriginal;

    
    public InterfazPrincipal() {
        initComponents();
  
        // Cambiamos su tipografía y color de letras para que combine con el estilo nuevo
        jButtonSiguiente.setForeground(Color.WHITE);
        jButtonSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));

        // Sobreescribimos el método de dibujo del botón existente directamente en tu interfaz
       

        // Instancias tu nuevo componente de cabina
        
        /*Buscas tu panel vacío de NetBeans donde irá el mapa (ej. jPanelContenedorAsientos)
        jPanelSeleccionDeVuelos.setLayout(new BorderLayout());
        jPanelSeleccionDeVuelos.add(cabina, BorderLayout.CENTER);
        jPanelSeleccionDeVuelos.validate();
        jPanelSeleccionDeVuelos.repaint();*/
        
        // Estilo moderno para el botón de 3 líneas
        btnMenu.setText("≡"); // Caracter de hamburguesa
        btnMenu.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 35));
        btnMenu.setForeground(java.awt.Color.WHITE);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        btnMenu.setFocusPainted(false);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        btnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
    
        // EFECTO HOVER: Cuando el mouse entra al botón
        @Override
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            // Se ilumina a un amarillo/dorado elegante que combina con aerolíneas
            btnMenu.setForeground(new java.awt.Color(205, 255, 255)); 
        }

        // EFECTO HOVER SALIDA: Cuando el mouse sale del botón
        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnMenu.setForeground(java.awt.Color.WHITE); // Vuelve a su blanco original
        }

        // EFECTO CLIC: Cuando el usuario presiona el botón
        @Override
        public void mousePressed(java.awt.event.MouseEvent evt) {
            // Se oscurece un poco el dorado para simular que fue hundido
            btnMenu.setForeground(new java.awt.Color(148, 231, 255)); 
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            // Si el mouse sigue adentro al soltarlo, vuelve al color del hover (dorado)
            if (btnMenu.getMousePosition() != null) {
        // EFECTO LIBERAR CLIC: Cuando suelta el botón dentro del área
                btnMenu.setForeground(new java.awt.Color(212, 175, 55));
                btnMenu.setForeground(java.awt.Color.WHITE);
             } else {
           }
        }
    }); 
        
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
    
    
            /**
         * Guarda en memoria los combos, listas y asientos antes de cambiar de pantalla.
         */
        public void guardarPantallaBusquedaOriginal() {
            if (this.PanelOrigenDestino != null) {
                this.componentesOrigenDestinoRespaldados = this.PanelOrigenDestino.getComponents();
                this.layoutOrigenDestinoOriginal = this.PanelOrigenDestino.getLayout();
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
    private javax.swing.JPanel panelLateral;
    private javax.swing.JPanel contenedorTickets;

    private void configurarMenuLateral() {
       // 1. Crear el panel principal del menú
        panelLateral = new javax.swing.JPanel();
        panelLateral.setBackground(new java.awt.Color(239, 246, 252)); // Color celeste claro
        panelLateral.setLayout(new java.awt.BorderLayout());

        // --- PANEL DE ENCABEZADO PARA TÍTULO Y EQUIS ---
        javax.swing.JPanel pnlHeader = new javax.swing.JPanel(new java.awt.BorderLayout());
        pnlHeader.setBackground(new java.awt.Color(239, 246, 252));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 10));

        // Título en Azul Oscuro
        javax.swing.JLabel titulo = new javax.swing.JLabel("GESTIÓN DE VUELOS PENDIENTES");
        titulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 15));
        titulo.setForeground(new java.awt.Color(10, 34, 64)); 
        pnlHeader.add(titulo, java.awt.BorderLayout.WEST);

        // BOTÓN EQUIS (X) PARA CERRAR
        javax.swing.JButton btnCerrar = new javax.swing.JButton("X");
        btnCerrar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20));
        btnCerrar.setForeground(new java.awt.Color(10, 34, 64)); // Azul oscuro inicial
        btnCerrar.setContentAreaFilled(false); 
        btnCerrar.setBorderPainted(false);    
        btnCerrar.setFocusPainted(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        // Acción para cerrar el panel al darle clic a la X
        btnCerrar.addActionListener(e -> {
            panelLateral.setBounds(this.getWidth(), 0, 350, this.getHeight()); // Lo esconde a la derecha
            menuAbierto = false; // Resetea el estado para el botón de 3 líneas
        });
        
        // Efecto Hover para la X (Corregido para volver al azul oscuro original en lugar de blanco)
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrar.setForeground(new java.awt.Color(255, 100, 100)); // Rojo al pasar encima
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrar.setForeground(new java.awt.Color(10, 34, 64)); // Vuelve a azul oscuro
            }
         });

        // Lógica para cerrar al presionar la X
        btnCerrar.addActionListener(e -> {
            panelLateral.setBounds(this.getWidth(), 0, 350, this.getHeight()); // Lo saca de pantalla
            menuAbierto = false; // Resetea el estado para que el botón de 3 líneas funcione bien
        });

        pnlHeader.add(btnCerrar, java.awt.BorderLayout.EAST);
        panelLateral.add(pnlHeader, java.awt.BorderLayout.NORTH);
        // -----------------------------------------------------

        // 2. Contenedor de los tickets (donde se irán sumando)
        contenedorTickets = new javax.swing.JPanel();
        contenedorTickets.setBackground(new java.awt.Color(239, 246, 252));
        contenedorTickets.setLayout(new javax.swing.BoxLayout(contenedorTickets, javax.swing.BoxLayout.Y_AXIS));

        // Scroll para cuando haya muchos vuelos
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(contenedorTickets);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        panelLateral.add(scroll, java.awt.BorderLayout.CENTER);

        // 3. Añadir el panel al LayeredPane del Frame (para que flote sobre todo)
        panelLateral.setBounds(this.getWidth(), 0, 350, this.getHeight()); 
        this.getLayeredPane().add(panelLateral, javax.swing.JLayeredPane.PALETTE_LAYER);

        // Ejemplo: Agregar un vuelo de prueba
        agregarVueloAlMenu("Vuelo #102", "Maracaibo -> Bogotá", "12/10/2024", "$150.00");
    }

    // MÉDITO PARA AGREGAR TICKETS DINÁMICAMENTE
    public void agregarVueloAlMenu(String id, String ruta, String fecha, String precio) {
        // 1. Crear el panel contenedor del ticket
         javax.swing.JPanel ticket = new javax.swing.JPanel();
         ticket.setBackground(java.awt.Color.WHITE); // Fondo blanco puro
         ticket.setMaximumSize(new java.awt.Dimension(330, 120)); // Un pelín más alto para la sombra curva
    
        // 2. EL TRUCO: BORDE PERSONALIZADO REDONDEADO CON SOMBRA SUAVE
        javax.swing.border.Border bordeSombraRedondeado = new javax.swing.border.AbstractBorder() {
            @Override
            public void paintBorder(java.awt.Component c, java.awt.Graphics g, int x, int y, int width, int height) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                // Pintar la Sombra Difuminada de la esquina (Gris azulado traslúcido)
                g2.setColor(new java.awt.Color(180, 195, 210, 90));
                g2.fillRoundRect(x + 2, y + 3, width - 4, height - 5, 18, 18);
                g2.setColor(new java.awt.Color(180, 195, 210, 45));
                g2.fillRoundRect(x + 1, y + 2, width - 2, height - 3, 18, 18);

                // Pintar el fondo blanco de la tarjeta para que tape la sombra interna
                g2.setColor(java.awt.Color.WHITE);
                g2.fillRoundRect(x, y, width - 4, height - 5, 16, 16);

                // Pintar el contorno Gris Claro del Ticket
                g2.setColor(new java.awt.Color(210, 215, 220));
                g2.setStroke(new java.awt.BasicStroke(1.2f)); // Grosor de línea suave
                g2.drawRoundRect(x, y, width - 4, height - 5, 16, 16);

                g2.dispose();
            }

            @Override
            public java.awt.Insets getBorderInsets(java.awt.Component c) {
                // Define el espacio que ocupa el borde (arriba, izquierda, abajo, derecha)
                return new java.awt.Insets(1, 1, 6, 5);
            }
        };

        // 3. MARGEN INTERNO: Para que los textos no toquen las curvas
        javax.swing.border.Border margenInterno = javax.swing.BorderFactory.createEmptyBorder(12, 14, 12, 14);

        // 4. Fusionar el diseño personalizado con los márgenes internos
        ticket.setBorder(javax.swing.BorderFactory.createCompoundBorder(bordeSombraRedondeado, margenInterno));
        ticket.setOpaque(false); // IMPORTANTE: true haría que las esquinas muestren un fondo cuadrado feo

        // Layout base de tu tarjeta
        ticket.setLayout(new java.awt.GridLayout(3, 1, 4, 4));

        contenedorTickets.add(ticket);
        // Agrega una separación vertical de 12 píxeles antes del siguiente ticket
        contenedorTickets.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 12))); 
        contenedorTickets.revalidate();
        
        javax.swing.JLabel lblRuta = new javax.swing.JLabel("✈ " + ruta);
        lblRuta.setForeground(new java.awt.Color(65, 65, 65));
        lblRuta.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 15));

        javax.swing.JLabel lblDetalle = new javax.swing.JLabel(fecha + " | " + precio);
        lblDetalle.setForeground(new java.awt.Color(65, 65, 65));

        // Panel de botones (Modificar y Eliminar)
        javax.swing.JPanel pnlBotones = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pnlBotones.setOpaque(false);

        javax.swing.JButton btnEdit = new javax.swing.JButton("Modificar");
        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 10));

        javax.swing.JButton btnDelete = new javax.swing.JButton("Eliminar");
        btnDelete.setBackground(new java.awt.Color(255, 65, 65));
        btnDelete.setForeground(java.awt.Color.WHITE);

        pnlBotones.add(btnEdit);
        pnlBotones.add(btnDelete);

        ticket.add(lblRuta);
        ticket.add(lblDetalle);
        ticket.add(pnlBotones);

        // Lógica para eliminar
        btnDelete.addActionListener(e -> {
            contenedorTickets.remove(ticket);
            contenedorTickets.revalidate();
            contenedorTickets.repaint();
        });

        contenedorTickets.add(ticket);
        contenedorTickets.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 5)));
        contenedorTickets.revalidate();
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
        btnMenu = new javax.swing.JButton();
        PanelOrigenDestino = new javax.swing.JPanel();
        jPanelSeleccionDeDatos = new javax.swing.JPanel();
        jComboBoxOrigen = new javax.swing.JComboBox<>();
        jComboBoxDestino = new javax.swing.JComboBox<>();
        jLabelDestino = new javax.swing.JLabel();
        btnBuscar = new vuelos.controller.BotonEstilizado();
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
        jButtonSiguiente = new vuelos.controller.BotonEstilizado("Siguiente")
        ;

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

        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
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
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelLogoLayout.setVerticalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogoLayout.createSequentialGroup()
                .addGroup(PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(PanelLogoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMenu)
                            .addComponent(jPanelProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2))
        );

        PanelOrigenDestino.setBackground(new java.awt.Color(255, 255, 255));

        jPanelSeleccionDeDatos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSeleccionDeDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detalle de salida"));

        jComboBoxOrigen.setEditable(true);
        jComboBoxOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOrigenActionPerformed(evt);
            }
        });

        jComboBoxDestino.setEditable(true);
        jComboBoxDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDestinoActionPerformed(evt);
            }
        });

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
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                    .addGroup(jPanelSeleccionDeDatosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelSeleccionDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDestino)
                            .addComponent(jLabelOrigen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelSeleccionDeDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        jPanelVuelos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelVuelos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Vuelos Disponibles"));

        javax.swing.GroupLayout jPanelVuelosLayout = new javax.swing.GroupLayout(jPanelVuelos);
        jPanelVuelos.setLayout(jPanelVuelosLayout);
        jPanelVuelosLayout.setHorizontalGroup(
            jPanelVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 184, Short.MAX_VALUE)
        );
        jPanelVuelosLayout.setVerticalGroup(
            jPanelVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );

        jPanelInformacion.setBackground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap(110, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jLabelLeyendaAD, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanellLeyendaAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelLeyendaAS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanellLeyendaAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabelLeyendaAND)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanellLeyendaAND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelOrigenDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelSeleccionDeDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(PanelOrigenDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelOrigenDestinoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelOrigenDestinoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanelSeleccionDeVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
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
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
                   
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
                    buscador.actualizarPanelVuelos(jPanelVuelos, resultados,jPanelSeleccionDeVuelos,barra,jPanelSiguiente,jButtonSiguiente);
                                                                     
                     barra.setPasoActual(2); 
        } else {
            System.out.println("No se pudo procesar: Datos de las ciudades incorrectos.");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private boolean menuAbierto = false;
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        if (panelLateral == null) configurarMenuLateral(); // Inicializa si no existe
    
        // Animación simple: si está abierto lo esconde, si está cerrado lo muestra
        if (!menuAbierto) {
            panelLateral.setBounds(this.getWidth() - 350, 0, 350, this.getHeight());
            menuAbierto = true;
        } else {
            panelLateral.setBounds(this.getWidth(), 0, 350, this.getHeight());
            menuAbierto = false;
        }
    }//GEN-LAST:event_btnMenuActionPerformed

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
            // 1. Guardamos el ancho y el alto actuales del panel contenedor
            // 1. Guardamos los paneles de búsqueda y asientos en la memoria privada
            guardarPantallaBusquedaOriginal();
            PanelLogo.remove(btnMenu);
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

    private void jComboBoxOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxOrigenActionPerformed

    private void jComboBoxDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDestinoActionPerformed

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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMenu;
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
