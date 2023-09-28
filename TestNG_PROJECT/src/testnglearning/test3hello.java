package testnglearning;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test3hello {

	@Test
	public void applogin() {
		System.out.println("webapplogin");
		Assert.assertTrue(false);
	}
	
	@Parameters({"URL"})
	@Test
	public void applogin1(@Optional String urlname ) {
		System.out.println("mobileapplogin");
		System.out.println(urlname);
	}
	
	@Test(dataProvider = "getData")
	public void applogin3(String username , String password) 
	{
		System.out.println(username);
		System.out.println(password);
	}
	
	@Test
	public void applogin2()
	{
		System.out.println("apilogin");
	}
	
	
	@DataProvider
	public Object[][] getData() 
	{
		//1st combination - username password- good credit history = row
		//2nd - username password - no credit history
		//3rd - fraudelent credit history
		
		Object[][] data = new Object[3][2];
		
		//1st set
		data[0][0] = "Firstusername";
		data[0][1] = "FirstPassword";
		//columns in the roe are nothing but values for that particular combination(row)
		
		//2nd set
		data[1][0] = "Secondusername";
		data[1][1] = "Secondpassword";
		
		//3rd set
		data[2][0] = "Thirdusername";
		data[2][1] = "Thirdpassword";	
				
		return data;
		}
}
	
	
	




