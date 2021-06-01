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
	
	//Clear Data
	public LoginObject ClearUserName (ExtentTest log, WebDriver driver) {
		ClearDataxpath(log, driver, user);
		return this;
	}
	public LoginObject ClearPasswd(ExtentTest log, WebDriver driver) {
		ClearDataxpath(log, driver, passbut);
		return this;
	}
	
	//Click
	public LoginObject ClickLogin_but (ExtentTest log, WebDriver driver) {
		ClickXpath(log, driver, login);
		return this;
	}
	public LoginObject ClickError_but (ExtentTest log, WebDriver driver) {
		ClickXpath(log, driver, errorbut);
		return this;
	}
	
	//Wait
	public LoginObject Wait_Error (WebDriverWait wait,WebDriver driver) {
		waitvisible(wait, driver, error);
		return this;
	}
	public LoginObject Wait_Error_but (WebDriverWait wait,WebDriver driver) {
		waitvisible(wait, driver, errorbut);
		return this;
	}
	public LoginObject Wait_User_but (WebDriverWait wait,WebDriver driver) {
		waitvisible(wait, driver, user);
		return this;
	}
	public LoginObject Wait_Pass_but (WebDriverWait wait,WebDriver driver) {
		waitvisible(wait, driver, passbut);
		return this;
	}
	
	
	//Compare
	public LoginObject Compare_fail_1 (ExtentTest log,SoftAssert softAssert,WebDriver driver) {
		sAssertEqual(log, softAssert, driver, error, failure1);
		return this;
	}
	public LoginObject Compare_fail_2 (ExtentTest log,WebDriver driver) {
		GetTextEqual(log, driver, error, failure2);
		return this;
	}
	public LoginObject Compare_fail_3 (ExtentTest log,WebDriver driver) {
		GetTextEqual(log, driver, error, failure3);
		return this;
	}
	public LoginObject Compare_fail_4 (ExtentTest log,WebDriver driver) {
		GetTextEqual(log, driver, error, failure4);
		return this;
	}
	public LoginObject Compare_fail_5 (ExtentTest log,WebDriver driver) {
		GetTextEqual(log, driver, error, failure5);
		return this;
	}
	
	
	//Track SoftAssert
	public LoginObject TracksAssert (SoftAssert softAssert) {
		softAssertAll(softAssert);
		return this;
	}

}
