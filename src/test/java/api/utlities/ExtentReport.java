package api.utlities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {

	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	
	public void onStart(ITestContext context) {
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report-" + timeStamp + ".html";
		
		sparkreporter = new ExtentSparkReporter(".\\reports\\" + repName);
		
		
		sparkreporter.config().setDocumentTitle("RestassuredAPITESTINg");

		sparkreporter.config().setReportName("jitender chauhan");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Application", "Pet store API");
		extent.setSystemInfo("Tester name", "jitender chauhan");
		extent.setSystemInfo("os","window");
		extent.setSystemInfo("browser", "chrome");
		extent.setSystemInfo("application name ", "testing expamle");
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "test case paseed:"+ result.getTestName());
		
	}
	public void onTestFailure(ITestResult result) {
		//capturescreen(repName);
		test=extent.createTest(result.getName());
		test.log(Status.FAIL,"test fail due to " + result.getName());
		test.log(Status.FAIL, "test cse faild cause is :" + result.getThrowable());
		
	}
public void onTestSkipped(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "test is skip due to: " + result.getName());
		test.log(Status.SKIP, "test case skped cause is :" + result.getName());
		
}
public void onFinish(ITestContext context){
	extent.flush();
	String pathextentReport= System.getProperty("user.dir")+"\\reports\\"+repName;
	File extentreport= new File(pathextentReport);

	try {
		Desktop.getDesktop().browse(extentreport.toURI());
	}catch(IOException e1) {
		e1.printStackTrace();
	}
	{
}
	
}


	
}

