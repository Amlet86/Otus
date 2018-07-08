package selenium.grid;

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

    private WebDriver driver;

    public WebDriver getDriver() {
        String browserName = "chrome-remote";
        if (driver == null) {
            switch (browserName) {
                case "chrome": {
                    chromeBrowser();
                    break;
                }
                case "chrome-haedless": {
                    chromeHeadless();
                    break;
                }
                case "chrome-ssl": {
                    chromeSSL();
                    break;
                }
                case "chrome-remote": {
                    chromeRemote();
                    break;
                }
                case "firefox": {
                    fireFoxBrowser();
                    break;
                }
                case "firefox-proxy": {
                    proxyFireFoxBrowser();
                    break;
                }
                case "opera": {
                    operaBrowser();
                    break;
                }
                case "ie": {
                    ieBrowser();
                    break;
                }
            }
        }
        return driver;
    }

    private WebDriver chromeBrowser() {
        WebDriverManager.chromedriver().setup();
        return driver = new ChromeDriver();
    }

    private WebDriver chromeHeadless() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("headless");
        return driver = new ChromeDriver(option);
    }

    private WebDriver chromeSSL() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return driver = new ChromeDriver(option);
    }

    private WebDriver chromeRemote() {
        WebDriverManager.chromedriver().setup();
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.180:4445/wd/hub"), DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private WebDriver fireFoxBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return driver = new FirefoxDriver();
    }

    private WebDriver proxyFireFoxBrowser() {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("78.111.114.50:8080");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability(CapabilityType.PROXY, proxy);
        WebDriverManager.firefoxdriver().setup();
        return driver = new FirefoxDriver(firefoxOptions);
    }

    /*
    Находит opera.exe только если путь есть в Binary
    */

    private WebDriver operaBrowser() {
        WebDriverManager.operadriver().setup();
        OperaOptions option = new OperaOptions();
        option.setBinary("C:\\Program Files\\Opera\\53.0.2907.68\\opera.exe");
        return driver = new OperaDriver(option);
    }

    /*
    Надо снизить безопасность до минимального уровня и добавить домен для тестов в доверенные сайты
     */

    private WebDriver ieBrowser() {
        WebDriverManager.iedriver().setup();
        return driver = new InternetExplorerDriver();
    }
}
