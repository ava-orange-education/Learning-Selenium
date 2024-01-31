package chapter4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Robin
 * @date: 29-06-2023
 * @purpose: This test covers the opening for a browser with Google Chrome 👼
 */
public class Chapter04_ExplicitWait {
	@Test(priority = 1)
	public void explicitWaitExample() throws Exception {
		// Creating a webdriver instance
		WebDriver driver = new ChromeDriver();

		// Navigating to sample page
		driver.get("https://smilinrobin.github.io/LearningSelenium/docs/Chapter3_Waits.html");
		WebElement yellowcirclebutton = driver.findElement(By.id("explicitbutton"));
		yellowcirclebutton.click();
		// Setting up Explicit wait
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".circle")));
		WebElement yellowcircle = driver.findElement(By.cssSelector(".circle"));
		// Asserting if the yellow circle is displayed on screen
		Assert.assertTrue(yellowcircle.isDisplayed(), "Yellow circle is not displayed");
		driver.quit();
	}
}
