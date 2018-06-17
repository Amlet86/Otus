package selenium.log4j;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static selenium.log4j.BaseTest.getDriver;

public class TestListener implements ITestListener {

    private Logger logger = Logger.getLogger(TestListener.class);

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Homework start!");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Homework happy end!");
    }

    public void onTestFailure(ITestResult iTestResult) {
        Date failedTime = new Date(iTestResult.getEndMillis());
        logger.error(iTestResult.getTestName() + " " + failedTime);
        File screen = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen, new File("target/test-classes/selenium/log4j/screen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        LogEntries logEntries = getDriver().manage().logs().get(LogType.PERFORMANCE);
        for (LogEntry entry : logEntries) {
            System.out.println(entry.getLevel() + " " + entry.getMessage());
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}