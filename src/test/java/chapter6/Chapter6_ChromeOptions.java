package chapter6;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Chapter6_ChromeOptions {

	@Test(priority = 1)
	public void optionsTest() throws Exception {
		// Create ChromeOptions instance
		ChromeOptions options = new ChromeOptions();
		// Add preferences and arguments
		options.addArguments("--start-maximized"); // Maximize the browser window
		options.addArguments("--disable-extensions"); // Disable Chrome extensions
		options.addArguments("--incognito"); // Launch Chrome in incognito mode
		// Initialize WebDriver with ChromeOptions
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://orangeava.com/");
		Thread.sleep(5000);
		driver.quit();

	}

	@Test(priority = 2)
	public void driverServiceTest() throws Exception {
		// Setting the location for ChromeDriver logs
		System.setProperty("webdriver.chrome.logfile",
				"C:\\Users\\robin.gupta\\git\\LearningSelenium\\logs\\chromedriver.log");
		// Create a ChromeDriverService instance
		ChromeDriverService service = new ChromeDriverService.Builder().usingPort(9515) // Specify the port for
																						// ChromeDriver
				.withVerbose(true) // Enable verbose logging
				.build();

		// Initialize ChromeDriver with the service
		WebDriver driver = new ChromeDriver(service);

		driver.get("https://orangeava.com/");
		Thread.sleep(5000);
		driver.quit();

	}

	@Test(priority = 3)
	public void insecureCertTest() throws Exception {
		// Disable invalid certificate errors
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		// Initialize WebDriver with ChromeOptions
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		Thread.sleep(5000);
		driver.quit();

	}

	@Test(priority = 4)
	public void disablePopTest() throws Exception {
		// Disable various popups
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		// Initialize WebDriver with ChromeOptions
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://what3words.com/toddler.geologist.animated");
		Thread.sleep(5000);
		driver.quit();

	}

	@Test(priority = 5)
	public void headlessBrowserTest() throws Exception {
		// Enable headless mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu"); // Necessary for some platforms
		// Initialize WebDriver with ChromeOptions
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://what3words.com/toddler.geologist.animated");
		Thread.sleep(5000);
		driver.quit();

	}

	@Test(priority = 6)
	public void mobileEmulationTest() throws Exception {
		// Emulate Pixel 2
		ChromeOptions options = new ChromeOptions();
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "Pixel 2");
		options.setExperimentalOption("mobileEmulation", mobileEmulation);

		// Initialize WebDriver with ChromeOptions
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://what3words.com/toddler.geologist.animated");
		Thread.sleep(5000);
		driver.quit();

	}

	@Test(priority = 7)
	public void foreignLanguageTest() throws Exception {
		// Set French browser language
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=fr");

		// Initialize WebDriver with ChromeOptions
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://what3words.com/toddler.geologist.animated");
		Thread.sleep(5000);
		driver.quit();

	}

	@Test(priority = 8)
	public void disableJSTest() throws Exception {
		// Disable images and JavaScript
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-javascript");
		options.addArguments("--blink-settings=imagesEnabled=false");

		// Initialize WebDriver with ChromeOptions
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://google.com");
		Thread.sleep(5000);
		driver.quit();

	}
}
