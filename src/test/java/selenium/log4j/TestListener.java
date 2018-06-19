package selenium.log4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

import static selenium.log4j.BaseTest.getDriver;

public class TestListener implements ITestListener {

    private Logger logger = Logger.getLogger(TestListener.class);

    public void onTestStart(ITestResult iTestResult) {
        logger.info("Happy start");
        System.out.println("Homework start!");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("Happy end");
        System.out.println("Homework happy end!");
    }

    public void onTestFailure(ITestResult iTestResult) {
        long failedMillis = iTestResult.getEndMillis();
        Date failedTime = new Date(failedMillis);
        logger.error(iTestResult.getTestName() + " " + failedTime);
        File screen = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen, new File("target/test-classes/selenium/log4j/screen" + failedMillis + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        LogEntries logEntries = getDriver().manage().logs().get(LogType.PERFORMANCE);
        String filePath = "target/test-classes/selenium/log4j/log" + failedMillis + ".txt";
        for (LogEntry entry : logEntries) {
            try {
                FileWriter fwriter = new FileWriter(filePath, true);
                BufferedWriter bWriter = new BufferedWriter(fwriter);
                bWriter.write(entry.getLevel() + " " + entry.getMessage());
                bWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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