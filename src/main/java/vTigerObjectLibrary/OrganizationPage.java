package vTigerObjectLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	//declaration
	@FindBy (xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	
	
	//initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	

	//getter or utilization
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}



	//business logics
	/**
	 * this method will click on create organization look up image
	 */
	public void ClickOrgImage()
	{
		CreateOrgLookUpImg.click();	
	}

}
