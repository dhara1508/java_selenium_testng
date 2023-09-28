package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class wishlist {
public static void main (String args[])  {
	System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://handmerch.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//button[text()=\" Login \"]")).click();
	driver.findElement(By.xpath("//input[@id=\"inputEmail4\"]")).sendKeys("dhara.itaims@gmail.com");
	driver.findElement(By.xpath("//input[@id=\"pwd\"]")).sendKeys("Dhara@1234");
	driver.findElement(By.xpath("//button[text()=\"Sign In\"]")).click();
	driver.findElement(By.xpath("(//button[text()='View All'])[1]")).click();
//	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//	jsExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	WebElement product = driver.findElement(By.xpath("//div[@role=\"group\"]//following::img[@alt=\"Black Polyresin Handcrafted Adiyogi Lord Shiva Statue\"]"));
	System.out.println(product.getText());
	product.click();
	driver.findElement(By.xpath("(//i[@class='bi bi-heart'])[2]")).click();
}
}
