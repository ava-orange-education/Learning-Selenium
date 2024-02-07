package chapter4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @author Robin
 * @date: 29-06-2023
 * @purpose: This test covers the opening for a browser with Google Chrome 👼
 */
public class Chapter04_AnimationAutomation {
	@Test(priority = 1)
	public void automationExample() throws Exception {
		// Creating a webdriver instance
		WebDriver driver = new ChromeDriver();

		// Navigating to sample page
		driver.get("https://ava-orange-education.github.io/Ultimate-Selenium-WebDriver-for-Test-Automation/docs/Chapter4_Butterfly.html");
		// Dynamic wait for butterfly animation to appear
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"nabpi n1\"]")));
		// Fetching count of all white butterflies in a list
		List<WebElement> whitebutterflylist = driver.findElements(By.xpath("//div[@class=\"nabpi n1\"]"));
		System.out.println("Count of white butterflies is : " + whitebutterflylist.size());
		driver.quit();
	}
}
