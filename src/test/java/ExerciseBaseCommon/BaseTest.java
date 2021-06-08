package ExerciseBaseCommon;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ExerciseShareObject.InventoryObject;
import ExerciseShareObject.LoginObject;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected static WebDriver driver;
	//Using variable
	public static String fileName;
	protected BaseActions mymethod = new BaseActions();
	protected SoftAssert softAssert = new SoftAssert();
	protected BaseActions excel = new BaseActions();
	protected LoginObject lb = new LoginObject();
	protected InventoryObject ib = new InventoryObject();
	protected static WebDriverWait wait;
	protected static ExtentReports report; //resgister for report, create a new report, save, screenshot
	ExtentSparkReporter spark; //create a report file
	protected static ExtentTest log; //log steps, test case
	
	
	
	//protected WebDriverWait wait = new WebDriverWait(driver, 5);
	
	//@BeforeMethod
	//public void initmethod() {
		//mymethod = new BaseActions();
	//}
	
	
	public void sleep_1() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
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

	public String TakeScreenshot(String screenshotName){
		
		TakesScreenshot ts = (TakesScreenshot) driver; //capture screen + save in memory of pc
		File source = ts.getScreenshotAs(OutputType.FILE); // save the captured screen to a file and save it as temp to HDD

		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "/My_Report/" + screenshotName + " " + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //copy file from temp HDD to a specific location
		return destination;
	}
	protected void softAssertAll () {
		softAssert.assertAll();
	}
	
	@BeforeTest
	@Parameters({ "browser", "filename" })
	public void driver_open(String browser, String filename) {
		fileName = System.getProperty("user.dir") + File.separator + "Resources" + File.separator + filename;
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
			//log.fail("Test Case Failed Snapshot is below " + log.addScreenCaptureFromPath(screenshotPath));
			log.info(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());


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
	
}
