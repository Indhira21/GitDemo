package Sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager"); 
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click(); 
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();//Leads tab menu
		driver.findElement(By.linkText("Create Lead")).click();//Create Lead option
		//companyName
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("EXPLEO");;
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Indhira");
		driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys("Durai");
		
		driver.findElement(By.xpath("(//input[@name='submitButton'])")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.quit();
		
	}

}
