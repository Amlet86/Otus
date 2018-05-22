package selenium.browsers;

import org.testng.annotations.AfterClass;
import selenium.browsers.Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test {

    WebDriver driver;
    WebDriverWait webDriverWait;

    byte timeout = 10;

    @BeforeClass
    public void beforeClass() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("headless");
        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, timeout);
        driver.get("http://automationpractice.com/index.php");
    }

    @org.testng.annotations.Test
    public void test() {
        MainPage page = new MainPage(driver);
        page.moveMouseInWomenBtn();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Women']/..//a[@title='T-shirts']")));
        page.tShirtsBtnClick();
        webDriverWait.until(ExpectedConditions.titleIs("T-shirts - My Store"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
