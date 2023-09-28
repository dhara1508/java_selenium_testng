package learning;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.lang.InterruptedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fluentWait {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//button[text()='Start']")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()=\"Hello World!\"]")));
//		Thread.sleep(5000L);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.xpath("//h4[text()=\"Hello World!\"]")).isDisplayed()) 
				{
					return (driver.findElement(By.xpath("//h4[text()=\"Hello World!\"]")));
				}
				else
					return null;
			}});
		
	    System.out.println(driver.findElement(By.xpath("//h4[text()=\"Hello World!\"]")).getText());
	    driver.close();
	}
}
