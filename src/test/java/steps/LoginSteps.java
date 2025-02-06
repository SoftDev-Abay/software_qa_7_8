package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage = new LoginPage(Hooks.driver);
        loginPage.openLoginPage();
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithCredentials(String username, String password) {
        loginPage.login(username, password, "https://esep.govtec.kz/admin");
    }

    @Then("I should be redirected to {string}")
    public void iShouldBeRedirected(String expectedUrl) {
        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "Login failed or unexpected redirect. Current URL: " + currentUrl);
    }
}
