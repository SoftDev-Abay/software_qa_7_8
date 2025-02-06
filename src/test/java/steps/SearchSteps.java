package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;
import pages.ReportsRegistryPage;

import java.util.List;

public class SearchSteps {

    private ReportsRegistryPage registryPage;
    private List<List<String>> searchResults;

    @Given("I am logged in as {string} with password {string}")
    public void iAmLoggedIn(String username, String password) {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.login(username, password, "https://esep.govtec.kz/admin");
        registryPage = new ReportsRegistryPage(Hooks.driver);
    }

    @When("I search for {string} in column {int}")
    public void iSearchForValueInColumn(String searchValue, int columnIndex) {
        searchResults = registryPage.searchInRegistry(searchValue, columnIndex);
    }

    @Then("I should see the code {string} with title {string}")
    public void iShouldSeeCodeAndTitle(String expectedCode, String expectedTitle) {
        boolean found = false;
        if (searchResults != null) {
            for (List<String> row : searchResults) {
                if (row.size() >= 2 && row.get(0).equals(expectedCode) && row.get(1).equals(expectedTitle)) {
                    found = true;
                    break;
                }
            }
        }
        Assert.assertTrue(found, "Expected row " + expectedCode + ", " + expectedTitle + " not found in results!");
    }
}
