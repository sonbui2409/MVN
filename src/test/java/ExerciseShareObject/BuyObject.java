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
	WebDriver LocalDriver;
	public static ExtentTest LocalLog;
	
	
	//Input
	public BuyObject(WebDriver remoteDriver, ExtentTest remoteLog) {
		super (remoteDriver, remoteLog); //call constructor of Father class (baseActions)
		LocalDriver = remoteDriver;
		LocalLog = remoteLog;
		
	}
	
	
	
	public BuyObject Input_Firstname (String data) {
		InputdataId("first-name", data);
		return this;
	}
	public BuyObject Input_Lastname (String data) {
		InputdataId("last-name", data);
		return this;
	}
	public BuyObject Input_Postalcode (String data) {
		InputdataId("postal-code", data);
		return this;
	}
	
	
	//Verify
	public BuyObject Add_item_ToCart (String item) {
		ClickFormat(buyitem, item);
		return this;
	}
	public BuyObject Verify_YourCart_page (WebDriverWait wait,String item, String price) {
		waitclickable(wait,  badgelink);
		ClickXpath(badgelink);
		GetTextEqual(pagetitle, "your cart");
		GetTextEqual(buyname1, item);		
		AssertEqual_replace(buyprice1, price);
		return this;
	}
	public BuyObject Goto_Checkout_Page (WebDriverWait wait) {
		waitclickable(wait,  checkout);
		ClickXpath(checkout);
		return this;
	}
	public BuyObject Goto_Checkout_Overview (WebDriverWait wait,String pricetotal) {
		waitclickable(wait,  butcont);
		ClickXpath(butcont);
		AssertEqual_replace(totalprice, pricetotal);
		return this;
	}
	public BuyObject Goto_Checkout_Complete (WebDriverWait wait) {
		waitclickable(wait,  finish);
		ClickXpath(finish);
		GetTextEqual(completeHead, "THANK YOU FOR YOUR ORDER");
		return this;
	}
	
	public BuyObject Click_Cart (WebDriverWait wait) {
		waitclickable(wait,  badgelink);
		ClickXpath(badgelink);
		return this;
	}
	
	//Compare
	public BuyObject Compare_CartNum (String compare) {
		GetTextEqual(badgeno, compare);
		return this;
	}

}
