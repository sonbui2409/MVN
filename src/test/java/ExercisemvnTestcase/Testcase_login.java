package ExercisemvnTestcase;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ExerciseBaseCommon.BaseTest;


public class Testcase_login extends BaseTest { //use extends command to get value from a variable of another class
	
	
	
	@Test (priority = 1)
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
	@Test (priority = 2)
	public void login_failure() {
		log = report.createTest("Login Failure");
		mymethod.InputdataXpath(log,driver, user,"locked_out_user");
		mymethod.InputdataXpath(log,driver,passbut , passwd);
		mymethod.ClickXpath(log,driver, login);
		sleep_3();
		mymethod.sAssertEqual(log,softAssert, driver, error, failure);
		sleep_3();
		
	}
	@Test (priority = 2)
	public void login_problem() {
		log = report.createTest("Login Problem");
		mymethod.GotoURL(log,driver, url);
		mymethod.InputdataXpath(log,driver, user,"problem_user");
		mymethod.InputdataXpath(log,driver,passbut , passwd);
		sleep_3();
		mymethod.ClickXpath(log,driver, login);
		sleep_3();
		mymethod.ClickXpath(log,driver, item1);
		sleep_3();	
		mymethod.sAssertEqual(log,softAssert, driver, itemTitle, "Sauce Labs Fleece Jacket");
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
}
