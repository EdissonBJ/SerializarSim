package co.com.userInterfaces.serializacion;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class PaginaSerializarUI {

    public static final Target INPUT_NUMERO_ORDEN  = Target.the("Campo Número de Orden")
            .located(By.id("orderNumber"));

    // Combo para seleccionar tipo de orden
    public static final Target SELECT_TIPO_ORDEN = Target.the("selector tipo de orden")
            .located(By.id("orderType"));
    // <-- cámbialo al id/xpath real

    public static final Target BOTON_BUSCAR = Target.the("botón buscar")
            .located(By.id("btnSearch"));



}
