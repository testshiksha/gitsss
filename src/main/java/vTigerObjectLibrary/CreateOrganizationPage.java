package vTigerObjectLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.Practice.WebDriverFileUtility;



public class CreateOrganizationPage  extends WebDriverFileUtility{
	//declaration
	@FindBy (name="accountname")
	private WebElement OrganizationNameEdt;
	
	
	@FindBy (name="industry")
	private WebElement slectByDropDown;
	
	@FindBy (xpath ="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//initialization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//getter
	public WebElement getOrganizationNameEdt() {
		return OrganizationNameEdt;
	}

	public WebElement getSlectByDropDown() {
		return slectByDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//business logics
	public void craetingNewOganization(String orgname ) throws Throwable {
		
		OrganizationNameEdt.sendKeys(orgname);
		Thread.sleep(2000);
		SaveBtn.click();
	}
	
	public void craetingNewOganization(String orgname , String industry) throws Throwable {
	
		OrganizationNameEdt.sendKeys(orgname);
		Thread.sleep(2000);
		handleDropDown(slectByDropDown, industry);
		SaveBtn.click();
		
		
		
	}
	

}
