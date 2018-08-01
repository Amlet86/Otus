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

    private String proxy_address = "78.111.114.50:8080";
    private String url_hub = "http://10.0.6.4:4444/wd/hub";
    protected WebDriver driver;

    protected WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "headless":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "remote":
                try {
                    driver = new RemoteWebDriver(new URL(url_hub), DesiredCapabilities.chrome());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case "firefox":
                Proxy proxy = new Proxy();
                proxy.setHttpProxy(proxy_address);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.PROXY, proxy);
                driver =  new FirefoxDriver(firefoxOptions);
                break;
            case "opera":
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.setBinary("C:\\Program Files\\Opera\\53.0.2907.68\\opera.exe");
                driver = new OperaDriver(operaOptions);
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }

}
