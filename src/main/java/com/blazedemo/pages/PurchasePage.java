package com.blazedemo.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Selector;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.ById;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.ByValue;

@JPage(url = "purchase.php")
public class PurchasePage extends WebPage {

    @ById("inputName")
    public TextField firstNameFld;

    @ById("address")
    public TextField addressFld;

    @ById("city")
    public TextField cityFld;

    @ById("state")
    public TextField stateFld;

    @ById("zipCode")
    public TextField zipCodeFld;

    @ById("cardType")
    public Selector cardTypeSel;

    @ById("creditCardNumber")
    public TextField creditCardNumberFld;

    @ById("creditCardMonth")
    public TextField creditCardMonthFld;

    @ById("creditCardYear")
    public TextField creditCardYearFld;

    @ById("nameOnCard")
    public TextField nameOnCardFld;

    @ByValue("Purchase Flight")
    public Button purchaseFlightBtn;
}
