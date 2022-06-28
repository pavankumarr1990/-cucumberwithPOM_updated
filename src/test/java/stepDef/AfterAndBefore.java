package stepDef;

import common.SeleniumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AfterAndBefore{

    public String urls="";

    @Before
    public void setUp() {
        //ExtentCucumberFormatter.initiateExtentCucumberFormatter();
        System.out.println("Before");
        SeleniumDriver.setUpDriver();
    }


    @After
    public static void tearDown(Scenario scenario) {
        System.out.println("After");
        System.out.println("Pavan After");
        WebDriver driver = SeleniumDriver.getDriver();
        System.out.println(scenario.isFailed());
        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshotBytes, "image/png", scenario.getName());

            scenario.attach(screenshotBytes, "image/png", "image");

            System.out.println("Pavan After sceenshot");
        }
        System.out.println("TearDown");
        SeleniumDriver.tearDown();
    }






}

