package ExerciseShareObject;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import ExerciseBaseCommon.BaseActions;

public class LoginObject extends BaseActions {
	//Include xpath
	protected String passwd = "secret_sauce";
	protected String url = "https://www.saucedemo.com/";
	protected String login = "//input[@type='submit']";
	protected String user = "//input[@name = 'user-name']";
	protected String passbut = "//input[@id = 'password']";
	protected String error = "//h3[@data-test='error']";
	protected String errorbut = "//button[@class='error-button']";
	protected String failure1 = "Epic sadface: Sorry, this user has been locked out..";
	protected String failure2 = "Epic sadface: You can only access '/inventory.html' when you are logged in.";
	protected String failure3 = "Epic sadface: Username is required";
	protected String failure4 = "Epic sadface: Password is required";
	protected String failure5 = "Epic sadface: Username and password do not match any user in this service";
	
	//method or action into element on page
	public LoginObject OpenLoginPage (ExtentTest log, WebDriver driver, String url) {
		GotoURL(log, driver, url);
		return this;
	}
	public LoginObject InputUserName (ExtentTest log, WebDriver driver, String data) {
		InputdataXpath(log, driver, user, data);
		return this;
	}
	public LoginObject InputPasswd(ExtentTest log, WebDriver driver) {
		InputdataXpath(log, driver, passbut, passwd);
		return this;
	}
	public LoginObject ClickLogin (ExtentTest log, WebDriver driver) {
		ClickXpath(log, driver, login);
		return this;
	}
	/*public LoginObject CompareLogin (ExtentTest log,SoftAssert softAssert,WebDriver driver, String expect) {
		sAssertEqual(log, softAssert, driver, pagetitle, expect);
		return this;
	}*/
	public LoginObject TracksAssert (SoftAssert softAssert) {
		softAssertAll(softAssert);
		return this;
	}
	public LoginObject Comparefail_1 (ExtentTest log,SoftAssert softAssert,WebDriver driver) {
		sAssertEqual(log, softAssert, driver, error, failure1);
		return this;
	}

}
