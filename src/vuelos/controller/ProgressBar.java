package vuelos.controller; 

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;

public class ProgressBar extends JPanel {
    
    // Cambiamos el límite máximo a 4 pasos
    private int pasoActual = 1;

    public ProgressBar() {
        // Configuraciones iniciales básicas
        this.setPreferredSize(new java.awt.Dimension(500, 80)); // Ampliado ligeramente para acomodar 4 textos
        this.setBackground(new java.awt.Color(11, 29, 58));
    }

    // Método público modificado para aceptar hasta el paso 4
    public void setPasoActual(int paso) {
        if (paso >= 1 && paso <= 4) {
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
        int centerY = (h / 2) - 10;

        // NUEVA DISTRIBUCIÓN MATEMÁTICA EN 8 PARTES PARA 4 PUNTOS COMPLETAMENTE EQUIDISTANTES
        int x1 = w / 8;
        int x2 = (w * 3) / 8;
        int x3 = (w * 5) / 8;
        int x4 = (w * 7) / 8;
        int radio = 16;

        Color colorBlanco = new Color(245, 242, 235);
        Color colorVerde = new Color(76, 175, 137);

        // Línea conectora base (ahora se extiende hasta el cuarto círculo x4)
        g2.setColor(colorBlanco);
        g2.setStroke(new BasicStroke(6));
        g2.drawLine(x1, centerY, x4, centerY);

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

        // --- NUEVO PASO 4 ---
        if (pasoActual >= 4) {
            g2.setColor(colorBlanco);
            g2.fillOval(x4 - radio - 2, centerY - radio - 2, (radio * 2) + 4, (radio * 2) + 4);
            g2.setColor(colorVerde);
            g2.fillOval(x4 - radio, centerY - radio, radio * 2, radio * 2);
        } else {
            g2.setColor(colorBlanco);
            g2.fillOval(x4 - radio, centerY - radio, radio * 2, radio * 2);
        }
    
        g2.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 11)); // Reducido a 11 para que no choquen los textos
        g2.setColor(colorBlanco); 

        // Textos correspondientes a cada fase (Incluyendo la nueva fase)
        String t1 = "Selección de Destino";
        String t2 = "Selección de vuelo";
        String t3 = "Selección de asientos";
        String t4 = "Confirmar compra";

        // Calculamos el ancho de cada texto
        int anchoT1 = g2.getFontMetrics().stringWidth(t1);
        int anchoT2 = g2.getFontMetrics().stringWidth(t2);
        int anchoT3 = g2.getFontMetrics().stringWidth(t3);
        int anchoT4 = g2.getFontMetrics().stringWidth(t4);

        // Posición vertical del texto (debajo de los círculos)
        int textoY = centerY + radio + 20; 

        // Dibujamos los cuatro textos centrados bajo su respectivo punto
        g2.drawString(t1, x1 - (anchoT1 / 2), textoY);
        g2.drawString(t2, x2 - (anchoT2 / 2), textoY);
        g2.drawString(t3, x3 - (anchoT3 / 2), textoY);
        g2.drawString(t4, x4 - (anchoT4 / 2), textoY);
    }
}


