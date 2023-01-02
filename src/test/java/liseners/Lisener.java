package liseners;

import basetest.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Lisener extends BaseClass implements ITestListener {

    // tester name field need to change
    ExtentReports extentReport = LisenerConfig
            .ReadyReport("LUMA Test Report", "LUMA", "Hemant sonawane");

    ExtentTest test;
    ThreadLocal<ExtentTest> Thread = new ThreadLocal<>();

    public Lisener() throws IOException {
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extentReport.createTest(result.getMethod().getMethodName());
        Thread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed!");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        try {
            BaseClass.TakeScreenShot(result.getMethod().getMethodName() + ".png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.log(Status.FAIL, "Test Failed!");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
    }
}
