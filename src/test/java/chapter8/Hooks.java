package chapter8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageobjects.OrangeLoginPage;

public class Hooks {
	public static WebDriver driver;
	public static OrangeLoginPage loginpage;

	@Before
	public void setUpClass() throws Exception {
		driver = new ChromeDriver();
		loginpage = new OrangeLoginPage(driver);

	}

	@After
	public static void tearDown(Scenario scenario) {
		driver.quit();
	}
}
