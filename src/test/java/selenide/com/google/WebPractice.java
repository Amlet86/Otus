package selenide.com.google;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenide.com.google.page.MainPage;
import selenide.com.google.page.ResultPage;

public class WebPractice {

    private String search = "selenide";
    private byte size = 6;

    @BeforeTest
    public void beforeTest() {
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void searchInGoogle() {
        MainPage mainPage = new MainPage();
        mainPage = mainPage.enterToMainPage();
        ResultPage resultPage = mainPage.inputSearch(search);
        resultPage.checkSizeResult(size);
        resultPage.checkContainsText(search);
    }
}
