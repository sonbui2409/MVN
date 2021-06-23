package ExerciseBaseCommon;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import ExerciseShareObject.BuyObject;
import ExerciseShareObject.InventoryObject;
import ExerciseShareObject.LoginObject;

public class ManageObject {
	
	private static LoginObject loginObj; //create static variable for Each Object
	private static InventoryObject InvenObj;
	private static BuyObject BuyObj;
	
	
	public static LoginObject ManageLogin(WebDriver LocalDriver, ExtentTest LocalLog) {
		if(loginObj == null) {
			loginObj = new LoginObject(LocalDriver, LocalLog);
		}
		else if(loginObj.getLoglocal() != LocalLog ) {
			loginObj.updateLocalLog(LocalLog);
		}
		
		return loginObj;
	}
	
	
	public static InventoryObject ManageInven(WebDriver LocalDriver, ExtentTest LocalLog) {
		if(InvenObj == null) {
			InvenObj = new InventoryObject(LocalDriver,LocalLog);
		}
		else if(InvenObj.getLoglocal() != LocalLog ) {
			InvenObj.updateLocalLog(LocalLog);
		}
		return InvenObj;
	}
	
	public static BuyObject ManageBuy(WebDriver driver, ExtentTest LocalLog) {
		if(BuyObj == null) {
			BuyObj = new BuyObject(driver,LocalLog);
		}
		else if(BuyObj.getLoglocal() != LocalLog ) {
			BuyObj.updateLocalLog(LocalLog);
		}
		return BuyObj;
	}
	

}
