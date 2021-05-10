package Exercisemvn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Testcase_login extends manage_driver { //use extends command to get value from a variable of another class
	String passwd = "secret_sauce";
	String url = "https://www.saucedemo.com/";
	String login = "//input[@type='submit']";
	String user = "//input[@name = 'user-name']";
	String passbut = "//input[@id = 'password']";
	String error = "//button[@class='error-button']";
	
	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test (priority = 1)
	public void login_Standard() {
		driver.get(url);
		driver.findElement(By.xpath(user))
		.sendKeys("standard_user"); 
		driver.findElement(By.xpath(passbut)).sendKeys(passwd);
		driver.findElement(By.xpath(login)).click();
		sleep();
		String title = driver.findElement(By.xpath("//span[@class = 'title']"))
		.getText();
		Assert.assertEquals(title, "Products");
	}
	@Test (priority = 2)
	public void login_failure() {
		driver.get(url);
		driver.findElement(By.xpath(user)).sendKeys("locked_out_user");
		driver.findElement(By.xpath(passbut)).sendKeys(passwd);
		driver.findElement(By.xpath(login)).click();
		sleep();
		String expect = "Epic sadface: Sorry, this user has been locked out.";
		WebElement errorbut = driver.findElement(By.xpath(error));
		Assert.assertEquals(errorbut.getText(), expect);
		
	}
}
