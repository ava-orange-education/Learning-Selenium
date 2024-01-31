package chapter5;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class Chapter05_LoginTest extends BaseTest {

	@Test(priority = 1)
	public void loginTest() throws Exception {
		// Navigating to sample page
		loginpage.openHomepage(orangehrmurl);
		// Test Steps
		loginpage.login("Admin", "admin123");
		homepage.clickProfileButton();
		String homepageURL = loginpage.getCurrentURL();
		Assert.assertTrue(homepageURL.contains("dashboard"));
	}
}
