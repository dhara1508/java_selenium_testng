package testnglearning;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test1hello {

	@AfterTest
	public void test1() {
		System.out.println("I will execute last");
		
	}
	
	@Test
	public void test2() {
		System.out.println("hello world");
		
		
	}
	
	@BeforeMethod
	public void beforemethod() {
		System.out.println("I execute before method");
		
	}
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("I execute before class");
	}
	
	@Test
	public void test4() {
		System.out.println("hello world check");
		
	}
	
	@BeforeSuite
	public void beforesuite() {
		System.out.println("I execute before suite");
	}
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("I execute after method");
	}
	
	@BeforeTest
	public void test3() {
		System.out.println("I WILL EXECUTE FIRST");
	}
	
	@AfterSuite
	public void aftersuite() {
		System.out.println("I execute after suite");
	}
	
	@Test(groups={"Smoke"})
	public void groupstest() {
		System.out.println("I WILL EXECUTE IN GROUP");
	}
	
	@AfterClass
	public void afterclass() {
		System.out.println("I execute after class");
	}
	
}



