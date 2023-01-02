package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pages.CommanMethods.AbstractClass;




public class LandingPage extends AbstractClass {
    private final WebDriver driver;
    @FindBy(css = "span.action.more.button")
    WebElement ShopNowActionBtn;


    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // edit return type of EnterInSearch


    // edit return type of ClickOnShopNowActionBtn
    public void ClickOnShopNowActionBtn() {
        Click(ShopNowActionBtn);
    }



}
