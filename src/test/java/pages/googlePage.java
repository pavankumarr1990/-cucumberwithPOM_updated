package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static common.SeleniumDriver.getDriver;

public class googlePage {
    WebDriver driver;
    public googlePage(WebDriver driver)
    {
        this.driver=getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@title='Search']")
    private WebElement googleSearch;

    public void googleSearch_Box() {
        googleSearch.sendKeys("Narashima swamy");
    }

}
