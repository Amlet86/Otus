package serenity.com.pipl.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends PageObject {

    @FindBy(id = "main_content")
    WebElementFacade results;

    public boolean resultsAreDisplayed() {
        results.waitUntilVisible();
        return results.isDisplayed();
    }

    public boolean titleIsDisplayed(){
        return $(".title-header").isDisplayed();
    }
}
