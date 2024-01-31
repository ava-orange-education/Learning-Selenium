package chapter6;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.grid.Main;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Chapter6_StandAloneGridTest {

	@Test(priority = 1)
	public void gridTest() throws Exception {
		final URL gridServerUrl;

		int port = PortProber.findFreePort();
		Main.main(new String[] { "standalone", "--port", String.valueOf(port) });
		gridServerUrl = new URL(String.format("http://localhost:%d/", port));
		RemoteWebDriver driver = new RemoteWebDriver(gridServerUrl, new ChromeOptions());
		// Navigating to sample page
		driver.get("https://google.com");
		Thread.sleep(3000);
		driver.quit();
	}
}
