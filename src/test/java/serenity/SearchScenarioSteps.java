package serenity;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import serenity.pages.ResultPage;
import serenity.pages.SearchPage;

import static junit.framework.TestCase.assertTrue;

public class SearchScenarioSteps {

    SearchPage searchPage;
    ResultPage resultPage;

    @Given("user (?:opens|opened) the site")
    public void givenUserOpensTheSite() {
        searchPage.open();
    }

    @Given("user clicks input")
    public void givenUserClicksOnInput() {
        searchPage.clickOnInput();
    }

    @When("user search for '(.*)'")
    public void whenUserSearchesFor(String text) {
        searchPage.inputToSearchField(text);
    }

    @When("user cliks search")
    public void whenUserCliksOnSearch() {
        searchPage.clickOnSubmitButton();
    }

    @Then("user see list of results")
    public void thenUserSeeListOfResult() {
        assertTrue(resultPage.resultsAreDisplayed());
    }

    @Then("'(.*)' should be contained")
    public void thenResultsShouldBeDisplayed(String text) {
        if (resultPage.resultsIsContains(text))
            System.out.println("Good Sputnik!");
        System.out.println("Stupid Sputnik.");
    }
}
