package chapter9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import base.BaseTest;
import graphql.Assert;

public class Chapter09_RelativeLocatorsTest extends BaseTest {
	@Test
	public void relativeLocatorTest() {

		driver.get("https://www.apple.com/in/");
		// Using relative locator to find a webelement for scenarios like regression
		// testing
		By carticonlocator = RelativeLocator.with(By.id("globalnav-bag"))
				.toRightOf(By.xpath("//li[@data-topnav-flyout-label='Search apple.com']"));
		WebElement carticon = driver.findElement(carticonlocator);
		Assert.assertTrue(carticon.isDisplayed());
	}

	@Test
	public void chainingLocatorTest() {
		driver.get("https://www.apple.com/in/");
		// Chaining relative locators to create a stable locator

		By searchiconlocator = RelativeLocator.with(By.xpath("//*[@data-topnav-flyout-label='Search apple.com']"))
				.toRightOf(By.xpath("//a[@aria-label='Support']//span[@class='globalnav-link-text-container']"));
		WebElement carticon = driver.findElement(searchiconlocator);
		Assert.assertTrue(carticon.isDisplayed());
	}

}
