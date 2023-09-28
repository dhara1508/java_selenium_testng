package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Assert.assertFalse(false);System.out.println(driver.findElement(By.cssSelector("input[value=\"option1\"]")).isSelected());
		driver.findElement(By.cssSelector("input[value=\"option1\"]")).click();
		Assert.assertTrue(true);System.out.println(driver.findElement(By.cssSelector("input[value=\"option1\"]")).isSelected());
		driver.findElement(By.cssSelector("input[value=\"option1\"]")).click();
		Assert.assertFalse(false);System.out.println(driver.findElement(By.cssSelector("input[value=\"option1\"]")).isSelected());
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		driver.close();
	}
}



