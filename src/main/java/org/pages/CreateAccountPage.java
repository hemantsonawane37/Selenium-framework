package org.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pages.CommanMethods.AbstractClass;

public class CreateAccountPage extends AbstractClass {
    private final WebDriver driver;
    @FindBy(css = "h1.page-title span")
    public WebElement PageTitle;
    @FindBy(xpath = "//legend//span[text()='Personal Information']")
    public WebElement personalinformationtitle;
    @FindBy(css = "input#firstname")
    WebElement firstnameinput;
    @FindBy(xpath = "//label[@for='firstname']")
    WebElement firstnamelabel;
    @FindBy(xpath = "//label[@for='lastname']")
    WebElement lastnamelabel;
    @FindBy(xpath = "//label[@for='email_address']")
    WebElement emaillabel;
    @FindBy(xpath = "//label[@for='password']")
    WebElement passwordlabel;
    @FindBy(xpath = "//label[@for='password-confirmation']")
    WebElement confirmpasswordlabel;
    @FindBy(css = "input#lastname")
    WebElement lastnameinput;
    @FindBy(xpath = "//label[@for='is_subscribed']")
    WebElement NewsletterCheckbox;
    @FindBy(xpath = "//legend//span[text()='Sign-in Information']")
    WebElement signininfotitle;
    @FindBy(css = "#email_address")
    WebElement emailinput;
    @FindBy(css = "input[id='password']")
    WebElement passwordinput;
    @FindBy(css = "input[id='password-confirmation']")
    WebElement confirmpasswordinput;

    @FindBy(css = "button[class='action submit primary'] span")
    WebElement createaccountbtn;

    @FindBy(css = "#firstname-error")
    WebElement firstnameerrormsg;
    @FindBy(css = "#lastname-error")
    WebElement lastnameerrormsg;
    @FindBy(id = "email_address-error")
    WebElement emailerrormsg;
    @FindBy(id = "password-error")
    WebElement passworderrormsg;
    @FindBy(id = "password-strength-meter-label")
    WebElement passwordstrengthmetermesg;
    @FindBy(id = "password-confirmation-error")
    WebElement passwordconfirmerrormsg;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String CheckPageTitle() {
        return GetText(PageTitle);
    }

    public void EnterEmail(String email) {
        EnterText(emailinput, email);
    }

    public String CheckPersonalInformationTitle() {
        return GetText(personalinformationtitle);
    }

    public void EnterFirstName(String fisrtname) {
        EnterText(firstnameinput, fisrtname);
    }

    public void EnterLastName(String lastname) {
        EnterText(lastnameinput, lastname);
    }

    public void ClickOnNewsletterCheckBox() {
        Click(NewsletterCheckbox);
    }

    public String SignInInfoTitle() {
        return signininfotitle.getText();
    }

    public void EnterPassword(String password) {
        EnterText(passwordinput, password);
    }

    public void EnterConfirmPassword(String confirmpassword) {
        EnterText(confirmpasswordinput, confirmpassword);
    }

    public LandingPage ClickOnCreateAccountButton() {
        Click(createaccountbtn);
        return new LandingPage(driver);
    }

    public String GetFirstNameLabelText() {
        return GetText(firstnamelabel)+GetStarOfLabel(firstnamelabel);
    }

    public String GetLastNameLabelText() {
        return GetText(lastnamelabel)+GetStarOfLabel(lastnamelabel);
    }

    private String GetStarOfLabel(WebElement element){
        JavascriptExecutor JS = (JavascriptExecutor)driver;
               return JS.executeScript("return window.getComputedStyle(arguments[0],'after').content;",element).toString();
    }

    public String GetEmailLabelText() {
        return GetText(emaillabel)+GetStarOfLabel(emaillabel);
    }

    public String GetPasswordLabelText() {
        return GetText(passwordlabel)+GetStarOfLabel(passwordlabel);
    }



    public String GetPasswordStrengthMsg(){
        return passwordstrengthmetermesg.isDisplayed() ? GetText(passwordstrengthmetermesg):"";
    }

    public String GetConfirmPasswordLabelText() {
        return GetText(confirmpasswordlabel)+GetStarOfLabel(confirmpasswordlabel);
    }

    public String GetPasswordErrorMsg(){
        return GetText(passworderrormsg);
    }
    public String GetEmailErrorMsg(){
        return  GetText(emailerrormsg);
    }
}
