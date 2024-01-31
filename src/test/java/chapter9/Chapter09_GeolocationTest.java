package chapter9;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

import graphql.Assert;

public class Chapter09_GeolocationTest {
	@Test
	public void locationSettingTest() {
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		Map<String, Object> coordinates = new HashMap<>();
		coordinates.put("latitude", 48.858093);
		coordinates.put("longitude", 2.2945);
		coordinates.put("accuracy", 100);
		((ChromeDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.get("https://whatmylocation.com/");
		WebElement shareablelocation = driver.findElement(By.id("latitude"));
		Assert.assertTrue(shareablelocation.getText().contains("48.858093"));
		driver.close();
	}

}
