package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pageobjects.OrangeHRMHomePage;
import pageobjects.OrangeLoginPage;
import testzeus.base.PageBase;

/*@author: Robin Gupta
@Date: 29 September 2021
@Purpose: All the test classes extend this base test , so as to carry forward the abstraction for page objects , webdriver setup and TEstNG level methods
🙏
*/

public class BaseTest implements PropertyReader {

	public static final Logger logger = LogManager.getLogger();
	protected static WebDriver driver;

	protected static Actions action;

	protected OrangeLoginPage loginpage;
	protected OrangeHRMHomePage homepage;
	protected static URL huburl;
	protected static PageFactory pageFactory;
	protected Properties staticData = getStaticData();

	protected static EmailUtils emailUtils;

	public static String orangehrmurl;
	public static String orangehrmuserid;
	public static String orangehrmpassword;

	@BeforeSuite(alwaysRun = true)
	@Parameters({ "browserType" })
	public void setupWebDriver(@Optional("chrome") String browserType) throws IOException, URISyntaxException {
		// Below lines can be uncommented to provide log level at fine grained scale for
		// debugging Selenium WebDriver
//		SeleniumLogger seleniumLogger = new SeleniumLogger();
//		seleniumLogger.setLevel(Level.FINE);

		// Uncomment below lines of code for running tests on Grid in Chapter 6
//		try {
//			huburl = new URI("http://localhost:4444").toURL();
//			// Setup GRID URL here or from properties
//		} catch (MalformedURLException ex) {
//			logger.error("Received error in converting URI to URL for Grid as " + ex.getMessage());
//		}
		if ((driver == null)) {
			logger.info("setupWebDriver()" + "With browser as " + browserType + " and HubURL as " + huburl);
			driver = WebDriverFactory.createInstance(huburl, browserType);
			action = new Actions(driver);
			pageFactory = new PageFactory(driver);

			driver.manage().window().maximize();

			logger.info("Window width: " + driver.manage().window().getSize().getWidth());
			logger.info("Window height: " + driver.manage().window().getSize().getHeight());
		}
	}

	@BeforeTest(alwaysRun = true)
	public void cleanTestSetup() {
		driver.manage().deleteAllCookies();
	}

	@BeforeClass(alwaysRun = true)
	protected void setUp() throws MessagingException {
		// Set up the common page objects using Reflections concept
		loginpage = (OrangeLoginPage) pageFactory.getPageObject(OrangeLoginPage.class.getName());
		homepage = (OrangeHRMHomePage) pageFactory.getPageObject(OrangeHRMHomePage.class.getName());
		// Below is code as reference for reading common data from properties file
		// Kindly note that the uncommon data should be read in the specific test class
		orangehrmurl = (String) getStaticData().get("orangehrmloginurl");
		orangehrmuserid = (String) getStaticData().get("orangehrmuserid");
		orangehrmpassword = (String) getStaticData().get("orangehrmpassword");
		// Setting up email utils object
		// EmailUtils emu = new EmailUtils();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDownandCaptureScreenShot(Method method, ITestResult result) {
		// Method for taking screenshots on failure of the test case
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
				String currentdatetime = simpleDateFormat.format(new Date());
				File source = captureScreenShot();
				FileUtils.copyFile(source, new File(System.getProperty("user.dir")
						+ "/target/surefire-reports/FailedScreenShots/" + result.getName() + currentdatetime + ".png"));
				logger.info("Screenshot taken");
			} catch (Exception e) {

				logger.info("Exception while taking screenshot " + e.getMessage());
			}
		}
		logger.info("*************");
		logger.info("Ending Test  ---->" + method.getName());

	}

	@AfterClass(alwaysRun = true)
	public void deleteAllCookies() {
		// Handling windows after executing each class from Suite
		try {
			String originalHandle = driver.getWindowHandle();
			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(originalHandle)) {
					driver.switchTo().window(handle);
					driver.close();
				}
			}
			driver.switchTo().window(originalHandle);
		} catch (Exception e) {
			logger.info("Error while closing child windows" + e.getMessage());
		}
		logger.info("Clearing all browser cookies...");
		driver.manage().deleteAllCookies();
	}

	@AfterSuite(alwaysRun = true)
	public void quitWebDrivers() {
		logger.info("terminateWebDrivers()");
		try {
			driver.close();
			driver.quit();
			// Setting driver to null for stopping persistent use of driver
			// session across browsers
			driver = null;
		} catch (Exception e) {
			// Sometime driver.quit() causes exception and not nullifying the
			// driver obj. Which stops next successful browser launch
			driver = null;
			logger.error("Error quitting driver");
			e.printStackTrace();
		}
	}

	public File captureScreenShot() {
		return new PageBase(driver).takeScreenshot();
	}

	@Override
	public Properties getStaticData() { // Method to read data from static data properties file
		if (staticData == null) {
			staticData = new Properties();
			InputStream input = null;

			try {
				String filename = "staticdata.properties";
				input = BaseTest.class.getClassLoader().getResourceAsStream(filename);
				if (input != null) {
					// load a properties file from class path, inside static
					// method
					staticData.load(input);
					logger.info("staticdata.properties loaded successfully");
				}
			} catch (IOException ex) {
				logger.info("error loading staticdata.properties" + ex.getMessage());
			} finally {
				if (input != null) {
					try {
						input.close();
						logger.info("staticdata.properties closed successfully");
					} catch (IOException e) {
						logger.info(("error loading staticdata.properties") + e.getMessage());
					}
				}
			}
		}
		return staticData;
	}

	public static String excelValueReader(int row, int column) throws FileNotFoundException {
		// Path of the excel file
		FileInputStream fs = new FileInputStream("src\\main\\resources\\ExcelDemoFile.xlsx");
		try (// Creating a workbook
				XSSFWorkbook workbook = new XSSFWorkbook(fs)) {
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row excelrow = sheet.getRow(row);
			Cell cell = excelrow.getCell(column);
			String cellval = cell.getStringCellValue();
			return cellval;
		} catch (IOException e) {
			// TODO Replace with logging if required
			System.out.println("Exception occured in excelValueReader" + e.getMessage());
			return null;
		}
	}

	public static void excelValueWriter(int row, int column, String value) throws FileNotFoundException {
		String path = "src\\main\\resources\\ExcelDemoFile.xlsx";
		FileInputStream fs = new FileInputStream(path);
		try (// Creating a workbook
				XSSFWorkbook workbook = new XSSFWorkbook(fs)) {
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row excelrow = sheet.getRow(row);
			Cell cell = excelrow.getCell(column);
			cell.setCellValue(value);
			FileOutputStream fos = new FileOutputStream(path);
			workbook.write(fos);
			fos.close();
		} catch (IOException e) {
			// TODO Replace with logging if required
			System.out.println("Exception occured in excelValueReader" + e.getMessage());

		}
	}

}
