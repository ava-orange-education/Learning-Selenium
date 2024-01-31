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
public class Chapter03_iFrameInteraction {
	@Test(priority = 1)
	public void tableReader() throws Exception {
		// Creating a webdriver instance
//
	  WebDriver driver = new ChromeDriver();
	    //Navigating to W3 website
	    driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_table_test");
	    driver.switchTo().frame(0);
	    Thread.sleep(10000);
	    WebElement columnheader1 = driver.findElement(By.xpath("//th[normalize-space()='Month']"));
	    //getting the text value 
	   System.out.println("First Column header is " + columnheader1.getText());
	    Thread.sleep(3000);
	 // Switch back to the main page
	    driver.switchTo().defaultContent();

	   driver.quit();
	}
}
