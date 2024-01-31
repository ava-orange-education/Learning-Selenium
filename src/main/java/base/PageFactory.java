package base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

public class PageFactory {
	/*
	 * @author: Robin Gupta
	 * 
	 * @Date: 29 Sep 2021
	 * 
	 * @Purpose: This class helps in creating new instances of page objects at run
	 * time using Java Reflections 🏭
	 */

	private WebDriver webDriver;

	public PageFactory(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public Object getPageObject(String pageobject) {

		try {
			Constructor<?> c = Class.forName(pageobject).getConstructor(WebDriver.class);
			return c.newInstance(webDriver);
		} catch (NoSuchMethodException e) {
			BaseTest.logger.error("No such method exception in PageFactory");
			e.printStackTrace();
		} catch (SecurityException e) {
			BaseTest.logger.error("Security exception in PageFactory");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			BaseTest.logger.error("Class not found exception in PageFactory");
			e.printStackTrace();
		} catch (InstantiationException e) {
			BaseTest.logger.error("Instantiation exception in PageFactory");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			BaseTest.logger.error("Illegal Access exception in PageFactory");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			BaseTest.logger.error("Illegal argument exception in PageFactory");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			BaseTest.logger.error("Invocation Target exception in PageFactory");
			e.printStackTrace();
		}
		return null;

	}

}
