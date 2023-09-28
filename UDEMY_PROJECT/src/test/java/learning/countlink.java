package learning;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.InterruptedException;
import java.time.Duration;

public class countlink {
public static void main(String[] args)   {
	System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
// 1. Give me the count of links on the page.
	
	System.out.println((driver.findElements(By.tagName("a")).size()));
	
// 2. Limited WebDriver scope	
	WebElement footerdriver = driver.findElement(By.id("gf-BIG"));    
	System.out.println((footerdriver.findElements(By.tagName("a")).size()));
	
// 3. column links 
	
	WebElement coloumndriver = footerdriver.findElement(By.xpath("table//tbody//tr//td[1]//ul"));
	System.out.println(coloumndriver.findElements(By.tagName("a")).size());
	
// 4. click on each link in the coloumn and check if the pages are opening
	
	for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++)
	{
		String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
		
	}
	Set<String> abc = driver.getWindowHandles();
	Iterator<String> it = abc.iterator();
	
	while(it.hasNext())
	{
		driver.switchTo().window(it.next());
		System.out.println(driver.getTitle());
	}
	
}
}
