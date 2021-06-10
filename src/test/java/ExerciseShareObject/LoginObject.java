package ExerciseShareObject;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import ExerciseBaseCommon.BaseActions;
import ExerciseBaseCommon.DataTest;

public class LoginObject extends BaseActions {
	//Include xpath
	/*protected String passwd = "secret_sauce";
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
*/	
	//method or action into element on page
	
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
		InputdataXpath(log, driver, readExl("Xpath", DataTest.ColXpath, 1), readExl("Login", DataTest.ColUser, 1));
		InputdataXpath(log, driver, readExl("Xpath", DataTest.ColXpath, 2), readExl("Login", DataTest.ColPass, 1));
		ClickXpath(log, driver, readExl("Xpath", DataTest.ColXpath, 3));
		return this;
	} 
	
	//Input Data
	public LoginObject InputUserName (ExtentTest log, WebDriver driver, String data) {
		InputdataXpath(log, driver, readExl("Xpath", DataTest.ColXpath, 1), data);
		return this;
	}
	public LoginObject InputPasswd(ExtentTest log, WebDriver driver) {
		InputdataXpath(log, driver, readExl("Xpath", DataTest.ColXpath, 2), readExl("Login", DataTest.ColPass, 1));
		return this;
	}
	public LoginObject InputPasswd_error(ExtentTest log, WebDriver driver, String data) {
		InputdataXpath(log, driver, readExl("Xpath", DataTest.ColXpath, DataTest.RowXpath_passwd), data);
		return this;
	}
	
	//Click
	public LoginObject ClickLogin_but (ExtentTest log, WebDriver driver) {
		ClickXpath(log, driver, readExl("Xpath", DataTest.ColXpath, 3));
		return this;
	}
	//Verify
	public LoginObject Verify_fail (ExtentTest log,WebDriver driver, String expect) {
		AssertEqual(log, driver, readExl("Xpath", DataTest.ColXpath, 4), expect);
		return this;
	}
	
	public LoginObject Verify_fail_1 (ExtentTest log,SoftAssert softAssert,WebDriver driver) {
		sAssertEqual(log, softAssert, driver, readExl("Xpath", DataTest.ColXpath, 4), readExl("Login", DataTest.ColError, 1));
		return this;
	}
	public LoginObject Verify_fail_2 (SoftAssert softAssert,WebDriverWait wait,ExtentTest log,WebDriver driver) {
		waitclickable(wait, driver, readExl("Xpath", DataTest.ColXpath, 4));
		GetTextEqual(softAssert,log, driver, readExl("Xpath", DataTest.ColXpath, 4), readExl("Login", DataTest.ColError, 2));
		waitclickable(wait, driver, readExl("Xpath", DataTest.ColXpath, 5));
		ClickXpath(log, driver, readExl("Xpath", DataTest.ColXpath, 5));
		return this;
	}
	
	public LoginObject Verify_fail_3 (SoftAssert softAssert,ExtentTest log,WebDriver driver) {
		InputdataXpath(log, driver, readExl("Xpath", 1, 2), "aaa");
		ClickXpath(log, driver, readExl("Xpath", 1, 3));
		GetTextEqual(softAssert,log, driver, readExl("Xpath", 1, 4), readExl("Login", DataTest.ColError, 3));
		return this;
	}
	public LoginObject Verify_fail_4 (SoftAssert softAssert,WebDriverWait wait,ExtentTest log,WebDriver driver) {
		waitvisible(wait, driver, readExl("Xpath", 1, 1));
		InputdataXpath(log, driver, readExl("Xpath", 1, 1), "abc");
		ClearDataxpath(log, driver, readExl("Xpath", 1, 2));
		ClickXpath(log, driver, readExl("Xpath", 1, 3));
		GetTextEqual(softAssert,log, driver, readExl("Xpath", 1, 4), readExl("Login", DataTest.ColError, 4));
		return this;
	}
	public LoginObject Verify_fail_5 (SoftAssert softAssert,ExtentTest log,WebDriver driver) {
		ClearDataxpath(log, driver, readExl("Xpath", 1, 1));
		InputdataXpath(log, driver, readExl("Xpath", 1, 1), "abc");
		ClearDataxpath(log, driver, readExl("Xpath", 1, 2));
		InputdataXpath(log, driver, readExl("Xpath", 1, 2), "aaa");
		ClickXpath(log, driver, readExl("Xpath", 1, 3));
		GetTextEqual(softAssert,log, driver, readExl("Xpath", 1, 4), readExl("Login", DataTest.ColError, 5));
		return this;
	}
	public LoginObject Compare_login_but (ExtentTest log,SoftAssert softAssert,WebDriver driver) {
		sAssertDisplay_true(log, softAssert, driver, readExl("Xpath", 1, 3));
		return this;
	}
	
	//Read excel
	
	
	
	//Track SoftAssert
	public LoginObject TracksAssert (SoftAssert softAssert) {
		softAssertAll(softAssert);
		return this;
	}
	
	public LoginObject LoginFail_1(ExtentReports report,ExtentTest log, WebDriver driver, Assert Assert) {
		ArrayList<String> lstUser = lstData("LoginFail", 0); 
		ArrayList<String> lstPasswd = lstData("LoginFail", 1);
		ArrayList<String> lstError = lstData("LoginFail", 2);
		ArrayList<String> lstTCName = lstData("LoginFail", 3);
		
		for(int i = 1; i < lstUser.size(); i++) {
			String username = lstUser.get(i);
			String password = lstPasswd.get(i);
			String error = lstError.get(i);
			String tcName = lstTCName.get(i);
			log = report.createTest(tcName);
			OpenLoginPage(log, driver);
			InputUserName(log, driver, username);
			InputPasswd_error(log, driver, password);
			ClickLogin_but(log, driver);
			//Verify_fail(log, Assert, driver, error);
			
		}
		
		
		return this;
				
	}

}
