package steps;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
