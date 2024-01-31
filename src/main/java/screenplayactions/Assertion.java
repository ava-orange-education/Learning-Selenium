package screenplayactions;

import org.openqa.selenium.WebDriver;

import uiscreens.HomePageUI;

public class Assertion {

	public static boolean forSearch(WebDriver driver) {
		ExplicitWait.forElement(driver, HomePageUI.searchfield, 15);
		return driver.findElement(HomePageUI.searchfield).isDisplayed();
	}

}
