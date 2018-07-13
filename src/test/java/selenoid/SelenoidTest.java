package selenoid;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;

public class SelenoidTest {

    @Test
    public void testChrome1() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("67.0");
        capabilities.setCapability("enableVNC", true);
        WebDriver driver = new RemoteWebDriver(
                URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities
        );
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://glr.lesegais.com/portal/");
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.titleIs("xxx"));
        driver.quit();
    }

    @Test
    public void testChrome2() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("67.0");
        capabilities.setCapability("enableVNC", true);
        WebDriver driver = new RemoteWebDriver(
                URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities
        );
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("http://glr.lesegais.com/portal/");
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.titleIs("xxx"));
        driver.quit();
    }

    @Test
    public void testFirefox1() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("61.0");
        capabilities.setCapability("enableVNC", true);
        WebDriver driver = new RemoteWebDriver(
                URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities
        );
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://glr.lesegais.com/portal/");
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.titleIs("xxx"));
        driver.quit();
    }

    @Test
    public void testFirefox2() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("61.0");
        capabilities.setCapability("enableVNC", true);
        WebDriver driver = new RemoteWebDriver(
                URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities
        );
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("http://glr.lesegais.com/portal/");
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.titleIs("xxx"));
        driver.quit();
    }

    @Test
    public void testOpera() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("opera");
        capabilities.setVersion("54.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("binary", "/usr/bin/opera");
        WebDriver driver = new RemoteWebDriver(
                URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities
        );
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("http://glr.lesegais.com/portal/");
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.titleIs("xxx"));
        driver.quit();
    }
}
