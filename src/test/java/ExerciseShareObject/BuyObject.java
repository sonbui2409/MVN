package ExerciseShareObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import ExerciseBaseCommon.BaseActions;

public class BuyObject extends BaseActions {
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
	
	
	//Click
	public BuyObject AddToCart (ExtentTest log, WebDriver driver, String item) {
		ClickFormat(log, driver, buyitem, item);
		return this;
	}
	public BuyObject Click_Cart (ExtentTest log, WebDriver driver) {
		ClickXpath(log, driver, badgelink);
		return this;
	}
	public BuyObject Click_Checkout (ExtentTest log, WebDriver driver) {
		ClickXpath(log, driver, checkout);
		return this;
	}
	public BuyObject Click_Continue (ExtentTest log, WebDriver driver) {
		ClickXpath(log, driver, butcont);
		return this;
	}
	public BuyObject Click_Finish (ExtentTest log, WebDriver driver) {
		ClickXpath(log, driver, finish);
		return this;
	}
	
	//Compare
	public BuyObject Compare_Inventory_1 (ExtentTest log, WebDriver driver, String compare) {
		GetTextEqual(log, driver, buyname1, compare);
		return this;
	}
	public BuyObject Compare_Price_1 (ExtentTest log,SoftAssert softAssert,WebDriver driver, String expect) {
		sAssertEqual_replace(log, softAssert, driver, buyprice1, expect);
		return this;
	}
	public BuyObject Compare_Total_Price (ExtentTest log,SoftAssert softAssert,WebDriver driver, String expect) {
		sAssertEqual_replace(log, softAssert, driver, totalprice, expect);
		return this;
	}
	public BuyObject Compare_Head_title (ExtentTest log, WebDriver driver) {
		GetTextEqual(log, driver, completeHead, "THANK YOU FOR YOUR ORDER");
		return this;
	}
	
	
	//Wait
	public BuyObject Wait_Cart (WebDriverWait wait,WebDriver driver) {
		waitclickable(wait, driver, badgelink);
		return this;
	}
	public BuyObject Wait_Checkout (WebDriverWait wait,WebDriver driver) {
		waitclickable(wait, driver, checkout);
		return this;
	}
	public BuyObject Wait_Continue (WebDriverWait wait,WebDriver driver) {
		waitclickable(wait, driver, butcont);
		return this;
	}
	public BuyObject Wait_Finish (WebDriverWait wait,WebDriver driver) {
		waitclickable(wait, driver, finish);
		return this;
	}

}
