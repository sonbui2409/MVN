package Exercisemvn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Testcase_login extends manage_driver { //use extends command to get value from a variable of another class
	String passwd = "secret_sauce";
	String url = "https://www.saucedemo.com/";
	WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
	WebElement user = driver.findElement(By.xpath("//input[@name = 'user-name']"));
	WebElement passbut = driver.findElement(By.xpath("//input[@id = 'password']"));
	WebElement error = driver.findElement(By.xpath("//button[@class='error-button']"));
	
	@Test
	public void login_Standard() {
		driver.get(url);
		user.sendKeys("standard_user"); 
		passbut.sendKeys(passwd);
		login.click();		
		String title = driver.findElement(By.xpath("//span[@class = 'title']"))
		.getText();
		Assert.assertEquals(title, "Products");
	}
	//@Test (priority = 2)
	public void login_failure() {
		driver.get(url);
		login.sendKeys("locked_out_user");
		passbut.sendKeys(passwd);
		login.click();
		String expect = "Epic sadface: Sorry, this user has been locked out.";
		Assert.assertEquals(error.getText(), expect);
		
	}
}
