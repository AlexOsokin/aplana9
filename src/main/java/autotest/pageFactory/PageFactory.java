package autotest.pageFactory;

import autotest.pageFactory.annotations.PageAnnotation;
import autotest.pageFactory.pages.GoogleMainPage;
import autotest.pageFactory.pages.OzonItemsPage;
import autotest.pageFactory.pages.OzonMainPage;
import autotest.util.Init;
import autotest.util.TestProperties;

public abstract class PageFactory {
    //public List<BasePage> pages = new ArrayList<>();

    @PageAnnotation(name = "Главная страница")
    public OzonMainPage ГлавнаяСтраницаОзон;

    @PageAnnotation(name = "Товары")
    public OzonItemsPage ТоварыОзон;

    @PageAnnotation(name = "Главная страница Google")
    public GoogleMainPage ПоисковаяСтраницаGoogle;

    protected void GoToPage(String page){
        Init.getDriver().get(TestProperties.getInstance().getProperty(page));
    }

    /*public <T> void Init(T page){
        if(page..getTypeName().equals(MainPage.class.getTypeName())){
            ГлавнаяСтраница = new MainPage();
        }
        else if(page.getTypeName().equals(ItemsPage.class.getTypeName())){
            Товары = new ItemsPage();
        }
        else{
            throw new IllegalStateException("Нет страницы с данным типом" + page.getClass().getTypeName());
        }
    }

    /*public Class<? extends BasePage> GetPage(String name) {
        Field[] fields = PageFactory.class.getFields();
        for(Field field : fields) {
            PageAnnotation pageAnnotation = field.getAnnotation(PageAnnotation.class);
            if(pageAnnotation.name().contains(name)){
                return (Class<? extends BasePage>) field.getType();
            }
        }
        Assert.fail("Страница не найдена");
        return null;
    }*/
    /*public PageFactory(){
        Initialize();
    }

    private void Initialize(){
        pages.add(new MainPage());
        pages.add(new ItemsPage());
    }

    public BasePage GetPage(String name) {
        return (BasePage) pages.stream().filter(basePage -> basePage.name.contains(name));
    }*/
}
