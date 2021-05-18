package ExerciseBaseCommon;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class manage_driver {
	protected static WebDriver driver;
	
	protected String passwd = "secret_sauce";
	protected String url = "https://www.saucedemo.com/";
	protected String login = "//input[@type='submit']";
	protected String user = "//input[@name = 'user-name']";
	protected String passbut = "//input[@id = 'password']";
	protected String error = "//h3[@data-test='error']";
	protected String pagetitle = "//span[@class = 'title']";
	protected String item1 = "//img[@alt = 'Sauce Labs Backpack']";
	protected String urlogin = "https://www.saucedemo.com/inventory.html";
	protected String badgelink = "//a[@class='shopping_cart_link']";
	protected String badgeno = "//span[@class='shopping_cart_badge']";
	protected String buyitem = "//button[contains (@name,'%s')]";
	protected BaseActions mymethod = new BaseActions();
	protected SoftAssert softAssert = new SoftAssert();
	protected WebDriverWait wait;
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
		driver.findElement(By.className("bm-burger-button")).click();
		sleep_3();
		mymethod.ClickId(driver, "logout_sidebar_link");
		sleep_3();
	}
	public void log_in() {
		mymethod.GotoURL(driver, url);
		mymethod.InputdataXpath(driver, user,"standard_user");
		mymethod.InputdataXpath(driver,passbut , passwd);
		mymethod.ClickXpath(driver, login);
		sleep_3();
	}
	public void open_menu() {
		driver.findElement(By.className("bm-burger-button")).click();
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

	}

	@AfterTest
	public void driver_quit() {
		driver.close();
		softAssert.assertAll();
	

	}
}
