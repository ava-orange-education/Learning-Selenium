package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMHomePage {
	protected WebDriver driver;

	private By profilebutton = By.xpath("//span[@class='oxd-userdropdown-tab']");

	public OrangeHRMHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickProfileButton() {
		// Setting up Explicit wait for the profile button
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(profilebutton));
		driver.findElement(profilebutton).click();

	}
}
