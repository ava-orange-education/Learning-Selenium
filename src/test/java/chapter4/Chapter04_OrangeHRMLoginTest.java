package chapter4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageobjects.OrangeHRMHomePage;
import pageobjects.OrangeHRMLoginPage;

/**
 * @author Robin
 * @date: 29-06-2023
 * @purpose: This test covers the opening for a browser with Google Chrome 👼
 */
public class Chapter04_OrangeHRMLoginTest {
	@Test(priority = 1)
	public void loginTest() throws Exception {
		// Creating a webdriver instance
		WebDriver driver = new ChromeDriver();

		// Navigating to sample page
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		Instantiating page objects for login page and home page

		OrangeHRMLoginPage loginpage = new OrangeHRMLoginPage(driver);
		OrangeHRMHomePage homepage = new OrangeHRMHomePage(driver);

//Attempting the login action

		loginpage.login("Admin", "admin123");
		homepage.clickProfileButton();
		System.out.println(driver.getCurrentUrl());
		// Added Thread sleep just for demo purpose, so that user can see if the profile
		// button is clicked
		Thread.sleep(5000);
		driver.quit();
	}
}
