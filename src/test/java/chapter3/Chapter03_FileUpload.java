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
public class Chapter03_FileUpload {
	@Test(priority = 1)
	public void fileUploader() throws Exception {
		// Creating a webdriver instance
////
	  WebDriver driver = new ChromeDriver();
	    //Navigating to W3 website
	    driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_input_file");
	    driver.switchTo().frame(0);
	    Thread.sleep(10000);
	 // Locate the upload input button
        WebElement uploadinput = driver.findElement(By.xpath("//input[@id='myfile']"));
        WebElement submitbutton = driver.findElement(By.xpath("//input[@value='Submit']"));
        String filePath = "C:\\Users\\robin.gupta\\OneDrive\\Desktop\\Project 70\\chromedriver_win32\\file.txt";
        uploadinput.sendKeys(filePath);
        // Wait for the file to be uploaded and perform further actions
        // (e.g., verify successful upload or check for error messages)
        // Click on the submit button to select it
        submitbutton.click();
        // Close the browser
	   driver.quit();
	}
}
