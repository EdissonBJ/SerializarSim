package co.com.userInterfaces.serializacion;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaSerializarUI {

        // El iframe de Buscar Orden
        public static final Target IFRAME_BUSCAR_ORDEN = Target.the("iframe buscar orden")
                .located(By.xpath("//iframe[@innerid='60131100']"));

        // Número de orden (input)
        public static final Target INPUT_NUMERO_ORDEN = Target.the("campo número de orden")
                .located(By.id("OrderId"));

        // Trigger para abrir el dropdown de Tipo de orden
        public static final Target DROPDOWN_TIPO_ORDEN = Target.the("desplegable de tipo de orden")
                .located(By.xpath("//div[contains(@class,'form_droplist') and @ng-model='$Gadget.orderType']//span[@class='trigger']"));

        // Input que muestra el valor actual seleccionado
        public static final Target INPUT_TIPO_ORDEN = Target.the("input de tipo de orden seleccionado")
                .located(By.xpath("//div[contains(@class,'form_droplist') and @ng-model='$Gadget.orderType']//input[@readonly]"));

        // Opción 'Crear Subscriptor'
        public static final Target OPCION_CREAR_SUBSCRIPTOR = Target.the("opción Crear Subscriptor")
                .located(By.xpath("//*[contains(text(),'Crear Subscriptor')]"));

        // Botón de consulta
        public static final Target BTN_CONSULTA = Target.the("botón de consulta")
                .located(By.xpath("//div[@id='QueryButton']/span[contains(text(),'Consulta')]"));

        // Botón de serializar Actualizar serie del recurso

        public static final Target BTN_ACTUALIZAR_SERIE =Target.the("botón actualizar serie")
                .located(By.xpath("//div[contains(@class,'td_1')and contains(text(),'Actualizar serie del recurso')]"));

        //input serial sim
        public static final Target INPUT_SERIAL_SIM = Target.the("panel serial sim")
                .located(By.id("serialNo2"));

        //iframe del popup para boton enviar

        public static final Target IFRAME_ACTUALIZAR_SERIE = Target.the("iframe actualizar serie")
                .located(By.cssSelector("div.popwin_iframe"));

        public static final Target ENVIAR_SERIAL_SIM = Target.the("botón Enviar serial")
                .located(By.xpath("//div[contains(@class,'btn_positive') and normalize-space(text())='Enviar']"));

}
