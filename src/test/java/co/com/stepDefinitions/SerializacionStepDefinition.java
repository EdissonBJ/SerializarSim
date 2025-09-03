package co.com.stepDefinitions;

import co.com.questions.ConfirmarEntregaSim;
import co.com.questions.VerificarMensajeSim;
import co.com.tasks.serializacion.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import co.com.tasks.serializacion.NavegarASerializarSim;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SerializacionStepDefinition {


    @Dado("que el usuario se encuentre en serializar sim")
    public void queElUsuarioSeEncuentreEnSerializarSim() {
        theActorInTheSpotlight().attemptsTo(
                NavegarASerializarSim.enLaAplicacion()
        );
    }

    @Cuando("ingrese un número de orden válido desde el archivo Excel")
    public void ingreseUnNumeroDeOrdenValidoDesdeElArchivoExcel() {
        theActorInTheSpotlight().attemptsTo(
          //      IngresarOrden.desdeExcel("ordenes.xlsx", "Hoja1")
        );
    }


    @Y("seleccione en el combo la opción {string}")
    public void seleccioneEnElComboLaOpcion(String opcion) {
        theActorInTheSpotlight().attemptsTo(
               // SeleccionarOpcion.enElCombo(opcion)
        );
    }

    @Y("elija la opción {string}")
    public void elijaLaOpcion(String opcion) {
        theActorInTheSpotlight().attemptsTo(
                //SeleccionarSubOpcion.enLaPantalla(opcion)
        );
    }

    @Y("registre una SIM válida desde el archivo Excel")
    public void registreUnaSimValidaDesdeElArchivoExcel() {
        theActorInTheSpotlight().attemptsTo(
              //  IngresarSim.desdeExcel("ordenes.xlsx", "Hoja1")
        );
    }

    @Y("haga clic en aplicar")
    public void hagaClicEnAplicar() {
        theActorInTheSpotlight().attemptsTo(
               // AplicarCambios.enLaPantalla()
        );
    }

    @Y("vuelva a ingresar el número de orden en el campo de consulta")
    public void vuelvaAIngresarElNumeroDeOrdenEnElCampoDeConsulta() {
        theActorInTheSpotlight().attemptsTo(
              //  ReingresarOrden.desdeExcel("ordenes.xlsx", "Hoja1")
        );
    }

    @Y("haga clic en buscar")
    public void hagaClicEnBuscar() {
        theActorInTheSpotlight().attemptsTo(
              //  BuscarOrden.enLaPantalla()
        );
    }

    @Y("haga clic en confirmar entrega")
    public void hagaClicEnConfirmarEntrega() {
        theActorInTheSpotlight().attemptsTo(
               // ConfirmarEntregaSim.deLaOrden()
        );
    }

    @Entonces("el usuario visualizará el mensaje de {string}")
    public void elUsuarioVisualizaraElMensajeDe(String mensajeEsperado) {
        theActorInTheSpotlight().should(
                //VerificarMensajeSim.deConfirmacion(mensajeEsperado)
        );
    }
}