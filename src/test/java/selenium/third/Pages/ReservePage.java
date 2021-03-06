package selenium.third.Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReservePage extends AbstractPage {

    @FindBy(xpath = "//input[@name='price']")
    private List<WebElement> priceList;

    public ReservePage(WebDriver driver) {
        super(driver);
    }

    public WebElement cheapFlight() {
        ArrayList priceFloat = new ArrayList();
        for (WebElement price : priceList) {
            priceFloat.add(Float.parseFloat((price.getAttribute("value"))));
        }
        WebElement elemMin = priceList.get(priceFloat.indexOf(Collections.min(priceFloat)));
        return elemMin;
    }

    public String getFlight(WebElement selectedElem) {
        return selectedElem.findElement(By.xpath("./..//input[@name='flight']")).getAttribute("value");
    }

    public String getAirline(WebElement selectedElem) {
        return selectedElem.findElement(By.xpath("./..//input[@name='airline']")).getAttribute("value");
    }

    public String getPrice(WebElement selectedElem) {
        return selectedElem.findElement(By.xpath("./..//input[@name='price']")).getAttribute("value");
    }

    public void chooseFlight(WebElement selectedElem) {
        selectedElem.findElement(By.xpath("./..//input[@value='Choose This Flight']")).click();
    }
}
