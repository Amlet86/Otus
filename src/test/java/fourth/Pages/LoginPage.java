package fourth.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(css = "#email")
    private WebElement emailFld;

    @FindBy(css = "#password")
    private WebElement passwordFld;

    @FindBy(css = ".btn")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        emailFld.sendKeys(email);
    }

    public void setPasswordFld(String password) {
        passwordFld.sendKeys(password);
    }

    public String getFontSize(){
        return loginBtn.getCssValue("font-size");
    }

    public String getPadding(){
        return loginBtn.getCssValue("padding");
    }

    public String getBackgroundColorLoginBtn (){
        return loginBtn.getCssValue("background-color");
    }

    public void moveMouseInLoginBtn(){
        Actions action = new Actions(driver);
        action.moveToElement(loginBtn).build().perform();
    }

    public void login() {
        loginBtn.click();
    }
}
