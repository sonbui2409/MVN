package ExercisemvnTestcase;

import java.util.ArrayList;
import org.testng.annotations.Test;
import ExerciseBaseCommon.BaseTest;
import ExerciseBaseCommon.DataTest;
import ExerciseBaseCommon.ManageObject;
import ExerciseShareObject.BuyObject;
import ExerciseShareObject.InventoryObject;
import ExerciseShareObject.LoginObject;


public class Testcase_login extends BaseTest { // use extends command to get value from a variable of another class
	LoginObject lb;
	InventoryObject ib;
	BuyObject bb;
	
	
	//@BeforeClass
	public void initObject() {
		lb = new LoginObject(driver, log);
		//ib = new InventoryObject(driver,log);
		//bb = new BuyObject(driver,log);
	}
	
	@Test (priority = 1)
	public void login_Standard() {
		// create a report for test case
		log = report.createTest("Login Standard");
		// create a log in each test case it should be input in each test
		// case with test case name in ()
		// LoginObject lb = new LoginObject();
		// InventoryObject ib = new InventoryObject();
		lb = ManageObject.ManageLogin(driver, log);
		lb.OpenLoginPage()
				// .InputUserName(log, "standard_user")
				.InputUserName(readExl("Login", DataTest.CUser, DataTest.Ruser ))
				.InputPasswd();
		ib = lb.ClickLogin_but();
		sleep_n(2);
		ib.CompareTitle(readExl("Inventory", DataTest.Ctitle, DataTest.Rproduct));
		lb = ib.Logout(wait);

	}

	@Test (priority = 2)
	public void login_failure() {
		log = report.createTest("Login Failure");
		lb = ManageObject.ManageLogin(driver, log);
		lb.OpenLoginPage()
		.InputUserName(readExl("Login", DataTest.CUser,DataTest.Ruserfail))
		.InputPasswd()
		.ClickLogin_but();
		sleep_n(2);
		lb.Verify_fail_1();

		/*
		 * mymethod.GotoURL(log,, url); mymethod.InputdataXpath(log,,
		 * user,"locked_out_user"); mymethod.InputdataXpath(log,,passbut ,
		 * passwd); mymethod.ClickXpath(log,, login); sleep_3();
		 * mymethod.sAssertEqual(log,softAssert, error, failure1); sleep_3();
		 * mymethod.softAssertAll(softAssert);
		 */

	}

	@Test (priority = 2)
	public void login_problem() {
		log = report.createTest("Login Problem");
		
		// InventoryObject ib = new InventoryObject();
		lb = ManageObject.ManageLogin(driver, log);
		lb.OpenLoginPage().InputUserName(readExl("Login", DataTest.CUser, DataTest.Ruserprob))
				.InputPasswd();
				ib = lb.ClickLogin_but();
		sleep_n(2);
		ib.Verify_Link_item_problem(wait)
		.Logout(wait);


		/*
		 * mymethod.GotoURL(log,, url); mymethod.InputdataXpath(log,,
		 * user,"problem_user"); mymethod.InputdataXpath(log,,passbut , passwd);
		 * sleep_3(); mymethod.ClickXpath(log,, login); mymethod.ClickFormat(log,
		 * itemlink, "item_1_img_link"); sleep_3();
		 * mymethod.sAssertEqual(log,softAssert, itemdetail_Title,
		 * "Sauce Labs Fleece Jacket"); logout(); mymethod.softAssertAll(softAssert);
		 */
	}
	// @Test (priority = 2)
	/*
	 * public void login_performance() { .get(url);
	 * .findElement(By.xpath(user)).sendKeys("performance_glitch_user");
	 * .findElement(By.xpath(passbut)).sendKeys(passwd);
	 * .findElement(By.xpath(login)).click(); WebElement title =
	 * .findElement(By.xpath("//button[contains (@name,'backpack')]"));
	 * Assert.assertFalse(title.getCssValue("font-size").equalsIgnoreCase("14px"));
	 */
	/*
	 * sleep_20(); Assert.assertTrue(title.isDisplayed());
	 * Assert.assertTrue(title.isDisplayed()); }
	 */

	@Test(priority = 2)
	public void login_error_page() {
		

		ArrayList<String> lstUser = reader.readExcelFileAtColumn(BaseTest.fileName, "LoginFail", 0);
		ArrayList<String> lstPasswd = reader.readExcelFileAtColumn(BaseTest.fileName, "LoginFail", 1);
		ArrayList<String> lstError = reader.readExcelFileAtColumn(BaseTest.fileName, "LoginFail", 2);
		ArrayList<String> lstTCName = reader.readExcelFileAtColumn(BaseTest.fileName, "LoginFail", 3);

		for (int i = 1; i < lstUser.size(); i++) {
			String username = lstUser.get(i);
			String password = lstPasswd.get(i);
			String error = lstError.get(i);
			String tcName = lstTCName.get(i);
			if (!tcName.isEmpty()) {
				log = report.createTest(tcName);
				
				lb = ManageObject.ManageLogin(driver, log);
				
				lb.OpenLoginPage().InputUserName(username)
						.InputPasswd_error(password)
						.ClickLogin_but();
						lb.Verify_fail(error);

			}
		}
		

		/*
		 * ib.OpenInvenPage(log, ); lb.Verify_fail_2(softAssert,wait, log, )
		 * .OpenLoginPage(log, ) .Verify_fail_3(softAssert,log, )
		 * .OpenLoginPage(log, ) .Verify_fail_4(softAssert,wait, log, )
		 * .OpenLoginPage(log, ) .Verify_fail_5(softAssert,log, )
		 * .TracksAssert(softAssert);
		 */

		/*
		 * mymethod.GotoURL(log, urlogin); mymethod.waitclickable(wait,
		 * error); mymethod.GetTextEqual(log, error, failure2);
		 * mymethod.waitclickable(wait, errorbut); mymethod.ClickXpath(log,
		 * errorbut); mymethod.waitvisible(wait, user);
		 * mymethod.InputdataXpath(log, user, "abc"); mymethod.ClickXpath(log,
		 * login);
		 * 
		 * mymethod.GetTextEqual(log, error, failure4);
		 * mymethod.ClearDataxpath(log, user); mymethod.InputdataXpath(log,
		 * passbut, "aaa"); mymethod.ClickXpath(log, login);
		 * mymethod.GetTextEqual(log, error, failure3);
		 * mymethod.ClearDataxpath(log, passbut); mymethod.InputdataXpath(log,
		 * user, "abc"); mymethod.InputdataXpath(log, passbut, "aaa");
		 * mymethod.ClickXpath(log, login); mymethod.GetTextEqual(log,
		 * error, failure5); mymethod.ClearDataxpath(log, user);
		 * mymethod.ClearDataxpath(log,passbut);
		 */
	}

}
