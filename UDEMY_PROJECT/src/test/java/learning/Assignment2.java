package learning;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	public static void main(String args[])  {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@minlength=\"2\"]")).sendKeys("Dhara");
		driver.findElement(By.name("email")).sendKeys("dhara.itaims@gmaiul/.com");
		driver.findElement(By.cssSelector("input[placeholder=\"Password\"]")).sendKeys("dhara");
		System.out.println((driver.findElement(By.id("exampleCheck1")).isSelected()));
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.id("exampleFormControlSelect1"));
		driver.findElement(By.xpath("//select[@id=\"exampleFormControlSelect1\"]//option[text()=\"Female\"]")).click();
		System.out.println((driver.findElement(By.id("inlineRadio2")).isSelected()));
		driver.findElement(By.id("inlineRadio2")).click();
		System.out.println((driver.findElement(By.id("inlineRadio2")).isSelected()));
		driver.findElement(By.name("bday")).sendKeys("20-01-2022");
		driver.findElement(By.cssSelector("input[value=\"Submit\"]")).click();
		Assert.assertEquals(driver.findElement(By.tagName("strong")).getText(), "Success!");
		System.out.println((driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]"))).getText());
		driver.close();
		
	}
}
