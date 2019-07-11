package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import factory.WebDriverFactory;

public class Hooks {

	
	public static void setUp() {
		WebDriverFactory.startChromeDriver();
	}

	@After
	public static void tearDown() {
		WebDriverFactory.getCurrentRunningDriver().close();
		WebDriverFactory.killCurrentRunningDriver();

	}
}
