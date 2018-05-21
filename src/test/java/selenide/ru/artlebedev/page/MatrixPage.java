package selenide.ru.artlebedev.page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MatrixPage extends BasePage {

    public MatrixPage inputSearch(String search) {
        $(".input").setValue(search).pressEnter();
        return this;
    }

    public MatrixPage checkResult(String search) {
        $$(".col-6").contains(search);
        return this;
    }
}
