package ExerciseBaseCommon;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;


public class BaseActions {
	
	ExcelInit reader;
	WebDriver driver;
	
	public BaseActions(WebDriver remoteDriver) {
		driver =  remoteDriver; //create driver variable in the class so do not need to define it again
		reader = new ExcelInit();
	}

	protected void GotoURL(ExtentTest log,  String url) {
		driver.get(url);
		//System.out.println("Go to URL " + url);
		log.info("Go to URL " + url );		
	}
	//Input Data
	protected void InputdataXpath (ExtentTest log, String xpath, String data) {
		driver.findElement(By.xpath(xpath)).sendKeys(data);
		log.info("Input " + data + "to field " + xpath);
	}
	
	protected void InputdataId (ExtentTest log, String id, String data) {
		driver.findElement(By.id(id)).sendKeys(data);
		log.info("Input " + data + " to " + id);
	}
	protected void InputdataClass (ExtentTest log, String classname, String data) {
		driver.findElement(By.className(classname)).sendKeys(data);
		log.info("Input " + data + " to " + classname);
	}
	protected void ClearDataxpath(ExtentTest log, String xpath) {
		driver.findElement(By.xpath(xpath)).clear();
		log.info("Clear Data of " + xpath + " Field");
	}
	//Click
	protected void ClickXpath(ExtentTest log, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		log.info("Click to " + xpath);
	}
	protected void ClickId(ExtentTest log, String id) {
		driver.findElement(By.id(id)).click();
		log.info("Click to " + id);
	}
	protected void ClickFormat (ExtentTest log, String xpath, String item) {
		String text = String.format(xpath, item);
		driver.findElement(By.xpath(text)).click();
		log.info("Click to " + text);
	}
	//Get Text
	protected void GetTextFormatEqual (ExtentTest log, String xpath, String item, String compare) {
		String text = String.format(xpath, item);
		Assert.assertTrue(driver.findElement(By.xpath(text)).getText().equalsIgnoreCase(compare));
		log.info("Get text of " + text + " and Compare to " + compare);
	}
	protected void GetTextEqual (ExtentTest log,String xpath, String compare) {
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).getText().equalsIgnoreCase(compare));
		log.info("Get text of " + xpath + " and Compare to " + compare);
	}
	protected void GetText (ExtentTest log,String xpath) {
		driver.findElement(By.xpath(xpath)).getText();
		log.info("Get text of " + xpath);
	}
	protected void GetTextFormatEqual_replace (ExtentTest log, String xpath, String item, String compare) {
		String text = String.format(xpath, item);
		Assert.assertTrue(driver.findElement(By.xpath(text)).getText().replace("\r" + "\n", "").equalsIgnoreCase(compare));
		log.info("Get text of " + text + " and Compare to " + compare);
	}
	protected void CompareCurrentURL (ExtentTest log,String compareUrl) {
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(compareUrl));
		log.info("The current URL is: " + compareUrl);
	}
	
	
	//Assert and softAssert
	protected void sAssertDisplay_true (ExtentTest log,SoftAssert softAssert,String xpath) {
		softAssert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
		log.info("Verify " + xpath + " is displayed");
	
	}
	protected void AssertDisplay_true (ExtentTest log,String xpath) {
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
		log.info("Verify " + xpath + " is displayed");
	
	}
	protected void sAssertDisplay_false (ExtentTest log,SoftAssert softAssert,String xpath) {
		softAssert.assertFalse(driver.findElement(By.xpath(xpath)).isDisplayed());
		log.info("Verify " + xpath + " is not displayed");
		
	
	}
	protected void sAssertEqual (ExtentTest log,SoftAssert softAssert,String xpath, String expect) {
		softAssert.assertEquals(driver.findElement(By.xpath(xpath)).getText(), expect);
		log.info("Verify " + xpath + " equal to " + expect);
	}
	protected void sAssertEqual_replace(ExtentTest log,SoftAssert softAssert,String xpath, String expect) {
		softAssert.assertEquals(driver.findElement(By.xpath(xpath)).getText().replace("\r" + "\n", ""), expect);
		//"\r" a space, "\n" a new line
		log.info("Verify " + xpath + " equal to " + expect);
	}
	protected void AssertEqual (ExtentTest log,String xpath, String expect) {
		Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText(), expect);
		log.info("Verify " + xpath + " equal to " + expect);
	}
	protected void AssertEqual_replace(ExtentTest log,String xpath, String expect) {
		Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().replace("\r" + "\n", ""), expect);
		//"\r" a space, "\n" a new line
		log.info("Verify " + xpath + " equal to " + expect);
	}
	//Wait
	protected void waitclickable(WebDriverWait wait, String xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	protected void waitformatclickable(WebDriverWait wait, String xpath, String item) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(xpath, item))));
	}
	protected void waitvisible(WebDriverWait wait, String xpath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	protected void waitformatvisible(WebDriverWait wait, String xpath, String item) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(xpath, item))));
	}
	protected void softAssertAll (SoftAssert softAssert) {
		softAssert.assertAll();
	}
	//Read Excel
	
	public String readExl(String sheetname,int icol, int irow) {
		String data = reader.RDataAtCell(BaseTest.fileName, sheetname, icol, irow);
		return data;
	}
	public ArrayList<String> lstData(String sheetname,int icol){
		ArrayList<String> data = reader.readExcelFileAtColumn(BaseTest.fileName, sheetname, icol);
		return data;
	}
}
