package ExercisemvnTestcase;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ExerciseBaseCommon.manage_driver;


public class Testcase_login extends manage_driver { //use extends command to get value from a variable of another class
	
	
	
	@Test (priority = 1)
	public void login_Standard() {
		mymethod.GotoURL(driver, url);
		mymethod.InputdataXpath(driver, user,"standard_user");
		mymethod.InputdataXpath(driver,passbut , passwd);
		mymethod.ClickXpath(driver, login);
		sleep_3();
		mymethod.sAssertEqual(softAssert, driver, pagetitle, "PRODUCTS");
		logout();
	}
	@Test (priority = 2)
	public void login_failure() {
		mymethod.InputdataXpath(driver, user,"locked_out_user");
		mymethod.InputdataXpath(driver,passbut , passwd);
		mymethod.ClickXpath(driver, login);
		sleep_3();
		String expect = "Epic sadface: Sorry, this user has been locked out.";
		mymethod.sAssertEqual(softAssert, driver, error, expect);
		sleep_3();
		
	}
	@Test (priority = 2)
	public void login_problem() {
		mymethod.GotoURL(driver, url);
		mymethod.InputdataXpath(driver, user,"problem_user");
		mymethod.InputdataXpath(driver,passbut , passwd);
		sleep_3();
		mymethod.ClickXpath(driver, login);
		sleep_3();
		mymethod.ClickXpath(driver, item1);
		sleep_3();	
		mymethod.sAssertEqual(softAssert, driver, "//div[contains (@class,'name large_size')]", "Sauce Labs Fleece Jacket");
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
