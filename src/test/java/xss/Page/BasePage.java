package xss.Page;

import static com.codeborne.selenide.Selenide.switchTo;

public class BasePage<T extends MainPage> {

    public void baseAcceptAlert() {
        switchTo().alert().accept();
        switchTo().defaultContent();
    }
}
