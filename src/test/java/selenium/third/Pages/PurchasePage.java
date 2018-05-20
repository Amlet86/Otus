package selenium.third.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class PurchasePage extends AbstractPage {

    @FindBy(xpath = "//div[2]/p[1]")
    private WebElement airlineAct;

    @FindBy(xpath = "//div[2]/p[2]")
    private WebElement flightAct;

    @FindBy(xpath = "//div[2]/p[3]")
    private WebElement priceAct;

    @FindBy(xpath = "//em")
    private WebElement totalCostAct;

    @FindBy(css = "#inputName")
    private WebElement firstNameFld;

    @FindBy(css = "#address")
    private WebElement addressFld;

    @FindBy(css = "#city")
    private WebElement cityFld;

    @FindBy(css = "#state")
    private WebElement stateFld;

    @FindBy(css = "#zipCode")
    private WebElement zipCodeFld;

    @FindBy(css = "#cardType")
    private WebElement cardTypeSel;

    @FindBy(css = "#creditCardNumber")
    private WebElement creditCardNumberFld;

    @FindBy(css = "#creditCardMonth")
    private WebElement creditCardMonthFld;

    @FindBy(css = "#creditCardYear")
    private WebElement creditCardYearFld;

    @FindBy(css = "#nameOnCard")
    private WebElement nameOnCardFld;

    @FindBy(xpath = "//input[@value='Purchase Flight']")
    private WebElement purchaseFlightBtn;

    public PurchasePage(WebDriver driver) {
        super(driver);
    }

    public String getAirlineAct() {
        return airlineAct.getText();
    }

    public String getFlightAct() {
        return flightAct.getText();
    }

    public String getPriceAct() {
        return priceAct.getText();
    }

    public String getTotalCostAct() {
        return totalCostAct.getText();
    }

    public void setFirstName(String firstName) {
        firstNameFld.sendKeys(firstName);
    }

    public void setAddress(String address) {
        addressFld.sendKeys(address);
    }

    public void setCity(String city) {
        cityFld.sendKeys(city);
    }

    public void setState(String state) {
        stateFld.sendKeys(state);
    }

    public void setZipCode(String zipCode) {
        zipCodeFld.sendKeys(zipCode);
    }

    public void setCardType(String randomCardType) {
        new Select(cardTypeSel).selectByValue(randomCardType);
    }

    public void setCardType(int randomCardType) {
        new Select(cardTypeSel).selectByIndex(randomCardType);
    }

    public void setCreditCardNumber(String creditCardNumber) {
        creditCardNumberFld.sendKeys(creditCardNumber);
    }

    public void setCreditCardMonth(String creditCardMonth) {
        creditCardMonthFld.clear();
        creditCardMonthFld.sendKeys(creditCardMonth);
    }

    public void setCreditCardYear(String creditCardYear) {
        creditCardYearFld.clear();
        creditCardYearFld.sendKeys(creditCardYear);
    }

    public void setNameOnCard(String firstName, String lastName) {
        nameOnCardFld.sendKeys(firstName + " " + lastName);
    }

    public String getDateNow() {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        formatForDateNow.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        return formatForDateNow.format(new Date());
    }

    public void purchaseFlight() {
        purchaseFlightBtn.click();
    }
}
