package chapter9;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;

public class Chapter09_ConsoleLogTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ava-orange-education.github.io/Learning-Selenium/docs/Chapter9_ConsoleLogs.html");
		driver.findElement(By.id("consoleLog")).click();
		driver.findElement(By.id("consoleError")).click();

		LogEntries logEntries = driver.manage().logs().get("browser");
		for (org.openqa.selenium.logging.LogEntry entry : logEntries) {
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
			String errorLogType = entry.getLevel().toString();
			String errorLog = entry.getMessage().toString();

			System.out.println("Error LogType: " + errorLogType + " Error Log message: " + errorLog);

		}	driver.quit();

	}

}
