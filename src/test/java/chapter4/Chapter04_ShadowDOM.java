
package chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author Robin
 * @date: 29-06-2023
 * @purpose: This test covers the opening for a browser with Google Chrome 👼
 */
public class Chapter04_ShadowDOM {
	@Test(priority = 1)
	public void shadowDOMExample() throws Exception {
		// Creating a webdriver instance
		WebDriver driver = new ChromeDriver();

		// Navigating to sample page
		driver.get("https://ava-orange-education.github.io/Learning-Selenium/docs/Chapter4_ShadowDOM.html");
//		// Erroneous navigation
//		WebElement inputfield = driver.findElement(By.id("shadowinput"));
//		inputfield.sendKeys("Test input value");
		WebElement shadowHost = driver.findElement(By.id("shadow_host"));
		SearchContext shadowRoot = shadowHost.getShadowRoot();
		WebElement inputfield = shadowRoot.findElement(By.cssSelector(".shadowinput"));
		inputfield.sendKeys("Test input value");
		// Added Thread sleep just for demo purpose, so that user can see if the text is
		// input correctly
		Thread.sleep(3000);
		driver.quit();
	}
}
