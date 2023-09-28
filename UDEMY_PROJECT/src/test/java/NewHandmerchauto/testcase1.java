package NewHandmerchauto;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testcase1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://handmerch.com/Login");
		
		driver.findElement(By.id("inputEmail4")).sendKeys("dhara.itaims@gmail.com");
		driver.findElement(By.id("pwd")).sendKeys("Dhara@1234");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		
		List<WebElement> products= driver.findElements(By.cssSelector(".swiper-slide"));

	}

}
