package vtiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerObjectLibrary.HomePage;
import vTigerObjectLibrary.LogInPage;

/**
 * this class consists of all the basic configuration annotation for all the common action
 * @author shiksha
 *
 */
public class BaseClass {
	public ExcelFileUtility Eutil = new ExcelFileUtility();
	public  JavaUtility jutil = new JavaUtility();
	  public PropertyFileUtility pUtil = new PropertyFileUtility();
	   public WebDriverFileUtility wUtil = new WebDriverFileUtility();
	   public WebDriver driver = null;
	   //used only for listener to take screenshot 
	  // public static WebDriver sdriver;
	@BeforeSuite (alwaysRun = true)
	
	public void BeforeSuiteConfiguration() 
	{
		System.out.println("----db connection successful---");
		
	}
	
	/*@Parameters("browser")*/
	@BeforeClass (alwaysRun = true)
	public void BeforeClassConfig(/*String BROWSER*/) throws Throwable {
		
		//read browser name and url from property file
		String BROWSER = pUtil.getPropertValues("browser");
		String URL = pUtil.getPropertValues("url");
		 if (BROWSER.equalsIgnoreCase("chrome")) {
		        WebDriverManager.chromedriver().setup();
		        driver = new ChromeDriver();
		        System.out.println(BROWSER + " --- Browser launched----");

		      } else if (BROWSER.equalsIgnoreCase("edge")) {
		        WebDriverManager.edgedriver().setup();
		        driver = new EdgeDriver();
		        System.out.println(BROWSER + " --- Browser launched-----");
		      } else {
		        System.out.println("invalid Browser name");
		      }

		      wUtil.maximaizeTheScreen(driver);
		      wUtil.implicitlyWait(driver);
		      
		    //used only for listener to take screenshot 
		     // sdriver=driver;
		      
		      // Step 3: Load the URL
		      driver.get(URL);
		
	}
	@BeforeMethod (alwaysRun = true)
	public void BeforeMethodConfiguration() throws Throwable
	{
		String USERNAME = pUtil.getPropertValues("username");
		String PASSWORD = pUtil.getPropertValues("password");
		LogInPage lp= new LogInPage(driver);
		lp.getloginpage(USERNAME, PASSWORD);
		
		System.out.println("log in successfully");
	}
	@AfterMethod (alwaysRun = true)
	public void AfterMethodCongiguration() throws Throwable 
	{
		HomePage hp= new HomePage(driver);
		 hp.LogOutOfApp(driver);
		System.out.println("log out successfully");	
	}
	
	@AfterClass (alwaysRun = true)
	public void AfterClassConfiguration()
	{
		driver.close();
		System.out.println("browser closed");
	}
	@AfterSuite (alwaysRun = true)
	public void AfterSuiteConfiguration() {
		System.out.println("----db connection closed---");
		
	}
	
	
}
