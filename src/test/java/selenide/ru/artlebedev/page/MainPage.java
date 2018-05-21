package selenide.ru.artlebedev.page;

import selenide.ru.artlebedev.components.MenuBlock;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage extends BasePage<MainPage> {

    private MenuBlock menuBlock;

    public static MainPage enterToMainPage() {
        open("https://www.artlebedev.ru/");
        return page(MainPage.class);
    }

    public ToolsPage goToToolsPage() {
        menuBlock.goToToolsPage();
        return page(ToolsPage.class);
    }
}
