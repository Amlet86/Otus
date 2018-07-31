package selenium.fourth;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.fourth.Pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class FourthTest {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    byte timeout = 10;
    String colorExp = "rgba(37, 121, 169, 1)";

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
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
        Dimension sizeLoginBtn = page.getSizeLoginBtn();
        page.moveMouseInLoginBtn();
        assertEquals(page.getSizeLoginBtn(), sizeLoginBtn, "Error: size loginBtn is incorrect.");
        assertEquals(page.getBackgroundColorLoginBtn(), colorExp, "Error: background-color is incorrect.");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
