package Exercisemvn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Testcase_login extends manage_driver { //use extends command to get value from a variable of another class
	String passwd = "secret_sauce";
	
	
	@Test
	public void login_Standard() {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@name = 'user-name']"))
		.sendKeys("standard_user"); 
		driver.findElement(By.xpath("//input[@id = 'password']"))
		.sendKeys(passwd);
	}

}
