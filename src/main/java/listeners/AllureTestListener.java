package listeners;

import helpers.AllureHelper;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;
import web_driver.Driver;

@Slf4j
public class AllureTestListener implements ITestListener {

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.warn("Test [%s] failed. Screenshot captured".formatted(getTestMethodName(result)));
        AllureHelper.savePageScreenshot(Driver.get(), "Test failed.");
        AllureHelper.saveTextLog(getTestMethodName(result));
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log.warn("Test [%s] failed. Screenshot captured".formatted(getTestMethodName(result)));
        AllureHelper.savePageScreenshot(Driver.get(), "Test failed by timeout.");
        AllureHelper.saveTextLog(getTestMethodName(result));
    }

}
