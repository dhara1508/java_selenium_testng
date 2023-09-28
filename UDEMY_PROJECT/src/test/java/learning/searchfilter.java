package learning;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class searchfilter {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggies= driver.findElements(By.xpath("//tr//td[1]"));
		veggies.forEach(a->System.out.println(a.getText()));
		
		List<WebElement> veggielist= veggies.stream().filter(veggie->veggie.getText().contains("Rice"))
		.collect(Collectors.toList());
		veggielist.forEach(s->System.out.println(s.getText()));
		
		Assert.assertEquals(veggies.size(), veggielist.size());
		
		
	}

}
