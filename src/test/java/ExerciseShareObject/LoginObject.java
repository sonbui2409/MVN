package ExerciseShareObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	protected String failure1 = "Epic sadface: Sorry, this user has been locked out.";
	protected String failure2 = "Epic sadface: You can only access '/inventory.html' when you are logged in.";
	protected String failure3 = "Epic sadface: Username is required";
	protected String failure4 = "Epic sadface: Password is required";
	protected String failure5 = "Epic sadface: Username and password do not match any user in this service";
	
	//method or action into element on page
	public LoginObject OpenLoginPage (ExtentTest log, WebDriver driver) {
		GotoURL(log, driver, url);
		return this;
	}
	public LoginObject Login (ExtentTest log, WebDriver driver) {
		GotoURL(log, driver, url);
		InputdataXpath(log, driver, user, "standard_user");
		InputdataXpath(log, driver, passbut, passwd);
		ClickXpath(log, driver, login);
		return this;
	} 
	
	//Input Data
	public LoginObject InputUserName (ExtentTest log, WebDriver driver, String data) {
		InputdataXpath(log, driver, user, data);
		return this;
	}
	public LoginObject InputPasswd(ExtentTest log, WebDriver driver) {
		InputdataXpath(log, driver, passbut, passwd);
		return this;
	}
	public LoginObject InputPasswd_error(ExtentTest log, WebDriver driver, String data) {
		InputdataXpath(log, driver, passbut, data);
		return this;
	}
	
	//Click
	public LoginObject ClickLogin_but (ExtentTest log, WebDriver driver) {
		ClickXpath(log, driver, login);
		return this;
	}
	//Verify
	public LoginObject Verify_fail_1 (ExtentTest log,SoftAssert softAssert,WebDriver driver) {
		sAssertEqual(log, softAssert, driver, error, failure1);
		return this;
	}
	public LoginObject Verify_fail_2 (SoftAssert softAssert,WebDriverWait wait,ExtentTest log,WebDriver driver) {
		waitclickable(wait, driver, error);
		GetTextEqual(softAssert,log, driver, error, failure2);
		waitclickable(wait, driver, errorbut);
		ClickXpath(log, driver, errorbut);
		return this;
	}
	
	public LoginObject Verify_fail_3 (SoftAssert softAssert,ExtentTest log,WebDriver driver) {
		InputdataXpath(log, driver, passbut, "aaa");
		ClickXpath(log, driver, login);
		GetTextEqual(softAssert,log, driver, error, failure3);
		ClearDataxpath(log, driver, passbut);
		return this;
	}
	public LoginObject Verify_fail_4 (SoftAssert softAssert,WebDriverWait wait,ExtentTest log,WebDriver driver) {
		waitvisible(wait, driver, user);
		InputdataXpath(log, driver, user, "abc");
		ClickXpath(log, driver, login);
		GetTextEqual(softAssert,log, driver, error, failure4);
		ClearDataxpath(log, driver, user);
		return this;
	}
	public LoginObject Verify_fail_5 (SoftAssert softAssert,ExtentTest log,WebDriver driver) {
		InputdataXpath(log, driver, user, "abc");
		InputdataXpath(log, driver, passbut, "aaa");
		ClickXpath(log, driver, login);
		GetTextEqual(softAssert,log, driver, error, failure5);
		ClearDataxpath(log, driver, user);
		ClearDataxpath(log, driver,passbut);
		return this;
	}
	public LoginObject Compare_login_but (ExtentTest log,SoftAssert softAssert,WebDriver driver) {
		sAssertDisplay_true(log, softAssert, driver, login);
		return this;
	}
	
	
	
	//Track SoftAssert
	public LoginObject TracksAssert (SoftAssert softAssert) {
		softAssertAll(softAssert);
		return this;
	}

}
