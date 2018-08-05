package xss.Page;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage<MainPage> {

    public static MainPage enterToMainPage() {
        open("https://xss-game.appspot.com/");
        return page(MainPage.class);
    }

    public FirstLevelPage goToFirstLevel() {
        $(".next-button").click();
        return page(FirstLevelPage.class);
    }
}
