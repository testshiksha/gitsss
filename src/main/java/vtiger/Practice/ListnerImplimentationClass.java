package vtiger.Practice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class provides implementation to ITestListener interface of testng
 * @author Lenovo
 *
 */
public class ListnerImplimentationClass implements ITestListener {
	
	ExtentReports Report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println("----start---"+ methodname);
		test=Report.createTest(methodname);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodname = result.getMethod().getMethodName();
		//System.out.println("----pass---"+ methodname);
		test.log(Status.PASS, "----pass---"+ methodname);
	

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		//System.out.println("----fail---"+ methodname);
		test.log(Status.FAIL, "----fail---"+ methodname);
		
		
		//System.out.println(result.getThrowable());
		test.log(Status.INFO, result.getThrowable());
		
		
		WebDriverFileUtility wu = new WebDriverFileUtility();
		JavaUtility ju= new JavaUtility();
		String ScreenshotName = methodname+ju.getSystemDateInFormat();
		//take screen shot for failed test script---to attach with bug rising
		try {
			String path = wu.takescreenshot(BaseClass.sdriver,ScreenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodname = result.getMethod().getMethodName();
		System.out.println("----skip---"+ methodname);
		test.log(Status.SKIP, "----skip---"+ methodname);
		
		System.out.println(result.getThrowable());
		test.log(Status.INFO, result.getThrowable());
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		//start of <suite>@Before suite
		System.out.println("suite execution started");
		ExtentSparkReporter HtmlReporter = new ExtentSparkReporter(".\\ExtentFolder\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		HtmlReporter.config().setDocumentTitle("vtiger Execution Report");
		HtmlReporter.config().setReportName("Build 3 Vtiger Execution Report");
		HtmlReporter.config().setTheme(Theme.DARK);
		
		//report generation
		
		Report = new ExtentReports();
		Report.attachReporter(HtmlReporter);
		Report.setSystemInfo("browser", "chrome");
		Report.setSystemInfo("platform", "Testing Env");
		Report.setSystemInfo("url", "https://localhost:8888");
		Report.setSystemInfo("os", "window");
		Report.setSystemInfo("Reporter", "shiksha");
	}

	public void onFinish(ITestContext context) {
		//end of </suite>@After suite
		System.out.println("suite execution ended");
		
		//Report Generation
		Report.flush();
		
	
	}

}
