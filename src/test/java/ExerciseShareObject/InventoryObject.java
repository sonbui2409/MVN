package ExerciseShareObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import ExerciseBaseCommon.BaseActions;

public class InventoryObject extends BaseActions {
	//Inventory page
	protected String urlogin = "https://www.saucedemo.com/inventory.html";
	public String pagetitle = "//span[@class = 'title']";
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
	
	
	public InventoryObject CompareTitle (ExtentTest log,SoftAssert softAssert,WebDriver driver, String expect) {
		sAssertEqual(log, softAssert, driver, pagetitle, expect);
		return this;
	} 
	public InventoryObject TracksAssert (SoftAssert softAssert) {
		softAssertAll(softAssert);
		return this;
	}
	public InventoryObject Logout(ExtentTest log, WebDriverWait wait,WebDriver driver) {
		ClickXpath(log, driver, menu);
		waitclickable(wait, driver, logout);
		ClickXpath(log, driver, logout);
		return this;
	}
	public InventoryObject ClickToItem (ExtentTest log, WebDriver driver, String item) {
		ClickFormat(log, driver, itemlink, item);
		return this;
	}
	public InventoryObject WaitElement_visible (WebDriverWait wait,WebDriver driver) {
		waitvisible(wait, driver, itemdetail_Title);
		return this;
	}

}
