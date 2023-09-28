package testnglearning;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test4hello {
	
	@Parameters({"URL" ,"Apikey/Username"})
	@Test
	public void webapphome(@Optional String urlname,@Optional String username) 
	{
		System.out.println("Webapphome");
		System.out.println(urlname);
		System.out.println(username);
	}
	
	@Test(groups={"Smoke"})
	public void mobileapphome() {
		System.out.println("mobileapphome");
	}
	
	@Test
	public void apihome() {
		System.out.println("apihome");
		
	}
}