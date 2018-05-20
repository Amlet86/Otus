package selenium.third.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FindFlightsPage extends AbstractPage {

    @FindBy(xpath = "//*[@name='fromPort']")
    private WebElement departureSel;

    @FindBy(xpath = "//*[@name='toPort']")
    private WebElement destinationSel;

    @FindBy(css = "input.btn")
    private WebElement findFlightsBtn;

    public FindFlightsPage(WebDriver driver) {
        super(driver);
    }

    public void setDeparture(String departure) {
        new Select(departureSel).selectByValue(departure);
    }

    public void setDestination(String destination) {
        new Select(destinationSel).selectByValue(destination);
    }

    public void findFlights() {
        findFlightsBtn.click();
    }
}
