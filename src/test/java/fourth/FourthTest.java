package fourth;

import fourth.Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class FourthTest extends BaseTest {

    @Test
    public void test() {
        LoginPage page = new LoginPage(driver);
        String colorBefor = page.getBackgroundColorLoginBtn();
        page.moveMouseInLoginBtn();

    }
}
