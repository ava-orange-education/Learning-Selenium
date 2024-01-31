package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class OrangeLoginPage extends PageBase {
	protected WebDriver driver;
	private By usernamelocator = By.xpath("//input[@placeholder='Username']");
	private By passwordlocator = By.xpath("//input[@placeholder='Password']");
	private By loginlocator = By.xpath("//button[@type='submit']");
	private By errormessage = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

	public OrangeLoginPage(WebDriver webDriver) {
		super(webDriver);
		this.driver = webDriver;
	}

	public OrangeHRMHomePage login(String userid, String passwordtext) throws InterruptedException {
		waitForJSandJQueryToLoad();
		explicitWait(usernamelocator, 20);
		// We can optionally call driver methods directly here or optionally use common
		// methods from PageBase
		driver.findElement(usernamelocator).sendKeys(userid);
		driver.findElement(passwordlocator).sendKeys(passwordtext);
		safeClick(loginlocator);
		// Returning the instance of Homepage for fluent style of programming
		return new OrangeHRMHomePage(driver);
	}

	// This method will be used later in Chapter 8
	public String getErrorMessage() throws InterruptedException {
		waitForJSandJQueryToLoad();
		explicitWait(errormessage, 20);
		return driver.findElement(errormessage).getText();
	}

}
