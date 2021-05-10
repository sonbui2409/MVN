package Exercisemvn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Testcase_login extends manage_driver { //use extends command to get value from a variable of another class
	String passwd = "secret_sauce";
	String url = "https://www.saucedemo.com/";
	String login = "//input[@type='submit']";
	String user = "//input[@name = 'user-name']";
	String passbut = "//input[@id = 'password']";
	String error = "//h3[@data-test='error']";
	String item1 = "//img[@alt = 'Sauce Labs Backpack']";
	
	public void sleep_3() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void sleep_20() {
		try {
			Thread.sleep(20000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void logout() {
		driver.findElement(By.className("bm-burger-button")).click();
		sleep_3();
		driver.findElement(By.id("logout_sidebar_link"))
		.click();
		sleep_3();
	}
	
	@Test (priority = 1)
	public void login_Standard() {
		driver.get(url);
		driver.findElement(By.xpath(user))
		.sendKeys("standard_user"); 
		driver.findElement(By.xpath(passbut)).sendKeys(passwd);
		driver.findElement(By.xpath(login)).click();
		sleep_3();
		String title = driver.findElement(By.xpath("//span[@class = 'title']"))
		.getText();
		Assert.assertEquals(title, "PRODUCTS");
		logout();
	}
	@Test (priority = 2)
	public void login_failure() {
		driver.findElement(By.xpath(user)).sendKeys("locked_out_user");
		driver.findElement(By.xpath(passbut)).sendKeys(passwd);
		driver.findElement(By.xpath(login)).click();
		sleep_3();
		String expect = "Epic sadface: Sorry, this user has been locked out.";
		WebElement errorbut = driver.findElement(By.xpath(error)); 
		Assert.assertEquals(errorbut.getText(), expect);
		sleep_3();
		
	}
	@Test (priority = 2)
	public void login_problem() {
		driver.get(url);
		driver.findElement(By.xpath(user)).sendKeys("problem_user");
		driver.findElement(By.xpath(passbut)).sendKeys(passwd);
		sleep_3();
		driver.findElement(By.xpath(login)).click();
		sleep_3();
		driver.findElement(By.xpath(item1)).click();
		sleep_3();
		String actual = driver.findElement(By.xpath("//div[contains (@class,'name large_size')]")).getText();		
		Assert.assertEquals(actual, "Sauce Labs Fleece Jacket");
		logout();
	}
	//@Test (priority = 2)
	public void login_performance() {
		driver.get(url);
		driver.findElement(By.xpath(user)).sendKeys("performance_glitch_user");
		driver.findElement(By.xpath(passbut)).sendKeys(passwd);
		driver.findElement(By.xpath(login)).click();
		WebElement title = driver.findElement(By.xpath("//span[@class = 'title']"));		
		Assert.assertFalse(title.isDisplayed());
		//sleep_20();
		//Assert.assertTrue(title.isDisplayed());
	}
}
