package ExercisemvnTestcase;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ExerciseBaseCommon.BaseTest;


public class Testcase_login extends BaseTest { //use extends command to get value from a variable of another class
	
	
	
	//@Test (priority = 1)
	public void login_Standard() {
		//create a report for test case
		log = report.createTest("Login Standard"); //create a log in each test case it should be input in each test case with test case name in ()
		
		mymethod.GotoURL(log,driver, url);
		mymethod.InputdataXpath(log,driver, user,"standard_user");
		mymethod.InputdataXpath(log,driver,passbut , passwd);
		mymethod.ClickXpath(log,driver, login);
		sleep_3();
		mymethod.sAssertEqual(log,softAssert, driver, pagetitle, "PRODUCTS");
		logout();
	}
	//@Test (priority = 2)
	public void login_failure() {
		log = report.createTest("Login Failure");
		mymethod.GotoURL(log,driver, url);
		mymethod.InputdataXpath(log,driver, user,"locked_out_user");
		mymethod.InputdataXpath(log,driver,passbut , passwd);
		mymethod.ClickXpath(log,driver, login);
		sleep_3();
		mymethod.sAssertEqual(log,softAssert, driver, error, failure1);
		sleep_3();
		
	}
	//@Test (priority = 2)
	public void login_problem() {
		log = report.createTest("Login Problem");
		mymethod.GotoURL(log,driver, url);
		mymethod.InputdataXpath(log,driver, user,"problem_user");
		mymethod.InputdataXpath(log,driver,passbut , passwd);
		sleep_3();
		mymethod.ClickXpath(log,driver, login);
		mymethod.ClickFormat(log, driver, itemlink, "item_1_img_link");
		sleep_3();	
		mymethod.sAssertEqual(log,softAssert, driver, itemdetail_Title, "Sauce Labs Fleece Jacket");
		logout();
	}
	//@Test (priority = 2)
	public void login_performance() {
		driver.get(url);
		driver.findElement(By.xpath(user)).sendKeys("performance_glitch_user");
		driver.findElement(By.xpath(passbut)).sendKeys(passwd);
		driver.findElement(By.xpath(login)).click();
		WebElement title = driver.findElement(By.xpath("//button[contains (@name,'backpack')]"));
		Assert.assertFalse(title.getCssValue("font-size").equalsIgnoreCase("14px"));
		//sleep_20();
		//Assert.assertTrue(title.isDisplayed());
		//Assert.assertTrue(title.isDisplayed());
	}
	@Test (priority = 2)
	public void login_error_page() {
		log = report.createTest("Error message when log-in");
		mymethod.GotoURL(log, driver, urlogin);
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
		mymethod.ClearDataxpath(log, driver,passbut);
	}
}
