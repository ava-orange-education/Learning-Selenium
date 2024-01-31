package chapter3;
import java.util.List;

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
public class Chapter03_clear {
	@Test(priority = 1)
	public void textSetter() throws Exception {
		// Creating a webdriver instance
//
	  WebDriver driver = new ChromeDriver();
	    //Navigating to Salesforce login page
	    driver.get("https://login.salesforce.com/");
	    WebElement usernameinput = driver.findElement(By.xpath("//input[@id='username']"));
	    //setting the text value 
	    usernameinput.sendKeys("reader@orangeava.com");
	    Thread.sleep(3000);
	    usernameinput.clear();
	    Thread.sleep(3000);
	   driver.quit();
	}
}
