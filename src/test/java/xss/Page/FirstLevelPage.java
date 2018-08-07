package xss.Page;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class FirstLevelPage extends BasePage {

    @FindBy(css = "iframe.game-frame")
    WebElement gameFrame;

    @FindBy(css = "a")
    WebElement tryAgain;

    @FindBy(css = ".next-button")
    WebElement nextButton;

    public FirstLevelPage inputScriptForFirstPage(ArrayList<String> scripts) {
        switchTo().frame(gameFrame);
        for (String script : scripts) {
            $("input#query").setValue(script).pressEnter();
            // cratch
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (tryAgain.isDisplayed())
                tryAgain.click();
            else
                break;
        }
        return this;
    }

    public FirstLevelPage acceptAlert() {
        baseAcceptAlert();
        return this;
    }

    public SecondLevelPage goToSecondLevel() {
        nextButton.click();
        return page(SecondLevelPage.class);
    }

}
