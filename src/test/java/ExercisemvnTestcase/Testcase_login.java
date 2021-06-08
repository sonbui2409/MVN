package ExercisemvnTestcase;


import org.testng.annotations.Test;
import ExerciseBaseCommon.BaseTest;
import ExerciseBaseCommon.DataTest;


public class Testcase_login extends BaseTest { //use extends command to get value from a variable of another class
	
	
	
	//@Test (priority = 1)
	public void login_Standard() {
		//create a report for test case
		log = report.createTest("Login Standard"); //create a log in each test case it should be input in each test case with test case name in ()
		//LoginObject lb = new LoginObject();
		//InventoryObject ib = new InventoryObject();
		lb.OpenLoginPage(log, driver)
		//.InputUserName(log, driver, "standard_user")
		.InputUserName(log, driver, excel.readExl("Login", DataTest.ColUser, 1))
		.InputPasswd(log, driver)
		.ClickLogin_but(log, driver);
		sleep_3();
		ib.CompareTitle(log, softAssert, driver, excel.readExl("Inventory", DataTest.ColPagetitle, 1))
		.Logout(log, wait, driver);
		//lb.TracksAssert(softAssert);
		softAssertAll ();
		
		
	}
	//@Test (priority = 2)
	public void login_failure() {
		log = report.createTest("Login Failure");
		//LoginObject lb = new LoginObject();
		lb.OpenLoginPage(log, driver)
		.InputUserName(log, driver, excel.readExl("Login", DataTest.ColUser, 2))
		.InputPasswd(log, driver)
		.ClickLogin_but(log, driver);
		sleep_3();
		lb.Verify_fail_1(log, softAssert, driver);
		//.TracksAssert(softAssert);
		softAssertAll ();
		/*mymethod.GotoURL(log,driver, url);
		mymethod.InputdataXpath(log,driver, user,"locked_out_user");
		mymethod.InputdataXpath(log,driver,passbut , passwd);
		mymethod.ClickXpath(log,driver, login);
		sleep_3();
		mymethod.sAssertEqual(log,softAssert, driver, error, failure1);
		sleep_3();
		mymethod.softAssertAll(softAssert);*/
		
	}
	//@Test (priority = 2)
	public void login_problem() {
		log = report.createTest("Login Problem");
		//LoginObject lb = new LoginObject();
		//InventoryObject ib = new InventoryObject();
		lb.OpenLoginPage(log, driver)
		.InputUserName(log, driver, excel.readExl("Login", DataTest.ColUser, 3))
		.InputPasswd(log, driver)
		.ClickLogin_but(log, driver);
		sleep_3();
		ib.Verify_Link_item_problem(softAssert, log, wait, driver, "Sauce Labs Fleece Jacket")
		.Logout(log, wait, driver);
		//lb.TracksAssert(softAssert);
		softAssertAll ();
		
		/*mymethod.GotoURL(log,driver, url);
		mymethod.InputdataXpath(log,driver, user,"problem_user");
		mymethod.InputdataXpath(log,driver,passbut , passwd);
		sleep_3();
		mymethod.ClickXpath(log,driver, login);
		mymethod.ClickFormat(log, driver, itemlink, "item_1_img_link");
		sleep_3();	
		mymethod.sAssertEqual(log,softAssert, driver, itemdetail_Title, "Sauce Labs Fleece Jacket");
		logout();
		mymethod.softAssertAll(softAssert);*/
	}
	//@Test (priority = 2)
	/*public void login_performance() {
		driver.get(url);
		driver.findElement(By.xpath(user)).sendKeys("performance_glitch_user");
		driver.findElement(By.xpath(passbut)).sendKeys(passwd);
		driver.findElement(By.xpath(login)).click();
		WebElement title = driver.findElement(By.xpath("//button[contains (@name,'backpack')]"));
		Assert.assertFalse(title.getCssValue("font-size").equalsIgnoreCase("14px"));*/
		/*sleep_20();
		Assert.assertTrue(title.isDisplayed());
		Assert.assertTrue(title.isDisplayed());
	}*/
	
	
	@Test (priority = 2)
	public void login_error_page() {
		log = report.createTest("Error message when log-in");
		//LoginObject lb = new LoginObject();
		//InventoryObject ib = new InventoryObject();
		
		ib.OpenInvenPage(log, driver);
		lb.Verify_fail_2(softAssert,wait, log, driver)
		.Verify_fail_3(softAssert,log, driver)
		//.Verify_fail_4(softAssert,wait, log, driver)
		.Verify_fail_5(softAssert,log, driver);
		//.TracksAssert(softAssert);
		softAssertAll ();
		
		/*mymethod.GotoURL(log, driver, urlogin);
		mymethod.waitclickable(wait, driver, error);
		mymethod.GetTextEqual(log, driver, error, failure2);
		mymethod.waitclickable(wait, driver, errorbut);
		mymethod.ClickXpath(log, driver, errorbut);
		mymethod.waitvisible(wait, driver, user);
		mymethod.InputdataXpath(log, driver, user, "abc");
		mymethod.ClickXpath(log, driver, login);
		
		mymethod.GetTextEqual(log, driver, error, failure4);
		mymethod.ClearDataxpath(log, driver, user);
		mymethod.InputdataXpath(log, driver, passbut, "aaa");
		mymethod.ClickXpath(log, driver, login);
		mymethod.GetTextEqual(log, driver, error, failure3);
		mymethod.ClearDataxpath(log, driver, passbut);
		mymethod.InputdataXpath(log, driver, user, "abc");
		mymethod.InputdataXpath(log, driver, passbut, "aaa");
		mymethod.ClickXpath(log, driver, login);
		mymethod.GetTextEqual(log, driver, error, failure5);
		mymethod.ClearDataxpath(log, driver, user);
		mymethod.ClearDataxpath(log, driver,passbut);*/
	}
}
