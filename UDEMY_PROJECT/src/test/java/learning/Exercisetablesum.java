package learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Exercisetablesum {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		List<WebElement> courses = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		int sum = 0;
		for(int i=0;i<courses.size();i++)
		{
			sum = sum + Integer.parseInt(courses.get(i).getText());
		}
		System.out.println(sum);
		int expectedtotal = 235;
		if(sum == expectedtotal)
		{
			System.out.println("Total match with Expected");
		}
		else {
			System.out.println("Total match not with Expected");
		}
		//Assert.assertEquals(sum, 235);
	}

}
