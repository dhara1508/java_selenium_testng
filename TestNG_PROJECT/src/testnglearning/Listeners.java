package testnglearning;

import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListeners interface which implements TestNg Listeners
public class Listeners implements ITestListener{
	 @Override
	    public void onTestStart(ITestResult result) {
	        // This method is called when a test method starts.
	        // You can perform actions here.
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        // This method is called when a test method succeeds.
	        // You can perform actions here.
	    	System.out.println("I successfully executed listeners pass code");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        // This method is called when a test method fails.
	        // getname for the testcase name 
	    	// screenshot code
	    	// responce if API is failed 
	    	System.out.println("I failed executed listeners code " + result.getName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        // This method is called when a test method is skipped.
	        // You can perform actions here.
	    }

	

}
