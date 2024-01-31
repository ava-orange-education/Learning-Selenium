package chapter3;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * @author Robin
 * @date: 29-06-2023
 * @purpose: This test covers the opening for a browser with Google Chrome 👼
 */
public class Chapter03_RadioInteraction {
	@Test(priority = 1)
	public void radioReader() throws Exception {
		// Creating a webdriver instance
//
	  WebDriver driver = new ChromeDriver();
	    //Navigating to W3 website
	    driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio");
	    driver.switchTo().frame(0);
	    Thread.sleep(10000);
	 // Locate the radio buttons by their IDs
        WebElement htmlRadio = driver.findElement(By.id("html"));
        WebElement cssRadio = driver.findElement(By.id("css"));
        WebElement javascriptRadio = driver.findElement(By.id("javascript"));
        // Click on the radio button to select it
        cssRadio.click();
        // Perform other actions if needed
        // For example, to check if a radio button is selected:
        boolean isHtmlSelected = htmlRadio.isSelected();
        System.out.println("Is HTML radio button selected? " + isHtmlSelected);
        // Close the browser
	   driver.quit();
	}
}
