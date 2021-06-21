package ExerciseShareObject;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import ExerciseBaseCommon.BaseActions;

public class ManageObject {
	
	private static LoginObject loginObj; //create static variable for Each Object
	private static InventoryObject InvenObj;
	private static BuyObject BuyObj;
	
	
	public static LoginObject ManageLogin(WebDriver LocalDriver, ExtentTest LocalLog) {
		if(loginObj == null) {
			loginObj = new LoginObject(LocalDriver, LocalLog);
		}
		if(LoginObject.LocalLog != LocalLog ) {
			 LoginObject.LocalLog = LocalLog;
		}
		
		return loginObj;
	}
	
	
	public static InventoryObject ManageInven(WebDriver LocalDriver, ExtentTest LocalLog) {
		if(InvenObj == null) {
			InvenObj = new InventoryObject(LocalDriver,LocalLog);
		}
		if(InventoryObject.LocalLog != LocalLog ) {
			InventoryObject.LocalLog = LocalLog;
		}
		return InvenObj;
	}
	
	public static BuyObject ManageBuy(WebDriver driver, ExtentTest LocalLog) {
		if(BuyObj == null) {
			BuyObj = new BuyObject(driver,LocalLog);
		}
		if(BuyObject.LocalLog != LocalLog) {
			BuyObject.LocalLog = LocalLog;
		}
		return BuyObj;
	}
	

}
