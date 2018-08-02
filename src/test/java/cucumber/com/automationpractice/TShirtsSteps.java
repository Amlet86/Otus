package cucumber.com.automationpractice;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.com.Browsers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TShirtsSteps extends Browsers {

    private byte timeOut = 10;
    private WebDriverWait webDriverWait;

    @Before
    public void before() {
        driver = getDriver("remote");
    }

    @Given("^I am on the automationpractice page$")
    public void i_am_on_the_automationpractice_page() {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, timeOut);
        driver.get("http://automationpractice.com/index.php");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Women']")));
    }

    @When("^I'm moving mouse in women button$")
    public void i_moving_mouse_in_women_button() {
        Actions action = new Actions(driver);
        WebElement womenBtn = driver.findElement(By.xpath("//a[@title='Women']"));
        action.moveToElement(womenBtn).build().perform();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Women']/..//a[@title='T-shirts']")));
    }

    @And("^I'm clicking in \"(.*)\" button$")
    public void I_clicking_in_button(String button) {
        driver.findElement(By.xpath("//a[@title='Women']/..//a[@title='" + button + "']")).click();
    }

    @Then("^The page opens \"(.*)\" My store$")
    public void the_page_opens_my_store(String button) {
        Assert.assertTrue(driver.getTitle().contains(button));
    }

    @After
    public void after() {
        driver.quit();
    }
}
