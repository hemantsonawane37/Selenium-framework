package org.pages.CommanMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.CreateAccountPage;

import java.time.Duration;

public class AbstractClass {
    private final WebDriver driver;
    @FindBy(css = "#ui-id-4 span:nth-child(2)")
    public WebElement Womencategory;
    @FindBy(xpath = "//header//a[contains(text(),\"Sign In\")]")
    public WebElement SignInLink;
    @FindBy(xpath = "//header//a[text()=\"Create an Account\"]")
    public WebElement createanaccount;
    @FindBy(css = "header .greet.welcome span")
    public WebElement welcomegreeting;
    @FindBy(id = "search")
    public WebElement SearchInput;
    @FindBy(css = ".navigation .nav-1 a")
    public WebElement WhatsNewLink;
    @FindBy(css = "#ui-id-5 span:nth-child(2)")
    public WebElement mencategorylink;
    @FindBy(css = "#ui-id-6 span:nth-child(2)")
    public WebElement gears;
    @FindBy(css = "#ui-id-7 span:nth-child(2)")
    public WebElement Treaning;
    @FindBy(css = "#ui-id-8 span")
    public WebElement Salelink;
    @FindBy(css = "a.logo")
    public WebElement logo;
    @FindBy(css = "a.action.showcart")
    protected WebElement cartbutton;
    @FindBy(css = ".panel.header ul li[class='greet welcome']")
    WebElement greetingMessage;

    public AbstractClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    protected void Click(WebElement element) {
        element.click();
    }
    protected void EnterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void ClickOnSignInLink() {
        Click(SignInLink);
    }

    public void EnterInSearch(String text) {
        EnterText(SearchInput, text);
        SearchInput.sendKeys(Keys.ENTER);
    }

    public void ClickOnLogo() {
        Click(logo);
    }

    public void ScrollTo(String x,String y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo("+x+","+"1000)");
    }
    public String GetText(WebElement element){
      return element.getText().trim();
    }

    public void ClickOnCartBtn() {
        Click(cartbutton);
    }

    public CreateAccountPage ClickOnCreateAnAccountLink() {
        Click(createanaccount);
        return new CreateAccountPage(driver);
    }

    public void ClickOnWhatsNew() {
        Click(WhatsNewLink);
    }

    public void ClickOnWomenCategory() {
        Click(Womencategory);
    }

    public void ClickOnMenCategory() {
        Click(mencategorylink);
    }
    public void ClickOnGear() {
        Click(gears);
    }
    public void ClickOnTreaning() {
        Click(Treaning);
    }
    public void ClickonSale() {
        Click(Salelink);
    }
    public WebElement WaitForVisibility(WebElement element, Duration duration) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public String getGreetingMessage(){
       return GetText(greetingMessage);
    }


}
