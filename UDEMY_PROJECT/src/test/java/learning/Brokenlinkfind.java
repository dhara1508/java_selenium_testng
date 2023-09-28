package learning;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Brokenlinkfind {

	public static void main(String[] args) throws MalformedURLException, IOException  {
		System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert a = new SoftAssert();
		List<WebElement> links = driver.findElements(By.cssSelector("li[class=\"gf-li\"] a"));
		for(WebElement link : links) {
			
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			
			int respcode = conn.getResponseCode(); 
			System.out.println(respcode);
			a.assertTrue(respcode > 400, "The link is "+ link.getText()+ " is broken with code " + respcode);
			
//				if(respcode > 400) {
//				System.out.println("The link is "+ link.getText()+ " is broken with code " + respcode );
//				Assert.assertTrue(false);
			}
		a.assertAll();
		}	
}


