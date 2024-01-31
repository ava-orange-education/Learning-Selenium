package chapter10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Chapter10_SoftAssertTest {
	@Test
	public void testGoogleSearchElements() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		SoftAssert softAssert = new SoftAssert();

		driver.get("https://www.google.com");

		// Check if the search bar is present
		WebElement searchBar = driver.findElement(By.name("q"));
		softAssert.assertNotNull(searchBar, "Search bar is not present");

		// Check if the Google Search button is present
		WebElement searchButton = driver.findElement(By.name("btnK"));
		softAssert.assertNotNull(searchButton, "Search button is not present");

		// Perform a search operation
		searchBar.sendKeys("Selenium WebDriver");
		// Simulating the press of Enter key to trigger search
		searchBar.sendKeys(Keys.ENTER);
		// searchButton.click();

		// Verify if the first search result is relevant
		Thread.sleep(3000);
		WebElement searchResult = driver.findElement(By.id("search"));
		String expectedTextInFirstResult = "WebDriver";
		softAssert.assertTrue(searchResult.getAttribute("innerHTML").contains(expectedTextInFirstResult),
				"First search result is not relevant");

		// Finalize the test with assertAll to report all soft assert failures
		softAssert.assertAll();
	}
}
