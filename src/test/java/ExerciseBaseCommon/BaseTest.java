package ExerciseBaseCommon;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected static WebDriver driver;
	
	protected String passwd = "secret_sauce";
	protected String url = "https://www.saucedemo.com/";
	protected String urlogin = "https://www.saucedemo.com/inventory.html";
	protected String login = "//input[@type='submit']";
	protected String user = "//input[@name = 'user-name']";
	protected String passbut = "//input[@id = 'password']";
	protected String error = "//h3[@data-test='error']";
	protected String failure = "Epic sadface: Sorry, this user has been locked out.";
	
	protected String pagetitle = "//span[@class = 'title']";
	protected String itemdetail_Title = "//div[contains (@class,'name large_size')]";
	protected String itemdetail_desc = "//div[contains (@class,'desc large_size')]";
	protected String itemdetail_price = "//div[@class ='inventory_details_price']";
	
	protected String itemlink = "//a[@id ='%s']";
	protected String itemname = "//a[@id ='%s']/div";
	protected String itemdesc = "//a[@id ='%s']/following-sibling::div";
	protected String itemprice = "//a[@id='%s']/parent::div/following-sibling::div/div[@class='inventory_item_price']";
	protected String item0name = "Sauce Labs Bike Light";
	protected String item0desc = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
	protected String item1name = "Sauce Labs Bolt T-Shirt";
	protected String item1desc = "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.";
	protected String item2name = "Sauce Labs Onesie";
	protected String item2desc = "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.";
	protected String item3name = "Test.allTheThings() T-Shirt (Red)";
	protected String item3desc = "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.";
	protected String item4name = "Sauce Labs Backpack";
	protected String item4desc = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
	protected String item5name = "Sauce Labs Fleece Jacket";
	protected String item5desc = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
	
	protected String badgelink = "//a[@class='shopping_cart_link']";
	protected String badgeno = "//span[@class='shopping_cart_badge']";
	protected String buyitem = "//button[contains (@name,'%s')]";
	protected String buyname1 = "//div[@class='inventory_item_name']";
	protected String buyprice1 = "//div[@class='inventory_item_price']";
	protected String checkout = "//button[@id='checkout']";
	protected String butcont = "//input[@id='continue']";
	protected String totalprice = "//div[@class='summary_total_label']";
	protected String finish = "//button[@id='finish']";
	protected String completeHead = "//h2[@class='complete-header']";
	
	
	protected String menu = "//div[@class='bm-burger-button']";
	protected String logout = "//a[@id='logout_sidebar_link']";
	protected String about = "//a[@id = 'about_sidebar_link']";
	protected String allitem = "//a[@id = 'inventory_sidebar_link']";
	
	
	
	protected BaseActions mymethod = new BaseActions();
	protected SoftAssert softAssert = new SoftAssert();
	protected static WebDriverWait wait;
	protected static ExtentReports report; //resgister for report, create a new report, save, screenshot
	ExtentSparkReporter spark; //create a report file
	protected static ExtentTest log; //log steps, test case
	
	
	
	//protected WebDriverWait wait = new WebDriverWait(driver, 5);
	
	//@BeforeMethod
	//public void initmethod() {
		//mymethod = new BaseActions();
	//}
	
	
	public void sleep_3() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void sleep_20() {
		try {
			Thread.sleep(20000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void logout() {
		mymethod.ClickXpath(log, driver, menu);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(logout)));
		mymethod.ClickXpath(log, driver, logout);
	}
	public void log_in() {
		mymethod.GotoURL(log,driver, url);
		mymethod.InputdataXpath(log,driver, user,"standard_user");
		mymethod.InputdataXpath(log,driver,passbut , passwd);
		mymethod.ClickXpath(log,driver, login);
	}
	public void open_menu() {
		mymethod.ClickXpath(log, driver, menu);
	}
	
	
	@BeforeTest
	@Parameters({ "browser" })
	public void driver_open(String browser) {
		browser = browser.toLowerCase(); 
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "My_Report" + File.separator + "Report_Result.html"); //path of location which used to save report.html file
		spark.config().setTheme(Theme.DARK);
		report.attachReporter(spark);
		
		report.setSystemInfo("OS", "WINDOW");
		report.setSystemInfo("Browser", browser);
		report.setSystemInfo("Author", "ShiN BlAck");
	}
	
	

	@AfterTest
	public void driver_quit() {
		driver.close();
		softAssert.assertAll();
		report.flush(); //save report after run
	

	}
	@AfterMethod
	public void getResult(ITestResult result) throws Exception
	{
		if(result.getStatus() == ITestResult.FAILURE) // get status of executed test case
		{
			//MarkupHelper is used to display the output in different colors
			log.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED)); // get name of test case
			log.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED)); //get failed reason

			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
			//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 

			//	String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			String screenshotPath = TakeScreenshot(result.getName());
			//To add it in the extent report 

			log.fail("Test Case Failed Snapshot is below " + log.addScreenCaptureFromPath(screenshotPath));


		}
		else if(result.getStatus() == ITestResult.SKIP){
			//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			log.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
		} 
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			log.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
	}
	public String TakeScreenshot(String screenshotName) throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot) driver; //capture screen + save in memory of pc
		File source = ts.getScreenshotAs(OutputType.FILE); // save the captured screen to a file and save it as temp to HDD

		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "/My_Report/" + screenshotName + " " + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination); //copy file from temp HDD to a specific location
		return destination;
	}
}
