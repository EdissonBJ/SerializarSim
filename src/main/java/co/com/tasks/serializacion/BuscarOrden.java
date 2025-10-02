package co.com.tasks.serializacion;

import co.com.interactions.ClickInFrame;
import co.com.interactions.serializacion.EnterInFrame;
import co.com.userInterfaces.serializacion.PaginaSerializarUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarOrden implements Task {

    private final String numeroOrden;

    public BuscarOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                // Ingresar número de orden
                EnterInFrame.theValue(numeroOrden,
                        PaginaSerializarUI.IFRAME_BUSCAR_ORDEN,
                        PaginaSerializarUI.INPUT_NUMERO_ORDEN),

                // Abrir combo de tipo de orden
                //ClickInFrame.on(PaginaSerializarUI.IFRAME_BUSCAR_ORDEN,PaginaSerializarUI.DROPDOWN_TIPO_ORDEN),

                // Seleccionar "Crear Subscriptor"
                //ClickInFrame.on(PaginaSerializarUI.IFRAME_BUSCAR_ORDEN,PaginaSerializarUI.OPCION_CREAR_SUBSCRIPTOR),

                // Dar clic en Consulta
                ClickInFrame.on(PaginaSerializarUI.IFRAME_BUSCAR_ORDEN,
                        PaginaSerializarUI.BTN_CONSULTA),
                ClickInFrame.on(PaginaSerializarUI.IFRAME_BUSCAR_ORDEN,
                        PaginaSerializarUI.BTN_ACTUALIZAR_SERIE)
        );
    }

    public static BuscarOrden conNumero(String numeroOrden)
    {
        return instrumented(BuscarOrden.class, numeroOrden);
    }
}
