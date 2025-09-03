package co.com.questions;

import co.com.userInterfaces.login.PaginaInicioUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionLogin implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return PaginaInicioUI.MENSAJE_LOGIN_EXITOSO.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> validarLogin() {
        return new ValidacionLogin();
    }
}