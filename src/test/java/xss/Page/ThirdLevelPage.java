package xss.Page;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.page;

public class ThirdLevelPage extends BasePage {

    public ThirdLevelPage inputScriptForThirdPage(ArrayList<String> scripts) {
        for (String script : scripts) {
            urlFld.sendKeys(script);
            goBtn.click();
            // cratch
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!goBtn.isDisplayed())
                break;
        }
        return this;
    }

    public ThirdLevelPage acceptAlert() {
        baseAcceptAlert();
        return this;
    }

    public FourthLevelPage goToFourthLevel() {
        nextButton.click();
        return page(FourthLevelPage.class);
    }
}
