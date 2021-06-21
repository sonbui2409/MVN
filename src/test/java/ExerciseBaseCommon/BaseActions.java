package ExerciseBaseCommon;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;


public class BaseActions {
	
	ExcelInit reader;
	WebDriver driver;
	ExtentTest log;
	
	public BaseActions(WebDriver remoteDriver,ExtentTest remoteLog ) {
		driver =  remoteDriver; //create driver variable in the class so do not need to define it again
		log = remoteLog;
		reader = new ExcelInit();
	}

	private String get_EleDescription(WebElement ele) {
		String des ="";
		des = ele.getAttribute("id");
		if(isNullOrEmpty(des)) {
			des= ele.getAttribute("name");
			if(isNullOrEmpty(des)) {
				des = ele.getText();
				if(isNullOrEmpty(des)) {
					des = ele.getAttribute("class");
				}
			}
		}
		return des;
	}
	
	private boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }

	protected void GotoURL(String url) {
		driver.get(url);
		//System.out.println("Go to URL " + url);
		log.info("Go to URL " + url );		
	}
	//Input Data
	protected void InputdataXpath (String xpath, String data) {
		WebElement field = driver.findElement(By.xpath(xpath));
		field.sendKeys(data);
		get_EleDescription(field);
		log.info("Input " + data + " to field " + get_EleDescription(field));
	}
	
	protected void InputdataId (String id, String data) {
		WebElement field = driver.findElement(By.id(id));
		field.sendKeys(data);
		log.info("Input " + data + " to " + id);
	}
	protected void InputdataClass (String classname, String data) {
		WebElement field = driver.findElement(By.className(classname));
		field.sendKeys(data);
		log.info("Input " + data + " to " + classname);
	}
	protected void ClearDataxpath(String xpath) {
		WebElement field = driver.findElement(By.xpath(xpath));
		field.clear();
		log.info("Clear Data of " + xpath + " Field");
	}
	//Click
	protected void ClickXpath(String xpath) {
		WebElement field = driver.findElement(By.xpath(xpath));
		field.click();
		log.info("Click to ");
	}
	protected void ClickId(String id) {
		WebElement field = driver.findElement(By.id(id));
		field.click();
		log.info("Click to " + get_EleDescription(field));
	}
	protected void ClickFormat (String xpath, String item) {
		String text = String.format(xpath, item);
		WebElement field = driver.findElement(By.xpath(text));
		field.click();
		log.info("Click to " + get_EleDescription(field));
	}
	//Get Text
	protected void GetTextFormatEqual (String xpath, String item, String compare) {
		String text = String.format(xpath, item);
		WebElement field = driver.findElement(By.xpath(text));
		Assert.assertTrue(field.getText().equalsIgnoreCase(compare));
		log.info("Get text of " + get_EleDescription(field) + " and Compare to " + compare);
	}
	protected void GetTextEqual (String xpath, String compare) {
		WebElement field = driver.findElement(By.xpath(xpath));
		Assert.assertTrue(field.getText().equalsIgnoreCase(compare));
		log.info("Get text of " + get_EleDescription(field) + " and Compare to " + compare);
	}
	protected void GetText (String xpath) {
		WebElement field = driver.findElement(By.xpath(xpath));
		field.getText();
		log.info("Get text of " + get_EleDescription(field));
	}
	protected void GetTextFormatEqual_replace (String xpath, String item, String compare) {
		String text = String.format(xpath, item);
		WebElement field = driver.findElement(By.xpath(text));
		Assert.assertTrue(field.getText().replace("\r" + "\n", "").equalsIgnoreCase(compare));
		log.info("Get text of " + get_EleDescription(field) + " and Compare to " + compare);
	}
	protected void CompareCurrentURL (String compareUrl) {
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(compareUrl));
		log.info("The current URL is: " + compareUrl);
	}
	
	
	//Assert and softAssert
	protected void sAssertDisplay_true (SoftAssert softAssert,String xpath) {
		WebElement field = driver.findElement(By.xpath(xpath));
		softAssert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
		log.info("Verify " + get_EleDescription(field) + " is displayed");
	
	}
	protected void AssertDisplay_true (String xpath) {
		WebElement field = driver.findElement(By.xpath(xpath));
		Assert.assertTrue(field.isDisplayed());
		log.info("Verify " + get_EleDescription(field) + " is displayed");
	
	}
	protected void sAssertDisplay_false (SoftAssert softAssert,String xpath) {
		WebElement field = driver.findElement(By.xpath(xpath));
		softAssert.assertFalse(field.isDisplayed());
		log.info("Verify " + get_EleDescription(field) + " is not displayed");
		
	
	}
	protected void sAssertEqual (SoftAssert softAssert,String xpath, String expect) {
		WebElement field = driver.findElement(By.xpath(xpath));
		softAssert.assertEquals(field.getText(), expect);
		log.info("Verify " + get_EleDescription(field) + " equal to " + expect);
	}
	protected void sAssertEqual_replace(SoftAssert softAssert,String xpath, String expect) {
		WebElement field = driver.findElement(By.xpath(xpath));
		softAssert.assertEquals(field.getText().replace("\r" + "\n", ""), expect);
		//"\r" a space, "\n" a new line
		log.info("Verify " + get_EleDescription(field) + " equal to " + expect);
	}
	protected void AssertEqual (String xpath, String expect) {
		WebElement field = driver.findElement(By.xpath(xpath));
		Assert.assertEquals(field.getText(), expect);
		log.info("Verify " + get_EleDescription(field) + " equal to " + expect);
	}
	protected void AssertEqual_replace(String xpath, String expect) {
		WebElement field = driver.findElement(By.xpath(xpath));
		Assert.assertEquals(field.getText().replace("\r" + "\n", ""), expect);
		//"\r" a space, "\n" a new line
		log.info("Verify " + get_EleDescription(field) + " equal to " + expect);
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
