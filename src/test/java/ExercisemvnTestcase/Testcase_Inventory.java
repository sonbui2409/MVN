package ExercisemvnTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ExerciseBaseCommon.manage_driver;

public class Testcase_Inventory extends manage_driver {
	
	@Test (priority = 1)
	public void buy_an_item() {
		log_in();
		mymethod.GetTextFormatEqual(driver, buyitem, "backpack", "add to cart");
		mymethod.ClickFormat(driver, buyitem, "backpack");
		sleep_3();
		mymethod.ClickXpath(driver, badgelink);
		sleep_3();
		mymethod.GetTextEqual(driver, pagetitle, "your cart");
		mymethod.GetTextEqual(driver, "//div[@class='inventory_item_name']", "Sauce Labs Backpack");		
		String price = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
		price = price.replace("\n", ""); //replace new line
		softAssert.assertEquals(price, "$29.99");
		mymethod.ClickXpath(driver, "//button[@id='checkout']");
		sleep_3();
		mymethod.InputdataId(driver, "first-name", "Shin");
		mymethod.InputdataId(driver, "last-name", "BLack");
		mymethod.InputdataId(driver, "postal-code", "700000");
		sleep_3();
		mymethod.ClickId(driver, "continue");
		sleep_3();
		String total = driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
		total = total.replace("\r",""); //replace separate line
		total = total.replace("\n", ""); //replace new line
		softAssert.assertEquals(total, "Total: $32.39");
		mymethod.ClickId(driver, "finish");
		mymethod.GetTextEqual(driver, "//h2[@class='complete-header']", "THANK YOU FOR YOUR ORDER");
		sleep_3();
	}
	@Test (priority = 3)
	public void Check_cart_number() {
		mymethod.GotoURL(driver, urlogin);
		sleep_3();
		mymethod.ClickFormat(driver, buyitem, "backpack");
		sleep_3();
		//Assert.assertEquals(cart1.getText(),"REMOVE");
		mymethod.GetTextEqual(driver, badgeno, "1");
		mymethod.ClickFormat(driver, buyitem, "bolt-t-shirt");
		sleep_3();
		mymethod.GetTextEqual(driver, badgeno, "2");
		mymethod.ClickFormat(driver, buyitem, "fleece-jacket");
		sleep_3();
		mymethod.GetTextEqual(driver, badgeno, "3");
		mymethod.ClickFormat(driver, buyitem, "test.allthethings()");
		sleep_3();
		mymethod.GetTextEqual(driver, badgeno, "4");
		mymethod.ClickFormat(driver, buyitem, "fleece-jacket");
		sleep_3();
		mymethod.GetTextEqual(driver, badgeno, "3");
		mymethod.ClickFormat(driver, buyitem, "backpack");
		sleep_3();
		mymethod.GetTextEqual(driver, badgeno, "2");
	}
	@Test (priority = 2)
	public void About() {
		mymethod.GotoURL(driver, urlogin);
		sleep_3();
		open_menu();
		sleep_3();
		mymethod.GetTextEqual(driver, "//a[@id = 'about_sidebar_link']", "about");
		mymethod.ClickXpath(driver, "//a[@id = 'about_sidebar_link']");
		driver.getCurrentUrl().equalsIgnoreCase("https://saucelabs.com/");
		sleep_3();
		
	}
	@Test (priority = 4)
	public void logout() {
		/*driver.get(urlogin);
		sleep_3();
		open_menu();
		sleep_3();
		WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
		logout.getText().equalsIgnoreCase("logout");
		logout.click();
		sleep_3();
		WebElement loginbut = driver.findElement(By.xpath(login));
		Assert.assertTrue(loginbut.isDisplayed());*/
		mymethod.GotoURL(driver, urlogin);
		sleep_3();
		open_menu();
		sleep_3();
		mymethod.GetTextEqual(driver, "//a[@id = 'logout_sidebar_link']", "logout");
		mymethod.ClickId(driver, "logout_sidebar_link");
		sleep_3();
		mymethod.sAssertDisplay(softAssert, driver, login);
	}
	@Test (priority = 2)
	public void all_item() {
		log_in();
		mymethod.GotoURL(driver, urlogin);
		//sleep_3();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(badgelink)));
		mymethod.ClickXpath(driver, badgelink);
		open_menu();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id = 'inventory_sidebar_link']")));
		//sleep_3();
		mymethod.GetTextEqual(driver, "//a[@id = 'inventory_sidebar_link']", "All Items");
		mymethod.ClickXpath(driver, "//a[@id = 'inventory_sidebar_link']");
		sleep_3();
		mymethod.GetTextEqual(driver, pagetitle, "products");
		sleep_3();
	}
}
