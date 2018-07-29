package cucumber.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Browsers {

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

    public static WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver operaDriver() {
        OperaOptions option = new OperaOptions();
        option.setBinary("C:\\Program Files\\Opera\\53.0.2907.68\\opera.exe");
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver(option);
        return driver;
    }

    public static WebDriver ieDriver() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        return driver;
    }

    public static WebDriver getDriver(String value) {
        switch (value) {
            case "headless":
                chromeHeadlessDriver();
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
