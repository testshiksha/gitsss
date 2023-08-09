package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Homework {

	public static void main(String[] args) throws Throwable {
		//step1--launch the browser
		//WebDriverManager.ChromeDriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step2--load the url
		driver.get("http://localhost:8888/index.php");
				
			//step3---adding credential 
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
				driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				
				//step4--click on the organization link
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				
				//step5--click on create organization look up image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				WebElement data = driver.findElement(By.xpath("//select[@name='salutationtype']"));
				data.click();
				Thread.sleep(1000);
				Select sel = new Select(data);
				sel.selectByVisibleText("Mrs.");
				driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("shiksha");
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("chhokar");
				WebElement data1 = driver.findElement(By.xpath("//select[@name='leadsource']"));
				data1.click();
				Thread.sleep(1000);
				Select sel1 = new Select(data1);
				sel1.selectByValue("Existing Customer");
				//driver.findElement(By.xpath("(//input)[48]")).click();there are two
																		//ways of doing this
				
				driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();//here i use * instead of html tag
				
				driver.findElement(By.xpath("//img[@style='width:16px;height:16px;']")).click();
				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//driver.close();

	}

}
