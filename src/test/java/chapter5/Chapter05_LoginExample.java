package chapter5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Chapter05_LoginExample {

	WebDriver driver = null;

	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			// initializing and starting the Chromebrowser
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			// initializing and starting the Firefoxbrowser
			driver = new FirefoxDriver();
		}
	}

	@Test(groups = { "regression" })
	public void test1() throws InterruptedException {

		System.out.println("Execution for Chrome browser");
		driver.get("https://orangeava.com/");
		Thread.sleep(3000);
	}

	@Test(groups = { "smoke" })
	public void test2() throws InterruptedException {
		System.out.println("Execution for Firefox browser");
		driver.get("https://orangeava.com/");
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}