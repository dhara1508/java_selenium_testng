package learning;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;


public class Partialscreenshot {
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");												
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/angularpractice/");
		 driver.manage().window().maximize();
		 
		 //switching new tab
		 driver.switchTo().newWindow(WindowType.TAB);
		 
		Set<String> WindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = WindowHandles.iterator();
		String parentwindow  = iterator.next(); 
		String childWindowHandle  = iterator.next();
		
		driver.switchTo().window(childWindowHandle );
		
		driver.get("https://courses.rahulshettyacademy.com/");
		String course = driver.findElements(By.cssSelector("div[class='course-listing-title']")).get(0).getText();
		
		driver.switchTo().window(parentwindow);
		WebElement name = driver.findElement(By.xpath("(//input[@name=\"name\"])[1]"));
		name.sendKeys(course);
		
		//screenshot 
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("logo.png"));
		
		//Get Hight and width
		System.out.println(name.getRect().getDimension().height);
		System.out.println(name.getRect().getDimension().width);
	}

}
