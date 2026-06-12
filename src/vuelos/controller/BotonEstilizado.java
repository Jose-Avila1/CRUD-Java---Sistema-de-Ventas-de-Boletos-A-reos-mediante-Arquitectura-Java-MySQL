package vuelos.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class BotonEstilizado extends JButton {

    // Variable interna para saber si el mouse está encima del botón
    private boolean mouseEncima = false;

    public BotonEstilizado() {
        super();
        configurarEstiloBase();
    }

    public BotonEstilizado(String texto) {
        super(texto);
        configurarEstiloBase();
    }

    private void configurarEstiloBase() {
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);

        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // DETECTOR DE HOVER: Escucha cuando el mouse entra o sale del botón
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseEncima = true;
                repaint(); // Obliga al botón a redibujarse con el nuevo brillo
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseEncima = false;
                repaint(); // Regresa al color original
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        // 1. Suavizado para el fondo redondeado
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color colorFondo;
        if (isEnabled()) {
            if (mouseEncima) {
                colorFondo = new Color(30, 75, 140);
            } else {
                colorFondo = new Color(20, 50, 95);
            }
            setForeground(Color.WHITE);
        } else {
            colorFondo = new Color(45, 60, 80);
            setForeground(new Color(140, 155, 175));
        }

        g2.setColor(colorFondo);
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 6, 6));
        g2.dispose(); // Liberamos el renderizador del fondo

        // =======================================================================
        // 2. SOLUCIÓN AL PIXELEADO: Activamos el suavizado de alta calidad para las letras
        // =======================================================================
        Graphics2D gText = (Graphics2D) g;
        gText.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Dibujamos el texto de forma manual (ahora saldrá completamente nítido)
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

        g.setColor(getForeground());
        g.setFont(getFont());
        g.drawString(getText(), x, y);
    }
}
