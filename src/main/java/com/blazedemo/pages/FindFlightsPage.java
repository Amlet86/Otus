package com.blazedemo.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Selector;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.ByName;

@JPage(url = "")
public class FindFlightsPage extends WebPage {

    @ByName("fromPort")
    public Selector departureSel;

    @ByName("toPort")
    public Selector destinationSel;

    @JFindBy(css = "input.btn")
    public Button findFlightsBtn;
}
