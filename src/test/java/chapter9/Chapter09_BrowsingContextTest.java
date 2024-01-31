package chapter9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Chapter09_BrowsingContextTest {

	public static void main(String[] args) {
		FirefoxOptions options = new FirefoxOptions();
		// Note here that we set the WebSocket capability as true
		options.setCapability("webSocketUrl", true);
		WebDriver driver = new FirefoxDriver(options);
		String id = driver.getWindowHandle();
		// Creating a new browsing context
		BrowsingContext browsingContext = new BrowsingContext(driver, id);
		System.out.println("ID for the browsing context is " + browsingContext.getId());
		// Create a new tab using BrowsingContext
		BrowsingContext tabBrowsingContext = new BrowsingContext(driver, WindowType.TAB);
		System.out.println("ID for the new tab is " + tabBrowsingContext.getId());

	}

}
