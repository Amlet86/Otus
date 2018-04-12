package second;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SecondTest extends BaseTest {

    private String departure = "Philadelphia";
    private String destination = "New York";
    private float taxes = 514.76f;
    private String firstName = "Andrey";
    private String lastName = "Mikhaylov";
    private String address = "Street, 123";
    private String city = "SPb";
    private String state = "SZFO";
    private String zipCode = "178178";
    private String cardMonth = "99";
    private String cardYear = "0000";
    private String cardNumber = "0123456789";
    private String currency = "USD";

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTaxes(float taxes) {
        this.taxes = taxes;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCardMonth(String cardMonth) {
        this.cardMonth = cardMonth;
    }

    public void setCardYear(String cardYear) {
        this.cardYear = cardYear;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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
        Сохранение параметров и выбор рейса
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
        assertEquals(chromeDriver.findElement(By.xpath("//div[2]/p[1]")).getText(), "Airline: " + airline,
                "Error: airline is incorrect.");
        assertTrue(chromeDriver.findElement(By.xpath("//div[2]/p[2]")).getText().contains(flight),
                "Error: flight number is incorrect.");
        assertFalse(!chromeDriver.findElement(By.xpath("//div[2]/p[3]")).getText().contains(price),
                "Error: price is incorrect.");
        /*
        Значение taxes вынесено в переменную, чтобы не переплачивать, если система подставит $100500
         */
        String totalCost = String.valueOf(Float.parseFloat(price) + taxes);
        assertEquals(chromeDriver.findElement(By.xpath("//em")).getText(), totalCost,
                "Error: total cost is incorrect.");
        /*
        Заполняем страницу резервирования
         */
        chromeDriver.findElement(By.cssSelector("#inputName")).sendKeys(firstName);
        chromeDriver.findElement(By.cssSelector("#address")).sendKeys(address);
        chromeDriver.findElement(By.cssSelector("#city")).sendKeys(city);
        chromeDriver.findElement(By.cssSelector("#state")).sendKeys(state);
        chromeDriver.findElement(By.cssSelector("#zipCode")).sendKeys(zipCode);
        int randomCardType = new Random().nextInt(3);
        new Select(chromeDriver.findElement(By.cssSelector("#cardType"))).selectByIndex(randomCardType);
        chromeDriver.findElement(By.cssSelector("#creditCardNumber")).sendKeys(cardNumber);
        WebElement creditCardMonth = chromeDriver.findElement(By.cssSelector("#creditCardMonth"));
        creditCardMonth.clear();
        creditCardMonth.sendKeys(cardMonth);
        WebElement creditCardYear = chromeDriver.findElement(By.cssSelector("#creditCardYear"));
        creditCardYear.clear();
        creditCardYear.sendKeys(cardYear);
        chromeDriver.findElement(By.cssSelector("#nameOnCard")).sendKeys(firstName + " " + lastName);
        chromeDriver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
        /*
        Создаём дату с определённым форматом и изменением TimeZone на GMT 0
         */
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        formatForDateNow.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        String dateNow = formatForDateNow.format(new Date());

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
        assertTrue(cardNumber.contains(cardNumAct), "Error: card number is incorrect.");
        /*
        Сравниваем даты: созданную при переходе на страницу и указанную в поле Date
         */
        String dateElem = chromeDriver.findElement(By.xpath("//*[text()='Date']/following-sibling::*")).getText();
        assertEquals(dateElem, dateNow, "Cry: date again false!");

        System.out.println("Информация о бронировании Id " + id + " не была сохранена.");
    }
}
