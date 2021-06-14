package ExerciseShareObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import ExerciseBaseCommon.BaseActions;
import ExerciseBaseCommon.DataTest;

public class InventoryObject extends BaseActions {
	//Inventory page
	/*protected String urlogin = "https://www.saucedemo.com/inventory.html";
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
	*/
	
	//Open
	WebDriver LocalDriver;
	
	
	public InventoryObject(WebDriver remoteDriver) {
		super (remoteDriver); //call constructor of Father class (baseActions)
		LocalDriver = remoteDriver;
	}
	
	
	
	public InventoryObject OpenInvenPage (ExtentTest log) {
		GotoURL(log, readExl("Login", DataTest.ColUrl, 2));
		return this;
	}
	public InventoryObject OpenMenu(ExtentTest log) {
		ClickXpath(log, readExl("Xpath", 1, 6));
		return this;
	}
	
	//Compare
	public InventoryObject CompareTitle (ExtentTest log, String expect) {
		AssertEqual(log, readExl("Xpath", 1, 10), expect);
		return this;
	}
	
	public InventoryObject Compare_Buy (ExtentTest log, String expect) {
		AssertEqual(log, readExl("Xpath", 1, 15), expect);
		return this;
	}
	public InventoryObject Compare_CurrentURL (ExtentTest log, String currentURL) {
		CompareCurrentURL(log, currentURL);
		return this;
	}
	
	//Log_out
	public LoginObject Logout(ExtentTest log, WebDriverWait wait) {
		ClickXpath(log, readExl("Xpath", 1, 6));
		waitclickable(wait, readExl("Xpath", 1, 7));
		ClickXpath(log, readExl("Xpath", 1, 7));
		return new LoginObject(LocalDriver);
	}
	
	//Click
	public InventoryObject ClickToItem (ExtentTest log, String item) {
		ClickFormat(log, readExl("Xpath", 1, 11), item);
		return this;
	}
	public InventoryObject GoToItem_1 (ExtentTest log) {
		ClickFormat(log, readExl("Xpath", 1, 11), readExl("Inventory", 1, 1));
		return this;
	}
	
	//Verify Content

	public InventoryObject Verify_Name_Desc_price_item_1 (ExtentTest log,WebDriverWait wait) {
		waitformatvisible(wait, readExl("Xpath", 1, 12), readExl("Inventory", 1, 1));
		GetTextFormatEqual(log, readExl("Xpath", 1, 12), readExl("Inventory", 1, 1), readExl("Inventory", 4, 1));
		GetTextFormatEqual(log, readExl("Xpath", 1, 13), readExl("Inventory", 1, 1), readExl("Inventory", 5, 1));
		GetTextFormatEqual_replace(log, readExl("Xpath", 1, 14), readExl("Inventory", 1, 1), readExl("Inventory", 3, 1));
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_2 (ExtentTest log,WebDriverWait wait) {
		waitformatvisible(wait, readExl("Xpath", 1, 12), readExl("Inventory", 1, 2));
		GetTextFormatEqual(log, readExl("Xpath", 1, 12), readExl("Inventory", 1, 2), readExl("Inventory", 4, 2));
		GetTextFormatEqual(log, readExl("Xpath", 1, 13), readExl("Inventory", 1, 2), readExl("Inventory", 5, 2));
		GetTextFormatEqual_replace(log, readExl("Xpath", 1, 14), readExl("Inventory", 1, 2), readExl("Inventory", 3, 2));
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_3 (ExtentTest log,WebDriverWait wait) {
		waitformatvisible(wait, readExl("Xpath", 1, 12), readExl("Inventory", 1, 3));
		GetTextFormatEqual(log, readExl("Xpath", 1, 12), readExl("Inventory", 1, 3), readExl("Inventory", 4, 3));
		GetTextFormatEqual(log, readExl("Xpath", 1, 13), readExl("Inventory", 1, 3), readExl("Inventory", 5, 3));
		GetTextFormatEqual_replace(log, readExl("Xpath", 1, 14), readExl("Inventory", 1, 3), readExl("Inventory", 3, 3));
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_4 (ExtentTest log,WebDriverWait wait) {
		waitformatvisible(wait, readExl("Xpath", 1, 12), readExl("Inventory", 1, 4));
		GetTextFormatEqual(log, readExl("Xpath", 1, 12), readExl("Inventory", 1, 4), readExl("Inventory", 4, 4));
		GetTextFormatEqual(log, readExl("Xpath", 1, 13), readExl("Inventory", 1, 4), readExl("Inventory", 5, 4));
		GetTextFormatEqual_replace(log, readExl("Xpath", 1, 14), readExl("Inventory", 1, 4), readExl("Inventory", 3, 4));
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_5 (ExtentTest log,WebDriverWait wait) {
		waitformatvisible(wait, readExl("Xpath", 1, 12), readExl("Inventory", 1, 5));
		GetTextFormatEqual(log, readExl("Xpath", 1, 12), readExl("Inventory", 1, 5), readExl("Inventory", 4, 5));
		GetTextFormatEqual(log, readExl("Xpath", 1, 13), readExl("Inventory", 1, 5), readExl("Inventory", 5, 5));
		GetTextFormatEqual_replace(log, readExl("Xpath", 1, 14), readExl("Inventory", 1, 5), readExl("Inventory", 3, 5));
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_6 (ExtentTest log,WebDriverWait wait) {
		waitformatvisible(wait, readExl("Xpath", 1, 12), readExl("Inventory", 1, 6));
		GetTextFormatEqual(log, readExl("Xpath", 1, 12), readExl("Inventory", 1, 6), readExl("Inventory", 4, 6));
		GetTextFormatEqual(log, readExl("Xpath", 1, 13), readExl("Inventory", 1, 6), readExl("Inventory", 5, 6));
		GetTextFormatEqual_replace(log, readExl("Xpath", 1, 14), readExl("Inventory", 1, 6), readExl("Inventory", 3, 6));
		return this;
	}
	public InventoryObject Verify_Page_item_1 (ExtentTest log,WebDriverWait wait) {
		waitvisible(wait, readExl("Xpath", 1, 15));
		GetTextEqual(log, readExl("Xpath", 1, 15), readExl("Inventory", 4, 1));
		waitvisible(wait, readExl("Xpath", 1, 16));
		GetTextEqual(log, readExl("Xpath", 1, 16), readExl("Inventory", 5, 1));
		waitvisible(wait, readExl("Xpath", 1, 17));
		AssertEqual_replace(log,  readExl("Xpath", 1, 17), readExl("Inventory", 3, 1));
		return this;
	}
	public InventoryObject Verify_GoBack (ExtentTest log,WebDriverWait wait) {
		waitclickable(wait, readExl("Xpath", 1, 18));
		ClickXpath(log, readExl("Xpath", 1, 18));
		waitvisible(wait, readExl("Xpath", 1, 10));
		GetTextEqual(log, readExl("Xpath", 1, 10), readExl("Inventory", 0, 1));
		return this;
	}
	public InventoryObject Verify_Link_item (ExtentTest log,WebDriverWait wait, String item) {
		waitformatclickable(wait, readExl("Xpath", 1, 11), item);
		ClickFormat(log, readExl("Xpath", 1, 11), item);
		waitclickable(wait, readExl("Xpath", 1, 18));
		ClickXpath(log, readExl("Xpath", 1, 18));
		return this;
	}
	public InventoryObject Verify_Link_item_problem ( ExtentTest log,WebDriverWait wait) {
		ClickFormat(log, readExl("Xpath", 1, 11), readExl("Inventory", 2, 2));
		waitvisible(wait, readExl("Xpath", 1, 15));
		AssertEqual(log,  readExl("Xpath", 1, 15), readExl("Inventory", 4, 3));	
		return this;
	}
	public InventoryObject Verify_Allitem (WebDriverWait wait,ExtentTest log, String expect) {
		waitclickable(wait, readExl("Xpath", 1, 9));
		GetTextEqual(log, readExl("Xpath", 1, 9), readExl("Inventory", 0, 2));
		ClickXpath(log, readExl("Xpath", 1, 9));
		GetTextEqual(log, readExl("Xpath", 1, 10), expect);
		return this;
	}
	public InventoryObject Verify_About (WebDriverWait wait,ExtentTest log,WebDriver driver) {
		waitclickable(wait, readExl("Xpath", 1, 8));
		GetTextEqual(log, readExl("Xpath", 1, 8), readExl("Inventory", 0, 3));
		ClickXpath(log, readExl("Xpath", 1, 8));
		return this;
	}	

}
