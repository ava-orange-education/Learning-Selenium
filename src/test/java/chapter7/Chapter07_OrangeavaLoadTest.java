package chapter7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseTest;

/**
 * @author Robin
 * @date: 29-06-2023
 * @purpose: This test covers the opening for a browser with Google Chrome 👼
 */
public class Chapter07_OrangeavaLoadTest extends BaseTest {
	public static void main(String[] args) throws Exception {
		// Creating a webdriver instance
		WebDriver driver = new ChromeDriver();
		// Navigating to OrangeAva
		driver.get("https://orangeava.com/");
		driver.quit();
	}
}