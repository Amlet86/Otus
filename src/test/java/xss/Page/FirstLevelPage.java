package xss.Page;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class FirstLevelPage extends BasePage {

    @FindBy(css = "a")
    WebElement tryAgain;

    @FindBy(css = "iframe.game-frame")
    WebElement gameFrame;

    public FirstLevelPage tryInputScript(ArrayList<String> scripts) {
        switchTo().frame(gameFrame);
        for (String script : scripts) {
            $("input#query").setValue(script).pressEnter();
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
        switchTo().alert().accept();
        switchTo().defaultContent();
        return this;
    }

    public SecondLevelPage goToSecondLevel() {
        $(".next-button").click();
        return page(SecondLevelPage.class);
    }

}
