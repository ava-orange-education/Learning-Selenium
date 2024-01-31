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
public class Chapter03_newTabInteraction {
	@Test(priority = 1)
	public void tabOpener() throws Exception {
		// Creating a webdriver instance
//
	  WebDriver driver = new ChromeDriver();
	    //Navigating to W3 website
	    driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_a_target");
	    driver.switchTo().frame(0);
	    Thread.sleep(10000);
	    WebElement tablink = driver.findElement(By.xpath("//a[normalize-space()='Visit W3Schools!']"));
	    tablink.click();
	 // Get the handles of all open tabs
        String parentTabHandle = driver.getWindowHandle();
        System.out.println("window handle of the parent tab is :"+parentTabHandle);
        for (String tabHandle : driver.getWindowHandles()) {
            if (!tabHandle.equals(parentTabHandle)) {
                driver.switchTo().window(tabHandle);
        	    Thread.sleep(5000);
                break;
            }
        }
        // Perform actions in the new tab
        System.out.println("tab handle of the new tab is :"+parentTabHandle);
        System.out.println("Title of the new tab: " + driver.getTitle());
        // Switch back to the parent tab
        driver.switchTo().window(parentTabHandle);
	    Thread.sleep(5000);
        // Perform actions in the parent tab
        System.out.println("Title of the parent tab: " + driver.getTitle());
	   driver.quit();
	}
}
