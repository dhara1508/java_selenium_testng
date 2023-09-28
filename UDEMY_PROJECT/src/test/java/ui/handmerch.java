package ui;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class handmerch {
	public static void main(String args[]){
	
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
//        FirefoxOptions options = new FirefoxOptions();
//        WebDriver driver = new FirefoxDriver(options);
        //WebDriverManager.edgedriver().setup();
        //ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
		driver.get("https://handmerch.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//input[@type=\"text\"])[1]")).sendKeys("Bucklo Wrop Wooden Chair");
		driver.findElement(By.xpath("(//i[@class=\"bi bi-search search-icon\"])[1]")).click();
		
//Click on forgot password link 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//button[text()=\" Login \"]")).click();
		driver.findElement(By.linkText("Forgot Password?")).click();
		driver.findElement(By.id("inputEmail4")).sendKeys("dhara.itaims@gmail.com");
		driver.findElement(By.xpath("//span[text()=' Reset Password ']")).click();
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		
		driver.close();
}

}