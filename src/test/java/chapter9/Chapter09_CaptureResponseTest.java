package chapter9;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v115.network.Network;

public class Chapter09_CaptureResponseTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		// Kindly ensure that the Devtools version for the imports are as per your
		// browser version, to correctly use Network libraries
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devTools.addListener(Network.responseReceived(), responseReceieved -> {
			System.out.println("Response Url => " + responseReceieved.getResponse().getUrl());
			System.out.println("Response Status => " + responseReceieved.getResponse().getStatus());
			System.out.println("Response Headers => " + responseReceieved.getResponse().getHeaders().toString());
			System.out.println("Response MIME Type => " + responseReceieved.getResponse().getMimeType().toString());
			System.out.println("------------------------------------------------------");
		});

		driver.get("http://google.com");
		driver.close();
	}

}
