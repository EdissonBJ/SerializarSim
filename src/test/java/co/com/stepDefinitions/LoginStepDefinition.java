
package co.com.stepDefinitions;


import co.com.exceptions.ResultadoNoEsperado;
import co.com.interactions.AbrirNavegador;
import co.com.questions.ValidacionLogin;
import co.com.tasks.login.Login;
import co.com.userInterfaces.login.PaginaInicioUI;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinition {

    @Before
    public void configuracion(){
        setTheStage(new OnlineCast());
    }

    @Dado("que el usuario se encuentre en la pagina web")
    public void queElUsuarioSeEncuentreEnLaPaginaWeb() {
        theActorCalled("Edi").wasAbleTo(AbrirNavegador.abrir());
    }

    @Cuando("ingrese el usuario con la clave")
    public void ingreseElUsuarioConLaClave()  {
        theActorInTheSpotlight().attemptsTo(Login.inicioSesion());


    }


    @Entonces("el usuario visualizara un mensaje de login exitoso")
    public void elUsuarioVisualizaraUnMensajeDeLoginExitoso() {
// Esperamos el mensaje de login
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PaginaInicioUI.MENSAJE_LOGIN_EXITOSO, isVisible())
                        .forNoMoreThan(15).seconds()
        );

        // Validamos el login
        theActorInTheSpotlight().should(seeThat(
                ValidacionLogin.validarLogin(),
                equalTo(true)
        ).orComplainWith(ResultadoNoEsperado.class, ResultadoNoEsperado.INICIO_SESION_FALLO));


    }
}
