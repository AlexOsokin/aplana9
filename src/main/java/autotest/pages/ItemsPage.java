package autotest.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ItemsPage extends BasePage {

    @FindBy(xpath = "//input[@data-test-id='range-filter-to-input']")
    private WebElement rangeFilterTo;

    @FindBy(xpath = "//label/span[@class='label-text']")
    private List<WebElement> labels;

    @FindBy(xpath = "//span[@data-test-id='filter-block-brand-show-all']")
    private WebElement allBrand;

    @FindBy(xpath = "//div[@class='input-wrap search-input']/input")
    private WebElement inputBrand;

    @FindBy(xpath = "//button[@class='search-button button default small flat-button']")
    private WebElement addBrand;

    @FindBy(xpath = "//button[@aria-label='Закрыть сообщение']")
    private WebElement closeAriaLabel;

    @FindBy(xpath = "//div[@class='f38c9b _458d39']/div/div/div/button")
    private List<WebElement> busketButtons;

    @FindBy(xpath = "//a[@href='/cart']")
    private WebElement busket;

    @FindBy(xpath = "//div[@class='filter m-range']/div[@class='title']")
    private WebElement scrollToPrice;

    private boolean checkCloseAriaLabel = false;

    public void inputRangeFilterTo(String rangeTo) {
        waitForElement(rangeFilterTo);
        rangeFilterTo.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), rangeTo);
    }

    public void clickCheckBox(String item) {
        String url = getCurrentUrl();
        for (WebElement label : labels) {
            waitForElement(label);
            if (label.getText().contains(item)) {
                waitForClickableElement(label);
                label.click();
                while (true) {
                    if (!getCurrentUrl().equals(url)) {
                        clickCloseAriaLabel();
                        return;
                    }
                }
            }
        }
        Assert.fail(String.format("Пунк %s не найден", item));
    }

    public void brandShowAll(){

        waitForElement(allBrand);
        waitForElement(scrollToPrice);
        scrollToElement(scrollToPrice);
        waitForElement(allBrand);
        waitForClickableElement(allBrand);
        allBrand.click();
        waitForInvisibilityElement(labels.get(5));
        waitForElement(inputBrand);
        waitForClickableElement(inputBrand);
        inputBrand.click();
    }

    public void brandClick(String item){
        inputBrand.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), item);
        String url = getCurrentUrl();
        waitForElement(addBrand);
        addBrand.click();
        while (true) {
            if (!getCurrentUrl().equals(url)) {
                return;
            }
        }
    }

    public List<String> inputInBusket(boolean parity) {
        List<String> items = new ArrayList<>();
        List<WebElement> webElements = new ArrayList<>();
        for (int i = 0; i < busketButtons.size(); i++) {
            if (parity && i % 2 != 0) {
                WebElement elementButton = busketButtons.get(i);
                webElements.add(elementButton);
                items.add(itemGetText(elementButton));
                if(i == 16){
                    break;
                }
            }
            if (!parity && i % 2 == 0) {
                WebElement elementButton = busketButtons.get(i);
                webElements.add(elementButton);
                items.add(itemGetText(elementButton));
                if(i == 15){
                    break;
                }
            }
        }
        for (WebElement elementButton : webElements){
            waitForClickableElement(elementButton);
            elementButton.click();
        }
        return items;
    }

    public void clickBusket() {
       waitForElement(busket);
       busket.click();
    }


    private String itemGetText(WebElement elementButton) {
        WebElement element = elementButton.findElement(By.xpath(".//parent::div/parent::div/parent::div/parent::div"));
        waitForElement(element);
        return element.findElement(By.xpath(".//div/div/span[@data-test-id='tile-name']")).getText();
    }


    private void clickCloseAriaLabel(){
        if(!checkCloseAriaLabel){
            waitForClickableElement(closeAriaLabel);
            closeAriaLabel.click();
            checkCloseAriaLabel = true;
        }

    }
}
