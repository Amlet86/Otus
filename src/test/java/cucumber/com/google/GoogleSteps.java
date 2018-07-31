package cucumber.com.google;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSteps {

    private byte timeOut = 10;
    private WebDriver driver;


    @Given("^I am on the Google search page$")
    public void i_am_on_the_Google_search_page() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://192.168.0.180:4444/wd/hub"), DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @When("^I search for \"(.*)\"$")
    public void i_search_for(String query) {
        driver.findElement(By.name("q")).sendKeys(query);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("^The page title contains \"(.*)\"$")
    public void the_page_title_contains_(String word) {
        WebElement element = driver.findElement(By.cssSelector("div[id='resultStats']"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(driver.getTitle().contains(word));
    }

    @org.junit.After
    public void after() {
        driver.quit();
    }
}
