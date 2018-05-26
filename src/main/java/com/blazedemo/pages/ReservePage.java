package com.blazedemo.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.ByName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JPage(url = "reserve.php")
public class ReservePage extends WebPage {

    @ByName("price")
    public List<WebElement> priceList;

    public void chooseFlight() {
        cheapFlight().findElement(By.xpath("./..//input[@value='Choose This Flight']")).click();
    }

    public WebElement cheapFlight() {
        ArrayList priceFloat = new ArrayList();
        for (WebElement price : priceList) {
            priceFloat.add(Float.parseFloat((price.getAttribute("value"))));
        }
        WebElement elemMin = priceList.get(priceFloat.indexOf(Collections.min(priceFloat)));
        return elemMin;
    }
}
