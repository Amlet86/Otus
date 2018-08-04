package serenity.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends PageObject {

    @FindBy(css = ".b-result-list")
    WebElementFacade results;

    public boolean resultsAreDisplayed() {
        results.waitUntilVisible();
        return results.isDisplayed();
    }

    public boolean resultsIsContains(String text) {
        int countResults = results.findElements(By.cssSelector(".b-result")).size();
        int countIncludes = 0;
        String[] arrayText = text.split(" ");
        for (WebElement result : results.findElements(By.cssSelector(".b-result"))) {
            for (String subStr : arrayText) {
                if ($(".b-result").containsText(subStr))
                    countIncludes++;
            }
        }
        boolean qualityResult = (countIncludes > countResults) ? true : false;
        return qualityResult;
    }
}
