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
	public void ClickXpath(ExtentTest log, WebDriver driver,String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		log.info("Click to " + xpath);
	}
	public void ClickId(ExtentTest log, WebDriver driver,String id) {
		driver.findElement(By.id(id)).click();
		log.info("Click to " + id);
	}
	public void ClickFormat (ExtentTest log, WebDriver driver,String xpath, String item) {
		driver.findElement(By.xpath(String.format(xpath, item))).click();
		log.info("Click to " + xpath);
	}
	public void GetTextFormatEqual (ExtentTest log, WebDriver driver,String xpath, String item, String compare) {
		driver.findElement(By.xpath(String.format(xpath, item))).getText().equalsIgnoreCase(compare);
		log.info("Get text of " + xpath + " And Compare to " + compare);
	}
	public void GetTextEqual (ExtentTest log,WebDriver driver,String xpath, String compare) {
		driver.findElement(By.xpath(xpath)).getText().equalsIgnoreCase(compare);
		log.info("Get text of " + xpath + " And Compare to " + compare);
	}
	public void GetText (ExtentTest log,WebDriver driver,String xpath) {
		driver.findElement(By.xpath(xpath)).getText();
		log.info("Get text of " + xpath);
	}
	public void sAssertDisplay (ExtentTest log,SoftAssert softAssert,WebDriver driver,String xpath) {
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
		log.info("Verify " + xpath + " is displayed");
	
	}
	public void sAssertEqual (ExtentTest log,SoftAssert softAssert,WebDriver driver,String xpath, String expect) {
		Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText(), expect);
		log.info("Verify " + xpath + " equal to " + expect);
	}
	public void sAssertEqual_replace(ExtentTest log,SoftAssert softAssert,WebDriver driver,String xpath, String expect) {
		Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().replace("\r" + "\n", ""), expect);
		//"\r" a space, "\n" a new line
		log.info("Verify " + xpath + " equal to " + expect);
	}
	public void waitclickable(WebDriverWait wait,WebDriver driver, String xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	public void waitformatclickable(WebDriverWait wait,WebDriver driver, String xpath, String item) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(xpath, item))));
	}
}
