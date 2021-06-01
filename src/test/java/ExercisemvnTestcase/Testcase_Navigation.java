package ExercisemvnTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ExerciseBaseCommon.BaseTest;

public class Testcase_Navigation extends BaseTest {
	
	@Test (priority = 1)
	public void buy_an_item() {
		log = report.createTest("Process to Buy an Item");
		log_in();
		mymethod.GetTextFormatEqual(log, driver, buyitem, "backpack", "add to cart");
		mymethod.ClickFormat(log,driver, buyitem, "backpack");
		mymethod.waitclickable(wait, driver, badgelink);
		mymethod.ClickXpath(log,driver, badgelink);
		mymethod.GetTextEqual(log,driver, pagetitle, "your cart");
		mymethod.GetTextEqual(log,driver, buyname1, "Sauce Labs Backpack");		
		mymethod.sAssertEqual_replace(log, softAssert, driver, buyprice1, "$29.99");		
		mymethod.waitclickable(wait, driver, checkout);
		mymethod.ClickXpath(log,driver, checkout);
		mymethod.InputdataId(log,driver, "first-name", "Shin");
		mymethod.InputdataId(log,driver, "last-name", "BLack");
		mymethod.InputdataId(log,driver, "postal-code", "700000");
		mymethod.waitclickable(wait, driver, butcont);
		mymethod.ClickXpath(log, driver, butcont);
		mymethod.sAssertEqual_replace(log, softAssert, driver, totalprice, "Total: $32.39");
		mymethod.waitclickable(wait, driver, finish);
		mymethod.ClickXpath(log, driver, finish);
		mymethod.GetTextEqual(log,driver, completeHead, "THANK YOU FOR YOUR ORDER");
		mymethod.softAssertAll(softAssert);
	}
	@Test (priority = 2)
	public void About() {
		log = report.createTest("Go to About Menu");
		mymethod.GotoURL(log,driver, urlogin);
		open_menu();
		mymethod.waitclickable(wait, driver, about);
		mymethod.GetTextEqual(log,driver,about, "about");
		mymethod.ClickXpath(log,driver, about);
		driver.getCurrentUrl().equalsIgnoreCase("https://saucelabs.com/");
		
	}
	@Test (priority = 2)
	public void all_item() {
		log = report.createTest("Go to About Menu");
		mymethod.GotoURL(log,driver, urlogin);
		mymethod.waitclickable(wait, driver, badgelink);
		mymethod.ClickXpath(log,driver, badgelink);
		open_menu();
		mymethod.waitclickable(wait, driver, allitem);
		mymethod.GetTextEqual(log,driver, allitem, "All Items");
		mymethod.ClickXpath(log,driver, allitem);
		mymethod.GetTextEqual(log,driver, pagetitle, "products");
		sleep_3();
	}
	
	@Test (priority = 3)
	public void Check_cart_number() {
		log = report.createTest("Checking Cart Number");
		mymethod.GotoURL(log,driver, urlogin);
		mymethod.ClickFormat(log,driver, buyitem, "backpack");
		sleep_3();
		//Assert.assertEquals(cart1.getText(),"REMOVE");
		mymethod.GetTextEqual(log,driver, badgeno, "1");
		mymethod.ClickFormat(log,driver, buyitem, "bolt-t-shirt");
		sleep_3();
		mymethod.GetTextEqual(log,driver, badgeno, "2");
		mymethod.ClickFormat(log,driver, buyitem, "fleece-jacket");
		sleep_3();
		mymethod.GetTextEqual(log,driver, badgeno, "3");
		mymethod.ClickFormat(log,driver, buyitem, "test.allthethings()");
		sleep_3();
		mymethod.GetTextEqual(log,driver, badgeno, "4");
		mymethod.ClickFormat(log,driver, buyitem, "fleece-jacket");
		sleep_3();
		mymethod.GetTextEqual(log,driver, badgeno, "3");
		mymethod.ClickFormat(log,driver, buyitem, "backpack");
		mymethod.GetTextEqual(log,driver, badgeno, "2");
	}
	
	@Test (priority = 4)
	public void logout() {
		log = report.createTest("Logout Menu");
		mymethod.GotoURL(log,driver, urlogin);
		open_menu();
		mymethod.waitclickable(wait, driver, logout);
		mymethod.GetTextEqual(log,driver, logout, "logout");
		mymethod.ClickXpath(log, driver, logout);
		mymethod.sAssertDisplay_true(log,softAssert, driver, login);
		mymethod.softAssertAll(softAssert);
	}
}
