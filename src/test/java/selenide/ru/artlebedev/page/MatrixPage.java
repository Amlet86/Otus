package selenide.ru.artlebedev.page;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MatrixPage {

    public MatrixPage inputSearch(String search) {
        $(".input").setValue(search).pressEnter();
        return this;
    }

    public MatrixPage checkResult(String search) {
        $$(".col-6").contains(search);
        return this;
    }
}
