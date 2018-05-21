package selenide.ru.artlebedev;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static selenide.ru.artlebedev.page.MainPage.enterToMainPage;

public class HomeWork {

    String search = "селенид";

    @BeforeTest
    public void beforeTest() {
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void searchInMatrix() {
        enterToMainPage()
                .goToToolsPage()
                .chooseMatrixIdea()
                .inputSearch(search)
                .checkResult(search);
    }
}
