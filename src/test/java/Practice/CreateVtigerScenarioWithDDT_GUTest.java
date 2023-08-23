package Practice;

import java.io.FileInputStream;
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
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerObjectLibrary.CreateOrganizationPage;
import vTigerObjectLibrary.HomePage;
import vTigerObjectLibrary.LogInPage;
import vTigerObjectLibrary.OrganizationInfoPage;
import vTigerObjectLibrary.OrganizationPage;
import vtiger.Practice.BaseClass;
import vtiger.Practice.ExcelFileUtility;
import vtiger.Practice.JavaUtility;
import vtiger.Practice.JavaUtilityDriver;
import vtiger.Practice.PropertyFileUtility;
import vtiger.Practice.WebDriverFileUtility;

public class CreateVtigerScenarioWithDDT_GUTest extends BaseClass {
@Test (groups = "Regresssion")
	
		public  void cteateVtigerScenarioTest() throws Throwable
		{
			
			//read test data from excel file
			  String orgname = Eutil.getExcelValue("organization", 4, 2)+jutil.getRandomNumber();
			 String industry = Eutil.getExcelValue("organization", 4, 3);
			
			System.out.println(industry);
			
			
			//step5--click on organization link
			//driver.findElement(By.linkText("Organizations")).click();
			HomePage hp= new HomePage(driver);
			hp.clickOrgBtn();
			
			//step6---create organization by clicking image
			//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			OrganizationPage op= new OrganizationPage(driver);
			op.ClickOrgImage();
			
			
			//step6---add organization name
			
			//step7---click industry dropdown 
			
			
			//step8---save
			CreateOrganizationPage cop= new CreateOrganizationPage(driver);
			cop.craetingNewOganization(orgname, industry);
			
			//step9---validation
			OrganizationInfoPage oip= new OrganizationInfoPage(driver);
			 String orgHeader = oip.getHeaderText();
			 Assert.assertTrue(orgHeader.contains(orgname));
			System.out.println(orgHeader);
			
			//step10---logout of application
			//it is finished
		}

	}
