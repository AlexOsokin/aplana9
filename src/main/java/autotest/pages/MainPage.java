package autotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage{

    @FindBy(xpath = "//input[@placeholder ='Искать на Ozon']")
    private WebElement input;

    @FindBy(xpath = "//div[@class='clear']")
    private WebElement clear;

    @FindBy(xpath = "//div[@class='search-button-wrap']/button")
    private WebElement searchButton;

    public void inputItem(String stringItem){
        waitForElement(input);
        input.sendKeys(stringItem);
        waitForElement(clear);
    }

    public void clickSearchButton(){
        waitForClickableElement(searchButton);
        searchButton.click();
    }

}
