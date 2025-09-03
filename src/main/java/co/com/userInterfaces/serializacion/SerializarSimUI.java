package co.com.userInterfaces.serializacion;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SerializarSimUI {

    public static final Target DIV_VENTA_OFERTA = Target.the("Vista 360° Individual")
            .located(By.xpath("//*[contains(text(),'Vista 360° Individual')]"));
}
