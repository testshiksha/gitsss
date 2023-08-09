package vTigerObjectLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	//declaration
	@FindBy (xpath="//img[@alt='Create Contact...']")
	private WebElement CreateContactLookUpImg;
	
	//initialization
	public ContactPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//getter

	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}
	//business library
	public void ClickContactLookUpImg() {
		CreateContactLookUpImg.click();	
	}

}
