package ExerciseShareObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import ExerciseBaseCommon.BaseActions;
import ExerciseBaseCommon.DataTest;

public class InventoryObject extends BaseActions {
	//Inventory page
	protected String urlogin = "https://www.saucedemo.com/inventory.html";
	protected String pagetitle = "//span[@class = 'title']";
	protected String itemlink = "//a[@id ='%s']";
	protected String itemname = "//a[@id ='%s']/div";
	protected String itemdesc = "//a[@id ='%s']/following-sibling::div";
	protected String itemprice = "//a[@id='%s']/parent::div/following-sibling::div/div[@class='inventory_item_price']";
	
	protected String item0name = "Sauce Labs Bike Light";
	protected String item0desc = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
	protected String item1name = "Sauce Labs Bolt T-Shirt";
	protected String item1desc = "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.";
	protected String item2name = "Sauce Labs Onesie";
	protected String item2desc = "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.";
	protected String item3name = "Test.allTheThings() T-Shirt (Red)";
	protected String item3desc = "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.";
	protected String item4name = "Sauce Labs Backpack";
	protected String item4desc = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
	protected String item5name = "Sauce Labs Fleece Jacket";
	protected String item5desc = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
	protected String menu = "//div[@class='bm-burger-button']";
	protected String logout = "//a[@id='logout_sidebar_link']";
	protected String about = "//a[@id = 'about_sidebar_link']";
	protected String allitem = "//a[@id = 'inventory_sidebar_link']";
	
	
	//Inventory child page
	protected String itemdetail_Title = "//div[contains (@class,'name large_size')]";
	protected String itemdetail_desc = "//div[contains (@class,'desc large_size')]";
	protected String itemdetail_price = "//div[@class ='inventory_details_price']";
	protected String backto = "//button[@id = 'back-to-products']";
	
	
	//Open
	public InventoryObject OpenInvenPage (ExtentTest log, WebDriver driver) {
		GotoURL(log, driver, readExl("Login", DataTest.ColUrl, 2));
		return this;
	}
	public InventoryObject OpenMenu(ExtentTest log, WebDriver driver) {
		ClickXpath(log, driver, readExl("Xpath", 1, 6));
		return this;
	}
	
	//Compare
	public InventoryObject CompareTitle (ExtentTest log,SoftAssert softAssert,WebDriver driver, String expect) {
		sAssertEqual(log, softAssert, driver, readExl("Xpath", 1, 10), expect);
		return this;
	}
	
	public InventoryObject Compare_Buy (ExtentTest log,SoftAssert softAssert,WebDriver driver, String expect) {
		sAssertEqual(log, softAssert, driver, readExl("Xpath", 1, 15), expect);
		return this;
	}
	public InventoryObject Compare_CurrentURL (SoftAssert softAssert,ExtentTest log,WebDriver driver, String currentURL) {
		CompareCurrentURL(softAssert,log, driver, currentURL);
		return this;
	}
	
	//Log_out
	public InventoryObject Logout(ExtentTest log, WebDriverWait wait,WebDriver driver) {
		ClickXpath(log, driver, readExl("Xpath", 1, 6));
		waitclickable(wait, driver, readExl("Xpath", 1, 7));
		ClickXpath(log, driver, readExl("Xpath", 1, 7));
		return this;
	}
	
	//Click
	public InventoryObject ClickToItem (ExtentTest log, WebDriver driver, String item) {
		ClickFormat(log, driver, readExl("Xpath", 1, 11), item);
		return this;
	}
	public InventoryObject GoToItem_1 (ExtentTest log, WebDriver driver) {
		ClickFormat(log, driver, readExl("Xpath", 1, 11), readExl("Inventory", 1, 1));
		return this;
	}
	
	//Verify Content

	public InventoryObject Verify_Name_Desc_price_item_1 (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver) {
		waitformatvisible(wait, driver, readExl("Xpath", 1, 12), readExl("Inventory", 1, 1));
		GetTextFormatEqual(softAssert,log, driver, readExl("Xpath", 1, 12), readExl("Inventory", 1, 1), readExl("Inventory", 4, 1));
		GetTextFormatEqual(softAssert,log, driver, readExl("Xpath", 1, 13), readExl("Inventory", 1, 1), readExl("Inventory", 5, 1));
		GetTextFormatEqual_replace(softAssert,log, driver, readExl("Xpath", 1, 14), readExl("Inventory", 1, 1), readExl("Inventory", 3, 1));
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_2 (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver) {
		waitformatvisible(wait, driver, readExl("Xpath", 1, 12), readExl("Inventory", 1, 2));
		GetTextFormatEqual(softAssert,log, driver, readExl("Xpath", 1, 12), readExl("Inventory", 1, 2), readExl("Inventory", 4, 2));
		GetTextFormatEqual(softAssert,log, driver, readExl("Xpath", 1, 13), readExl("Inventory", 1, 2), readExl("Inventory", 5, 2));
		GetTextFormatEqual_replace(softAssert,log, driver, readExl("Xpath", 1, 14), readExl("Inventory", 1, 2), readExl("Inventory", 3, 2));
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_3 (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver) {
		waitformatvisible(wait, driver, readExl("Xpath", 1, 12), readExl("Inventory", 1, 3));
		GetTextFormatEqual(softAssert,log, driver, readExl("Xpath", 1, 12), readExl("Inventory", 1, 3), readExl("Inventory", 4, 3));
		GetTextFormatEqual(softAssert,log, driver, readExl("Xpath", 1, 13), readExl("Inventory", 1, 3), readExl("Inventory", 5, 3));
		GetTextFormatEqual_replace(softAssert,log, driver, readExl("Xpath", 1, 14), readExl("Inventory", 1, 3), readExl("Inventory", 3, 3));
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_4 (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver) {
		waitformatvisible(wait, driver, readExl("Xpath", 1, 12), readExl("Inventory", 1, 4));
		GetTextFormatEqual(softAssert,log, driver, readExl("Xpath", 1, 12), readExl("Inventory", 1, 4), readExl("Inventory", 4, 4));
		GetTextFormatEqual(softAssert,log, driver, readExl("Xpath", 1, 13), readExl("Inventory", 1, 4), readExl("Inventory", 5, 4));
		GetTextFormatEqual_replace(softAssert,log, driver, readExl("Xpath", 1, 14), readExl("Inventory", 1, 4), readExl("Inventory", 3, 4));
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_5 (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver) {
		waitformatvisible(wait, driver, readExl("Xpath", 1, 12), readExl("Inventory", 1, 5));
		GetTextFormatEqual(softAssert,log, driver, readExl("Xpath", 1, 12), readExl("Inventory", 1, 5), readExl("Inventory", 4, 5));
		GetTextFormatEqual(softAssert,log, driver, readExl("Xpath", 1, 13), readExl("Inventory", 1, 5), readExl("Inventory", 5, 5));
		GetTextFormatEqual_replace(softAssert,log, driver, readExl("Xpath", 1, 14), readExl("Inventory", 1, 5), readExl("Inventory", 3, 5));
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_6 (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver) {
		waitformatvisible(wait, driver, readExl("Xpath", 1, 12), readExl("Inventory", 1, 6));
		GetTextFormatEqual(softAssert,log, driver, readExl("Xpath", 1, 12), readExl("Inventory", 1, 6), readExl("Inventory", 4, 6));
		GetTextFormatEqual(softAssert,log, driver, readExl("Xpath", 1, 13), readExl("Inventory", 1, 6), readExl("Inventory", 5, 6));
		GetTextFormatEqual_replace(softAssert,log, driver, readExl("Xpath", 1, 14), readExl("Inventory", 1, 6), readExl("Inventory", 3, 6));
		return this;
	}
	public InventoryObject Verify_Page_item_1 (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver) {
		waitvisible(wait, driver, readExl("Xpath", 1, 15));
		GetTextEqual(softAssert,log, driver, readExl("Xpath", 1, 15), readExl("Inventory", 4, 1));
		waitvisible(wait, driver, readExl("Xpath", 1, 16));
		GetTextEqual(softAssert,log, driver, readExl("Xpath", 1, 16), readExl("Inventory", 5, 1));
		waitvisible(wait, driver, readExl("Xpath", 1, 17));
		sAssertEqual_replace(log, softAssert, driver, readExl("Xpath", 1, 17), readExl("Inventory", 3, 1));
		return this;
	}
	public InventoryObject Verify_GoBack (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver) {
		waitclickable(wait, driver, readExl("Xpath", 1, 18));
		ClickXpath(log, driver, readExl("Xpath", 1, 18));
		waitvisible(wait, driver, readExl("Xpath", 1, 10));
		GetTextEqual(softAssert,log, driver, readExl("Xpath", 1, 10), readExl("Inventory", 0, 1));
		return this;
	}
	public InventoryObject Verify_Link_item (ExtentTest log,WebDriverWait wait, WebDriver driver, String item) {
		waitformatclickable(wait, driver, readExl("Xpath", 1, 11), item);
		ClickFormat(log, driver, readExl("Xpath", 1, 11), item);
		waitclickable(wait, driver, readExl("Xpath", 1, 18));
		ClickXpath(log, driver, readExl("Xpath", 1, 18));
		return this;
	}
	public InventoryObject Verify_Link_item_problem (SoftAssert softAssert, ExtentTest log,WebDriverWait wait, WebDriver driver) {
		ClickFormat(log, driver, readExl("Xpath", 1, 11), readExl("Inventory", 2, 2));
		waitvisible(wait, driver, readExl("Xpath", 1, 15));
		sAssertEqual(log, softAssert, driver, readExl("Xpath", 1, 15), readExl("Inventory", 4, 3));	
		return this;
	}
	public InventoryObject Verify_Allitem (SoftAssert softAssert,WebDriverWait wait,ExtentTest log,WebDriver driver, String expect) {
		waitclickable(wait, driver, readExl("Xpath", 1, 9));
		GetTextEqual(softAssert,log, driver, readExl("Xpath", 1, 9), readExl("Inventory", 0, 2));
		ClickXpath(log, driver, readExl("Xpath", 1, 9));
		GetTextEqual(softAssert,log, driver, readExl("Xpath", 1, 10), expect);
		return this;
	}
	public InventoryObject Verify_About (SoftAssert softAssert,WebDriverWait wait,ExtentTest log,WebDriver driver) {
		waitclickable(wait, driver, readExl("Xpath", 1, 8));
		GetTextEqual(softAssert,log, driver, readExl("Xpath", 1, 8), readExl("Inventory", 0, 3));
		ClickXpath(log, driver, readExl("Xpath", 1, 8));
		return this;
	}
	
	
	

}
