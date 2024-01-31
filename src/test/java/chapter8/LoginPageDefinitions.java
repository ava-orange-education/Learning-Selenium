package chapter8;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageDefinitions {

	@Given("User is on HRMLogin page {string}")
	public void loginTest(String url) {
		Hooks.driver.get(url);

	}

	@When("User enters username as {string} and password as {string}")
	public void login(String userName, String passWord) throws InterruptedException {

		// login to application
		Hooks.loginpage.login(userName, passWord);

	}

	@Then("User should be able to login successfully and land on home page")
	public void verifyLogin() {

		// Verify home page
		String homepageURL = Hooks.driver.getCurrentUrl();
		Assert.assertTrue(homepageURL.contains("dashboard"));

	}

	@Then("User should be able to see error message {string}")
	public void verifyError(String errormessagetext) throws InterruptedException {
		String expectederror = errormessagetext;
		String actualerror = Hooks.loginpage.getErrorMessage();
		Assert.assertEquals(actualerror, expectederror);
	}

}