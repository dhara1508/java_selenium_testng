package learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Calendar {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(293, 1359)");
	       
		 driver.findElement(By.xpath("//input[@id=\'form-field-travel_comp_date\']")).click();
		 
		 while(!driver.findElement(By.cssSelector("[class='flatpickr-month'] [class='flatpickr-current-month']")).getText().contains("December"))
		 {
			 driver.findElement(By.cssSelector("[class='flatpickr-month'] [class='flatpickr-next-month']")).click();
		 }
		 
		 List<WebElement> dates = driver.findElements(By.cssSelector(".flatpickr-day "));
		 int count = driver.findElements(By.cssSelector(".flatpickr-day ")).size();
		 for(int i=0;i<count;i++)
		 {
			 String text = driver.findElements(By.cssSelector(".flatpickr-day ")).get(i).getText();
			 if(text.equalsIgnoreCase("24")) 
			 {
				 driver.findElements(By.cssSelector(".flatpickr-day ")).get(i).click();
				 break;
			 } 
		 }
		 //driver.close();
	}
	
}
