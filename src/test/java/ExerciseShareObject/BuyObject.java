package ExerciseShareObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import ExerciseBaseCommon.BaseActions;
import ExerciseBaseCommon.DataTest;

public class BuyObject extends BaseActions {
	
	WebDriver LocalDriver;
	public static ExtentTest LocalLog;
	
	
	//Input
	public BuyObject(WebDriver remoteDriver, ExtentTest remoteLog) {
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
	//Input
	
	public BuyObject Input_Firstname (String data) {
		InputdataId("first-name", data);
		return this;
	}
	public BuyObject Input_Lastname (String data) {
		InputdataId("last-name", data);
		return this;
	}
	public BuyObject Input_Postalcode (String data) {
		InputdataId("postal-code", data);
		return this;
	}
	
	
	//Verify
	public BuyObject Verify_YourCart_page (WebDriverWait wait,String item, String price) {
		GetTextEqual(readExl("Xpath", DataTest.Cxpt_Inventory, DataTest.Rxpt_pagetitle ), 
				readExl("Other", DataTest.COther, DataTest.RYourcarthead));
		GetTextEqual(readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_buyname1 ), item);		
		AssertEqual_replace(readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_buyprice ), price);
		return this;
	}
	public BuyObject Goto_Checkout_Page (WebDriverWait wait) {
		waitclickable(wait, readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_checkout));
		ClickXpath(readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_checkout));
		return this;
	}
	public BuyObject Goto_Checkout_Overview (WebDriverWait wait,String pricetotal) {
		waitclickable(wait,readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_continue));
		ClickXpath(readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_continue));
		AssertEqual_replace(readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_totalprice) ,pricetotal);
		return this;
	}
	public BuyObject Goto_Checkout_Complete (WebDriverWait wait) {
		waitclickable(wait,readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_finish));
		ClickXpath(readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_finish));
		GetTextEqual(readExl("Xpath", DataTest.Cxpt_Buy, DataTest.Rxpt_complete) ,
				readExl("Other", DataTest.COther, DataTest.ROrderhead ));
		return this;
	}
	

}
