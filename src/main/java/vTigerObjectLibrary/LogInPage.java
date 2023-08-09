package vTigerObjectLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.Practice.WebDriverFileUtility;



public class LogInPage extends WebDriverFileUtility {
	@FindBy (name="user_name")
	private WebElement usernameEdt;
	
	@FindBy (name="user_password")
	private WebElement  passwordEdt;
	
	@FindBy (id="submitButton")
	private WebElement loginBtn;
	
	
	public LogInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Rule4:provide getter to access these web elements

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}


	public WebElement getPasswordEdt() {
		return passwordEdt;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//Business logics or library
	/**
	 * this method will perform log in operation
	 * @param USERNAME
	 * @param password
	 */
	public  void getloginpage(String USERNAME,String password)
	{
		usernameEdt.sendKeys(USERNAME);	
		 passwordEdt.sendKeys(password);
		 loginBtn.click();
	}
	
	
	
}
