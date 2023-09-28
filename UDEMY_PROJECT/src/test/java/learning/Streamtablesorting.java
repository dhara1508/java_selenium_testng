package learning;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Streamtablesorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr//th[1]")).click();
		//Capture all webelements into list
		List<WebElement> elementlist= driver.findElements(By.xpath("//tr//td[1]"));
		
		//capture text of all webelements into new (original) list
		List<String> orignallist = elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the original list of step - 3 - >Sorted list  
		List<String> sortedlist = orignallist.stream().sorted().collect(Collectors.toList());
		
		//Campare original list vs sorted list 
		Assert.assertTrue(orignallist.equals(sortedlist));		
		
		
		//scan the name coloumn with gettext -> Beans -> print the price of Beans
		List<String> price = elementlist.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggi(s))
		.collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		
		
		//scan the name coloumn with gettext -> rice -> print the price of rice on pagination 
		List<String> price1;
		do {
		 List<WebElement> rows = driver.findElements(By.xpath("//tr//td[1]"));
		 price1 = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggi(s))
				.collect(Collectors.toList());
				price1.forEach(a->System.out.println(a));
				
		if(price1.size()<1) 
		{
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		}
		while(price1.size()<1); 
	
	}
	private static String getPriceVeggi(WebElement s) {
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
