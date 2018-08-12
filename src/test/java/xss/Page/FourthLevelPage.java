package xss.Page;

import static com.codeborne.selenide.Selenide.*;

public class FourthLevelPage extends BasePage {

    public FourthLevelPage inputScriptForFourthPage(String script) {
        switchTo().frame(gameFrame);
        $("input#timer").setValue(script).pressEnter();
        return this;
    }

    public FourthLevelPage acceptAlert() {
        baseAcceptAlert();
        return this;
    }

    public FifthLevelPage goToFifthLevel() {
        nextButton.click();
        return page(FifthLevelPage.class);
    }


}
