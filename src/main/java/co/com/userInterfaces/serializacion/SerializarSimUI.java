package co.com.userInterfaces.serializacion;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SerializarSimUI {

        public static final Target INPUT_BUSQUEDA = Target.the("Campo de búsqueda en el menú")
                .located(By.id("search_info_text"));

        public static final Target BOTON_BUSCAR = Target.the("Botón de búsqueda en el menú")
                .located(By.id("search_button_info"));

        public static final Target DIV_SERIALIZAR_SIM = Target.the("Opción 'Actualizar serial de recurso'")
                .located(By.xpath("//a[@name='Actualizar serial de recurso']"));



}
