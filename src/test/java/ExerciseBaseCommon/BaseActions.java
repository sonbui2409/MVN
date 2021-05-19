package ExerciseBaseCommon;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class BaseActions {

	public void GotoURL(WebDriver driver, String url) {
		driver.get(url);
		//System.out.println("Go to URL " + url);
		System.out.println("Go to URL" + url );	
			
	}
	
	public void InputdataXpath (WebDriver driver,String xpath, String data) {
		driver.findElement(By.xpath(xpath)).sendKeys(data);
		System.out.println("Input " + data + "to field " + xpath);
	}
	
	public void InputdataId (WebDriver driver,String id, String data) {
		driver.findElement(By.id(id)).sendKeys(data);
		System.out.println("Input " + data + " to " + id);
	}
	public void InputdataClass (WebDriver driver,String classname, String data) {
		driver.findElement(By.className(classname)).sendKeys(data);
		System.out.println("Input " + data + " to " + classname);
	}
	public void ClickXpath(WebDriver driver,String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		System.out.println("Click to " + xpath);
	}
	public void ClickId(WebDriver driver,String id) {
		driver.findElement(By.id(id)).click();
		System.out.println("Click to " + id);
	}
	public void ClickFormat (WebDriver driver,String xpath, String item) {
		driver.findElement(By.xpath(String.format(xpath, item))).click();
		System.out.println("Click to " + xpath);
	}
	public void GetTextFormatEqual (WebDriver driver,String xpath, String item, String compare) {
		driver.findElement(By.xpath(String.format(xpath, item))).getText().equalsIgnoreCase(compare);
		System.out.println("Get text of " + xpath + " And Compare to " + compare);
	}
	public void GetTextEqual (WebDriver driver,String xpath, String compare) {
		driver.findElement(By.xpath(xpath)).getText().equalsIgnoreCase(compare);
		System.out.println("Get text of " + xpath + " And Compare to " + compare);
	}
	public void GetText (WebDriver driver,String xpath) {
		driver.findElement(By.xpath(xpath)).getText();
		System.out.println("Get text of " + xpath);
	}
	public void sAssertDisplay (SoftAssert softAssert,WebDriver driver,String xpath) {
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
		System.out.println("Verify " + xpath + " is displayed");
	
	}
	public void sAssertEqual (SoftAssert softAssert,WebDriver driver,String xpath, String expect) {
		Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText(), expect);
		System.out.println("Verify " + xpath + " equal to " + expect);
	
	}
}
