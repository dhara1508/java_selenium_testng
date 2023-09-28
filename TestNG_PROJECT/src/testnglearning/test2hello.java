package testnglearning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test2hello {

	@Test(enabled=false)
	public void test4() {
		System.out.println("hello 1");
		
	}
	
	@Test (dependsOnMethods={"test5"})
	public void depends() {
		System.out.println("hello depends on test 6");
	}
	
	@Test(groups= {"Smoke"})
	public void test5() {
		System.out.println("hello world 1");
	}
	
	@Test(timeOut=4000)
	public void test6() {
		System.out.println("hello world again");
	}
	
}