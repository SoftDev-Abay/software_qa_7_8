package steps;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Hooks {
    // Declare a static driver variable so that all step definitions can access it.
    public static WebDriver driver;

    @Before
    public void setUp() {
        // Initialize the driver before each scenario using your DriverFactory.
        driver = DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
        // Quit the driver after each scenario.
        if (driver != null) {
            driver.quit();
        }
    }
}
