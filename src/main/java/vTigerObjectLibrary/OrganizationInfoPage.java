package vTigerObjectLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	//declaration
	@FindBy (xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	//initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//getter
	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
	//business logics
	/**
	 * this method will capture the header text and return to the caller
	 * @return
	 */
	public String getHeaderText() {
		return orgHeaderText.getText();	
	}
	
	
	
	

}
