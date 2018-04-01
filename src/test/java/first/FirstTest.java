package first;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FirstTest {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://blazedemo.com/");
        WebElement findFlights = driver.findElement(By.cssSelector("[value='Find Flights']"));
        findFlights.click();
        ExpectedConditions.urlContains("reserve.php");
        driver.quit();
    }
}
