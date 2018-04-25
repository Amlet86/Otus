package fourth;

import fourth.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class FourthTest {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    byte timeout = 10;
    String colorExp = "rgba(37, 121, 169, 1)";

    @BeforeClass
    public void beforeClass() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, timeout);
        driver.get("http://blazedemo.com/login");
    }

    @Test
    public void test() {
        LoginPage page = new LoginPage(driver);
        String fontSizeAfter = page.getFontSize();
        String paddingAfter = page.getPadding();
        page.moveMouseInLoginBtn();
        assertEquals(page.getFontSize(), fontSizeAfter, "Error: font-size is incorrect.");
        assertEquals(page.getPadding(), paddingAfter, "Error: padding is incorrect.");
        assertEquals(page.getBackgroundColorLoginBtn(), colorExp, "Error: background-color is incorrect.");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
