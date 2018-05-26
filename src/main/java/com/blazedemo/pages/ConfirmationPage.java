package com.blazedemo.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;

@JPage(url = "confirmation.php")
public class ConfirmationPage extends WebPage {

    @JFindBy(xpath = "//*[text()='Id']/following-sibling::*")
    public Text idAct;

    @JFindBy(xpath = "//*[text()='Amount']/following-sibling::*")
    public Text currencyAct;

    @JFindBy(xpath = "//*[text()='Card Number']/following-sibling::*")
    public Text cardNumberAct;
}
