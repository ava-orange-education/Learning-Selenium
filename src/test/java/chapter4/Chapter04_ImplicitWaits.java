package chapter4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author Robin
 * @date: 29-06-2023
 * @purpose: This test covers the opening for a browser with Google Chrome 👼
 */
public class Chapter04_ImplicitWaits {
	@Test(priority = 1)
	public void implicitWaitExample() throws Exception {
		// Creating a webdriver instance
//
		WebDriver driver = new ChromeDriver();

		// Navigating to sample page
		driver.get("https://ava-orange-education.github.io/Learning-Selenium/docs/Chapter3_Waits.html");
		// Setting up Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement inputboxbutton = driver.findElement(By.id("implicitbutton"));
		inputboxbutton.click();
		WebElement inputbox = driver.findElement(By.id("inputbox"));
		System.out.println("Tag name of the displayed box on screen is " + inputbox.getTagName());
		inputbox.sendKeys("Input value in the box");
		// Added sleep below so that the user can see if the text is correctly input to
		// the box
		Thread.sleep(3000);
		driver.quit();
	}
}
