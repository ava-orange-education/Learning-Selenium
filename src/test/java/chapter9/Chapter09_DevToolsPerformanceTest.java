package chapter9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v115.performance.Performance;
import org.openqa.selenium.devtools.v115.performance.model.Metric;

public class Chapter09_DevToolsPerformanceTest {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Performance.enable(Optional.empty()));

		driver.get("https://www.google.org");

		List<Metric> metrics = devTools.send(Performance.getMetrics());
		List<String> metricNames = metrics.stream().map(o -> o.getName()).collect(Collectors.toList());

		devTools.send(Performance.disable());

		List<String> metricsToCheck = Arrays.asList("Timestamp", "Documents", "Frames", "JSEventListeners",
				"LayoutObjects", "MediaKeySessions", "Nodes", "Resources", "DomContentLoaded", "NavigationStart");

		metricsToCheck.forEach(
				metric -> System.out.println(metric + " is : " + metrics.get(metricNames.indexOf(metric)).getValue()));
		driver.close();
	}
}