package first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://blazedemo.com/");
        driver.findElement(By.cssSelector("[value='Find Flights']")).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.titleIs("BlazeDemo - reserve"));
        driver.quit();
    }
}
