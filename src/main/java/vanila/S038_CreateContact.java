package vanila;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class S038_CreateContact {
	
	public static void main(String[] args) throws InterruptedException {
		
		// Launch chrome
		WebDriverManager.chromedriver().setup(); // download chromedriver and set the path
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		
		//1. Login to https://login.salesforce.com
		driver.findElement(By.id("username")).sendKeys("nupela@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("India@123");
		driver.findElement(By.id("Login")).click();
		
		//2. Click on the toggle menu button from the left corner
		driver.findElement(By.className("slds-icon-waffle")).click();
		
		//3. Click View All and click 'Contract' from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		//4. Click on the Dropdown icon in the Contract tab
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contracts");
		driver.findElement(By.xpath("//mark[text()='Contracts']")).click();
		
		//5. Click on New Contract
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		//6. Select the accounts listed on the'Account Name' field
		driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']"))
						   .sendKeys("SanTest");
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']"))
		   .sendKeys(Keys.DOWN, Keys.ENTER);
		
		//7. Select the Contract Start Date as Tommorow's Date
		driver.findElement(By.xpath("(//span[text()='Contract Start Date'])[2]/following::input")).click();
		driver.findElement(By.xpath("//span[contains(@class,'todayDate')]/following::td[1]")).click();
		
		//8. Click save
		driver.findElement(By.xpath("//button[@title='Save']//span[1]")).click();
		
		//9. Verify the Alert message(These required fields must be completed: Contract Term (months))
		String errorText = driver.findElement(By.xpath("//ul[@class='errorsList']//li[1]")).getText();
		System.out.println(errorText);
		
		// Close the browser
		// driver.close();
		
	}

}
