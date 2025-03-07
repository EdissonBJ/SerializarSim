package co.com.userInterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;


public class PaginaInicioUI {

    public static final Target TXT_USUARIO = Target.the("usuario").located(By.id("ipt_name"));
    public static final Target TXT_CLAVE = Target.the("ingresar clave").located(By.id("ipt_pwd"));
    public static final Target BTN_INGRESAR = Target.the("boton ingresar").located(By.id("loginBtn"));

    public static final Target MSJ_LOGIN = Target
            .the("Campo de búsqueda de información")
            .locatedBy("//input[@id='search_info_text']");
}