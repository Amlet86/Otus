package com.blazedemo;

import com.blazedemo.pages.ConfirmationPage;
import com.blazedemo.pages.FindFlightsPage;
import com.blazedemo.pages.PurchasePage;
import com.blazedemo.pages.ReservePage;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import ru.yandex.qatools.allure.annotations.Step;

import static com.blazedemo.entities.TestData.departure;
import static com.blazedemo.entities.TestData.destination;

@JSite(value = "http://blazedemo.com")
public class JDIBlazeDemoSite extends WebSite {

    public static FindFlightsPage findFlightsPage;
    public static ReservePage reservePage;
    public static PurchasePage purchasePage;
    public static ConfirmationPage confirmationPage;

    @Step
    public static void findFlightsFromTo() {
        findFlightsPage.departureSel.select(departure);
        findFlightsPage.destinationSel.select(destination);
        findFlightsPage.findFlightsBtn.click();
        reservePage.checkOpened();
    }

}
