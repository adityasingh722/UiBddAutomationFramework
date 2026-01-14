package reusable;

import java.time.Duration;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

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
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("STARTED: " + result.getMethod().getMethodName());
		// It gives the current method name
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		float time = (result.getEndMillis() - result.getStartMillis()) / 1000;
		// It gives the total execution time in seconds
		System.out.println("EXECUTION TIME :" + time + "sec");
		System.out.println(result.wasRetried());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("FAILED: " + result.getMethod().getMethodName());
		// It gives the current method name
		System.out.println("Reason: " + result.getThrowable());
		// It gives the exception, the reason for failure
		float time = (result.getEndMillis() - result.getStartMillis()) / 1000;
		// It gives the total execution time in seconds
		System.out.println("EXECUTION TIME :" + time + "sec");
		System.out.println(result.wasRetried());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("SKIPPED: " + result.getMethod().getMethodName());
		float time = (result.getEndMillis() - result.getStartMillis()) / 1000;
		System.out.println("EXECUTION TIME :" + time + "sec");
		System.out.println(result.wasRetried());
	}

}
