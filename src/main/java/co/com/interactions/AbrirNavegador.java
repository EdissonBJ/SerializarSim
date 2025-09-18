package co.com.interactions;

import co.com.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AbrirNavegador implements Interaction {

    public static List<Map<String, String>> leerExcel = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            // Ruta absoluta más segura para que no falle
            String rutaExcel = "src/test/resources/Data/DatosExcel.xlsx";

            // Leer hoja "Url" (verifica el nombre real en tu archivo)
            leerExcel = Excel.leerDatosDeHojaDeExcel(rutaExcel, "Url");

            // Tomar la primera fila y la columna "Url"
            String url = leerExcel.get(0).get("Url");
            if (url == null || url.isEmpty()) {
                throw new RuntimeException("⚠️ No se encontró valor en la columna 'Url'");
            }

            // Abrir la URL
            actor.attemptsTo(
                    Open.url(url)
            );

        } catch (IOException e) {
            throw new RuntimeException("⚠️ Error leyendo el archivo Excel: " + e.getMessage(), e);
        }
    }

    public static AbrirNavegador abrir() {
        return Tasks.instrumented(AbrirNavegador.class);
    }
}
