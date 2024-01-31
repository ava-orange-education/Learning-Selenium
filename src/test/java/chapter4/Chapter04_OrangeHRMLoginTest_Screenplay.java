package chapter4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import screenplayactions.Assertion;
import tasks.Login;
import tasks.OpenBrowser;

/**
 * @author Robin
 * @date: 29-06-2023
 * @purpose: This test covers the opening for a browser with Google Chrome 👼
 */
public class Chapter04_OrangeHRMLoginTest_Screenplay {
	@Test(priority = 1)
	public void loginTest() throws Exception {
		// Creating a webdriver instance
		WebDriver driver = new ChromeDriver();

		// Attempting the login action
		OpenBrowser.navigate(driver, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Login.As(driver, "Admin", "admin123");
		Assert.assertTrue(Assertion.forSearch(driver));
		// Added Thread sleep just for demo purpose, so that user can see if the
		// homepage is displayed
		Thread.sleep(5000);
		driver.quit();
	}
}
