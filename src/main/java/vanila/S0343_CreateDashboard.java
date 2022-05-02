package vanila;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0343_CreateDashboard {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://login.salesforce.com");
		//1. Login to https://login.salesforce.com
		
		driver.findElement(By.id("username")).sendKeys("nupela@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("India@123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.className("slds-icon-waffle")).click();
		//2. Click on the toggle menu button from the left corner 
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//3. Click View All and click Dashboards from App Launcher
		
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']"))
			.sendKeys("dashboard");
		driver.findElement(By.xpath("//mark[text()='Dashboard']")).click();
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
		//4. Click on the New Dashboard option
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		driver.findElement(By.xpath("//h2[text()='New Dashboard']/following::label[text()='Name']/following::input")).sendKeys("Salesforce Automation by Amudha");
		driver.findElement(By.xpath("//h2[text()='New Dashboard']/following::label[text()='Name']/following::button[@id='submitBtn']")).click();
		//5. Enter Name as 'Salesforce Automation by Your Name ' and Click on Create.
		
		
		driver.switchTo().defaultContent();

		Thread.sleep(4000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		String dtitle = driver.findElement(By.xpath("//label[text()='Edit Dashboard name']/following::span")).getText();
		System.out.println(dtitle);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		//6.Click on Save and Verify Dashboard name."
		driver.close();

		
	}
}
