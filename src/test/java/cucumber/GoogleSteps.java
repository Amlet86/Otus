package cucumber;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSteps {

    private WebDriver driver;

    @Given("^I am on the Google search page$")
    public void i_am_on_the_Google_search_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
    public void close() {
        driver.quit();
    }
}
