package co.com.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features", // ruta de tus .feature
        glue = "co.com.stepDefinitions",          // paquete donde están tus StepDefinitions
        snippets = CucumberOptions.SnippetType.CAMELCASE
        //tags = "@Login" // opcional, puedes filtrar con etiquetas
)
public class Runner {
}