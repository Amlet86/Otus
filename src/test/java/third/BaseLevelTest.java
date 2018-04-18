package third;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import third.Pages.FindFlightsPage;

import java.util.concurrent.TimeUnit;

public class BaseLevelTest {

    static WebDriver driver;
    static WebDriverWait webDriverWait;

    byte timeout = 10;

    @BeforeClass
    public void beforeClass() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, timeout);
        driver.get("http://blazedemo.com/");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

