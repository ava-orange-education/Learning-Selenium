package chapter3;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * @author Robin
 * @date: 29-06-2023
 * @purpose: This test covers the opening for a browser with Google Chrome 👼
 */
public class Chapter03_DragAndDropInteraction {
	@Test(priority = 1)
	public void dragAndDropper() throws Exception {
		// Creating a webdriver instance
//
	  WebDriver driver = new ChromeDriver();
	    //Navigating to W3 website
	    driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");
//	    driver.switchTo().frame(0);
	    Thread.sleep(5000);
	    // Locate the source and target elements
        WebElement sourceElement = driver.findElement(By.xpath("//div[@id='main']//img[@id='drag1']"));
        WebElement targetElement = driver.findElement(By.id("div2"));
      //Creating object of Actions class to build composite actions
        Actions builder = new Actions(driver);
        //Performing the drag and drop action
        builder.dragAndDrop(sourceElement, targetElement).build().perform();
        // Close the browser
	   driver.quit();
	}
}
