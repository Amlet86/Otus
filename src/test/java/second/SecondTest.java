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

        // TODO заменить говнолокатор
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table")));

        // TODO подумать, как уменьшить кол-во кода
        ArrayList<WebElement> pricesElem = (ArrayList<WebElement>) chromeDriver.findElements(By.xpath("//input[@name='price']"));
        ArrayList priceInt = new ArrayList();
        for (WebElement price: pricesElem) {
            priceInt.add(Integer.parseInt((price.getAttribute("value")).replace(".", "")));
        }
        WebElement elemMin = pricesElem.get(priceInt.indexOf(Collections.min(priceInt)));
        elemMin.findElement(By.xpath("./..//input[@value='Choose This Flight']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputName")));

        chromeDriver.findElement(By.cssSelector("#inputName")).sendKeys("Andrey");
        chromeDriver.findElement(By.cssSelector("#address")).sendKeys("Street, 123");
        chromeDriver.findElement(By.cssSelector("#city")).sendKeys("S-Pb");
        chromeDriver.findElement(By.cssSelector("#state")).sendKeys("SZFO");
        chromeDriver.findElement(By.cssSelector("#zipCode")).sendKeys("0123456789");
        new Select(chromeDriver.findElement(By.cssSelector("#cardType"))).selectByValue("amex");
        chromeDriver.findElement(By.cssSelector("#creditCardNumber")).sendKeys("0123456789");
        WebElement creditCardMonth = chromeDriver.findElement(By.cssSelector("#creditCardMonth"));
        creditCardMonth.clear();
        creditCardMonth.sendKeys("99");
        WebElement creditCardYear = chromeDriver.findElement(By.cssSelector("#creditCardYear"));
        creditCardYear.clear();
        creditCardYear.sendKeys("0000");
        chromeDriver.findElement(By.cssSelector("#nameOnCard")).sendKeys("AndreyM");
        chromeDriver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();


    }
}
