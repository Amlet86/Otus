package serenity.com.pipl.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://pipl.com")
public class SearchPage extends PageObject {

    @FindBy(name = "q")
    WebElementFacade searchInput;

    @FindBy(css = ".btn-search")
    WebElementFacade searchButton;

    public void search(String text) {
        searchInput.type(text);
        $(".btn-search").click();
    }

    public void inputToSearchField(String text) {
        searchInput.type(text);
    }

    public void clickOnInput(){
        searchInput.click();
    }

    public void clickOnSubmitButton() {
        searchButton.click();
    }


}
