package chapter8;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty",
		"html:target/cucumber" }, features = "src\\test\\java\\chapter8\\OrangeHRMLogin.feature", glue = "chapter8")
@Test
public class Chapter08_CucumberRunnerTest extends AbstractTestNGCucumberTests {

}
