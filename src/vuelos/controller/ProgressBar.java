package vuelos.controller; // <-- Cambia esto por el nombre real de tu paquete

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;

public class ProgressBar extends JPanel {
    
    private int pasoActual = 1;

    public ProgressBar() {
        // Configuraciones iniciales básicas
        this.setPreferredSize(new java.awt.Dimension(400, 80)); 
        this.setBackground(new java.awt.Color(11, 29, 58));
    }

    // Método público para actualizar el paso desde cualquier lugar
    public void setPasoActual(int paso) {
        if (paso >= 1 && paso <= 3) {
            this.pasoActual = paso;
            this.repaint(); // Redibuja automáticamente al cambiar el paso
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int centerY = (h / 2) -10 ;

        int x1 = w / 6;
        int x2 = w / 2;
        int x3 = (w * 5) / 6;
        int radio = 16;

        Color colorBlanco = new Color(245, 242, 235);
        Color colorVerde = new Color(76, 175, 137);

        // Línea conectora base
        g2.setColor(colorBlanco);
        g2.setStroke(new BasicStroke(6));
        g2.drawLine(x1, centerY, x3, centerY);

        // --- PASO 1 ---
        if (pasoActual >= 1) {
            g2.setColor(colorBlanco);
            g2.fillOval(x1 - radio - 2, centerY - radio - 2, (radio * 2) + 4, (radio * 2) + 4);
            g2.setColor(colorVerde);
            g2.fillOval(x1 - radio, centerY - radio, radio * 2, radio * 2);
        }

        // --- PASO 2 ---
        if (pasoActual >= 2) {
            g2.setColor(colorBlanco);
            g2.fillOval(x2 - radio - 2, centerY - radio - 2, (radio * 2) + 4, (radio * 2) + 4);
            g2.setColor(colorVerde);
            g2.fillOval(x2 - radio, centerY - radio, radio * 2, radio * 2);
        } else {
            g2.setColor(colorBlanco);
            g2.fillOval(x2 - radio, centerY - radio, radio * 2, radio * 2);
        }

        // --- PASO 3 ---
        if (pasoActual >= 3) {
            g2.setColor(colorBlanco);
            g2.fillOval(x3 - radio - 2, centerY - radio - 2, (radio * 2) + 4, (radio * 2) + 4);
            g2.setColor(colorVerde);
            g2.fillOval(x3 - radio, centerY - radio, radio * 2, radio * 2);
        } else {
            g2.setColor(colorBlanco);
            g2.fillOval(x3 - radio, centerY - radio, radio * 2, radio * 2);
        }
    
    
        g2.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12)); // Tipo de letra
        g2.setColor(colorBlanco); // Color del texto

        // Textos correspondientes a cada fase
        String t1 = "Selección de Destino";
        String t2 = "Selección de vuelo";
        String t3 = "Selección de asientos";

        // Calculamos el ancho de cada texto para centrarlo perfectamente bajo su círculo
        int anchoT1 = g2.getFontMetrics().stringWidth(t1);
        int anchoT2 = g2.getFontMetrics().stringWidth(t2);
        int anchoT3 = g2.getFontMetrics().stringWidth(t3);

        // Posición vertical del texto (debajo de los círculos)
        int textoY = centerY + radio + 20; 

        // Dibujamos cada texto en su coordenada correspondiente
        g2.drawString(t1, x1 - (anchoT1 / 2), textoY);
        g2.drawString(t2, x2 - (anchoT2 / 2), textoY);
        g2.drawString(t3, x3 - (anchoT3 / 2), textoY);
    }
}
    
    

