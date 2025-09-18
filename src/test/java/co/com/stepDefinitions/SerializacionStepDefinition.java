package co.com.stepDefinitions;

import co.com.interactions.AbrirNavegador;
import co.com.questions.ConfirmarEntregaSim;
import co.com.questions.VerificarMensajeSim;
import co.com.tasks.login.Login;
import co.com.tasks.serializacion.*;
import co.com.utils.Excel;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import co.com.tasks.serializacion.NavegarASerializarSim;
import co.com.utils.Excel;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SerializacionStepDefinition {

    @Dado("que el usuario se encuentre en serializar sim")
    public void queElUsuarioSeEncuentreEnSerializarSim() {
        theActorInTheSpotlight().attemptsTo(
                NavegarASerializarSim.enLaAplicacion()
        );
    }

    @Cuando("ingrese un número de orden válido desde el archivo Excel")
    public void ingreseUnNumeroDeOrdenValidoDesdeElArchivoExcel()throws Exception  {
        String rutaExcel = "src/test/resources/data/ordenes.xlsx"; // ajusta tu ruta
        String hoja = "Hoja2";

        // Leemos todo
        List<Map<String, String>> datos = Excel.leerDatosDeHojaDeExcel(rutaExcel, hoja);

        // Tomamos la primera fila de la hoja
        String numeroOrden = datos.get(0).get("NumeroOrden");  // <-- nombre de la columna en tu Excel

        theActorInTheSpotlight().attemptsTo(
                BuscarOrden.conNumero(numeroOrden)
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