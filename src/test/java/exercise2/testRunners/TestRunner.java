package exercise2.testRunners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/java/exercise2/features"},
    glue = {"exercise2.stepDefinitions"}, // Ruta del paquete de definiciones de pasos
    plugin = {"progress"},
    monochrome = true
)
public class TestRunner {
}
