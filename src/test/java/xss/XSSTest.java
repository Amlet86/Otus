package xss;

import org.testng.annotations.Test;

import static xss.Page.MainPage.enterToMainPage;

public class XSSTest extends BaseTest {

    @Test()
    public void xssGame() {
        enterToMainPage()
            .goToFirstLevel()
            .inputScriptForFirstPage(getCheatSheetAlert())
            .acceptAlert()
            .goToSecondLevel()
            .inputScriptForSecondPage(getCheatSheetAlert())
            .acceptAlert()
            .goToThirdLevel()
            .inputScriptForThirdPage(getCheatSheetAlert())
            .acceptAlert()
            .goToFourthLevel();

    }

}
