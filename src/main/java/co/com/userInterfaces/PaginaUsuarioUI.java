package co.com.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaUsuarioUI {

    public static final Target MSJ_LOGIN = Target
            .the("Elemento deseado dentro de entrance")
            .locatedBy("//div[@id='entrance']/ul/li/div/div/div[2]");
}