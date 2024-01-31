package screenplayactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Enter {

	public static void Text(WebDriver driver, By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

}
