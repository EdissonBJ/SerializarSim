package co.com.tasks.serializacion;

import co.com.interactions.ClickInFrame;
import co.com.userInterfaces.serializacion.SerializarSimUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.userInterfaces.serializacion.SerializarSimUI.DIV_SERIALIZAR_SIM;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavegarASerializarSim implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Escribir en el buscador
                Enter.theValue("serial").into(SerializarSimUI.INPUT_BUSQUEDA),

                // Clic en botón buscar
                Click.on(SerializarSimUI.BOTON_BUSCAR),

                // Esperar que aparezca la opción
                WaitUntil.the(SerializarSimUI.DIV_SERIALIZAR_SIM, isVisible())
                        .forNoMoreThan(30).seconds(),

                // Clic en la opción
                Click.on(SerializarSimUI.DIV_SERIALIZAR_SIM)
        );
    }

    public static NavegarASerializarSim enLaAplicacion() {
        return instrumented(NavegarASerializarSim.class);
    }
}
