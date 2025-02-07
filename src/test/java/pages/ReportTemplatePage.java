// ReportTemplatePAge

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DropdownUtils;

public class ReportTemplatePage extends BasePage {

    private final By REPORT_TEMPLATE_TAB = By.xpath("//*[@id='root']/div/div[1]/div[3]/div/div/div[1]/div[2]");
    private final By REPORT_SUBMISSIONS_PERIOD_TAB = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div/div/div[1]/div[3]");

    private final By CREATE_TEMPLATE_BUTTON = By.xpath("//*[@id='root']/div/div[1]/div[3]/div/div/div[2]/div/button");
    private final By CREATE_SUBMISSIONS_PERIOD_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div/div/div[2]/div/button");

    private final By TEMPLATE_ID_INPUT       = By.xpath("//*[@id='modal-root']/div/div/div[2]/div[1]/div[2]/input");
    private final By TEMPLATE_NAME_RUS_INPUT = By.xpath("//*[@id='modal-root']/div/div/div[2]/div[2]/div[2]/input");
    private final By TEMPLATE_NAME_KAZ_INPUT = By.xpath("//*[@id='modal-root']/div/div/div[2]/div[3]/div[2]/input");
    private final By TEMPLATE_SUBMIT_BUTTON  = By.xpath("/html/body/div[2]/div/div/div[3]/button[1]");


    private final By TEMPLATE_SUBMISSION_PERIOD_SUBMIT_BUTTON  = By.xpath("//*[@id=\"modal-root\"]/div/div/div[3]/button[1]");


    private final String DROPDOWN_1_XPATH  = "//*[@id=\"modal-root\"]/div/div/div[2]/div[1]/div[2]/div/div/div";
    private final String PARENT_SUBMISSIONS_PERIOD  = "//*[@id=\":r9:\"]";






    public ReportTemplatePage(WebDriver driver) {
        super(driver);
    }

    public void openReportTemplatePage(String reportBaseId) {
        String url = "https://esep.govtec.kz/admin/reports/info/" + reportBaseId;

        openUrl(url);
    }


    public void createTemplate(String templateId, String templateNameRus, String templateNameKaz) {
        clickElement(REPORT_TEMPLATE_TAB);
        clickElement(CREATE_TEMPLATE_BUTTON);

        enterText(TEMPLATE_ID_INPUT, templateId);
        enterText(TEMPLATE_NAME_RUS_INPUT, templateNameRus);
        enterText(TEMPLATE_NAME_KAZ_INPUT, templateNameKaz);

        clickElement(TEMPLATE_SUBMIT_BUTTON);

    }

    public void createSubmissionPeriod(String period, String templateNameRus, String start, String end ) {
        clickElement(REPORT_SUBMISSIONS_PERIOD_TAB);
        clickElement(CREATE_SUBMISSIONS_PERIOD_BUTTON);


//        DropdownUtils.selectDropdownOption(driver, DROPDOWN_1_XPATH, PARENT_SUBMISSIONS_PERIOD,
//                period);

        clickElement(TEMPLATE_SUBMISSION_PERIOD_SUBMIT_BUTTON);

    }
}
