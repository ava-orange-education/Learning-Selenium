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
public class Chapter03_FormSubmission {
	@Test(priority = 1)
	public void displayChecker() throws Exception {
		// Creating a webdriver instance
//
	  WebDriver driver = new ChromeDriver();
	    //Navigating to OrangeHRM demo login page
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    Thread.sleep(3000);
	    WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
	    username.sendKeys("Admin");
	    WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	    password.sendKeys("admin123");
	    WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
	    loginbutton.submit();
	    Thread.sleep(3000);
	    //Checking if the home page is displayed
	   System.out.println( "URL of the dashboard is  "+driver.getCurrentUrl());
	   driver.quit();
	}
}
