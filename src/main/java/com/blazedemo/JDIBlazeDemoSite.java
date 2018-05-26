package com.blazedemo;

import com.blazedemo.pages.ConfirmationPage;
import com.blazedemo.pages.FindFlightsPage;
import com.blazedemo.pages.PurchasePage;
import com.blazedemo.pages.ReservePage;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Random;

import static com.blazedemo.entities.TestData.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @Step
    public static void reserve() {
        reservePage.chooseFlight();
        purchasePage.checkOpened();
    }

    @Step
    public static void purchase() {
        purchasePage.firstNameFld.setValue(firstName);
        purchasePage.addressFld.setValue(address);
        purchasePage.cityFld.setValue(city);
        purchasePage.stateFld.setValue(state);
        purchasePage.zipCodeFld.setValue(zipCode);
        purchasePage.cardTypeSel.select(new Random().nextInt(3));
        purchasePage.creditCardNumberFld.setValue(creditCardNumber);
        purchasePage.creditCardMonthFld.setValue(cardMonth);
        purchasePage.creditCardYearFld.setValue(cardYear);
        purchasePage.nameOnCardFld.setValue(firstName + " " + lastName);
        purchasePage.purchaseFlightBtn.click();
        confirmationPage.checkOpened();
    }

    @Step
    public static void confirmation() {
        assertEquals(confirmationPage.currencyAct.getText(), currency, "Error: currency is incorrect.");
        assertTrue(creditCardNumber.contains(confirmationPage.cardNumberAct.getText().replace("x", "")),
                "Error: card number is incorrect.");
        System.out.println("Информация о бронировании Id " + confirmationPage.idAct.getText() + " не была сохранена.");
    }

}
