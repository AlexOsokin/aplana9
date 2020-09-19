package autotest.steps.pageSteps;

import autotest.pageFactory.PageFactory;
import cucumber.api.java.ru.Когда;
import org.openqa.selenium.Keys;

public class GoogleSteps extends PageFactory {
    @Когда("Вводим слово для поиска: \"(.*)\"")
    public void inputItemStep(String item){
        GoToPage("urlGoogle");
        ПоисковаяСтраницаGoogle.ввод.SetText(item, Keys.ENTER);
    }
}
