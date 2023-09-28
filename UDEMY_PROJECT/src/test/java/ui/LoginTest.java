package ui;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class LoginTest {

	public static String browser = "Chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		if (browser.equals("Chrome"))
		{
			 driver = new ChromeDriver();
		}
		else if (browser.equals("Firefox"))
		{
			 driver = new FirefoxDriver();
		}
		else if (browser.equals("Edge"))
		{
			 driver = new EdgeDriver();
		}
		
		
		driver.get("https://handmerch.in/");
		driver.manage().window().maximize();
		
//TC_1 : Verify the title of application 	
		
		System.out.println(driver.getTitle());

//TC_2 : Verify the URL of application 	
		
		System.out.println(driver.getCurrentUrl());
		
//TC_3 : Verify the Login into the application 
		
		driver.findElement(By.xpath("//button[text()=\" Login \"]")).click();
		driver.findElement(By.xpath("//input[@id=\"inputEmail4\"]")).sendKeys("dhara.itaims@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"pwd\"]")).sendKeys("Dhara@1234");
		driver.findElement(By.xpath("//button[text()=\"Sign In\"]")).click();
		//Thread.sleep(2000);
		//System.out.println(driver.findElement(By.tagName("p")).getText());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		//Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,\"v-toast__item v-toast__item--success v-toast__item--bottom-right\")]")).getText(), "User successfully logged in.");
		driver.findElement(By.xpath("//i[@class=\"bi bi-person\"]")).click();
		driver.findElement(By.xpath("//p[text()=\"Logout\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"Logout\"]")).click();
		
//TC_4 : Verify that add product into cart
		
		//driver.findElement(By.xpath("//div[text()='Bucklo Wrop Wooden Chair']")).click();
		
		
		
		driver.close();          // Use for close current window 
		//driver.quit();		 // Use for close all open window
		
		//System.out.println("//p[text()=\"User successfully logged in.\"]");
//		driver.findElement(By.xpath("//i[@class=\"bi bi-person\"]")).click();	
//		driver.findElement(By.xpath("//p[text()=\"Logout\"]")).click();
	
		
	}
	
 
}