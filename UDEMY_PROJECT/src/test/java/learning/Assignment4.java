package learning;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", "C://browserdrivers//ChromeDriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://the-internet.herokuapp.com/");
	driver.findElement(By.xpath("//a[text()=\"Multiple Windows\"]")).click();
	driver.findElement(By.xpath("//a[text()=\"Click Here\"]")).click();
	Set<String> window = driver.getWindowHandles();
	Iterator<String> it =window.iterator();
	String parantid =it.next();
	String childid = it.next();
	driver.switchTo().window(childid);
	System.out.println(driver.findElement(By.tagName("h3")).getText());
	driver.switchTo().window(parantid);
	System.out.println(driver.findElement(By.tagName("h3")).getText());
	}
}
