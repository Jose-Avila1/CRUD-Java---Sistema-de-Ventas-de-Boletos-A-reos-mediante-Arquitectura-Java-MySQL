package vuelos.controller;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

// wall


public class ControladorRutas {

    private JComboBox<String> comboOrigen;
    private JComboBox<String> comboDestino;
    private List<String> listaCiudades;

    private String origenSeleccionado = "";
    private String destinoSeleccionado = "";

    private boolean estaActualizando = false;

    public ControladorRutas(JComboBox<String> comboOrigen, JComboBox<String> comboDestino) {
        this.comboOrigen = comboOrigen;
        this.comboDestino = comboDestino;
        this.listaCiudades = obtenerCiudades();

        configurarComportamiento();
    }
        //Aqui es donde hay que llenar las ciudades desde las bd
    private List<String> obtenerCiudades() {
        List<String> ciudades = new ArrayList<>();
        ciudades.add("");
        ciudades.add("Maracaibo");
        ciudades.add("Caracas");
        ciudades.add("Valencia");
        ciudades.add("Barquisimeto");
        ciudades.add("Mérida");
        ciudades.add("Porlamar");
        ciudades.add("San Cristóbal");
        return ciudades;
    }

    private void configurarComportamiento() {
        configurarCombo(comboOrigen, true);
        configurarCombo(comboDestino, false);
    }

    private void configurarCombo(JComboBox<String> comboBox, boolean esOrigen) {
        comboBox.setEditable(true);
        JTextField editor = (JTextField) comboBox.getEditor().getEditorComponent();

        // 1. Escuchador de teclado para filtrado dinámico 
        editor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_ENTER || key == KeyEvent.VK_ESCAPE) {
                    return;
                }

                String textoEscrito = editor.getText();
                int posicionCursor = editor.getCaretPosition();

                actualizarModelo(comboBox, textoEscrito, esOrigen);
                
                editor.setText(textoEscrito);
                if (posicionCursor <= textoEscrito.length()) {
                    editor.setCaretPosition(posicionCursor);
                }

                if (!textoEscrito.isEmpty()) {
                    comboBox.showPopup();
                } else {
                    comboBox.hidePopup();
                }
            }
        });

        // 2. Escuchador de acción para cuando seleccionas una ciudad
        comboBox.addActionListener(e -> {
            if (estaActualizando) {
                return; 
            }

            if (comboBox.getSelectedItem() != null) {
                String seleccion = comboBox.getSelectedItem().toString();

                if (listaCiudades.contains(seleccion)) {
                    if (esOrigen) {
                        origenSeleccionado = seleccion;
                        actualizarModelo(comboDestino, "", false);
                    } else {
                        destinoSeleccionado = seleccion;
                        actualizarModelo(comboOrigen, "", true);
                    }
                } else {
                    // Si el usuario borra o escribe algo inválido, limpiamos la selección
                    limpiarSeleccion(esOrigen);
                }
            } else {
                limpiarSeleccion(esOrigen);
            }
        });
        
        actualizarModelo(comboBox, "", esOrigen);
    }

    private void limpiarSeleccion(boolean esOrigen) {
        if (esOrigen) {
            origenSeleccionado = "";
            actualizarModelo(comboDestino, "", false);
        } else {
            destinoSeleccionado = "";
            actualizarModelo(comboOrigen, "", true);
        }
    }

    private void actualizarModelo(JComboBox<String> comboBox, String filtro, boolean esOrigen) {
        estaActualizando = true; 

    // 1. Guardar el estado visual e interno actual
    Object itemPrevio = comboBox.getSelectedItem();
    JTextField editor = (JTextField) comboBox.getEditor().getEditorComponent();
    String textoPrevio = editor.getText();

    DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
    String ciudadAExcluir = esOrigen ? destinoSeleccionado : origenSeleccionado;

    // 2. Llenar el modelo filtrado
    for (String ciudad : listaCiudades) {
        boolean coincideFiltro = ciudad.toLowerCase().contains(filtro.toLowerCase());
        
        // Si ciudadAExcluir está vacío (""), permitimos que el espacio en blanco entre al modelo.
        boolean noEsExcluida = ciudadAExcluir.isEmpty() || !ciudad.equals(ciudadAExcluir);

        if (coincideFiltro && noEsExcluida) {
            modelo.addElement(ciudad);
        }
    }

    // Aplicar el nuevo modelo al JComboBox
    comboBox.setModel(modelo);
    
    // 3. Restaurar la selección correcta
    if (itemPrevio != null && !itemPrevio.toString().equals(ciudadAExcluir) && listaCiudades.contains(itemPrevio.toString())) {
        comboBox.setSelectedItem(itemPrevio);
    } else if (!filtro.isEmpty()) {
        editor.setText(textoPrevio);
    } else {
        // Si el filtro viene vacío (cuando se inicializa o se limpia desde el otro combo)
        String ciudadGuardada = esOrigen ? origenSeleccionado : destinoSeleccionado;
        if (!ciudadGuardada.isEmpty()) {
            comboBox.setSelectedItem(ciudadGuardada);
        } else {
            // CORRECCIÓN 2: Forzar a Swing a que seleccione internamente el vacío "" 
            // en lugar de auto-seleccionar el primer elemento disponible por defecto.
            comboBox.setSelectedItem(""); 
            editor.setText("");
        }
    }

    estaActualizando = false;
    }

    public String getOrigenSeleccionado() {
        return origenSeleccionado;
    }

    public String getDestinoSeleccionado() {
        return destinoSeleccionado;
    }
}