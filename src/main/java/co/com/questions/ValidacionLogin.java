package co.com.questions;

import co.com.userInterfaces.PaginaUsuarioUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionLogin implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String mensajeObtenido = PaginaUsuarioUI.MSJ_LOGIN.resolveFor(actor).getText();
        return "Vista 360° Individual".equals(mensajeObtenido);
    }

    public static Question<Boolean> validarLogin() {
        return new ValidacionLogin();
    }
}