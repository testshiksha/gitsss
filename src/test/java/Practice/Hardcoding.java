package Practice;

import java.awt.event.ActionEvent;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hardcoding {

	public static void main(String[] args) throws Throwable  {
		
		
		
		Random r = new Random();
		int random = r.nextInt(1000);
		
				//step1--launch the browser
				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				//step2--load the url
				driver.get("http://localhost:8888/index.php");
						
				//step3---adding credential 
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();

				
				//step4--click on organization link
				driver.findElement(By.linkText("Organizations")).click();
				
				
				//step5---create organization by clicking image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//step6---add organization name
				 String orgname = "g&c"+random;
				driver.findElement(By.name("accountname")).sendKeys(orgname);
				
				//step7---click industry dropdown 
				WebElement data = driver.findElement(By.name("industry"));
				//data.click();
				Select sel = new Select(data);
				sel.selectByValue("Chemicals");
				
				//step8---save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//step9---validation
				 String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(orgHeader.contains(orgname))
				{
					System.out.println("pass");
					System.out.println(orgHeader);
				}
				else
				{
					System.out.println("fail");
				}
				//step10---logout of application
				WebElement UserImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(UserImg).perform();
				 driver.findElement(By.linkText("Sign Out")).click();
				 System.out.println("logout successfully");
				
	}

}
