package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {
String name = "labeltext";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//fieldset//label[2]//input[@type=\"checkbox\"]")).click();
        String label = driver.findElement(By.xpath("//div[@id='checkbox-example']//fieldset//label[2]")).getText();
		//String labeltext = label.getText();
		System.out.println(label);
		
		WebElement Staticdropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(Staticdropdown);
		dropdown.selectByVisibleText(label);
		System.out.println(label);
		
		driver.findElement(By.id("name")).sendKeys(label);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		String text = driver.switchTo().alert().getText();
		if(text.contains("label"))
		{
			System.out.println("Successful alert message");
		}
		else {
			System.out.println("Unsuccessful alert message");
		}
		driver.close();
	}

}	
