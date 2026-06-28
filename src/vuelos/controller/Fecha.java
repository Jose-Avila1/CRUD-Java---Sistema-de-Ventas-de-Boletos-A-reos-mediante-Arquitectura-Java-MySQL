
package vuelos.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fecha {
    public String FechaFormateada;

    public void obtenerFecha() {
        LocalDateTime in = LocalDateTime.now();
        DateTimeFormatter formatoF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        FechaFormateada = in.format(formatoF);
    }
}