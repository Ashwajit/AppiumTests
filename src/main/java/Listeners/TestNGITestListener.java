package Listeners;

import base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sun.tools.internal.ws.wsdl.document.Output;
import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ExtentUtility;
import utilities.ScreenshotUtility;

public class TestNGITestListener implements ITestListener {

    private static ExtentReports extent = ExtentUtility.createInstance("./reports/ExtentReport.html");
    private ExtentTest test;

  @Override
    public synchronized void onStart(ITestContext context) {
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
      extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
      test = extent.createTest(result.getMethod().getMethodName());
    }


    @Override
    public synchronized void onTestSuccess(ITestResult result) {
    test.log(Status.PASS,"Test is pass");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
      AppiumDriver driver = (AppiumDriver)result.getAttribute("appiumDriver");
      File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      File dest = new File(System.getProperty("user.dir")+"/screenshots/demo.jpeg");
      try {
        FileUtils.copyFile(src , dest);
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        test.log(Status.FAIL,result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(dest.getAbsolutePath()).build());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {

    test.log(Status.SKIP,result.getThrowable());
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//
    }
  }



