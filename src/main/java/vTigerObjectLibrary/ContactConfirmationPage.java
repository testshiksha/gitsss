package vTigerObjectLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactConfirmationPage {
	@FindBy (xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	//declaration
	public ContactConfirmationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
 //getter
	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	//business logics
	public String GetTextOfContactHeader()
	{
	return ContactHeaderText.getText();
		
	}

}
