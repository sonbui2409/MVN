package ExerciseShareObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import ExerciseBaseCommon.BaseActions;

public class BuyObject extends BaseActions {
	protected String pagetitle = "//span[@class = 'title']";
	protected String badgelink = "//a[@class='shopping_cart_link']";
	protected String badgeno = "//span[@class='shopping_cart_badge']";
	protected String buyitem = "//button[contains (@name,'%s')]";
	protected String buyname1 = "//div[@class='inventory_item_name']";
	protected String buyprice1 = "//div[@class='inventory_item_price']";
	protected String checkout = "//button[@id='checkout']";
	protected String butcont = "//input[@id='continue']";
	protected String totalprice = "//div[@class='summary_total_label']";
	protected String finish = "//button[@id='finish']";
	protected String completeHead = "//h2[@class='complete-header']";
	
	
	//Input
	public BuyObject Input_Firstname (ExtentTest log, WebDriver driver, String data) {
		InputdataId(log, driver, "first-name", data);
		return this;
	}
	public BuyObject Input_Lastname (ExtentTest log, WebDriver driver, String data) {
		InputdataId(log, driver, "last-name", data);
		return this;
	}
	public BuyObject Input_Postalcode (ExtentTest log, WebDriver driver, String data) {
		InputdataId(log, driver, "postal-code", data);
		return this;
	}
	
	
	//Verify
	public BuyObject Add_item_ToCart (ExtentTest log, WebDriver driver, String item) {
		ClickFormat(log,driver, buyitem, item);
		return this;
	}
	public BuyObject Verify_YourCart_page (WebDriverWait wait,SoftAssert softAssert,ExtentTest log, WebDriver driver, String item, String price) {
		waitclickable(wait, driver, badgelink);
		ClickXpath(log,driver, badgelink);
		GetTextEqual(softAssert,log,driver, pagetitle, "your cart");
		GetTextEqual(softAssert,log,driver, buyname1, item);		
		sAssertEqual_replace(log, softAssert, driver, buyprice1, price);
		return this;
	}
	public BuyObject Goto_Checkout_Page (WebDriverWait wait,ExtentTest log, WebDriver driver) {
		waitclickable(wait, driver, checkout);
		ClickXpath(log,driver, checkout);
		return this;
	}
	public BuyObject Goto_Checkout_Overview (SoftAssert softAssert,WebDriverWait wait,ExtentTest log, WebDriver driver, String pricetotal) {
		waitclickable(wait, driver, butcont);
		ClickXpath(log, driver, butcont);
		sAssertEqual_replace(log, softAssert, driver, totalprice, pricetotal);
		return this;
	}
	public BuyObject Goto_Checkout_Complete (SoftAssert softAssert,WebDriverWait wait,ExtentTest log, WebDriver driver) {
		waitclickable(wait, driver, finish);
		ClickXpath(log, driver, finish);
		GetTextEqual(softAssert,log,driver, completeHead, "THANK YOU FOR YOUR ORDER");
		return this;
	}
	
	public BuyObject Click_Cart (WebDriverWait wait,ExtentTest log, WebDriver driver) {
		waitclickable(wait, driver, badgelink);
		ClickXpath(log, driver, badgelink);
		return this;
	}
	
	//Compare
	public BuyObject Compare_CartNum (SoftAssert softAssert,ExtentTest log, WebDriver driver, String compare) {
		GetTextEqual(softAssert,log, driver, badgeno, compare);
		return this;
	}

}
