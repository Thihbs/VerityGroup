package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty",
		"json:target/test.json" }, snippets = SnippetType.CAMELCASE, monochrome = true, strict = true, features = {
				"classpath:features" }, glue = { "classpath:steps" }, tags = { "@Verity" })
public class RunnersTest {

}
