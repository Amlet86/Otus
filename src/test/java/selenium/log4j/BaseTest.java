package selenium.log4j;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public abstract class BaseTest {

    public static WebDriver driver;
    public WebDriverWait webDriverWait;

    byte timeout = 2;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");

        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);
        option.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);

        driver = new ChromeDriver(option);
        LogEntries logEntries = driver.manage().logs().get(LogType.PERFORMANCE);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, timeout);
        driver.get("http://blazedemo.com/");

        for (LogEntry entry : logEntries) {
            System.out.println(entry.getLevel() + " " + entry.getMessage());
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
