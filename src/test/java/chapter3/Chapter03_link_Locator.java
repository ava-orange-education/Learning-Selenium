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
public class Chapter03_link_Locator {
	@Test(priority = 1)
	public void nameLocatorExample() throws Exception {
		// Creating a webdriver instance
//
	  WebDriver driver = new ChromeDriver();
	    //Navigating to Salesforce home page
	    driver.get("https://login.salesforce.com/");
	    WebElement tryforfreelink = driver.findElement(By.linkText("Try for Free"));
	   System.out.println("Location of the input field on screen is" +tryforfreelink.getLocation()); 
	   driver.quit();
	}
}
