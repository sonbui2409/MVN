package ExerciseShareObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import ExerciseBaseCommon.BaseActions;
import ExerciseBaseCommon.DataTest;

public class InventoryObject extends BaseActions {
	WebDriver LocalDriver;
	
	
	public InventoryObject(WebDriver remoteDriver) {
		super (remoteDriver); //call constructor of Father class (baseActions)
		LocalDriver = remoteDriver;
	}
	
	
	
	public InventoryObject OpenInvenPage (ExtentTest log) {
		GotoURL(log, readExl("Login", DataTest.CUrl, DataTest.RInventory));
		return this;
	}
	public InventoryObject OpenMenu(ExtentTest log) {
		ClickXpath(log, readExl("Xpath",DataTest.Cxpt_Inventory, DataTest.Rxpt_menu));
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
	public InventoryObject ClickToItem (ExtentTest log,WebDriverWait wait, String item) {
		waitformatclickable(wait, readExl("Xpath",DataTest.Cxpt_Inventory,DataTest.Rxpt_Ilink), item);
		ClickFormat(log, readExl("Xpath",DataTest.Cxpt_Inventory,DataTest.Rxpt_Ilink), item);
		return this;
	}
	public InventoryObject Click_GoBack (ExtentTest log,WebDriverWait wait) {
		waitclickable(wait, readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_back ));
		ClickXpath(log, readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_back));
		return this;
	}
	/*public InventoryObject GoToItem_1 (ExtentTest log) {
		ClickFormat(log, readExl("Xpath", 1, 11), readExl("Inventory", 1, 1));
		return this;
	}*/
	
	//Verify Content
	public InventoryObject Verify_Item_Name (ExtentTest log,WebDriverWait wait, String link ,String Data) {
		waitformatvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory,DataTest.Rxpt_Iname), link);
		GetTextFormatEqual(log, readExl("Xpath", DataTest.Cxpt_Inventory,DataTest.Rxpt_Iname), link, Data);
		return this;
	}
	public InventoryObject Verify_Item_Desc (ExtentTest log,WebDriverWait wait, String link ,String Data) {
		waitformatvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory,DataTest.Rxpt_Idesc), link);
		GetTextFormatEqual(log, readExl("Xpath", DataTest.Cxpt_Inventory,DataTest.Rxpt_Idesc), link, Data);
		return this;
	}
	public InventoryObject Verify_Item_Price (ExtentTest log,WebDriverWait wait, String link ,String Data) {
		waitformatvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory,DataTest.Rxpt_Iprice), link);
		GetTextFormatEqual_replace(log, readExl("Xpath", DataTest.Cxpt_Inventory,DataTest.Rxpt_Iprice), link, Data);
		return this;
	}
	

	public InventoryObject Verify_Name_Desc_price_item_1 (ExtentTest log,WebDriverWait wait) {
		waitformatvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Iname), 
				readExl("Inventory", DataTest.CitemLink, DataTest.RitemLink1));
		GetTextFormatEqual(log, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Iname), readExl("Inventory", DataTest.CitemLink, DataTest.RitemLink1), 
				readExl("Inventory", DataTest.CitemName,DataTest.RitemName1 ));
		GetTextFormatEqual(log, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Idesc), readExl("Inventory", DataTest.CitemLink, DataTest.RitemLink1), 
				readExl("Inventory", DataTest.CitemDesc, DataTest.RitemDesc1));
		GetTextFormatEqual_replace(log, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Iprice), readExl("Inventory", DataTest.CitemLink, DataTest.RitemLink1), 
				readExl("Inventory", DataTest.CitemPrice, DataTest.RitemPrice1));
		return this;
	}
/*	public InventoryObject Verify_Name_Desc_price_item_2 (ExtentTest log,WebDriverWait wait) {
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
	}*/
	
	public InventoryObject Verify_Page_item_1 (ExtentTest log,WebDriverWait wait) {
		waitvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Dtitle));
		GetTextEqual(log, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Dtitle), 
				readExl("Inventory", DataTest.CitemName, DataTest.RitemName1));
		
		waitvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Ddesc));
		GetTextEqual(log, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Ddesc), 
				readExl("Inventory", DataTest.CitemDesc, DataTest.RitemDesc1));
		
		waitvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Dprice));
		AssertEqual_replace(log,  readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Dprice), 
				readExl("Inventory", DataTest.CitemPrice, DataTest.RitemPrice1));
		
		return this;
	}
	public InventoryObject Verify_GoBack (ExtentTest log,WebDriverWait wait, String data) {
		waitclickable(wait, readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_back ));
		ClickXpath(log, readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_back));
		
		waitvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_pagetitle));
		GetTextEqual(log, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_pagetitle), data);
		return this;
	}
	/*public InventoryObject Verify_Link_item (ExtentTest log,WebDriverWait wait, String item) {
		waitformatclickable(wait, readExl("Xpath", 1, 11), item);
		ClickFormat(log, readExl("Xpath", 1, 11), item);
		return this;
	}*/
	public InventoryObject Verify_Link_item_problem ( ExtentTest log,WebDriverWait wait) {
		ClickFormat(log, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Ilink), 
				readExl("Inventory", DataTest.CitemImage,DataTest.RitemImage2));
		waitvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Dtitle));
		AssertEqual(log,  readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Dtitle), 
				readExl("Inventory", DataTest.CitemName, DataTest.RitemName3));	
		return this;
	}
	public InventoryObject Verify_Allitem (WebDriverWait wait,ExtentTest log, String expect) {
		waitclickable(wait, readExl("Xpath", 1, 9));
		GetTextEqual(log, readExl("Xpath", 1, 9), readExl("Inventory", 0, 2));
		ClickXpath(log, readExl("Xpath", 1, 9));
		GetTextEqual(log, readExl("Xpath", 1, 10), expect);
		return this;
	}
	public InventoryObject Verify_About (WebDriverWait wait,ExtentTest log) {
		waitclickable(wait, readExl("Xpath", 1, 8));
		GetTextEqual(log, readExl("Xpath", 1, 8), readExl("Inventory", 0, 3));
		ClickXpath(log, readExl("Xpath", 1, 8));
		return this;
	}	

}
