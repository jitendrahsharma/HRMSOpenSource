package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		plugin = {"pretty"},
				monochrome = true,
				glue = {"parallel"},
				features = {"src/test/resources/parallel"}
		)
public class SerenityTestRunner {

}
