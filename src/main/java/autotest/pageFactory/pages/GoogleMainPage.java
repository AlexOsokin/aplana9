package autotest.pageFactory.pages;

import autotest.controls.Button;
import autotest.controls.Field;

public class GoogleMainPage {
    public static Field ввод = new Field("//input[@name = 'q']");

    public static Button найти = new Button("//button[@type='submit']");
}
