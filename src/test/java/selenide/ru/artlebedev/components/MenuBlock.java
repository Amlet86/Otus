package selenide.ru.artlebedev.components;

import com.codeborne.selenide.ElementsContainer;

import static com.codeborne.selenide.Selenide.$x;

public class MenuBlock extends ElementsContainer {

    public void goToToolsPage() {
        $x("//a[text() = 'Инвентарь']").click();
    }
}
