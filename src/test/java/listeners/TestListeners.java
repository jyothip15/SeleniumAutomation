package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class TestListeners extends BaseTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Method started "+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Method Passed " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result){
		 System.out.println("Test Method Failed " +result.getName());
		 try {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			test.fail(result.getName()+" FAILED");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Method Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("");
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("Suite start");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Suite finishes");
		
	}

}