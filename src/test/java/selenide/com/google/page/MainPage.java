package selenide.com.google.page;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public MainPage enterToMainPage() {
        open("https://www.google.com/");
        return this;
    }

    public ResultPage inputSearch(String search) {
        $("[name='q']").setValue(search).pressEnter();
        return page(ResultPage.class);
    }
}
