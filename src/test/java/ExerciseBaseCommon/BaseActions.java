package ExerciseBaseCommon;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;


public class BaseActions {

	public void GotoURL(ExtentTest log, WebDriver driver, String url) {
		driver.get(url);
		//System.out.println("Go to URL " + url);
		log.info("Go to URL " + url );		
	}
	//Input Data
	public void InputdataXpath (ExtentTest log, WebDriver driver,String xpath, String data) {
		driver.findElement(By.xpath(xpath)).sendKeys(data);
		log.info("Input " + data + "to field " + xpath);
	}
	
	public void InputdataId (ExtentTest log, WebDriver driver,String id, String data) {
		driver.findElement(By.id(id)).sendKeys(data);
		log.info("Input " + data + " to " + id);
	}
	public void InputdataClass (ExtentTest log, WebDriver driver,String classname, String data) {
		driver.findElement(By.className(classname)).sendKeys(data);
		log.info("Input " + data + " to " + classname);
	}
	public void ClearDataxpath(ExtentTest log, WebDriver driver,String xpath) {
		driver.findElement(By.xpath(xpath)).clear();
		log.info("Clear Data of " + xpath + " Field");
	}
	//Click
	public void ClickXpath(ExtentTest log, WebDriver driver,String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		log.info("Click to " + xpath);
	}
	public void ClickId(ExtentTest log, WebDriver driver,String id) {
		driver.findElement(By.id(id)).click();
		log.info("Click to " + id);
	}
	public void ClickFormat (ExtentTest log, WebDriver driver,String xpath, String item) {
		String text = String.format(xpath, item);
		driver.findElement(By.xpath(text)).click();
		log.info("Click to " + text);
	}
	//Get Text
	public void GetTextFormatEqual (ExtentTest log, WebDriver driver,String xpath, String item, String compare) {
		String text = String.format(xpath, item);
		driver.findElement(By.xpath(text)).getText().equalsIgnoreCase(compare);
		log.info("Get text of " + text + " and Compare to " + compare);
	}
	public void GetTextEqual (ExtentTest log,WebDriver driver,String xpath, String compare) {
		driver.findElement(By.xpath(xpath)).getText().equalsIgnoreCase(compare);
		log.info("Get text of " + xpath + " and Compare to " + compare);
	}
	public void GetText (ExtentTest log,WebDriver driver,String xpath) {
		driver.findElement(By.xpath(xpath)).getText();
		log.info("Get text of " + xpath);
	}
	public void GetTextFormatEqual_replace (ExtentTest log, WebDriver driver,String xpath, String item, String compare) {
		String text = String.format(xpath, item);
		driver.findElement(By.xpath(text)).getText().replace("\r" + "\n", "").equalsIgnoreCase(compare);
		log.info("Get text of " + text + " and Compare to " + compare);
	}
	
	//Assert and softAssert
	public void sAssertDisplay_true (ExtentTest log,SoftAssert softAssert,WebDriver driver,String xpath) {
		softAssert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
		log.info("Verify " + xpath + " is displayed");
	
	}
	public void sAssertDisplay_false (ExtentTest log,SoftAssert softAssert,WebDriver driver,String xpath) {
		softAssert.assertFalse(driver.findElement(By.xpath(xpath)).isDisplayed());
		log.info("Verify " + xpath + " is not displayed");
		
	
	}
	public void sAssertEqual (ExtentTest log,SoftAssert softAssert,WebDriver driver,String xpath, String expect) {
		softAssert.assertEquals(driver.findElement(By.xpath(xpath)).getText(), expect);
		log.info("Verify " + xpath + " equal to " + expect);
	}
	public void sAssertEqual_replace(ExtentTest log,SoftAssert softAssert,WebDriver driver,String xpath, String expect) {
		softAssert.assertEquals(driver.findElement(By.xpath(xpath)).getText().replace("\r" + "\n", ""), expect);
		//"\r" a space, "\n" a new line
		log.info("Verify " + xpath + " equal to " + expect);
	}
	//Wait
	public void waitclickable(WebDriverWait wait,WebDriver driver, String xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	public void waitformatclickable(WebDriverWait wait,WebDriver driver, String xpath, String item) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(xpath, item))));
	}
	public void waitvisible(WebDriverWait wait,WebDriver driver, String xpath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	public void waitformatvisible(WebDriverWait wait,WebDriver driver, String xpath, String item) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(xpath, item))));
	}
	public void softAssertAll (SoftAssert softAssert) {
		softAssert.assertAll();
	}
}
