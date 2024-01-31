package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PageBase;

public class LightningLoginPage extends PageBase {

	@FindBy(id = "username")
	@CacheLookup
	private WebElement username;

	@FindBy(id = "password")
	@CacheLookup
	private WebElement password;

	@FindBy(id = "Login")
	@CacheLookup
	private WebElement login_button;

	public LightningLoginPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);// Creates instance for all web elements
	}

	public void login(String userid, String passwordtext) throws InterruptedException {
		waitForJSandJQueryToLoad();
		username.sendKeys(userid);
		password.sendKeys(passwordtext);
		login_button.click();

	}

}
