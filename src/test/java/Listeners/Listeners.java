package Listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Listeners implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;
    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        Listeners.driver = driver;
    }

    @Override
    public void onStart(ITestContext context) {
        // Initialize extent report
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String pathOfReport = System.getProperty("user.dir") + "\\reports\\extentReport_" + timeStamp + ".html";
        
        ExtentSparkReporter reporter = new ExtentSparkReporter(pathOfReport);
        reporter.config().setReportName("Test Report Name - " + timeStamp);

        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush extent report
        if (extent != null) {
            extent.flush();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create new test instance for each test method
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log test success status
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log test failure status and capture screenshot
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());

        if (driver != null) {
            try {
                // Capture screenshot
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                
                // Define screenshot path
                String screenshotPath = System.getProperty("user.dir") + "\\screenshots\\" + result.getMethod().getMethodName() + ".png";
                
                // Create directories if not exist
                Files.createDirectories(Paths.get(System.getProperty("user.dir") + "\\screenshots\\"));
                
                // Save screenshot to path
                Files.copy(src.toPath(), Paths.get(screenshotPath));
                
                // Attach screenshot to report
                test.addScreenCaptureFromPath(screenshotPath, "Test Failure Screenshot");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log test skipped status
        test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional: Implement if needed
    }
}
