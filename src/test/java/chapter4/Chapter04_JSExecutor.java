package chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author Robin
 * @date: 29-06-2023
 * @purpose: This test covers the opening for a browser with Google Chrome 👼
 */
public class Chapter04_JSExecutor {
	@Test(priority = 1)
	public void jsExecutorTest() throws Exception {
		// Creating a webdriver instance
		WebDriver driver = new ChromeDriver();

		// Navigating to sample page
		driver.get("https://googlechromelabs.github.io/chrome-for-testing/");
		// Utilizing JavaScript Executor to scroll to the Canary header on Chrome for
		// testing page
		WebElement canaryheader = driver.findElement(By.xpath("//h2[text()='Canary']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", canaryheader);
		// Thread sleep added only for reader's reference and verification of the
		// actions performed above
		Thread.sleep(2000);
		// Utilizing JavaScript Executor to add a border to the header identified above
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='15px solid red';", canaryheader);
		// Thread sleep added only for reader's reference and verification of the
		// actions performed above
		Thread.sleep(5000);
		driver.quit();
	}
}
