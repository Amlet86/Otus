package xss.Page;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage extends BasePage<MainPage> {

    public static MainPage enterToMainPage() {
        open("https://xss-game.appspot.com/");
        return page(MainPage.class);
    }

    public FirstLevelPage goToFirstLevel() {
        nextButton.click();
        return page(FirstLevelPage.class);
    }
}
