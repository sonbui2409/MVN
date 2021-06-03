package ExerciseShareObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import ExerciseBaseCommon.BaseActions;

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
		GotoURL(log, driver, urlogin);
		return this;
	}
	public InventoryObject OpenMenu(ExtentTest log, WebDriver driver) {
		ClickXpath(log, driver, menu);
		return this;
	}
	
	//Compare
	public InventoryObject CompareTitle (ExtentTest log,SoftAssert softAssert,WebDriver driver, String expect) {
		sAssertEqual(log, softAssert, driver, pagetitle, expect);
		return this;
	}
	
	public InventoryObject Compare_Buy (ExtentTest log,SoftAssert softAssert,WebDriver driver, String expect) {
		sAssertEqual(log, softAssert, driver, itemdetail_Title, expect);
		return this;
	}
	public InventoryObject Compare_CurrentURL (SoftAssert softAssert,ExtentTest log,WebDriver driver, String currentURL) {
		CompareCurrentURL(softAssert,log, driver, currentURL);
		return this;
	}
	
	//Log_out
	public InventoryObject Logout(ExtentTest log, WebDriverWait wait,WebDriver driver) {
		ClickXpath(log, driver, menu);
		waitclickable(wait, driver, logout);
		ClickXpath(log, driver, logout);
		return this;
	}
	
	//Click
	public InventoryObject ClickToItem (ExtentTest log, WebDriver driver, String item) {
		ClickFormat(log, driver, itemlink, item);
		return this;
	}
	public InventoryObject GoToItem_1 (ExtentTest log, WebDriver driver) {
		ClickFormat(log, driver, itemlink, "item_0_title_link");
		return this;
	}
	
	//Verify Content

	public InventoryObject Verify_Name_Desc_price_item_1 (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver, String price) {
		waitformatvisible(wait, driver, itemname, "item_0_title_link");
		GetTextFormatEqual(softAssert,log, driver, itemname, "item_0_title_link", item0name);
		GetTextFormatEqual(softAssert,log, driver, itemdesc, "item_0_title_link", item0desc);
		GetTextFormatEqual_replace(softAssert,log, driver, itemprice, "item_0_title_link", price);
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_2 (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver, String price) {
		waitformatvisible(wait, driver, itemname, "item_1_title_link");
		GetTextFormatEqual(softAssert,log, driver, itemname, "item_1_title_link", item1name);
		GetTextFormatEqual(softAssert,log, driver, itemdesc, "item_1_title_link", item1desc);
		GetTextFormatEqual_replace(softAssert,log, driver, itemprice, "item_1_title_link", price);
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_3 (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver, String price) {
		waitformatvisible(wait, driver, itemname, "item_2_title_link");
		GetTextFormatEqual(softAssert,log, driver, itemname, "item_2_title_link", item2name);
		GetTextFormatEqual(softAssert,log, driver, itemdesc, "item_2_title_link", item2desc);
		GetTextFormatEqual_replace(softAssert,log, driver, itemprice, "item_2_title_link", price);
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_4 (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver, String price) {
		waitformatvisible(wait, driver, itemname, "item_3_title_link");
		GetTextFormatEqual(softAssert,log, driver, itemname, "item_3_title_link", item3name);
		GetTextFormatEqual(softAssert,log, driver, itemdesc, "item_3_title_link", item3desc);
		GetTextFormatEqual_replace(softAssert,log, driver, itemprice, "item_3_title_link", price);
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_5 (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver, String price) {
		waitformatvisible(wait, driver, itemname, "item_4_title_link");
		GetTextFormatEqual(softAssert,log, driver, itemname, "item_4_title_link", item4name);
		GetTextFormatEqual(softAssert,log, driver, itemdesc, "item_4_title_link", item4desc);
		GetTextFormatEqual_replace(softAssert,log, driver, itemprice, "item_4_title_link", price);
		return this;
	}
	public InventoryObject Verify_Name_Desc_price_item_6 (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver, String price) {
		waitformatvisible(wait, driver, itemname, "item_5_title_link");
		GetTextFormatEqual(softAssert,log, driver, itemname, "item_5_title_link", item5name);
		GetTextFormatEqual(softAssert,log, driver, itemdesc, "item_5_title_link", item5desc);
		GetTextFormatEqual_replace(softAssert,log, driver, itemprice, "item_5_title_link", price);
		return this;
	}
	public InventoryObject Verify_Page_item_1 (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver) {
		GetTextEqual(softAssert,log, driver, itemdetail_Title, item0name);
		GetTextEqual(softAssert,log, driver, itemdetail_desc, item0desc);
		sAssertEqual_replace(log, softAssert, driver, itemdetail_price, "$9.99");
		return this;
	}
	public InventoryObject Verify_GoBack (SoftAssert softAssert,ExtentTest log,WebDriverWait wait, WebDriver driver) {
		waitclickable(wait, driver, backto);
		ClickXpath(log, driver, backto);
		waitvisible(wait, driver, pagetitle);
		GetTextEqual(softAssert,log, driver, pagetitle, "products");
		return this;
	}
	public InventoryObject Verify_Link_item (ExtentTest log,WebDriverWait wait, WebDriver driver, String item) {
		waitformatclickable(wait, driver, itemlink, item);
		ClickFormat(log, driver, itemlink, item);
		waitclickable(wait, driver, backto);
		ClickXpath(log, driver, backto);
		return this;
	}
	public InventoryObject Verify_Link_item_problem (SoftAssert softAssert, ExtentTest log,WebDriverWait wait, WebDriver driver, String expect) {
		ClickFormat(log, driver, itemlink, "item_1_img_link");
		waitvisible(wait, driver, itemdetail_Title);
		sAssertEqual(log, softAssert, driver, itemdetail_Title, expect);	
		return this;
	}
	public InventoryObject Verify_Allitem (SoftAssert softAssert,WebDriverWait wait,ExtentTest log,WebDriver driver, String expect) {
		waitclickable(wait, driver, allitem);
		GetTextEqual(softAssert,log, driver, allitem, "All Items");
		ClickXpath(log, driver, allitem);
		GetTextEqual(softAssert,log, driver, pagetitle, expect);
		return this;
	}
	public InventoryObject Verify_About (SoftAssert softAssert,WebDriverWait wait,ExtentTest log,WebDriver driver) {
		waitclickable(wait, driver, about);
		GetTextEqual(softAssert,log, driver, about, "about");
		ClickXpath(log, driver, about);
		return this;
	}
	
	
	

}
