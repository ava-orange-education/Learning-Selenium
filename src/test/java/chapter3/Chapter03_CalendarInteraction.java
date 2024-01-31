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
public class Chapter03_CalendarInteraction {
	@Test(priority = 1)
	public void dateSetter() throws Exception {
		// Creating a webdriver instance
//
	  WebDriver driver = new ChromeDriver();
	    //Navigating to calendar page
	    driver.get("https://jqueryui.com/datepicker/");
	    Thread.sleep(3000);
driver.switchTo().frame(0);
	 // Locate the date element using XPath (Replace with appropriate locator strategy)
        WebElement dateinputelement = driver.findElement(By.xpath("//input[@id='datepicker']"));
        dateinputelement.click();
Thread.sleep(3000);
        WebElement dateElement = driver.findElement(By.xpath("//a[@data-date=\"5\"]"));
        // Click on the date element to select the date
        dateElement.click();
        Thread.sleep(3000);
        // Optionally, perform actions after selecting the date
        // For example, you can verify the selected date by getting the element's text
        String selectedDate = dateElement.getText();
        System.out.println("Selected Date: " + selectedDate);
	   driver.quit();
	}
}
