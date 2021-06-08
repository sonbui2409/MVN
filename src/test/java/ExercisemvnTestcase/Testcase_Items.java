package ExercisemvnTestcase;

import org.testng.annotations.Test;
import ExerciseBaseCommon.BaseTest;

public class Testcase_Items extends BaseTest {

	@Test (priority = 1)
	public void products_page () {
		log = report.createTest("Verify Inventory Page");		
		lb.Login(log, driver);
		ib.Verify_Name_Desc_price_item_1(softAssert,log, wait, driver)
		.GoToItem_1(log, driver)
		.Verify_Page_item_1(softAssert, log, wait, driver);
		sleep_1();
		ib.Verify_GoBack(softAssert,log, wait, driver)
		.Logout(log, wait, driver);
		lb.TracksAssert(softAssert);
		
		
		
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
		lb.Login(log, driver);
		ib.Verify_Link_item(log, wait, driver, excel.readExl("Inventory", 1 , 1))
		.Verify_Link_item(log, wait, driver, excel.readExl("Inventory", 1 , 2))
		.Verify_Link_item(log, wait, driver, excel.readExl("Inventory", 1 , 3))
		.Verify_Link_item(log, wait, driver, excel.readExl("Inventory", 1 , 4))
		.Verify_Link_item(log, wait, driver, excel.readExl("Inventory", 1 , 5))
		.Verify_Link_item(log, wait, driver, excel.readExl("Inventory", 1 , 6))
		.Logout(log, wait, driver);
		
		
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
		lb.Login(log, driver);
		ib.Verify_Link_item(log, wait, driver, excel.readExl("Inventory", 2 , 1))
		.Verify_Link_item(log, wait, driver, excel.readExl("Inventory", 2 , 2))
		.Verify_Link_item(log, wait, driver, excel.readExl("Inventory", 2 , 3))
		.Verify_Link_item(log, wait, driver, excel.readExl("Inventory", 2 , 4))
		.Verify_Link_item(log, wait, driver, excel.readExl("Inventory", 2 , 5))
		.Verify_Link_item(log, wait, driver, excel.readExl("Inventory", 2 , 6))
		.Logout(log, wait, driver);
		
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
		lb.Login(log, driver);
		ib.Verify_Name_Desc_price_item_1(softAssert,log, wait, driver)
		.Verify_Name_Desc_price_item_2(softAssert,log, wait, driver)
		.Verify_Name_Desc_price_item_3(softAssert,log, wait, driver)
		.Verify_Name_Desc_price_item_4(softAssert,log, wait, driver)
		.Verify_Name_Desc_price_item_5(softAssert,log, wait, driver)
		.Verify_Name_Desc_price_item_6(softAssert,log, wait, driver)
		.Logout(log, wait, driver);
		lb.TracksAssert(softAssert);
		
		
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
