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
public class Chapter03_TableInteraction {
	@Test(priority = 1)
	public void tableReader() throws Exception {
		// Creating a webdriver instance
//
	  WebDriver driver = new ChromeDriver();
	    //Navigating to W3 website
	    driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_table_test");
	    driver.switchTo().frame(0);
	    Thread.sleep(10000);
	 // Locate the table element
        WebElement tableElement = driver.findElement(By.xpath("//table"));
        // Access all rows within the table
        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
        // Loop through rows and access cells (columns)
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            // Accessing data from each cell and printing it
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "\t");
            }
            System.out.println(); // Move to the next row
        }
	   driver.quit();
	}
}
