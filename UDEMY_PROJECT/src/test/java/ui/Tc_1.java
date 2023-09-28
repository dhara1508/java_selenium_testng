package ui;
						//* Select particular item form the list *//
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tc_1 {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://handmerch.in/");
		List<WebElement> products = driver.findElements(By.className("product-card"));

		for (int i = 0; i < products.size(); i++) {
			Thread.sleep(5000L);
			String name = products.get(i).getText();

			if (name.contains("Bucklo Wrop Wooden Chair"))
			{
				driver.findElements(By.xpath("//div[@class=\"product-name\"]")).get(i).click();
			}
			driver.close();
		}

	}
}
