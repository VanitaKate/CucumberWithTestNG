package Listener;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilities.DateTimeStamp;

public class Listener implements ITestListener{
	WebDriver driver;
	DateTimeStamp timeStamp=new DateTimeStamp();

	public void onTestStart(ITestResult result) {
System.out.println("The test starts here:"+timeStamp.getTimeStamp());
	}

	public void onTestSuccess(ITestResult result) {
System.out.println("The test with name '"+result.getTestName()+"' is PASSED");
	}

	public void onTestFailure(ITestResult result) {
		TakesScreenshot SC=(TakesScreenshot)driver;
		File src=SC.getScreenshotAs(OutputType.FILE);
		String DestFile=("C://"+result.getName()+".png");
//		FileUtils.copyFile(src, DestPath);
		System.out.println("The test with name '"+result.getTestName()+"' is FAILED");
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		System.out.println("The Execution started here: "+timeStamp.getTimeStamp());
	}

	public void onFinish(ITestContext context) {
		System.out.println("The Execution finished here: "+timeStamp.getTimeStamp());
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}


}
