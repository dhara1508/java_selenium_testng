package learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class actionsDemo {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("a[data-group=\"men\"]"));
		a.moveToElement(driver.findElement(By.xpath("//input[@class='desktop-searchBar']"))).click().keyDown(Keys.SHIFT).sendKeys("woman").doubleClick().build().perform();
		a.moveToElement(move).contextClick().build().perform();
		
		
		//driver.close();
	}
}
