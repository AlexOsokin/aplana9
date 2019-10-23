package autotest.pages;

import autotest.util.Busket;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.TreeMap;

public class BusketPage extends BasePage{
    @FindBy(xpath = "//a[@class='title']/span")
    private List<WebElement> busketItemsText;

    @FindBy(xpath = "//div[@style='font-size: 15px; color: rgb(0, 26, 52); font-weight: bold;']/span")
    private List<WebElement> busketItemsPrice;

    @FindBy(xpath = "//span[@class='total-middle-header-text']")
    private WebElement totalItems;

    @FindBy(xpath = "//div[@class='item-buttons']/span")
    private List<WebElement> actions;

    @FindBy(xpath = "//button[@data-test-id='checkcart-confirm-modal-confirm-button']")
    private WebElement delete;

    @FindBy(xpath = "//h1")
    private WebElement title;


    public void checkItems(List<String> stringItems){
        TreeMap<Integer,String> textPrice = new TreeMap<>();
        for (int i = 0; i < busketItemsText.size(); i++){
            WebElement itemText = busketItemsText.get(i);
            WebElement itemPrice = busketItemsPrice.get(i);
            waitForElement(itemText);
            waitForElement(itemPrice);
            for (String stringItem : stringItems){
                if(itemText.getText().equalsIgnoreCase(stringItem)){
                    System.out.println("Товар присутствует в корзине: " + stringItem);
                    String numberOnly = itemPrice.getText().replaceAll("[^0-9]", "");
                    //System.out.println(numberOnly + itemText.getText());
                    textPrice.put(Integer.parseInt(numberOnly), itemText.getText());
                }
            }
        }
        Busket.itemsWhitPrice = textPrice;
    }
    public void checkTotalItems(String stringItem){
        check(stringItem, totalItems);
    }
    public void busketAction(String stringAction){
        for (WebElement action : actions){
            waitForElement(action);
            if (action.getText().contains(stringAction)){
                waitForClickableElement(action);
                action.click();
                waitForElement(action);
                waitForElement(delete);
                delete.click();
                waitForInvisibilityElement(action);
            }
        }
    }
    public void checkTitle(String stringTitle){
        check(stringTitle, title);
    }
    private void check(String stringItem, WebElement item){
        waitForElement(item);
        if (item.getText().contains(stringItem)){
            System.out.println("Страница содержит элемент: "+ stringItem);
        }
    }
}