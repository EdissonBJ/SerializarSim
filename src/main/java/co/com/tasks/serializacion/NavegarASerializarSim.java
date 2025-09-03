package co.com.tasks.serializacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.userInterfaces.serializacion.SerializarSimUI.DIV_VENTA_OFERTA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavegarASerializarSim implements Task {

    public static NavegarASerializarSim enLaAplicacion() {
        return instrumented(NavegarASerializarSim.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DIV_VENTA_OFERTA)
        );
    }

}
