package second;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.testng.Assert.assertEquals;

public class SecondTest extends BaseTest {

    private String departure = "Philadelphia";
    private String destination = "New York";
    private String cardNumber = "0123456789";
    private float taxes = 514.76f;
    private String currency = "USD";

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Test
    public void test() {
        /*
        Выбор маршрута
         */
        new Select(chromeDriver.findElement(By.xpath("//*[@name='fromPort']"))).selectByValue(departure);
        new Select(chromeDriver.findElement(By.xpath("//*[@name='toPort']"))).selectByValue(destination);
        chromeDriver.findElement(By.cssSelector("input.btn")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()= 'Flights from " +
                departure + " to " + destination + ": ']")));
        /*
        Поиск самого дешевого рейса
         */
        ArrayList<WebElement> pricesWE = (ArrayList<WebElement>) chromeDriver.findElements(By.xpath("//input[@name='price']"));
        ArrayList priceFloat = new ArrayList();
        for (WebElement price : pricesWE) {
            priceFloat.add(Float.parseFloat((price.getAttribute("value"))));
        }
        WebElement elemMin = pricesWE.get(priceFloat.indexOf(Collections.min(priceFloat)));
        /*
        Сохранение параметров и выбор самого дешевого рейса
         */
        String flight = elemMin.findElement(By.xpath("./..//input[@name='flight']")).getAttribute("value");
        String airline = elemMin.findElement(By.xpath("./..//input[@name='airline']")).getAttribute("value");
        String price = elemMin.findElement(By.xpath("./..//input[@name='price']")).getAttribute("value");
        elemMin.findElement(By.xpath("./..//input[@value='Choose This Flight']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()= 'Your flight from "
                + departure + " to " + destination + " has been reserved.']")));
        /*
        Сравнение параметров из таблицы рейсов со страницей резервирования
         */
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath("//div[2]/p[1]"), "Airline: " + airline));
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath("//div[2]/p[2]"), "Flight Number: " + flight));
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath("//div[2]/p[3]"), "Price: " + price));
        /*
        Величина taxes вынесена в переменную, чтобы не переплачивать, если тут окажется $100500
         */
        String totalCost = String.valueOf(Float.parseFloat(price) + taxes);
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath("//em"), totalCost));
        /*
        Заполняем страницу резервирования
         */
        chromeDriver.findElement(By.cssSelector("#inputName")).sendKeys("Andrey");
        chromeDriver.findElement(By.cssSelector("#address")).sendKeys("Street, 123");
        chromeDriver.findElement(By.cssSelector("#city")).sendKeys("S-Pb");
        chromeDriver.findElement(By.cssSelector("#state")).sendKeys("SZFO");
        chromeDriver.findElement(By.cssSelector("#zipCode")).sendKeys("0123456789");
        new Select(chromeDriver.findElement(By.cssSelector("#cardType"))).selectByValue("amex");
        chromeDriver.findElement(By.cssSelector("#creditCardNumber")).sendKeys(cardNumber);
        WebElement creditCardMonth = chromeDriver.findElement(By.cssSelector("#creditCardMonth"));
        creditCardMonth.clear();
        creditCardMonth.sendKeys("99");
        WebElement creditCardYear = chromeDriver.findElement(By.cssSelector("#creditCardYear"));
        creditCardYear.clear();
        creditCardYear.sendKeys("0000");
        chromeDriver.findElement(By.cssSelector("#nameOnCard")).sendKeys("AndreyM");
        chromeDriver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()= " +
                "'Thank you for your purchase today!']")));
        /*
        Фиксируем или проверяем элементы страницы подтверждения
         */
        String id = chromeDriver.findElement(By.xpath("//*[text()='Id']/following-sibling::*")).getText();

        String currencyAct = chromeDriver.findElement(By.xpath("//*[text()='Amount']/following-sibling::*")).getText();
        assertEquals(currencyAct, currency, "Error: currency is incorrect.");

        WebElement cardNumElem = chromeDriver.findElement(By.xpath("//*[text()='Card Number']/following-sibling::*"));
        String cardNumAct = cardNumElem.getText().replace("x", "");
        if(!cardNumber.contains(cardNumAct)) {
            System.out.println("Error: card number is incorrect.");
        }
        System.out.println(cardNumAct);

    }
}
