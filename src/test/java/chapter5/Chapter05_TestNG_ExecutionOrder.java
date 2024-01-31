package chapter5;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Chapter05_TestNG_ExecutionOrder {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite: Clean the entire house.");
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println("BeforeTest: Ensure the kitchen is ready.");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass: Get all the ingredients for the dish.");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod: Lay out the cooking tools.");
	}

	@Test(groups = "starters")
	public void serveSalad() {
		System.out.println("Test: Serving salad as a starter.");
	}

	@Test(groups = "mains")
	public void servePasta() {
		System.out.println("Test: Serving pasta as a main course.");
	}

	@Test(groups = "desserts")
	public void serveIceCream() {
		System.out.println("Test: Serving ice cream for dessert.");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod: Clean the cooking tools.");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass: Place the dish on the dining table.");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest: Turn off the kitchen lights.");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite: Lock up the house and retire for the night.");
	}

	public static void main(String[] args) {
		// This is just a placeholder. Typically, TestNG tests are not run via a main
		// method.
		// Instead, you'd run this using a TestNG runner (via testng.xml or directly
		// through your IDE's TestNG plugin).
		System.out.println("Run the test through TestNG runner.");
	}
}
