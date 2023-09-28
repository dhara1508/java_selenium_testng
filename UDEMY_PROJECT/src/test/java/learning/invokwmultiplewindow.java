package learning;

import java.awt.Window;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class invokwmultiplewindow {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");												
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/angularpractice/");
		 driver.manage().window().maximize();
		 driver.switchTo().newWindow(WindowType.TAB);
		Set<String> WindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = WindowHandles.iterator();
		String parentwindow  = iterator.next(); 
		String childWindowHandle  = iterator.next();
		driver.switchTo().window(childWindowHandle );
		driver.get("https://courses.rahulshettyacademy.com/");
		String name = driver.findElements(By.cssSelector("div[class='course-listing-title']")).get(0).getText();
		
		driver.switchTo().window(parentwindow);
		driver.findElement(By.xpath("(//input[@name=\"name\"])[1]")).sendKeys(name);
	}

}
