package autotest.pageFactory.pages;

import autotest.controls.Button;
import autotest.controls.Field;

public final class OzonMainPage {

    public static Field ввод = new Field("//input[@placeholder ='Искать на Ozon']");

    //public Field диапазонДо = new Field("//div[contains(text(), 'Цена')]/..//input[contains(@qa-id, 'range-to')]", driver);

    public static Button найти = new Button("//button[@type='submit']");
    /*@FindBy(xpath = "//input[@placeholder ='Искать на Ozon']")
    public WebElement input;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;*/
}
