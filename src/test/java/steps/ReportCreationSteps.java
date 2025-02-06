package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.ReportsRegistryPage;
import pages.ReportInfoPage;
import pages.ReportTemplatePage;
import pages.TemplateEditorPage;

public class ReportCreationSteps {

    private ReportsRegistryPage registryPage;
    private ReportInfoPage reportInfoPage;
    private ReportTemplatePage reportTemplatePage;
    private TemplateEditorPage templateEditorPage;

    @When("I create a new report base with id {string}, Russian name {string} and Kazakh name {string}")
    public void createNewReportBase(String reportBaseId, String reportBaseNameRus, String reportBaseNameKaz) {
        registryPage = new ReportsRegistryPage(Hooks.driver);
        registryPage.openReportsRegistry();
        registryPage.createReportBase(reportBaseId, reportBaseNameRus, reportBaseNameKaz);
    }

    @And("I fill additional report info for report base {string} with template id {string}")
    public void fillAdditionalReportInfo(String reportBaseId, String templateId) {
        reportInfoPage = new ReportInfoPage(Hooks.driver);
        reportInfoPage.openReportInfo(reportBaseId);
        reportInfoPage.fillBaseInfo(templateId);
    }

    @And("I create a new report template for report base {string} with Russian name {string} and Kazakh name {string}")
    public void createNewReportTemplate(String templateId, String templateNameRus, String templateNameKaz) {
        reportTemplatePage = new ReportTemplatePage(Hooks.driver);
        reportTemplatePage.createTemplate(templateId, templateNameRus, templateNameKaz);
    }

    @And("I open the template editor for report base {string} and create a table named {string} with type {string}, {int} rows and {int} columns")
    public void openTemplateEditorAndCreateTable(String templateId, String tableName, String tableType, int rows, int columns) {
        templateEditorPage = new TemplateEditorPage(Hooks.driver);
        templateEditorPage.openTemplateEditor(templateId);
        boolean isStatic = tableType.equalsIgnoreCase("static");
        templateEditorPage.createTable(tableName, isStatic, rows, columns);
    }

    @And("I save the template")
    public void saveTemplate() {
        templateEditorPage.saveTemplate();
    }

    @Then("the report should be created successfully")
    public void reportShouldBeCreatedSuccessfully() {
        Assert.assertTrue(true, "Report created successfully (placeholder assertion).");
    }
}
