package ExerciseShareObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import ExerciseBaseCommon.BaseActions;
import ExerciseBaseCommon.DataTest;

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
	//ExcelInit reader = new ExcelInit();
	
	//method or action into element on page
	public void sleep_3() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public LoginObject OpenLoginPage (ExtentTest log, WebDriver driver) {
		//GotoURL(log, driver, url);
		GotoURL(log, driver, readExl("Login", DataTest.ColUrl, 1));
		return this;
	}
	public LoginObject Login (ExtentTest log, WebDriver driver) {
		/*GotoURL(log, driver, url);
		InputdataXpath(log, driver, user, "standard_user");
		InputdataXpath(log, driver, passbut, passwd);
		ClickXpath(log, driver, login);*/
		GotoURL(log, driver, readExl("Login", DataTest.ColUrl, 1));
		InputdataXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_user), readExl("Login", DataTest.ColUser, 1));
		InputdataXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_passwd), readExl("Login", DataTest.ColPass, 1));
		ClickXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_login));
		return this;
	} 
	
	//Input Data
	public LoginObject InputUserName (ExtentTest log, WebDriver driver, String data) {
		InputdataXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_user), data);
		return this;
	}
	public LoginObject InputPasswd(ExtentTest log, WebDriver driver) {
		InputdataXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_passwd), readExl("Login", DataTest.ColPass, 1));
		return this;
	}
	/*public LoginObject InputPasswd_error(ExtentTest log, WebDriver driver, String data) {
		InputdataXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_passwd), data);
		return this;
	}*/
	
	//Click
	public LoginObject ClickLogin_but (ExtentTest log, WebDriver driver) {
		ClickXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_login));
		return this;
	}
	//Verify
	public LoginObject Verify_fail_1 (ExtentTest log,SoftAssert softAssert,WebDriver driver) {
		sAssertEqual(log, softAssert, driver, readExl("Xpath", 1, DataTest.RowXpath_error), readExl("Login", DataTest.ColError, 1));
		return this;
	}
	public LoginObject Verify_fail_2 (SoftAssert softAssert,WebDriverWait wait,ExtentTest log,WebDriver driver) {
		waitclickable(wait, driver, readExl("Xpath", 1, DataTest.RowXpath_error));
		GetTextEqual(softAssert,log, driver, readExl("Xpath", 1, DataTest.RowXpath_error), readExl("Login", DataTest.ColError, 2));
		waitclickable(wait, driver, readExl("Xpath", 1, DataTest.RowXpath_errorbut));
		ClickXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_errorbut));
		return this;
	}
	
	public LoginObject Verify_fail_3 (SoftAssert softAssert,ExtentTest log,WebDriver driver) {
		InputdataXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_passwd), "aaa");
		ClickXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_login));
		GetTextEqual(softAssert,log, driver, readExl("Xpath", 1, DataTest.RowXpath_error), readExl("Login", DataTest.ColError, 3));
		ClearDataxpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_passwd));
		return this;
	}
	public LoginObject Verify_fail_4 (SoftAssert softAssert,WebDriverWait wait,ExtentTest log,WebDriver driver) {
		waitvisible(wait, driver, readExl("Xpath", 1, DataTest.RowXpath_user));
		InputdataXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_user), "abc");
		ClickXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_login));
		GetTextEqual(softAssert,log, driver, readExl("Xpath", 1, DataTest.RowXpath_error), readExl("Login", DataTest.ColError, 4));
		ClearDataxpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_user));
		return this;
	}
	public LoginObject Verify_fail_5 (SoftAssert softAssert,ExtentTest log,WebDriver driver) {
		InputdataXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_user), "abc");
		InputdataXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_passwd), "aaa");
		ClickXpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_login));
		GetTextEqual(softAssert,log, driver, readExl("Xpath", 1, DataTest.RowXpath_error), readExl("Login", DataTest.ColError, 5));
		ClearDataxpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_user));
		ClearDataxpath(log, driver, readExl("Xpath", 1, DataTest.RowXpath_passwd));
		return this;
	}
	public LoginObject Compare_login_but (ExtentTest log,SoftAssert softAssert,WebDriver driver) {
		sAssertDisplay_true(log, softAssert, driver, readExl("Xpath", 1, DataTest.RowXpath_login));
		return this;
	}
	
	//Read excel
	public LoginObject Readexcel (String sheetname, int icol, int irow) {
		readExl(sheetname, icol, irow);
		return this;
	}
	
	
	//Track SoftAssert
	public LoginObject TracksAssert (SoftAssert softAssert) {
		softAssertAll(softAssert);
		return this;
	}

}
