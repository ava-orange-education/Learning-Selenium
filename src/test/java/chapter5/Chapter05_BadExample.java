package chapter5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.OrangeHRMHomePage;
import pageobjects.OrangeHRMLoginPage;

public class Chapter05_BadExample {
	@Test(priority = 1)
	public void loginTest() throws Exception {
		// Creating a webdriver instance
		WebDriver driver = new ChromeDriver();

		// Navigating to sample page
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// Instantiating page objects for login page and home page
		OrangeHRMLoginPage loginpage = new OrangeHRMLoginPage(driver);
		OrangeHRMHomePage homepage = new OrangeHRMHomePage(driver);
		// Test Steps
		loginpage.login("Admin", "admin123");
		homepage.clickProfileButton();
		String homepageURL = driver.getCurrentUrl();
		Assert.assertTrue(homepageURL.contains("dashboard"));
		driver.quit();
	}
}
