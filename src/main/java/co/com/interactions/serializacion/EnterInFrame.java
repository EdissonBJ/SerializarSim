package co.com.interactions.serializacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterInFrame implements Interaction {

    private final Target frame;
    private final Target target;
    private final String value;

    public EnterInFrame(Target frame, Target target, String value) {
        this.frame = frame;
        this.target = target;
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = getDriver();

        try {
            // Cambiar al iframe
            WebElement iframeElement = frame.resolveFor(actor);
            driver.switchTo().frame(iframeElement);

            // Esperar a que el input esté visible y luego escribir
            actor.attemptsTo(
                    WaitUntil.the(target, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(value).into(target)
            );

        } finally {
            // Regresar siempre al contexto principal
            driver.switchTo().defaultContent();
        }
    }

    public static EnterInFrame theValue(String value, Target frame, Target target) {
        return new EnterInFrame(frame, target, value);
    }
}
