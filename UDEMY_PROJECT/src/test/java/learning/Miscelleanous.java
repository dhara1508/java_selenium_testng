package learning;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscelleanous {
	public static void main(String args[]) throws IOException {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://handmerch.in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		int a =5;
		getscreenshot(driver);
		}
	public static void getscreenshot(WebDriver driver) throws IOException 
	{
		driver.get("https://www.goole.com/");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Dhara\\Pictures\\Screenshots"));
	}
}
