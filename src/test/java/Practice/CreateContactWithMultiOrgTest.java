package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
import vtiger.Practice.PropertyFileUtility;
import vtiger.Practice.WebDriverFileUtility;

public class CreateContactWithMultiOrgTest extends BaseClass {
	
	
	    @Test(dataProvider = "getData")
	    public void createMultipleOrg(String ORG, String INDUSTRY)  throws Throwable {

	     

	      // Step 1: Read all the necessary data

	    //read all the necessary common data
			
	      /* Read Data from Excel sheet - Test data */
	      String ORGNAME = ORG + jutil.getRandomNumber();

	      // Step 2: Launch the browser - driver is acting based runtime data - RunTime
	      // polymorphism
	     
	      // Step 3: Load the URL
	     

	    //step4---adding credential 
			//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			//driver.findElement(By.id("submitButton")).click();
			
			
			
			
			
			
			//step5--click on organization link
			//driver.findElement(By.linkText("Organizations")).click();
			HomePage hp= new HomePage(driver);
			hp.clickOrgBtn();
			
			//step6---create organization by clicking image
			//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			OrganizationPage op= new OrganizationPage(driver);
			op.ClickOrgImage();
			
			
			
			//step7---add organization name
			//driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			
			//step8---save
			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			cop.craetingNewOganization(ORGNAME);
			
			//step9---validation
			//OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			 // OrgHeader =oip.getOrgHeaderText();
			//Assert.assertTrue(OrgHeader.contains(ORGNAME));
			  OrganizationInfoPage oip= new OrganizationInfoPage(driver);
				 String orgHeader = oip.getHeaderText();
				Assert.assertTrue(orgHeader.contains(ORGNAME));
	    }
	    @DataProvider
	    public Object[][] getData() throws Throwable, IOException {
	      return Eutil.readMultipleData("MultipleOrg");
	    }

	  }



