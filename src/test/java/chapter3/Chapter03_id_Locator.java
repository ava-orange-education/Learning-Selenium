package chapter3;
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
public class Chapter03_id_Locator {
	@Test(priority = 1)
	public void idLocatorExample() throws Exception {
		// Creating a webdriver instance
//
	  WebDriver driver = new ChromeDriver();
	    //Navigating to Salesforce LoginTry for Free page
	    driver.get("https://login.salesforce.com/");
	    WebElement inputfield = driver.findElement(By.id("username"));
	   System.out.println("Location of the input field on screen is" +inputfield.getLocation()); 
	   driver.quit();
	}
}
