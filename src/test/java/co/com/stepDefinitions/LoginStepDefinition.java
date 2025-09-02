
package co.com.stepDefinitions;


import co.com.exceptions.ResultadoNoEsperado;
import co.com.interactions.AbrirNavegador;
import co.com.interactions.ClickInFrame;
import co.com.questions.ValidacionLogin;
import co.com.tasks.Login;
import co.com.tasks.SeleccionarVentaOferta;
import co.com.userInterfaces.PaginaUsuarioUI;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;

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
        theActorCalled("Sol").wasAbleTo(AbrirNavegador.abrir());
    }

    @Cuando("ingrese el usuario con la clave")
    public void ingreseElUsuarioConLaClave()  {
        theActorInTheSpotlight().attemptsTo(Login.inicioSesion());
    }

    @Entonces("el usuario visualizara un mensaje de login exitoso")
    public void elUsuarioVisualizaraUnMensajeDeLoginExitoso() {
        theActorInTheSpotlight().attemptsTo(
                ClickInFrame.on(4, PaginaUsuarioUI.DIV_VENTA_OFERTA)
        );

        // Validamos el login
        theActorInTheSpotlight().should(seeThat(
                ValidacionLogin.validarLogin(),
                equalTo(true)
        ).orComplainWith(ResultadoNoEsperado.class, ResultadoNoEsperado.INICIO_SESION_FALLO));

        // Continuar con la acción original
        theActorInTheSpotlight().attemptsTo(SeleccionarVentaOferta.enPantalla());
    }
}
