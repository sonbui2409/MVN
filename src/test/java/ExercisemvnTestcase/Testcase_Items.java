package ExercisemvnTestcase;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ExerciseBaseCommon.BaseTest;
import ExerciseBaseCommon.DataTest;
import ExerciseBaseCommon.ManageObject;
import ExerciseShareObject.InventoryObject;
import ExerciseShareObject.LoginObject;

public class Testcase_Items extends BaseTest {
	LoginObject lb;
	InventoryObject ib;
	
	//@BeforeClass
	public void initObject() {
		lb = new LoginObject(driver, log);
		ib = new InventoryObject(driver, log);
	}
	
	@Test (priority = 1)
	public void products_page () {
		log = report.createTest("Verify Inventory Page");		
		lb = ManageObject.ManageLogin(driver, log);
		
		ib = lb.Login();
		ib.Verify_Name_Desc_price_item_1(wait)
		.ClickToItem(wait,readExl("Inventory", DataTest.CitemLink, DataTest.Ritem1))
		.Verify_Page_item_1(wait);
		sleep_n(1);
		ib.Verify_GoBack(wait,readExl("Inventory", DataTest.Ctitle, DataTest.Rproduct));
		lb = ib.Logout(wait);
		
		
		
		/*log_in();
		mymethod.GetTextFormatEqual(log, driver, itemname, "item_0_title_link", item0name);
		mymethod.GetTextFormatEqual(log, driver, itemdesc, "item_0_title_link", item0desc);
		mymethod.waitformatclickable(wait, driver, itemlink, "item_0_title_link");
		mymethod.ClickFormat(log, driver, itemlink, "item_0_title_link");
		mymethod.GetTextEqual(log, driver, itemdetail_Title, item0name);
		mymethod.GetTextEqual(log, driver, itemdetail_desc, item0desc);
		mymethod.sAssertEqual_replace(log, softAssert, driver, itemdetail_price, "$9.99");
		sleep_3();
		mymethod.waitclickable(wait, driver, backto);
		mymethod.ClickXpath(log, driver, backto);
		mymethod.waitvisible(wait, driver, pagetitle);
		mymethod.GetTextEqual(log, driver, pagetitle, "products");
		logout();
		mymethod.softAssertAll(softAssert);*/
	}
	@Test (priority = 2)
	public void verify_content_1 () {
		log = report.createTest("Verify Title Link of each item");		
		lb = ManageObject.ManageLogin(driver, log);
		
		ib = lb.Login();
		/*ib.Verify_Link_item(log, wait, readExl("Inventory", 1 , 1))
		.Verify_Link_item(log, wait, readExl("Inventory", 1 , 2))
		.Verify_Link_item(log, wait, readExl("Inventory", 1 , 3))
		.Verify_Link_item(log, wait, readExl("Inventory", 1 , 4))
		.Verify_Link_item(log, wait, readExl("Inventory", 1 , 5))
		.Verify_Link_item(log, wait, readExl("Inventory", 1 , 6));*/
		
		ArrayList<String> lstLink = reader.readExcelFileAtColumn(BaseTest.fileName, "Inventory",DataTest.CitemLink );

		for (int i = 1; i < lstLink.size(); i++) {
			String itemlink = lstLink.get(i);
			if (!itemlink.isEmpty()) {
			ib.ClickToItem(wait, itemlink);
			sleep_n(1);
			ib.Click_GoBack(wait);

			}
		}
		lb = ib.Logout(wait);
		
		/*mymethod.waitformatclickable(wait, driver, itemlink, "item_0_title_link");
		mymethod.ClickFormat(log, driver, itemlink, "item_0_title_link");
		mymethod.waitclickable(wait, driver, backto);
		mymethod.ClickXpath(log, driver, backto);
		mymethod.waitformatclickable(wait, driver, itemlink, "item_1_title_link");
		mymethod.ClickFormat(log, driver, itemlink, "item_1_title_link");
		mymethod.waitclickable(wait, driver, backto);
		mymethod.ClickXpath(log, driver, backto);
		mymethod.waitformatclickable(wait, driver, itemlink, "item_2_title_link");
		mymethod.ClickFormat(log, driver, itemlink, "item_2_title_link");
		mymethod.waitclickable(wait, driver, backto);
		mymethod.ClickXpath(log, driver, backto);
		mymethod.waitformatclickable(wait, driver, itemlink, "item_3_title_link");
		mymethod.ClickFormat(log, driver, itemlink, "item_3_title_link");
		mymethod.waitclickable(wait, driver, backto);
		mymethod.ClickXpath(log, driver, backto);
		mymethod.waitformatclickable(wait, driver, itemlink, "item_4_title_link");
		mymethod.ClickFormat(log, driver, itemlink, "item_4_title_link");
		mymethod.waitclickable(wait, driver, backto);
		mymethod.ClickXpath(log, driver, backto);
		mymethod.waitformatclickable(wait, driver, itemlink, "item_5_title_link");
		mymethod.ClickFormat(log, driver, itemlink, "item_5_title_link");
		mymethod.waitclickable(wait, driver, backto);
		mymethod.ClickXpath(log, driver, backto);
		logout();*/
	}
	@Test (priority = 2)
	public void verify_content_2 () {
		log = report.createTest("Verify Image Link of each item");		
		lb = ManageObject.ManageLogin(driver, log);
		
		ib = lb.Login();
		
		ArrayList<String> lstImage = reader.readExcelFileAtColumn(BaseTest.fileName, "Inventory",DataTest.CitemImage );

		for (int i = 1; i < lstImage.size(); i++) {
			String imagelink = lstImage.get(i);
			if (!imagelink.isEmpty()) {
			ib.ClickToItem(wait, imagelink);
			sleep_n(1);
			ib.Click_GoBack(wait);

			}
		}
		lb = ib.Logout(wait);
		
		
		/*ib.Verify_Link_item(log, wait,readExl("Inventory", 2 , 1))
		.Verify_Link_item(log, wait,readExl("Inventory", 2 , 2))
		.Verify_Link_item(log, wait,readExl("Inventory", 2 , 3))
		.Verify_Link_item(log, wait,readExl("Inventory", 2 , 4))
		.Verify_Link_item(log, wait,readExl("Inventory", 2 , 5))
		.Verify_Link_item(log, wait, readExl("Inventory", 2 , 6));*/
		
		
		/*mymethod.waitformatclickable(wait, driver, itemlink, "item_0_img_link");
		mymethod.ClickFormat(log, driver, itemlink, "item_0_img_link");
		mymethod.waitclickable(wait, driver, backto);
		mymethod.ClickXpath(log, driver, backto);
		mymethod.waitformatclickable(wait, driver, itemlink, "item_1_img_link");
		mymethod.ClickFormat(log, driver, itemlink, "item_1_img_link");
		mymethod.waitclickable(wait, driver, backto);
		mymethod.ClickXpath(log, driver, backto);
		mymethod.waitformatclickable(wait, driver, itemlink, "item_2_img_link");
		mymethod.ClickFormat(log, driver, itemlink, "item_2_img_link");
		mymethod.waitclickable(wait, driver, backto);
		mymethod.ClickXpath(log, driver, backto);
		mymethod.waitformatclickable(wait, driver, itemlink, "item_3_img_link");
		mymethod.ClickFormat(log, driver, itemlink, "item_3_img_link");
		mymethod.waitclickable(wait, driver, backto);
		mymethod.ClickXpath(log, driver, backto);
		mymethod.waitformatclickable(wait, driver, itemlink, "item_4_img_link");
		mymethod.ClickFormat(log, driver, itemlink, "item_4_img_link");
		mymethod.waitclickable(wait, driver, backto);
		mymethod.ClickXpath(log, driver, backto);
		mymethod.waitformatclickable(wait, driver, itemlink, "item_5_img_link");
		mymethod.ClickFormat(log, driver, itemlink, "item_5_img_link");
		mymethod.waitclickable(wait, driver, backto);
		mymethod.ClickXpath(log, driver, backto);*/
	}
	@Test (priority = 2)
	public void verify_content_3 () {
		log = report.createTest("Verify Title,Description and price of each item");	
		lb = ManageObject.ManageLogin(driver, log);
		
		ib = lb.Login();
		
		ArrayList<String> lstLink = reader.readExcelFileAtColumn(BaseTest.fileName, "Inventory",DataTest.CitemLink );
		ArrayList<String> lstName = reader.readExcelFileAtColumn(BaseTest.fileName, "Inventory",DataTest.CitemName );
		ArrayList<String> lstDesc = reader.readExcelFileAtColumn(BaseTest.fileName, "Inventory",DataTest.CitemDesc );
		ArrayList<String> lstPrice = reader.readExcelFileAtColumn(BaseTest.fileName, "Inventory",DataTest.CitemPrice );

		for (int i = 1; i < lstLink.size(); i++) {
			String link = lstLink.get(i);
			String name = lstName.get(i);
			String desc = lstDesc.get(i);
			String price = lstPrice.get(i);
			
			if (!link.isEmpty()) {
			ib.Verify_Item_Name(wait, link, name)
			.Verify_Item_Desc(wait, link, desc)
			.Verify_Item_Price(wait, link, price);	

			}
		}
		lb = ib.Logout(wait);
		
		
		/*ib.Verify_Name_Desc_price_item_1(log, wait)
		.Verify_Name_Desc_price_item_2(log, wait)
		.Verify_Name_Desc_price_item_3(log, wait)
		.Verify_Name_Desc_price_item_4(log, wait)
		.Verify_Name_Desc_price_item_5(log, wait)
		.Verify_Name_Desc_price_item_6(log, wait);*/
		
		
		
		/*log_in();
		mymethod.waitformatvisible(wait, driver, itemname, "item_0_title_link");
		mymethod.GetTextFormatEqual(log, driver, itemname, "item_0_title_link", item0name);
		mymethod.GetTextFormatEqual(log, driver, itemdesc, "item_0_title_link", item0desc);
		mymethod.GetTextFormatEqual_replace(log, driver, itemprice, "item_0_title_link", "$9.99");
		mymethod.waitformatvisible(wait, driver, itemname, "item_1_title_link");
		mymethod.GetTextFormatEqual(log, driver, itemname, "item_1_title_link", item0name);
		mymethod.GetTextFormatEqual(log, driver, itemdesc, "item_1_title_link", item0desc);
		mymethod.GetTextFormatEqual_replace(log, driver, itemprice, "item_1_title_link", "$15.99");
		mymethod.waitformatvisible(wait, driver, itemname, "item_2_title_link");
		mymethod.GetTextFormatEqual(log, driver, itemname, "item_2_title_link", item0name);
		mymethod.GetTextFormatEqual(log, driver, itemdesc, "item_2_title_link", item0desc);
		mymethod.GetTextFormatEqual_replace(log, driver, itemprice, "item_2_title_link", "$7.99");
		mymethod.waitformatvisible(wait, driver, itemname, "item_3_title_link");
		mymethod.GetTextFormatEqual(log, driver, itemname, "item_3_title_link", item0name);
		mymethod.GetTextFormatEqual(log, driver, itemdesc, "item_3_title_link", item0desc);
		mymethod.GetTextFormatEqual_replace(log, driver, itemprice, "item_3_title_link", "$15.99");
		mymethod.waitformatvisible(wait, driver, itemname, "item_4_title_link");
		mymethod.GetTextFormatEqual(log, driver, itemname, "item_4_title_link", item0name);
		mymethod.GetTextFormatEqual(log, driver, itemdesc, "item_4_title_link", item0desc);
		mymethod.GetTextFormatEqual_replace(log, driver, itemprice, "item_4_title_link", "$29.99");
		mymethod.waitformatvisible(wait, driver, itemname, "item_5_title_link");
		mymethod.GetTextFormatEqual(log, driver, itemname, "item_5_title_link", item0name);
		mymethod.GetTextFormatEqual(log, driver, itemdesc, "item_5_title_link", item0desc);
		mymethod.GetTextFormatEqual_replace(log, driver, itemprice, "item_5_title_link", "$49.99");
		logout();*/
	}
}
