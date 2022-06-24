package pages;

import common.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static common.SeleniumDriver.getDriver;

public class googlePage {

    Utilities utilities=new Utilities(getDriver());


    WebDriver driver;
    public googlePage(WebDriver driver)
    {
        this.driver=getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@title='Search']")
    private WebElement type_googleSearch;

    public void googleSearch_Box() {
//        type_googleSearch.sendKeys("Narashima swamy");
//        utilities.waitUntilElementVisible(type_googleSearch, 30);
        utilities.typeStrValue(type_googleSearch, "Narashima swamy");
        System.out.println("Narashima swamy");
    }

}
