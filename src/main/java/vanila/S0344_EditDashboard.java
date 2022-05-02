package vanila;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class S0344_EditDashboard {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup(); // download chromedriver and set the path
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");

		// 1. Login to https://login.salesforce.com
		driver.findElement(By.id("username")).sendKeys("nupela@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("India@123");
		driver.findElement(By.id("Login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// 2. Click on the toggle menu button from the left corner
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"))));

		wait.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']")));
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();


		// 3. Click View All and click Dashboards from App Launcher
		// 4. Click on the Dashboards tab
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='View All']"))));
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Dashboard");
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark")).click();

		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("Indhira");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//table[contains(@class,'slds-table')]//tbody//button")).click();
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//lightning-menu-item[@class='slds-dropdown__item']//span[text()='Edit']")))).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")).click();
		
		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("Salesforce");
		
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		
		driver.findElement(By.xpath("//footer//button[text()='Save']")).click();
		
	}
}
