package xss.Page;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage extends BasePage<MainPage> {

    public static MainPage enterToMainPage() {
        open("https://www.artlebedev.ru/");
        return page(MainPage.class);
    }

}
