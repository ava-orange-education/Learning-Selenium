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
public class Chapter03_SelectInteraction {
	@Test(priority = 1)
	public void selectReader() throws Exception {
		// Creating a webdriver instance
//
	  WebDriver driver = new ChromeDriver();
	    //Navigating to W3 website
	    driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
	    driver.switchTo().frame(0);
	    Thread.sleep(10000);
	 // Locate the <select> element by its ID
        WebElement selectElement = driver.findElement(By.id("cars"));
	 // Create a Select object using the <select> element
        Select select = new Select(selectElement);
        // 1. Select option by visible text
        select.selectByVisibleText("Volvo");
        // 2. Select option by value
        // select.selectByValue("saab");
        // 3. Select option by index (0-based index)
        // select.selectByIndex(2);
        // Perform other actions if needed
        // For example, to get the selected option text:
        String selectedOption = select.getFirstSelectedOption().getText();
        System.out.println("Selected option: " + selectedOption);
        // Close the browser
	   driver.quit();
	}
}
