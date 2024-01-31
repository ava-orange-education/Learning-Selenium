package screenplayactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Click {

	public static void On(WebDriver driver, By locator) {
		driver.findElement(locator).click();
	}

}
