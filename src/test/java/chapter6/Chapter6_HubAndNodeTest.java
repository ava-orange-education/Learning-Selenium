package chapter6;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Chapter6_HubAndNodeTest {

	@Test(priority = 1)
	public void chromeGridTest() throws Exception {
		WebDriver driver_chrome = new RemoteWebDriver(new URL("http://192.168.0.103:4444"), new ChromeOptions());
		// Navigating to sample page
		driver_chrome.get("https://google.com");
		Thread.sleep(3000);
		driver_chrome.quit();
	}

	@Test(priority = 1)
	public void firefoxGridTest() throws Exception {
		FirefoxOptions options = new FirefoxOptions();
		WebDriver driver_firefox = new RemoteWebDriver(new URL("http://192.168.0.103:4444"), options);
		// Navigating to sample page
		driver_firefox.get("https://google.com");
		Thread.sleep(3000);
		driver_firefox.quit();
	}
}
