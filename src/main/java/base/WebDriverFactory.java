package base;

import java.io.IOException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")
public class WebDriverFactory {

	/*
	 * @author: Robin Gupta
	 * 
	 * @Date: 29 September 2023
	 * 
	 * @Purpose: This class helps in setting up the webdriver dynamically as per the
	 * parameters passed from BaseTest class. 🏭
	 */

	static Logger log = LogManager.getLogger(WebDriverFactory.class);

	public static WebDriver createInstance(URL hubUrl, String browserName) throws IOException {
		WebDriver driver = null;
		try {
			if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver(createFirefoxProfile());
			} else if (browserName.equalsIgnoreCase("chrome") && hubUrl == null) {
				driver = new ChromeDriver();
//		Uncomment below lines of code for running tests on Grid in Chapter 6
// 			} else if (browserName.equalsIgnoreCase("chrome") && hubUrl != null) {
//				DesiredCapabilities capabilities = new DesiredCapabilities();
//				capabilities.setCapability("browserName", "chrome");
//				driver = new RemoteWebDriver(hubUrl, capabilities);
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("safari") && isSafariSupportedPlatform()) {
				driver = new SafariDriver();
			}

		}

		catch (Exception e) {
			log.error("Error creating browser session --" + e.getLocalizedMessage());
		}
		log.info("WebDriverFactory created an instance of WebDriver for: " + browserName);
		return driver;
	}

	static boolean isSafariSupportedPlatform() {
		Platform current = Platform.getCurrent();
		return Platform.MAC.is(current) || Platform.WINDOWS.is(current);
	}

	static FirefoxOptions createFirefoxProfile() {
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxOptions options = new FirefoxOptions();

		profile.setPreference("dom.max_chrome_script_run_time", 60);
		profile.setPreference("setTimeoutInSeconds", 60);
		profile.setPreference("dom.max_script_run_time", 60);
		profile.setPreference("dom.popup_maximum", 0);
		profile.setPreference("privacy.popups.disable_from_plugins", 3);
		profile.setPreference("browser.xul.error_pages.enabled", false);
		profile.setPreference("general.useragent.extra.firefox", "Firefox");
		profile.setAcceptUntrustedCertificates(true);
		options.setProfile(profile);
		return (options);
	}
}