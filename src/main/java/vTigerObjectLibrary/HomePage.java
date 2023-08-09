package vTigerObjectLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.Practice.WebDriverFileUtility;



public class HomePage extends WebDriverFileUtility {
	
	//declaration
	@FindBy (linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy (linkText="Contacts")
	private WebElement ContactsLnk;
	
	
	@FindBy (linkText="Oppertuneties")
	private WebElement OppertunetiesLnk;
	
	
	@FindBy (linkText="Sign Out")
	private WebElement SignoutBtn;
	
	@FindBy (xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	

//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//getter method
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOppertunetiesLnk() {
		return OppertunetiesLnk;
	}

	public WebElement getSignoutBtn() {
		return SignoutBtn;
	}
	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}
	
	
//business library or logics
	public void clickOrgBtn()
	{
		organizationLnk.click();
	}
	public void clickcontactLnk()
	{
		ContactsLnk.click();
	}
	public void clickOnOppLnk() {
	
		OppertunetiesLnk.click();
	}
	
	public void ClicoOnAdministratot() {
		AdministratorImg.click();
	}
	
	
	/**
	 * this method will log out the application
	 * @param driver
	 * @throws Throwable
	 */
	
	public void LogOutOfApp(WebDriver driver) throws Throwable {
		moveToElementAction(driver, AdministratorImg);
		Thread.sleep(1000);
		SignoutBtn.click();
	}
	

}