package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateForDDT {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=null;
		
		Random r = new Random();
		int random = r.nextInt(1000);
		
		
		//read all the necessary common data
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\data.properties");
		Properties pro = new Properties();
		pro.load(fisp);
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		//read test data from excel file
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\testdata1.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("organization");
		Row rw = sh.getRow(4);
		String orgname = rw.getCell(2).getStringCellValue()+random;
		System.out.println(orgname);
		String INDUSTRY = rw.getCell(3).getStringCellValue();
		System.out.println(INDUSTRY);
		
		//step2: launch the browser,here driver is acting based runtime data---runtime polymorphism
		if(BROWSER.equalsIgnoreCase("CHROME"))
		{
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
			System.out.println("browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver= new FirefoxDriver();
			System.out.println("browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("EDGE"))
		{
			WebDriverManager.edgedriver().setup();
			 driver= new EdgeDriver();
			System.out.println("browser launched");
		}
		else
		{
			System.out.println("invalid");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//step3--load the url
		driver.get(URL);
				
		//step4---adding credential 
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		
		//step5--click on organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		
		//step6---create organization by clicking image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step6---add organization name
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		Thread.sleep(2000);
		//step7---click industry dropdown 
		WebElement data = driver.findElement(By.xpath("//select[@name='industry']"));
		//data.click();
		Select sel = new Select(data);
		sel.selectByValue(INDUSTRY);
		
		//step8---save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step9---validation
		 String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(orgname))
		{
			System.out.println("pass");
			System.out.println(orgHeader);
		}
		else
		{
			System.out.println("fail");
		}
		//step10---logout of application
		WebElement UserImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(UserImg).perform();
		 driver.findElement(By.linkText("Sign Out")).click();
		 System.out.println("logout successfully");
		
		 driver.close();
		//and now end
		//and it is done now
	}

}
