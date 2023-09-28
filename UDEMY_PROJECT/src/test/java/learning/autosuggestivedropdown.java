					/* Autosuggestive dropdown (While putting input and show options dropdown)*/
package learning;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autosuggestivedropdown {
	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind"); // select from search value
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']  a"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India"));
			{
				option.click();
				break;
			}
		}
		driver.close();
	}
}
