package selenide.ru.artlebedev;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenide.ru.artlebedev.page.MainPage;
import selenide.ru.artlebedev.page.MatrixPage;
import selenide.ru.artlebedev.page.ToolsPage;

public class HomeWork {

    String search = "селенид";

    @BeforeTest
    public void beforeTest() {
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void searchInMatrix() {
        MainPage mainPage = new MainPage();
        mainPage = mainPage.enterToMainPage();
        ToolsPage toolsPage = mainPage.goToToolsPage();
        MatrixPage matrixPage = toolsPage.chooseMatrixIdea();
        matrixPage.inputSearch(search);
        matrixPage.checkResult(search);
    }
}
