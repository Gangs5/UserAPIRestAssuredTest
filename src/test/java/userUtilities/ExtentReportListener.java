package userUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


	public class ExtentReportListener implements ITestListener {

	    private static ExtentReports extent = new ExtentReports();
	    private static ExtentTest test;

	    private static String reportFileName = "ExtentReport.html";

	    @Override
	    public void onStart(ITestContext context) {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFileName);
	        extent.attachReporter(htmlReporter);
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.pass("Test passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.fail(result.getThrowable());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.skip(result.getThrowable());
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        
	    }
	}



