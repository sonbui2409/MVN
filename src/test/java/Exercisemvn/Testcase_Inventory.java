package Exercisemvn;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase_Inventory extends manage_driver {
	
	String passwd = "secret_sauce";
	String url = "https://www.saucedemo.com";
	String urlogin = "https://www.saucedemo.com/inventory.html";
	String login = "//input[@type='submit']";
	String user = "//input[@name = 'user-name']";
	String passbut = "//input[@id = 'password']";
	String badgelink = "//a[@class='shopping_cart_link']";
	String badgeno = "//span[@class='shopping_cart_badge']";
	String buyitem1 = "//button[contains (@name,'backpack')]";
	String buyitem2 = "//button[contains (@name,'bolt-t-shirt')]";
	String buyitem5 = "//button[contains (@name,'fleece-jacket')]";
	String buyitem6 = "//button[contains (@name,'test.allthethings()')]";
	
	public void sleep_3() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void log_in() {
		driver.get(url);
		driver.findElement(By.xpath(user))
		.sendKeys("standard_user"); 
		driver.findElement(By.xpath(passbut)).sendKeys(passwd);
		driver.findElement(By.xpath(login)).click();
		sleep_3();
	}
	public void open_menu() {
		driver.findElement(By.className("bm-burger-button")).click();
	}
	@Test (priority = 1)
	public void buy_an_item() {
		log_in();
		WebElement cart1 = driver.findElement(By.xpath(buyitem1));
		cart1.getText().equalsIgnoreCase("add to cart");
		cart1.click();
		sleep_3();
		driver.findElement(By.xpath(badgelink)).click();
		sleep_3();
		driver.findElement(By.xpath("//span[@class='title']"))
		.getText().equalsIgnoreCase("your cart");
		driver.findElement(By.xpath("//div[@class='inventory_item_name']"))
		.getText().equalsIgnoreCase("Sauce Labs Backpack");
		WebElement price = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
		String pricestr = price.getText();
		pricestr = pricestr.replace("\n", ""); //replace new line
		Assert.assertEquals(pricestr, "$29.99");
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		sleep_3();
		driver.findElement(By.id("first-name")).sendKeys("Son");
		driver.findElement(By.id("last-name")).sendKeys("Bui");
		driver.findElement(By.id("postal-code")).sendKeys("700000");
		sleep_3();
		driver.findElement(By.id("continue")).click();
		sleep_3();
		WebElement total = driver.findElement(By.xpath("//div[@class='summary_total_label']"));
		String totalstr = total.getText();
		totalstr = totalstr.replace("\r",""); //replace separate line
		totalstr = totalstr.replace("\n", ""); //replace new line
		Assert.assertEquals(totalstr, "Total: $32.39");
		driver.findElement(By.id("finish")).click();
		driver.findElement(By.xpath("//h2[@class='complete-header']"))
		.getText().equalsIgnoreCase("THANK YOU FOR YOUR ORDER");
		sleep_3();
	}
	@Test (priority = 3)
	public void Check_cart_number() {
		//driver.get(urlogin);
		sleep_3();
		WebElement cart1 = driver.findElement(By.xpath(buyitem1));
		cart1.click();
		sleep_3();
		//Assert.assertEquals(cart1.getText(),"REMOVE");
		WebElement badge = driver.findElement(By.xpath(badgeno));
		badge.getText().equalsIgnoreCase("1");
		driver.findElement(By.xpath(buyitem2)).click();
		sleep_3();
		badge.getText().equalsIgnoreCase("2");
		driver.findElement(By.xpath(buyitem5)).click();
		sleep_3();
		badge.getText().equalsIgnoreCase("3");
		driver.findElement(By.xpath(buyitem6)).click();
		sleep_3();
		badge.getText().equalsIgnoreCase("4");
		driver.findElement(By.xpath(buyitem5)).click();
		sleep_3();
		badge.getText().equalsIgnoreCase("3");
		driver.findElement(By.xpath(buyitem6)).click();
		sleep_3();
		badge.getText().equalsIgnoreCase("2");		
	}
	@Test (priority = 2)
	public void About() {
		driver.get(urlogin);
		sleep_3();
		open_menu();
		sleep_3();
		WebElement about = driver.findElement(By.id("about_sidebar_link"));
		about.getText().equalsIgnoreCase("about");
		about.click();
		driver.getCurrentUrl().equalsIgnoreCase("https://saucelabs.com/");
		sleep_3();
	}
	@Test (priority = 4)
	public void logout() {
		driver.get(urlogin);
		sleep_3();
		open_menu();
		sleep_3();
		WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
		logout.getText().equalsIgnoreCase("logout");
		logout.click();
		sleep_3();
		WebElement loginbut = driver.findElement(By.xpath(login));
		Assert.assertTrue(loginbut.isDisplayed());
	}
	@Test (priority = 2)
	public void all_item() {
		driver.get(urlogin);
		sleep_3();
		driver.findElement(By.xpath(badgelink)).click();
		sleep_3();
		open_menu();
		sleep_3();
		WebElement allitem = driver.findElement(By.id("inventory_sidebar_link"));
		allitem.getText().equalsIgnoreCase("All Items");
		allitem.click();
		sleep_3();
		driver.findElement(By.xpath("//span[@class='title']"))
		.getText().equalsIgnoreCase("products");
		sleep_3();
	}
}
