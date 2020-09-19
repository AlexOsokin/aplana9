package autotest.controls;

public class Field extends BaseWebElement{

    public Field(String xpath) {
        super(xpath);
    }

    public Field SetText(CharSequence... var1){
        Find();
        waitForElement(element);
        element.sendKeys(var1);
        return this;
    }
}
