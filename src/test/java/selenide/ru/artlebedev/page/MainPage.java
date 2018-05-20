package selenide.ru.artlebedev.page;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public MainPage enterToMainPage() {
        open("https://www.artlebedev.ru/");
        return this;
    }

    public ToolsPage goToToolsPage() {
        $x("//a[text() = 'Инвентарь']").click();
        return page(ToolsPage.class);
    }
}
