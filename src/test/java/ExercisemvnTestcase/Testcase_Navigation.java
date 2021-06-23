package ExercisemvnTestcase;

import org.testng.annotations.Test;
import ExerciseBaseCommon.BaseTest;
import ExerciseBaseCommon.DataTest;
import ExerciseBaseCommon.ManageObject;
import ExerciseShareObject.BuyObject;
import ExerciseShareObject.InventoryObject;
import ExerciseShareObject.LoginObject;

public class Testcase_Navigation extends BaseTest {
	LoginObject lb;
	InventoryObject ib;
	BuyObject bb;
	
	/*//@BeforeClass
	public void initObject() {
		lb = new LoginObject(driver);
		ib = new InventoryObject(driver);
		bb = new BuyObject(driver);
	}*/
	
	@Test (priority = 1)
	public void buy_an_item() {
		log = report.createTest("Process to Buy an Item");
		lb = ManageObject.ManageLogin(driver, log);
		
		ib = lb.Login();
		sleep_n(1);
		ib.Add_item_ToCart( readExl("Inventory", DataTest.Citembuy, DataTest.Ritem5));
		sleep_n(1);
		bb = ib.Go_to_YourCart_page(wait);
		bb.Verify_YourCart_page(wait, readExl("Inventory", DataTest.CitemName, DataTest.Ritem5 ), 
				readExl("Inventory", DataTest.CitemPrice, DataTest.Ritem5 ))
		.Goto_Checkout_Page(wait);
		sleep_n(1);
		bb.Input_Firstname(readExl("Other", DataTest.CInput, DataTest.Rfirstname))
		.Input_Lastname(readExl("Other", DataTest.CInput, DataTest.Rlastname))
		//.Input_Postalcode(readExl("Other", DataTest.CInput, DataTest.Rzipcode));
		.Input_Postalcode("700000");
		sleep_n(1);
		bb.Goto_Checkout_Overview(wait,readExl("Other", DataTest.CTotalPrice, DataTest.RTotalprice5));
		sleep_n(1);
		bb.Goto_Checkout_Complete(wait);
		sleep_n(1);
		
		
		/*log_in();
		mymethod.GetTextFormatEqual(log, driver, buyitem, "backpack", "add to cart");
		mymethod.ClickFormat(log,driver, buyitem, "backpack");
		mymethod.waitclickable(wait, driver, badgelink);
		mymethod.ClickXpath(log,driver, badgelink);
		mymethod.GetTextEqual(log,driver, pagetitle, "your cart");
		mymethod.GetTextEqual(log,driver, buyname1, "Sauce Labs Backpack");		
		mymethod.sAssertEqual_replace(log, softAssert, driver, buyprice1, "$29.99");		
		mymethod.waitclickable(wait, driver, checkout);
		mymethod.ClickXpath(log,driver, checkout);
		mymethod.InputdataId(log,driver, "first-name", "Shin");
		mymethod.InputdataId(log,driver, "last-name", "BLack");
		mymethod.InputdataId(log,driver, "postal-code", "700000");
		mymethod.waitclickable(wait, driver, butcont);
		mymethod.ClickXpath(log, driver, butcont);
		mymethod.sAssertEqual_replace(log, softAssert, driver, totalprice, "Total: $32.39");
		mymethod.waitclickable(wait, driver, finish);
		mymethod.ClickXpath(log, driver, finish);
		mymethod.GetTextEqual(log,driver, completeHead, "THANK YOU FOR YOUR ORDER");
		mymethod.softAssertAll(softAssert);*/
	}
	@Test (priority = 2)
	public void About() {
		log = report.createTest("Go to About Menu");	
		ib = ManageObject.ManageInven(driver, log);

		ib.OpenInvenPage()
		.OpenMenu()
		.Verify_About(wait)
		.Compare_CurrentURL(readExl("Other", DataTest.COther, DataTest.RUrlAbout));
		sleep_n(1);
		
		
		/*mymethod.GotoURL(log,driver, urlogin);
		open_menu();
		mymethod.waitclickable(wait, driver, about);
		mymethod.GetTextEqual(log,driver,about, "about");
		mymethod.ClickXpath(log,driver, about);
		driver.getCurrentUrl().equalsIgnoreCase("https://saucelabs.com/");*/
		
	}
	@Test (priority = 2)
	public void all_item() {
		log = report.createTest("Go to All Item Menu");
		ib = ManageObject.ManageInven(driver, log);
	
		ib.OpenInvenPage()
		.Click_Cart(wait);
		ib.OpenMenu()
		.Verify_Allitem(wait, readExl("Inventory", DataTest.Ctitle, DataTest.Rproduct));
		sleep_n(1);
		
		/*mymethod.GotoURL(log,driver, urlogin);
		mymethod.waitclickable(wait, driver, badgelink);
		mymethod.ClickXpath(log,driver, badgelink);
		open_menu();
		mymethod.waitclickable(wait, driver, allitem);
		mymethod.GetTextEqual(log,driver, allitem, "All Items");
		mymethod.ClickXpath(log,driver, allitem);
		mymethod.GetTextEqual(log,driver, pagetitle, "products");
		sleep_3();*/
	}
	
	@Test (priority = 3)
	public void Check_cart_number() {
		log = report.createTest("Checking Cart Number");	
		ib = ManageObject.ManageInven(driver, log);
		
		ib.OpenInvenPage()
		.Add_item_ToCart(readExl("Inventory", DataTest.Citembuy, DataTest.Ritem1))
		.Compare_CartNum("1");
		sleep_n(1);
		ib.Add_item_ToCart(readExl("Inventory", DataTest.Citembuy, DataTest.Ritem2))
		.Compare_CartNum("2");
		sleep_n(1);
		ib.Add_item_ToCart(readExl("Inventory", DataTest.Citembuy, DataTest.Ritem3))
		.Compare_CartNum("3");
		sleep_n(1);
		ib.Add_item_ToCart(readExl("Inventory", DataTest.Citembuy, DataTest.Ritem4))
		.Compare_CartNum("4");
		sleep_n(1);
		ib.Add_item_ToCart(readExl("Inventory", DataTest.Citembuy, DataTest.Ritem2))
		.Compare_CartNum("3");
		sleep_n(1);
		ib.Add_item_ToCart(readExl("Inventory", DataTest.Citembuy, DataTest.Ritem1))
		.Compare_CartNum("2");
		sleep_n(1);
		
		/*mymethod.GotoURL(log,driver, urlogin);
		mymethod.ClickFormat(log,driver, buyitem, "backpack");
		sleep_3();
		//Assert.assertEquals(cart1.getText(),"REMOVE");
		mymethod.GetTextEqual(log,driver, badgeno, "1");
		mymethod.ClickFormat(log,driver, buyitem, "bolt-t-shirt");
		sleep_3();
		mymethod.GetTextEqual(log,driver, badgeno, "2");
		mymethod.ClickFormat(log,driver, buyitem, "fleece-jacket");
		sleep_3();
		mymethod.GetTextEqual(log,driver, badgeno, "3");
		mymethod.ClickFormat(log,driver, buyitem, "test.allthethings()");
		sleep_3();
		mymethod.GetTextEqual(log,driver, badgeno, "4");
		mymethod.ClickFormat(log,driver, buyitem, "fleece-jacket");
		sleep_3();
		mymethod.GetTextEqual(log,driver, badgeno, "3");
		mymethod.ClickFormat(log,driver, buyitem, "backpack");
		mymethod.GetTextEqual(log,driver, badgeno, "2");*/
	}
	
	@Test (priority = 4)
	public void logout() {
		log = report.createTest("Logout Menu");		
		ib = ManageObject.ManageInven(driver, log);
		
		ib.OpenInvenPage();
		lb = ib.Logout(wait);
		lb.Compare_login_but();
		
		/*mymethod.GotoURL(log,driver, urlogin);
		open_menu();
		mymethod.waitclickable(wait, driver, logout);
		mymethod.GetTextEqual(log,driver, logout, "logout");
		mymethod.ClickXpath(log, driver, logout);
		mymethod.sAssertDisplay_true(log,softAssert, driver, login);
		mymethod.softAssertAll(softAssert);*/
	}
}
