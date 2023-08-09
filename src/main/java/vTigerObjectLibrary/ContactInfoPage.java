package vTigerObjectLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.Practice.WebDriverFileUtility;



public class ContactInfoPage extends WebDriverFileUtility {
	@FindBy (name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy (xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrgNameImg;
	
	@FindBy (name="search_text")
	private WebElement OrgSearchLookUpImg;
	
	@FindBy (name="search")
	private WebElement OrgSearchBtn;
	 
	@FindBy (xpath="//input[@class='crmButton small save']")
	private WebElement SaveBtn;
	
	//INITIALIZATION
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//getter
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getOrgNameImg() {
		return OrgNameImg;
	}

	public WebElement getOrgSearchLoolUpImg() {
		return OrgSearchLookUpImg;
	}

	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	//business logics or library
	/**
	 * this method will create contacts with mandatory information
	 * @param LASTNAME
	 */
	public void CreatingContact(String LASTNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	/**
	 * this metod will create contacts with relevant organization
	 * @param driver
	 * @param LASTNAME
	 * @param orgname
	 */
	public void CreatingContact(WebDriver driver, String LASTNAME,String orgname) 
	{
		LastNameEdt.sendKeys(LASTNAME);
		OrgNameImg.click();
		switchtowindow(driver, "Accounts");
		OrgSearchLookUpImg.sendKeys(orgname);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+orgname+"']")).click();
		switchtowindow(driver, "Contacts");
		SaveBtn.click();
		
		
		
	}
	
	
	
}
