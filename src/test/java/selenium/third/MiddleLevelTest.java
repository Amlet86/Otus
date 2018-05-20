package selenium.third;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import selenium.third.Pages.ConfirmationPage;
import selenium.third.Pages.FindFlightsPage;
import selenium.third.Pages.PurchasePage;
import selenium.third.Pages.ReservePage;

import java.util.Random;

import static org.testng.Assert.*;

public class MiddleLevelTest extends BaseLevelTest {

    private String departure = "San Diego";
    private String destination = "New York";
    private float taxes = 514.76f;
    private String firstName = "Andrey";
    private String lastName = "Mikhaylov";
    private String address = "Street, 123";
    private String city = "SPb";
    private String state = "SZFO";
    private String zipCode = "178178";
    private String creditCardNumber = "0123456789";
    private String cardMonth = "99";
    private String cardYear = "0000";
    private String currency = "USD";

    String airline;
    String flight;
    String price;
    String dateNow;

    @Test(suiteName = "smoke")
    public void findFlightsFromTo() {
        FindFlightsPage page = new FindFlightsPage(driver);
        page.setDeparture(departure);
        page.setDestination(destination);
        page.findFlights();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()= 'Flights from " +
                departure + " to " + destination + ": ']")));
    }

    @Test(dependsOnMethods = "findFlightsFromTo", suiteName = "smoke")
    public void reserve() {
        ReservePage page = new ReservePage(driver);
        WebElement selectedElem = page.cheapFlight();
        this.flight = page.getFlight(selectedElem);
        this.airline = page.getAirline(selectedElem);
        this.price = page.getPrice(selectedElem);
        page.chooseFlight(selectedElem);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()= 'Your flight from "
                + departure + " to " + destination + " has been reserved.']")));
    }

    @Test(dependsOnMethods = "reserve", suiteName = "smoke")
    public void purchase() {
        PurchasePage page = new PurchasePage(driver);
        assertEquals(page.getAirlineAct(), "Airline: " + airline, "Error: airline is incorrect.");
        assertTrue(page.getFlightAct().contains(flight), "Error: flight number is incorrect.");
        assertFalse(!page.getPriceAct().contains(price), "Error: price is incorrect.");
        String totalCost = String.valueOf(Float.parseFloat(price) + taxes);
        assertEquals(page.getTotalCostAct(), totalCost, "Error: total cost is incorrect.");
        page.setFirstName(firstName);
        page.setAddress(address);
        page.setCity(city);
        page.setState(state);
        page.setZipCode(zipCode);
        page.setCardType(new Random().nextInt(3));
        page.setCreditCardNumber(creditCardNumber);
        page.setCreditCardMonth(cardMonth);
        page.setCreditCardYear(cardYear);
        page.setNameOnCard(firstName, lastName);
        page.purchaseFlight();
        this.dateNow = page.getDateNow();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()= " +
                "'Thank you for your purchase today!']")));
    }

    @Test(dependsOnMethods = "purchase", suiteName = "smoke")
    public void confirmation() {
        ConfirmationPage page = new ConfirmationPage(driver);
        assertEquals(page.getCurrencyAct(), currency, "Error: currency is incorrect.");
        assertTrue(creditCardNumber.contains(page.getCardNumberAct()), "Error: card number is incorrect.");
        assertEquals(page.getDateAct(), dateNow, "Cry: date again false!");
        System.out.println("Информация о бронировании Id " + page.getId() + " не была сохранена.");
    }
}
