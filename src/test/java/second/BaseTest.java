package second;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver chromeDriver;
    protected WebDriverWait webDriverWait;

    byte timeout = 10;

    @BeforeClass
    public void beforeClass() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(chromeDriver, timeout);
        chromeDriver.get("http://blazedemo.com/");
    }

    @AfterClass
    public void afterClass(){
//        chromeDriver.quit();
    }
}
