package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerObjectLibrary.ContactConfirmationPage;
import vTigerObjectLibrary.ContactInfoPage;
import vTigerObjectLibrary.ContactPage;
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
@Listeners (vtiger.Practice.ListnerImplimentationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass {

	@Test (groups = "smoke")
	//creating organization
	public void CreateContactWithOrgTest()throws Throwable
	{
		
		
		
		
		//read test data from excel file
		  String orgname = Eutil.getExcelValue("contacts", 4, 3)+jutil.getRandomNumber();
		 String LASTNAME = Eutil.getExcelValue("contacts", 4, 2);
		
		System.out.println(LASTNAME);
		
		
				
		//step4---adding credential 
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		
	
		
		
		
		
		//step5--click on organization link
		//driver.findElement(By.linkText("Organizations")).click();
		HomePage hp= new HomePage(driver);
		hp.clickOrgBtn();
		Reporter.log("click org button");
		
		//step6---create organization by clicking image
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		OrganizationPage op= new OrganizationPage(driver);
		op.ClickOrgImage();
		Reporter.log("click on org image");
		
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		
		cop.craetingNewOganization(orgname);
		
		Reporter.log("creating new organization");
		
		//step9---validation
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		 String orgHeader = oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(orgname));
		
		//CREATE CONTACT USING ORGANIZATION
		//-------------------------------
		
		//step10: click on contact
		//driver.findElement(By.linkText("Contacts")).click();
		hp.clickcontactLnk();
		
		//navigate to create  contact look up image
		//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		ContactPage  cp=new ContactPage (driver);
		cp.ClickContactLookUpImg();
		
		
		//step11: create a contact with mandatory information
		//driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		ContactInfoPage cip= new ContactInfoPage(driver);
		cip.CreatingContact(driver, LASTNAME, orgname);
		
		//driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		//driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select")).click();
		
		//step12:switch to child window
		//Wutil.switchtowindow(driver, "Accounts");
		
		//step13: search for organization
		//driver.findElement(By.name("search_text")).sendKeys(orgname);
		
		
		//step14: click on search now button
		//driver.findElement(By.name("search")).click();
		
		//driver.findElement(By.xpath("//a[.='"+orgname+"']")).click();//dynamic xpath or runtime data
		
		//step15:switch the control back to parent parent window
		//Wutil.switchtowindow(driver, "Contacts");
		
		//step16:save the data
		//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		
		//step17: validate the data
		ContactConfirmationPage ccip = new ContactConfirmationPage(driver);
		
		 String contactHeader =ccip.GetTextOfContactHeader();
		 Assert.assertTrue(contactHeader.contains(LASTNAME));
			
			//step 18:log out
			//WebElement UserImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			//Wutil.moveToElementAction(driver, UserImg);
			
			 //driver.findElement(By.linkText("Sign Out")).click();
			
	}
	@Test
	public void creat()
	{
	
		System.out.println("yesss");
	}

}
