package chapter7;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

public class Chapter07_ZAPTest {
	static final String ZAP_API_KEY = "90t1jo31ububjg0go75i0out3j";
	static final int ZAP_PROXY_PORT = 8081; // This is the port on which ZAP is running
	static final String ZAP_PROXY_ADDRESS = "localhost";
	public WebDriver driver;
	public ClientApi clientapi;

	@BeforeMethod
	public void proxySetup() {
		String proxyserverURL = "http://" + ZAP_PROXY_ADDRESS + ":" + ZAP_PROXY_PORT;
		Proxy proxy = new Proxy(); // This dependency is being utilized from Selenium
		proxy.setHttpProxy(proxyserverURL);
		proxy.setSslProxy(proxyserverURL);
		ChromeOptions options = new ChromeOptions();
		options.setProxy(proxy);
		options.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(options);
		clientapi = new ClientApi(ZAP_PROXY_ADDRESS, ZAP_PROXY_PORT, ZAP_API_KEY);
	}

	@Test
	public void seleniumSecurityTest() {
		driver.get("https://www.selenium.dev/");
	}

	@AfterMethod
	public void TearDown() throws ClientApiException {
		if (clientapi != null) {
			String reporttitle = "Selenium website ZAP Report";
			String template = "traditional-html";
			String description = "OWASP ZAP report for https://www.selenium.dev/";
			String reportfilename = "selenium-zap-report.html";
			String targetfolder = System.getProperty("user.dir");
			System.out.println("Report is generated at this folder " + targetfolder);
			ApiResponse apiresponse = clientapi.reports.generate(reporttitle, template, null, description, null, null,
					null, null, null, reportfilename, null, targetfolder, null);
			System.out.println("Check the ZAP report at this location " + apiresponse.toString());
			driver.quit();
		}
	}
}
