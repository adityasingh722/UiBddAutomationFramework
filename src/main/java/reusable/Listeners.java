package reusable;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends TestBase implements ITestListener {
	
	ThreadLocal<ExtentTest> parallelThread = new ThreadLocal<ExtentTest>();
	ExtentReports extent = ExtentReportNG.runReport();
	ExtentTest test;
	

	@Override
	public void onStart(ITestContext context) {
		System.out.println("TEST STARTED: " + context.getName());
		// It gives the name of the <test> from testng.xml
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("TEST FINISHED: " + context.getName());
		// It gives the name of the <test> from testng.xml
		System.out.println("Passed Tests :" + context.getPassedTests().size());
		System.out.println("Failed Tests :" + context.getFailedTests().size());
		System.out.println("Skipped Tests :" + context.getSkippedTests().size());
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// It gives the current method name
		System.out.println("METHOD STARTED: " + result.getMethod().getMethodName());
		//Create a test for reporting
		test = extent.createTest(result.getMethod().getMethodName());
		parallelThread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// It gives the total execution time in seconds
		float time = (result.getEndMillis() - result.getStartMillis()) / 1000;
		System.out.println("EXECUTION TIME :" + time + "sec");
		parallelThread.get().log(Status.PASS, "TEST PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// It gives the current method name
		System.out.println("METHOD FAILED: " + result.getMethod().getMethodName());
		// It gives the exception, the reason for failure
		System.out.println("Reason: " + result.getThrowable());
		//It gives if the method was retried after failure
		System.out.println(result.wasRetried());
		// It gives the total execution time in seconds
		float time = (result.getEndMillis() - result.getStartMillis()) / 1000;
		System.out.println("EXECUTION TIME :" + time + "sec");
		//Logging exception in report
		parallelThread.get().fail(result.getThrowable());
		//Getting live driver instance to initialize take screenshot driver
		Object testClass =  result.getInstance();
		TestBase testBase = (TestBase)testClass;
		WebDriver driver = getDriver();
		//Add screenshot
		String imagePath = null;
		try {
			imagePath = takeScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parallelThread.get().addScreenCaptureFromPath(imagePath);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("SKIPPED: " + result.getMethod().getMethodName());
		float time = (result.getEndMillis() - result.getStartMillis()) / 1000;
		System.out.println("EXECUTION TIME :" + time + "sec");
		System.out.println(result.wasRetried());
	}

}
