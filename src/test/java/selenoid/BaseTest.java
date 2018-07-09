package selenoid;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {

    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("67.0");
        capabilities.setCapability("enableVNC", true);
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities
        );
        driver.get("http://blazedemo.com/");
        driver.findElement(By.cssSelector("[value='Find Flights']")).click();
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.titleIs("BlazeDemo - reserve"));
        driver.quit();
    }
}
