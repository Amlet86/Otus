package selenium.xpath_css;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.xpath_css.Pages.RamblerXPathPage;

public class FixTest {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    byte timeout = 10;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, timeout);
        driver.get("https://www.rambler.ru/");
    }

    @Test
    public void fixLocator() {
        RamblerXPathPage page = new RamblerXPathPage(driver);
        String text = page.getHeaderSearch();
        System.out.println(text);
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) driver.quit();
    }
}
