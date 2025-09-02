package co.com.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import co.com.userInterfaces.PaginaUsuarioUI;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.userInterfaces.PaginaUsuarioUI.DIV_VENTA_OFERTA;

public class SeleccionarVentaOferta implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on(DIV_VENTA_OFERTA)
        );
    }

    public static SeleccionarVentaOferta enPantalla() {
        return instrumented(SeleccionarVentaOferta.class);
    }
}
