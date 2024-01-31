package tasks;

import org.openqa.selenium.WebDriver;

import screenplayactions.With;

public class OpenBrowser {
	public static void navigate(WebDriver driver, String URL) {
		With.URL(driver, URL);

	}
}
