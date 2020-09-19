package autotest.controls;

import autotest.util.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWebElement {

    String xpath;

    WebElement element;

    WebDriver driver;

    WebDriverWait wait;

    public BaseWebElement(String xpath){
        this.xpath = xpath;
        this.driver = Init.getDriver();
        wait = new WebDriverWait(driver, 15);
    }

    public void Find(){
        element = driver.findElement(By.xpath(xpath));
    }


    /*public <T> T GetCustomElement(String xPath){
        Class<T> clazz = null;
        if(clazz.getTypeName().equals(Button.class.getTypeName())){
            System.out.println("afd");
        }
        else if(clazz.getTypeName().equals(Field.class.getTypeName())){

        }
        else{
            throw new IllegalStateException("Нет элемента с данным типом" + clazz.getTypeName());
        }
        return null;
    }*/

    public WebElement waitForElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrollToElement(WebElement element){
        int elementPosition = element.getLocation().getY();
        String js = String.format("window.scroll(0, %s)", elementPosition);
        ((JavascriptExecutor)driver).executeScript(js);
    }
    public void waitForInvisibilityElement(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
