package autotest.controls;

public class Button extends BaseWebElement{

    public Button(String xpath) {
        super(xpath);
    }

    public Button Click(){
        Find();
        waitForClickableElement(element);
        element.click();
        return this;
    }
}
