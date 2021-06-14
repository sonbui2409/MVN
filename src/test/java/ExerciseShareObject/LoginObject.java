package ExerciseShareObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
import ExerciseBaseCommon.BaseActions;
import ExerciseBaseCommon.DataTest;

public class LoginObject extends BaseActions {
	// Include xpath
	/*
	 * protected String passwd = "secret_sauce"; protected String url =
	 * "https://www.saucedemo.com/"; protected String login =
	 * "//input[@type='submit']"; protected String user =
	 * "//input[@name = 'user-name']"; protected String passbut =
	 * "//input[@id = 'password']"; protected String error =
	 * "//h3[@data-test='error']"; protected String errorbut =
	 * "//button[@class='error-button']"; protected String failure1 =
	 * "Epic sadface: Sorry, this user has been locked out."; protected String
	 * failure2 =
	 * "Epic sadface: You can only access '/inventory.html' when you are logged in."
	 * ; protected String failure3 = "Epic sadface: Username is required"; protected
	 * String failure4 = "Epic sadface: Password is required"; protected String
	 * failure5 =
	 * "Epic sadface: Username and password do not match any user in this service";
	 * //ExcelInit reader = new ExcelInit();
	 */
	// method or action into element on page

	WebDriver LocalDriver; //create a Localdriver which will be = driver to define LocalDriver in Return Class
	
	public LoginObject(WebDriver remoteDriver) {
		super (remoteDriver); //call constructor of Father class (baseActions)
		LocalDriver = remoteDriver;
	}
	
	
	public LoginObject OpenLoginPage(ExtentTest log) {
		// GotoURL(log, url);
		GotoURL(log, readExl("Login", DataTest.ColUrl, 1));
		return this;
	}

	public InventoryObject Login(ExtentTest log) {
		/*
		 * GotoURL(log, url); InputdataXpath(log, user,
		 * "standard_user"); InputdataXpath(log, passbut, passwd);
		 * ClickXpath(log, login);
		 */
		GotoURL(log, readExl("Login", DataTest.ColUrl, 1));
		InputdataXpath(log, readExl("Xpath", DataTest.ColXpath, 1), readExl("Login", DataTest.ColUser, 1));
		InputdataXpath(log, readExl("Xpath", DataTest.ColXpath, 2), readExl("Login", DataTest.ColPass, 1));
		ClickXpath(log, readExl("Xpath", DataTest.ColXpath, 3));
		return new InventoryObject(LocalDriver);
	}

	// Input Data
	public LoginObject InputUserName(ExtentTest log, String data) {
		InputdataXpath(log, readExl("Xpath", DataTest.ColXpath, 1), data);
		return this;
	}

	public LoginObject InputPasswd(ExtentTest log) {
		InputdataXpath(log, readExl("Xpath", DataTest.ColXpath, 2), readExl("Login", DataTest.ColPass, 1));
		return this;
	}

	public LoginObject InputPasswd_error(ExtentTest log, String data) {
		InputdataXpath(log, readExl("Xpath", DataTest.ColXpath, DataTest.RowXpath_passwd), data);
		return this;
	}

	// Click
	public InventoryObject ClickLogin_but(ExtentTest log) {
		ClickXpath(log, readExl("Xpath", DataTest.ColXpath, 3));
		return new InventoryObject(LocalDriver);
	}

	// Verify
	public LoginObject Verify_fail(ExtentTest log, String expect) {
		AssertEqual(log, readExl("Xpath", DataTest.ColXpath, 4), expect);
		return this;
	}

	public LoginObject Verify_fail_1(ExtentTest log) {
		AssertEqual(log, readExl("Xpath", DataTest.ColXpath, 4),
				readExl("Login", DataTest.ColError, 1));
		return this;
	}

	public LoginObject Verify_fail_2(WebDriverWait wait, ExtentTest log) {
		waitclickable(wait, readExl("Xpath", DataTest.ColXpath, 4));
		GetTextEqual(log, readExl("Xpath", DataTest.ColXpath, 4),
		readExl("Login", DataTest.ColError, 2));
		waitclickable(wait, readExl("Xpath", DataTest.ColXpath, 5));
		ClickXpath(log, readExl("Xpath", DataTest.ColXpath, 5));
		return this;
	}

	public LoginObject Verify_fail_3(ExtentTest log) {
		InputdataXpath(log, readExl("Xpath", 1, 2), "aaa");
		ClickXpath(log, readExl("Xpath", 1, 3));
		GetTextEqual(log, readExl("Xpath", 1, 4), readExl("Login", DataTest.ColError, 3));
		return this;
	}

	public LoginObject Verify_fail_4(WebDriverWait wait, ExtentTest log) {
		waitvisible(wait, readExl("Xpath", 1, 1));
		InputdataXpath(log, readExl("Xpath", 1, 1), "abc");
		ClearDataxpath(log, readExl("Xpath", 1, 2));
		ClickXpath(log, readExl("Xpath", 1, 3));
		GetTextEqual( log, readExl("Xpath", 1, 4), readExl("Login", DataTest.ColError, 4));
		return this;
	}

	public LoginObject Verify_fail_5( ExtentTest log) {
		ClearDataxpath(log, readExl("Xpath", 1, 1));
		InputdataXpath(log, readExl("Xpath", 1, 1), "abc");
		ClearDataxpath(log, readExl("Xpath", 1, 2));
		InputdataXpath(log, readExl("Xpath", 1, 2), "aaa");
		ClickXpath(log, readExl("Xpath", 1, 3));
		GetTextEqual(log, readExl("Xpath", 1, 4), readExl("Login", DataTest.ColError, 5));
		return this;
	}

	public LoginObject Compare_login_but(ExtentTest log, SoftAssert softAssert) {
		sAssertDisplay_true(log, softAssert, readExl("Xpath", 1, 3));
		return this;
	}

	// Read excel

	// Track SoftAssert
	public LoginObject TracksAssert(SoftAssert softAssert) {
		softAssertAll(softAssert);
		return this;
	}

}
