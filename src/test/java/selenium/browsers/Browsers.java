package selenium.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Browsers {

    private WebDriver driver;

    public WebDriver chromeBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("headless");
        return driver = new ChromeDriver(option);
    }

    public WebDriver fireFoxBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return driver = new FirefoxDriver();
    }

    /*
    Находит opera.exe только если путь есть в Binary
    */

    public WebDriver operaBrowser() {
        WebDriverManager.operadriver().setup();
        OperaOptions option = new OperaOptions();
        option.setBinary("C:\\Program Files\\Opera\\53.0.2907.68\\opera.exe");
        return driver = new OperaDriver(option);
    }

    /*
    Надо снизить безопасность до минимального уровня и добавить домен для тестов в доверенные сайты
     */

    public WebDriver ieBrowser() {
        WebDriverManager.iedriver().setup();
        return driver = new InternetExplorerDriver();
    }
}
