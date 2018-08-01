package cucumber.com.google;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.com.Browsers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSteps extends Browsers {

    private byte timeOut = 10;

    @Before
    public void before() {
        driver = getDriver("chrome");
    }

    @Given("^I am on the Google search page$")
    public void i_am_on_the_Google_search_page() {
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

    @After
    public void after() {
        driver.quit();
    }
}
