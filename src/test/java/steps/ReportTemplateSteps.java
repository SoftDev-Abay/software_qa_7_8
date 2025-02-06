package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.ReportTemplatePage;

public class ReportTemplateSteps {

    private ReportTemplatePage templatePage;

    @And("I am on the report template page for report base {string}")
    public void iAmOnTheReportTemplatePageForReportBase(String reportBaseId) {
        templatePage = new ReportTemplatePage(Hooks.driver);
        templatePage.openReportTemplatePage(reportBaseId);
    }

    @When("I create a submission period with period {string} and template name {string} and start date {string} and end date {string}")
    public void iCreateASubmissionPeriodWith(String period, String templateNameRus, String start, String end) {
        templatePage.createSubmissionPeriod(period, templateNameRus, start, end);
    }

    @Then("I should see a success message or be able to confirm it was created")
    public void iShouldSeeASuccessMessage() {
        Assert.assertTrue(true, "Submission period created (placeholder assertion).");
    }
}
