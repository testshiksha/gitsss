package vtiger.Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * this class consist of all the re usable methods
 * @author Shiksha
 *
 */
public class WebDriverFileUtility {
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximaizeTheScreen(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * this method will use for minimize the window
	 * @param driver
	 */
	public void minimizeTheMethod(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * this method will wait for all find elements and find elements
	 * @param driver
	 */
	public void implicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	/**
	 * this method will wait until the specified element is visible in DOM
	 * @param driver
	 * @param element
	 */
	public void explicitlyWait(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	 /**
	  * this method will handle drop down by using index
	  * @param element
	  * @param index
	  */
	public void handleDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * this method will handle drop down by using value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * this method will handle drop down by using visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * this method will perform mouse hover action on a target element
	 * @param driver
	 * @param element
	 */
	public void moveToElementAction(WebDriver driver, WebElement element)
	{
		Actions Act = new Actions(driver);
		Act.moveToElement(element).perform();
	}
	
	/**
	 * this method will double click anywhere on webpage
	 * @param driver
	 */

	public void doubleClickAction(WebDriver driver)
	{
		Actions Act = new Actions(driver);
		Act.doubleClick().perform();
	}
	/**
	 * this method will double click on a web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions Act = new Actions(driver);
		Act.doubleClick( element).perform();
	}
	
	
	/**
	 * this method will right click anywhere on a web page
	 * @param driver
	 */
	public void contextclickAction(WebDriver driver)
	{
		Actions Act = new Actions(driver);
		Act.contextClick().perform();
	}
	
	
	/**
	 * this method will right click on  particular web element
	 * @param driver
	 * @param element
	 */
	public void contextclickAction(WebDriver driver,WebElement element)
	{
		Actions Act = new Actions(driver);
		Act.contextClick(element).perform();
	}
	
	
	/**
	 * this method will perform drag and drop action
	 * @param driver
	 * @param Srcelement
	 * @param targetelement
	 */
	public void dragAndDropAction(WebDriver driver,WebElement Srcelement,WebElement targetelement)
	{
		Actions Act = new Actions(driver);
		Act.dragAndDrop(Srcelement, targetelement).perform();
	}
	
	
	public void moveAcrossWebPage(WebDriver driver,int xoffset,int yoffset)
	{
		Actions Act = new Actions(driver);
		Act.moveByOffset(xoffset, yoffset).click().perform();
	}
	/**
	 * this method will scroll  vertically for 500 pixels
	 * @param driver
	 */
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scroolBy(0,500);", "");
	}
	/**
	 * this method will scroll horizantally for 200 pixels
	 * @param driver
	 */
	public void scrollDownhori(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scroolBy(200,0)", "");
	}
	
	/**
	 * this metod will scroll vertically until the element reference
	 * @param driver
	 * @param element
	 */
	public void scrollDown(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scroolBy("+y+");", element);
		
		//js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
	/**
	 * this method will accept the confirmation pop up
	 * @param driver
	 */
	public void AcceptAlertPopUp(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method will dismiss or cancel confirmation pop up
	 * @param driver
	 */
	public void DismissAlertPopUp(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	 
	
	/**
	 * this method will enter the text in prompt pop up
	 * @param driver
	 * @param text
	 */
		public void sendTextToAlert(WebDriver driver, String text) {
			driver.switchTo().alert().sendKeys(text);
		}

		
		/**
		 * this method will capture alert message and give to caller
		 * @param driver
		 * @return
		 */
		public String getTextToAlert(WebDriver driver) {
			return driver.switchTo().alert().getText();
		}

		
		/**
		 * this method will handle frame based on frame index
		 * @param driver
		 * @param index
		 */
		public void handleFrame(WebDriver driver, int index) {
			driver.switchTo().frame(index);
		}
		
		
		/**
		 * this method will handle frame based on value of name or id
		 * @param driver
		 * @param NameOrId
		 */
		public void handleFrame(WebDriver driver, String NameOrId ) {
			driver.switchTo().frame(NameOrId);
		}
		
		 
		
		/**
		 * this method will handle frame based on web element
		 * @param driver
		 * @param element
		 */
			public void handleFrame(WebDriver driver, WebElement element) {
				driver.switchTo().frame(element);
			}
		
			
			
			
			/**
			 * this method will help to switch the control back to the immediate parent
			 * @param driver
			 */
			public void switchToParentFrame(WebDriver driver) {
				driver.switchTo().parentFrame();
			}

			
			
			 /**
			  * this method will help to switch the control back to the current page
			  * @param driver
			  */
				public void switchToDefaultPage(WebDriver driver ) {
					driver.switchTo().defaultContent();
				}
				public void switchtowindow(WebDriver driver, String partialWinTitle) {
					//step1: capture all the windows ids
					Set<String> AllIds = driver.getWindowHandles();
					
					//step2: iterate through individual ids
					for(String winndowids:AllIds)
					{
						//step3:switch to each id and capture the title
						String currentTitle = driver.switchTo().window(winndowids).getTitle();
						
						//step4:compare the title with required reference
						if(currentTitle.contains(partialWinTitle))
						{
							break;
						}
					}
					
				}
				
				public String takescreenshot(WebDriver driver, String screenshotName) throws Throwable
				{
				 TakesScreenshot ts = (TakesScreenshot)driver;
				 File src = ts.getScreenshotAs(OutputType.FILE);
				File dst = new File(".\\ScreenShot\\"+screenshotName+"+.png");
				 Files.copy(src, dst);
				 return dst.getAbsolutePath();
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
}
