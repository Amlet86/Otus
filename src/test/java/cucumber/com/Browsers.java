package cucumber.com;

import java.net.MalformedURLException;
import java.net.URL;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browsers {

    private static final String PROXY_ADDRESS = "78.111.114.50:8080";
    public static WebDriver driver;

    public static WebDriver chromeDriver() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        return driver;
    }

    public static WebDriver chromeHeadlessDriver() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        return driver;
    }

    public static WebDriver chromeRemoteDriver() {
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.180:4444/wd/hub"), DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver firefoxDriver() {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(PROXY_ADDRESS);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability(CapabilityType.PROXY, proxy);
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver operaDriver() {
        OperaOptions option = new OperaOptions();
        option.setBinary("C:\\Program Files\\Opera\\53.0.2907.68\\opera.exe");
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver(option);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver ieDriver() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver(String value) {
        switch (value) {
            case "headless":
                chromeHeadlessDriver();
                break;
            case "remote":
                chromeRemoteDriver();
                break;
            case "firefox":
                firefoxDriver();
                break;
            case "opera":
                operaDriver();
                break;
            case "ie":
                ieDriver();
                break;
            default:
                chromeDriver();
                break;
        }
        return driver;
    }

}
