package ExerciseShareObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import ExerciseBaseCommon.BaseActions;
import ExerciseBaseCommon.DataTest;
import ExerciseBaseCommon.ManageObject;

public class InventoryObject extends BaseActions {
	WebDriver LocalDriver;
	protected static ExtentTest LocalLog;
	
	
	public InventoryObject(WebDriver remoteDriver, ExtentTest remoteLog) {
		super (remoteDriver, remoteLog); //call constructor of Father class (baseActions)
		LocalDriver = remoteDriver;
		LocalLog = remoteLog;
		
	}
	public ExtentTest getLoglocal() {
		return LocalLog;
	}
	public void updateLocalLog(ExtentTest log) {
		updateLog(log);
		LocalLog = log;
	}
	
	
	public InventoryObject OpenInvenPage () {
		GotoURL(readExl("Login", DataTest.CUrl, DataTest.RInventory));
		return this;
	}
	public InventoryObject OpenMenu() {
		ClickXpath(readExl("Xpath",DataTest.Cxpt_Inventory, DataTest.Rxpt_menu));
		return this;
	}
	
	//Compare
	public InventoryObject CompareTitle (String expect) {
		AssertEqual(readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_pagetitle), expect);
		return this;
	}
	
	public InventoryObject Compare_CurrentURL (String currentURL) {
		CompareCurrentURL(currentURL);
		return this;
	}
	
	//Log_out
	public LoginObject Logout(WebDriverWait wait) {
		ClickXpath(readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_menu));
		waitclickable(wait, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_logout));
		ClickXpath(readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_logout));
		return ManageObject.ManageLogin(LocalDriver, LocalLog);
	}
	
	//Click
	public InventoryObject ClickToItem (WebDriverWait wait, String item) {
		waitformatclickable(wait, readExl("Xpath",DataTest.Cxpt_Inventory,DataTest.Rxpt_Ilink), item);
		ClickFormat(readExl("Xpath",DataTest.Cxpt_Inventory,DataTest.Rxpt_Ilink), item);
		return this;
	}
	public InventoryObject Click_GoBack (WebDriverWait wait) {
		waitclickable(wait, readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_back ));
		ClickXpath(readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_back));
		return this;
	}
	public InventoryObject Add_item_ToCart (String item) {
		ClickFormat(readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_buy ), item);
		return this;
	}
	public BuyObject Go_to_YourCart_page (WebDriverWait wait) {
		waitclickable(wait,  readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_Badgelink ));
		ClickXpath(readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_Badgelink ));
		return ManageObject.ManageBuy(LocalDriver, LocalLog);
	}
	public InventoryObject Click_Cart (WebDriverWait wait) {
		waitclickable(wait,readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_Badgelink));
		ClickXpath(readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_Badgelink));
		return this;
	}
	
	/*public InventoryObject GoToItem_1 (ExtentTest log) {
		ClickFormat(log, readExl("Xpath", 1, 11), readExl("Inventory", 1, 1));
		return this;
	}*/
	
	//Verify Content
	public InventoryObject Verify_Item_Name (WebDriverWait wait, String link ,String Data) {
		waitformatvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory,DataTest.Rxpt_Iname), link);
		GetTextFormatEqual(readExl("Xpath", DataTest.Cxpt_Inventory,DataTest.Rxpt_Iname), link, Data);
		return this;
	}
	public InventoryObject Verify_Item_Desc (WebDriverWait wait, String link ,String Data) {
		waitformatvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory,DataTest.Rxpt_Idesc), link);
		GetTextFormatEqual(readExl("Xpath", DataTest.Cxpt_Inventory,DataTest.Rxpt_Idesc), link, Data);
		return this;
	}
	public InventoryObject Verify_Item_Price (WebDriverWait wait, String link ,String Data) {
		waitformatvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory,DataTest.Rxpt_Iprice), link);
		GetTextFormatEqual_replace(readExl("Xpath", DataTest.Cxpt_Inventory,DataTest.Rxpt_Iprice), link, Data);
		return this;
	}
	

	public InventoryObject Verify_Name_Desc_price_item_1 (WebDriverWait wait) {
		waitformatvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Iname), 
				readExl("Inventory", DataTest.CitemLink, DataTest.Ritem1));
		GetTextFormatEqual(readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Iname), readExl("Inventory", DataTest.CitemLink, DataTest.Ritem1), 
				readExl("Inventory", DataTest.CitemName,DataTest.Ritem1 ));
		GetTextFormatEqual(readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Idesc), readExl("Inventory", DataTest.CitemLink, DataTest.Ritem1), 
				readExl("Inventory", DataTest.CitemDesc, DataTest.Ritem1));
		GetTextFormatEqual_replace(readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Iprice), readExl("Inventory", DataTest.CitemLink, DataTest.Ritem1), 
				readExl("Inventory", DataTest.CitemPrice, DataTest.Ritem1));
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
	
	public InventoryObject Verify_Page_item_1 (WebDriverWait wait) {
		waitvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Dtitle));
		GetTextEqual(readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Dtitle), 
				readExl("Inventory", DataTest.CitemName, DataTest.Ritem1));
		
		waitvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Ddesc));
		GetTextEqual(readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Ddesc), 
				readExl("Inventory", DataTest.CitemDesc, DataTest.Ritem1));
		
		waitvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Dprice));
		AssertEqual_replace(readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Dprice), 
				readExl("Inventory", DataTest.CitemPrice, DataTest.Ritem1));
		
		return this;
	}
	public InventoryObject Verify_GoBack (WebDriverWait wait, String data) {
		waitclickable(wait, readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_back ));
		ClickXpath(readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_back));
		
		waitvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_pagetitle));
		GetTextEqual(readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_pagetitle), data);
		return this;
	}
	/*public InventoryObject Verify_Link_item (ExtentTest log,WebDriverWait wait, String item) {
		waitformatclickable(wait, readExl("Xpath", 1, 11), item);
		ClickFormat(log, readExl("Xpath", 1, 11), item);
		return this;
	}*/
	public InventoryObject Verify_Link_item_problem (WebDriverWait wait) {
		ClickFormat(readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Ilink), 
				readExl("Inventory", DataTest.CitemImage,DataTest.Ritem2));
		waitvisible(wait, readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Dtitle));
		AssertEqual(readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_Dtitle), 
				readExl("Inventory", DataTest.CitemName, DataTest.Ritem2));	
		return this;
	}
	public InventoryObject Verify_Allitem (WebDriverWait wait, String expect) {
		waitclickable(wait, readExl("Xpath",DataTest.Cxpt_Inventory, DataTest.Rxpt_allitem));
		GetTextEqual(readExl("Xpath",DataTest.Cxpt_Inventory, DataTest.Rxpt_allitem), readExl("Inventory",DataTest.Ctitle, DataTest.Rallitem));
		ClickXpath(readExl("Xpath",DataTest.Cxpt_Inventory, DataTest.Rxpt_allitem));
		GetTextEqual(readExl("Xpath", DataTest.Cxpt_Inventory,DataTest.Rxpt_pagetitle), expect);
		return this;
	}
	public InventoryObject Verify_About (WebDriverWait wait) {
		waitclickable(wait, readExl("Xpath",DataTest.Cxpt_Inventory, DataTest.Rxpt_about));
		GetTextEqual(readExl("Xpath",DataTest.Cxpt_Inventory, DataTest.Rxpt_about), readExl("Inventory", DataTest.Ctitle, DataTest.Rabout));
		ClickXpath(readExl("Xpath",DataTest.Cxpt_Inventory, DataTest.Rxpt_about));
		return this;
	}
	public InventoryObject Compare_CartNum (String compare) {
		GetTextEqual(readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_Badgenum) ,compare);
		return this;
	}

}
