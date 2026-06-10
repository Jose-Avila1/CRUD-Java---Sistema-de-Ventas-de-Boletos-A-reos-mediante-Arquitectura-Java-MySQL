package vuelos.controller;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

//Wall

public class ValidarCampos {

    public static boolean validar(ControladorRutas controlador, JComboBox<String> comboOrigen, JComboBox<String> comboDestino) {
        
        // 1. Obtener el componente de texto interno de cada JComboBox
        JTextField txtOrigen = (JTextField) comboOrigen.getEditor().getEditorComponent();
        JTextField txtDestino = (JTextField) comboDestino.getEditor().getEditorComponent();

        // 2. Limpiar espacios en blanco
        String textoOrigen = txtOrigen.getText().trim();
        String textoDestino = txtDestino.getText().trim();

        // --- VERIFICACIÓN 1: ¿Están vacíos? ---
        if (textoOrigen.isEmpty() || textoDestino.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                    "Error: Los campos de Origen y Destino no pueden estar vacíos.", 
                    "Campos Vacíos", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // --- VERIFICACIÓN 2: ¿Son la misma ciudad? --- 
        if (textoOrigen.equalsIgnoreCase(textoDestino)) {
            JOptionPane.showMessageDialog(null, 
                    "Error: El origen y el destino no pueden ser la misma ciudad. Por favor, rectifique.", 
                    "Ruta Duplicada", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // --- VERIFICACIÓN 3: ¿Escribió una ciudad que NO está en la lista? ---
        String origenValido = controlador.getOrigenSeleccionado();
        String destinoValido = controlador.getDestinoSeleccionado();

        if (origenValido.isEmpty() || !origenValido.equalsIgnoreCase(textoOrigen)) {
            JOptionPane.showMessageDialog(null, 
                    "Error: El origen '" + textoOrigen + "' no es una ciudad válida de la lista.", 
                    "Origen Inválido", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (destinoValido.isEmpty() || !destinoValido.equalsIgnoreCase(textoDestino)) {
            JOptionPane.showMessageDialog(null, 
                    "Error: El destino '" + textoDestino + "' no es una ciudad válida de la lista.", 
                    "Destino Inválido", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // 5. GUARDAR EN VARIABLES LOCALES DEFINITIVAS
        //String origenFinal = origenValido;
        //String destinoFinal = destinoValido;

        return true; 
    }

    
}