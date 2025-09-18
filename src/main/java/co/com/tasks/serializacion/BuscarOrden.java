package co.com.tasks.serializacion;

import co.com.interactions.ClickInFrame;
import co.com.userInterfaces.serializacion.PaginaSerializarUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actions.Enter.theValue;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;

public class BuscarOrden implements Task {

    private final String numeroOrden;

    public BuscarOrden(String numeroOrden){
        this.numeroOrden=numeroOrden;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(

                // Escribir número en el campo (dentro del iframe)
                ClickInFrame.on(0, PaginaSerializarUI.INPUT_NUMERO_ORDEN),
                theValue(numeroOrden).into(PaginaSerializarUI.INPUT_NUMERO_ORDEN),

                // Seleccionar tipo de orden
                ClickInFrame.on(0, PaginaSerializarUI.SELECT_TIPO_ORDEN),
                byVisibleText("Crear Subscriptor").from(PaginaSerializarUI.SELECT_TIPO_ORDEN),

                // Click en buscar
                ClickInFrame.on(0, PaginaSerializarUI.BOTON_BUSCAR)
        );
    }

    public static BuscarOrden conNumero(String numeroOrden) {
        return instrumented(BuscarOrden.class, numeroOrden);
    }
}
