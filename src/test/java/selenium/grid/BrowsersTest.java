package selenium.grid;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.grid.Pages.MainPage;

public class BrowsersTest extends Browsers {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    byte timeout = 10;

    @BeforeClass
    public void beforeClass() {
        Browsers browsers = new Browsers();
        driver = browsers.getDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, timeout);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void test() {
        MainPage page = new MainPage(driver);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Women']")));
        page.moveMouseInWomenBtn();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Women']/..//a[@title='T-shirts']")));
        page.tShirtsBtnClick();
        webDriverWait.until(ExpectedConditions.titleIs("T-shirts - My Store"));
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) driver.quit();
    }
}
