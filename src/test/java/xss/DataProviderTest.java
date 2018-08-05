package xss;

import org.testng.annotations.Test;

import static xss.Page.MainPage.enterToMainPage;

public class DataProviderTest extends BaseTest {

    @Test()
    public void xssGame() {
        enterToMainPage()
            .goToFirstLevel()
            .tryInputScript(getCheatSheetAlert())
            .acceptAlert()
            .goToSecondLevel();
    }

}
