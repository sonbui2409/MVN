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
	public BuyObject(WebDriver remoteDriver) {
		super (remoteDriver); //call constructor of Father class (baseActions)
	}
	
	
	
	public BuyObject Input_Firstname (ExtentTest log,  String data) {
		InputdataId(log,  "first-name", data);
		return this;
	}
	public BuyObject Input_Lastname (ExtentTest log,  String data) {
		InputdataId(log,  "last-name", data);
		return this;
	}
	public BuyObject Input_Postalcode (ExtentTest log,  String data) {
		InputdataId(log,  "postal-code", data);
		return this;
	}
	
	
	//Verify
	public BuyObject Add_item_ToCart (ExtentTest log,  String item) {
		ClickFormat(log, buyitem, item);
		return this;
	}
	public BuyObject Verify_YourCart_page (WebDriverWait wait,ExtentTest log,  String item, String price) {
		waitclickable(wait,  badgelink);
		ClickXpath(log, badgelink);
		GetTextEqual(log, pagetitle, "your cart");
		GetTextEqual(log, buyname1, item);		
		AssertEqual_replace(log,   buyprice1, price);
		return this;
	}
	public BuyObject Goto_Checkout_Page (WebDriverWait wait,ExtentTest log) {
		waitclickable(wait,  checkout);
		ClickXpath(log, checkout);
		return this;
	}
	public BuyObject Goto_Checkout_Overview (WebDriverWait wait,ExtentTest log,  String pricetotal) {
		waitclickable(wait,  butcont);
		ClickXpath(log,  butcont);
		AssertEqual_replace(log,   totalprice, pricetotal);
		return this;
	}
	public BuyObject Goto_Checkout_Complete (WebDriverWait wait,ExtentTest log) {
		waitclickable(wait,  finish);
		ClickXpath(log,  finish);
		GetTextEqual(log, completeHead, "THANK YOU FOR YOUR ORDER");
		return this;
	}
	
	public BuyObject Click_Cart (WebDriverWait wait,ExtentTest log) {
		waitclickable(wait,  badgelink);
		ClickXpath(log,  badgelink);
		return this;
	}
	
	//Compare
	public BuyObject Compare_CartNum (ExtentTest log,  String compare) {
		GetTextEqual(log,  badgeno, compare);
		return this;
	}

}
