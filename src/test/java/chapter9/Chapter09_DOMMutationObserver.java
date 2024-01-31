package chapter9;

import static org.openqa.selenium.devtools.events.CdpEventTypes.domMutation;

import java.time.Duration;
import java.util.concurrent.CopyOnWriteArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.HasLogEvents;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Chapter09_DOMMutationObserver {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://smilinrobin.github.io/LearningSelenium/docs/Chapter3_Waits.html");
		CopyOnWriteArrayList<WebElement> mutations = new CopyOnWriteArrayList<>();
		((HasLogEvents) driver).onLogEvent(domMutation(e -> mutations.add(e.getElement())));

		driver.findElement(By.id("implicitbutton")).click();

		wait.until(_d -> !mutations.isEmpty());
		System.out.println("Number of DOM mutations observed is " + mutations.size());
		driver.quit();
	}

}
