package exercise2.testRunners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/java/feature"},
glue = {"feature"},
plugin = { "progress" },
monochrome = true
)
public class TestRunner{



}