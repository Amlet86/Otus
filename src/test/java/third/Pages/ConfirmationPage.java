package third.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends AbstractPage{

    @FindBy(xpath = "//*[text()='Id']/following-sibling::*")
    private WebElement idAct;

    @FindBy(xpath = "//*[text()='Amount']/following-sibling::*")
    private WebElement currencyAct;

    @FindBy(xpath = "//*[text()='Card Number']/following-sibling::*")
    private WebElement cardNumberAct;

    @FindBy(xpath = "//*[text()='Date']/following-sibling::*")
    private WebElement dateAct;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getId(){
        return idAct.getText();
    }

    public String getCurrencyAct(){
        return currencyAct.getText();
    }

    public String getCardNumberAct(){
        return cardNumberAct.getText().replace("x", "");
    }

    public String getDateAct(){
        return dateAct.getText();
    }
}
