package reusable;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports runReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//index.html");
		reporter.config().setReportName("UI Automation Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		return extent;
	}

}
