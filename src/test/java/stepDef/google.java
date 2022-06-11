package stepDef;

import common.SeleniumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class google {


    @Given("^Open browser and navigate to \"([^\"]*)\"$")
    public void open_browser_and_navigate_to_something(String strArg1) throws Throwable {
        SeleniumDriver.openPage(strArg1);
    }


    @Then("^Fail the test case$")
    public void fail_the_test_case() throws Throwable {
        WebElement a = SeleniumDriver.getDriver().findElement(By.xpath("//input[@name='Pavan']"));
        a.click();
    }
}
