package ExercisemvnTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ExerciseBaseCommon.BaseActions;
import ExerciseBaseCommon.manage_driver;

public class Demo_Wait extends manage_driver  {
	
	@Test
	public void excersie () {
		mymethod.GotoURL(driver, "https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
		mymethod.ClickXpath(driver, "//button[@id='save']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'First Name')]")));
		WebElement Picture = driver.findElement(By.xpath("//div[@id='loading']"));
		System.out.println(Picture.getText());
	}

}
