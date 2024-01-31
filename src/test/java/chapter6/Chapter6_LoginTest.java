package chapter6;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class Chapter6_LoginTest extends BaseTest {

	@Test(priority = 1)
	public void loginTest() throws Exception {
		// Navigating to sample page
		loginpage.openHomepage(orangehrmurl);
		// Test Steps
		loginpage.login(orangehrmuserid, orangehrmpassword);
		homepage.clickProfileButton();
		String homepageURL = loginpage.getCurrentURL();
		Assert.assertTrue(homepageURL.contains("dashboard"));
	}
}
