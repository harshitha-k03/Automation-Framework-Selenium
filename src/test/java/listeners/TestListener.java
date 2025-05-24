package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReportManager;
import com.aventstack.extentreports.Status;
import utils.LoggerUtil;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        LoggerUtil.info("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getInstance().createTest(result.getName()).log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getInstance().createTest(result.getName()).log(Status.FAIL, result.getThrowable());
        LoggerUtil.error("Test Failed: " + result.getName(), result.getThrowable());
    }
}