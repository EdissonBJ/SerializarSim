package co.com.userInterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;


public class PaginaInicioUI {

    public static final Target TXT_USUARIO = Target.the("usuario").located(By.id("ipt_name"));
    public static final Target TXT_CLAVE = Target.the("ingresar clave").located(By.id("ipt_pwd"));
    public static final Target BTN_INGRESAR = Target.the("boton ingresar").located(By.id("loginBtn"));

   public static final Target DIV_VENTA_OFERTA = Target.the("Venta Oferta Individual y Empaquetada")
            .located(By.xpath("//div[@class='item_title' and text()='Venta Oferta Individual y Empaquetada (Fija)']"));

}