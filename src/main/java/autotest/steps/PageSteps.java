package autotest.steps;


import autotest.pages.BasePage;
import autotest.pages.BusketPage;
import autotest.pages.ItemsPage;
import autotest.pages.MainPage;
import autotest.util.Busket;
import cucumber.api.java.mn.Харин;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import java.util.List;

public class PageSteps {
    MainPage mainPage = new MainPage();
    ItemsPage itemsPage = new ItemsPage();
    BusketPage busketPage = new BusketPage();
    List<String> items;

    @Когда("Вводим товар для поиска: \"(.*)\"")
    public void inputItemStep(String item){
        mainPage.inputItem(item);
    }

    @Тогда("Нажимаем кнопку поиска")
    public void clickSearchButtonStep(){
        mainPage.clickSearchButton();
    }

    @Когда("Ограничиваем цену до: \"(.*)\"")
    public void inputRangeFilterToStep(String item){
        itemsPage.inputRangeFilterTo(item);
    }

    @Когда("Кликаем на чекбокс: \"(.*)\"")
    public void clickCheckBoxStep(String item){
        itemsPage.clickCheckBox(item);
    }

    @Когда("Откроем все бренды")
    public void  brandShowAllStep(){
        itemsPage.brandShowAll();
    }

    @Когда("Ищем по всем значениям бренда: \"(.*)\"")
    public void  brandShowAllStep(String item){
        itemsPage.brandClick(item);
    }



    @Тогда("Выбираем товары с четностью: \"(.*)\"")
    public void inputInBusketStep(String item){
        boolean parity;
        if(item.equalsIgnoreCase("четные")){
            parity = true;
        }
        else{
            parity = false;
        }
        items = itemsPage.inputInBusket(parity);
        for (String it : items){
            System.out.println(it);
        }
    }

    @Когда("Кликаем на корзину")
    public void clickBusketStep(){
        itemsPage.clickBusket();
    }
    @Тогда("Преверяем товары в корзине")
    public void checkItemsStep(){
        busketPage.checkItems(items);
    }
    @Тогда("Проверка: Ваша корзина - \"(.*)\"")
    public void checkTotalItemsStep(String totalItems){
        busketPage.checkTotalItems(totalItems);
    }
    @Когда("Выполняем действие: \"(.*)\"")
    public void busketActionStep(String аctionItem){
        busketPage.busketAction(аctionItem);
    }
    @Тогда("Проверка, что страница содержит эелемент: \"(.*)\"")
    public void checkTitleStep(String item){
        busketPage.checkTitle(item);
    }
    @Тогда("Приложить файл отчет")
    public void attachmentStep(){
        Busket busket = new Busket();
        saveTextLog("Busket contents", busket.toString() + " Товар с максимальной ценой: " + busket.getMaxPrice());

    }
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String attachName, String message) {
        return message;
    }
}
