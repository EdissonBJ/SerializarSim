package co.com.tasks.login;

import co.com.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static co.com.userInterfaces.login.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    public static List<Map<String, String>> leerExcel;

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            // Asegúrate que la ruta sea correcta
            leerExcel = Excel.leerDatosDeHojaDeExcel(
                    "src/test/resources/Data/DatosExcel.xlsx",
                    "DatosLogin"
            );
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el Excel de login", e);
        }

        actor.attemptsTo(
                Enter.theValue(leerExcel.get(0).get("Usuario")).into(TXT_USUARIO),
                Enter.theValue(leerExcel.get(0).get("Clave")).into(TXT_CLAVE),
                Click.on(BTN_INGRESAR)
        );
    }

    public static Login inicioSesion() {
        return instrumented(Login.class);
    }
}
