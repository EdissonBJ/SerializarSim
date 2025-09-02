package co.com.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickInFrame implements Interaction {

    private final int frameIndex;
    private final Target target;

    public ClickInFrame(int frameIndex, Target target) {
        this.frameIndex = frameIndex;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = getDriver();

        // Cambiar al iframe por índice
        driver.switchTo().frame(frameIndex);

        // Esperar a que el elemento sea visible y luego hacer click
        actor.attemptsTo(
                WaitUntil.the(target, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(target)
        );

        // Volver al contenido principal
        driver.switchTo().defaultContent();
    }

    public static ClickInFrame on(int frameIndex, Target target) {
        return new ClickInFrame(frameIndex, target);
    }
}
