package co.com.tasks.serializacion;

import co.com.interactions.ClickInFrame;
import co.com.interactions.serializacion.EnterInFrame;
import co.com.userInterfaces.serializacion.PaginaSerializarUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarOrden implements Task {

    private final String numeroSerieRecurso;

    public ConsultarOrden(String numeroSerieRecurso) {
        this.numeroSerieRecurso = numeroSerieRecurso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

               // Ingresar número de orden
                EnterInFrame.theValue(numeroSerieRecurso,
                        PaginaSerializarUI.IFRAME_BUSCAR_ORDEN,
                        PaginaSerializarUI.INPUT_SERIAL_SIM),



               ClickInFrame.on(PaginaSerializarUI.IFRAME_BUSCAR_ORDEN,
                     PaginaSerializarUI.ENVIAR_SERIAL_SIM)
        );
    }

    public static ConsultarOrden buscarSerie(String numeroSerieRecurso) {
        return instrumented(ConsultarOrden.class, numeroSerieRecurso);
    }
}

