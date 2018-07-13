package selenoid;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WithOutSelenoidTest {

    @Test
    public void testChrome1() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(option);
        driver.get("http://glr.lesegais.com/portal/");
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.titleIs("xxx"));
        driver.quit();
    }

    @Test
    public void testChrome2() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(option);
        driver.get("http://glr.lesegais.com/portal/");
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.titleIs("xxx"));
        driver.quit();
    }

    @Test
    public void testFirefox1() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://glr.lesegais.com/portal/");
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.titleIs("xxx"));
        driver.quit();
    }

    @Test
    public void testFirefox2() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://glr.lesegais.com/portal/");
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.titleIs("xxx"));
        driver.quit();
    }
}
