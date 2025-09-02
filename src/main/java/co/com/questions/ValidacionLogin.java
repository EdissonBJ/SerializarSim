package co.com.questions;

import co.com.userInterfaces.PaginaUsuarioUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionLogin implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String mensajeObtenido = PaginaUsuarioUI.DIV_VENTA_OFERTA.resolveFor(actor).getText();
        return  mensajeObtenido.contains("Venta Oferta Individual y Empaquetada (Fija)");
    }

    public static Question<Boolean> validarLogin() {
        return new ValidacionLogin();
    }
}