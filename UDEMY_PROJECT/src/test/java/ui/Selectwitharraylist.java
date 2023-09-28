package ui;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selectwitharraylist {
	
	 
	
	 public static void main(String args[]) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://handmerch.in/");
        int j = 0;
        String[] itemsNeeded = {"Fashion Girl Painting", "Bucklo Wrop Wooden Chair", "Bucklo Wrop Wooden Table" };
       
		List<WebElement> products = driver.findElements(By.cssSelector(".product-image.bg-6"));
		
		for(int i = 0; i < products.size(); i++) 
		{
			String[] name = products.get(i).getText().split(" ");
			String formatteditem = name[0].trim();
			Thread.sleep(5000L);
			List itemNeededList = Arrays.asList(itemsNeeded);
			if (itemNeededList.contains(formatteditem)) 
				j++;
			Thread.sleep(2000L);
				driver.findElements(By.cssSelector(".product-name")).get(i).click();
				if(j==3) {
					break;
			}
			driver.close();
		}
	}
}
