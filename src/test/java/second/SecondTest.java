package second;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondTest extends BaseTest {

    private String departure = "Philadelphia";
    private String destination = "New York";

    @Test
    public void test() {
        new Select(chromeDriver.findElement(By.xpath("//*[@name='fromPort']"))).selectByValue(departure);
        new Select(chromeDriver.findElement(By.xpath("//*[@name='toPort']"))).selectByValue(destination);
        chromeDriver.findElement(By.cssSelector("input.btn")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table")));

        ArrayList<WebElement> pricesElem = (ArrayList<WebElement>) chromeDriver.findElements(By.xpath("//input[@name='price']"));
        ArrayList priceInt = new ArrayList();
        for (WebElement price: pricesElem) {
            priceInt.add(Integer.parseInt((price.getAttribute("value")).replace(".", "")));
        }
        WebElement elemMin = pricesElem.get(priceInt.indexOf(Collections.min(priceInt)));
        elemMin.findElement(By.xpath("./..//input[@value='Choose This Flight']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputName")));


    }
}
