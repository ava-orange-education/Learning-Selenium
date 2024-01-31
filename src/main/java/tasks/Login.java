package tasks;

import org.openqa.selenium.WebDriver;

import screenplayactions.Click;
import screenplayactions.Enter;
import screenplayactions.ExplicitWait;
import uiscreens.LoginUI;

public class Login {
	public static void As(WebDriver driver, String userid, String passwordtext) throws InterruptedException {
		// Waiting for the home page to load
		ExplicitWait.forElement(driver, LoginUI.usernamefield, 15);
		// Typing the username
		Enter.Text(driver, LoginUI.usernamefield, userid);
		// Typing the password
		Enter.Text(driver, LoginUI.passwordfield, passwordtext);
		// Pressing the Login button
		Click.On(driver, LoginUI.submitbutton);

	}
}
