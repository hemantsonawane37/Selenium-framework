package tests.pages;

import liseners.Retry;
import org.openqa.selenium.WebDriver;
import org.pages.CreateAccountPage;
import org.pages.LandingPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testdata.TestData;

import java.io.IOException;
import java.util.HashMap;

import static basetest.BaseClass.*;

public class CreateUserAccountPage {

    WebDriver driver;
    TestData testData;

    @Test(dataProvider = "CreateAccountData", retryAnalyzer = Retry.class)
    public void CreateAccountWithPositiveData(HashMap<String, String> inputs) {
        LandingPage landingPage = LaunchApplication(driver);
        CreateAccountPage createAccountPage = landingPage.ClickOnCreateAnAccountLink();
        createAccountPage.EnterFirstName(inputs.get("firstname"));
        createAccountPage.EnterLastName(inputs.get("lastname"));
        createAccountPage.EnterEmail(inputs.get("email"));
        createAccountPage.EnterPassword(inputs.get("password"));
        createAccountPage.EnterConfirmPassword(inputs.get("confirmpassword"));
        String StrongPasswordMsg = createAccountPage.GetPasswordStrengthMsg();
        Assert.assertEquals(StrongPasswordMsg,inputs.get("confirmpasswordmessage"));
        createAccountPage.ClickOnCreateAccountButton();

    }

    @DataProvider(name = "CreateAccountData")
    public Object[][] CreateAccountData() throws IOException {
        this.testData = new TestData(GetPropertiesObjects().getProperty("TestDataPath"));
        HashMap<String, String> map = testData.getTestDataFromExcel(new String[]{"firstname", "lastname", "email", "password", "confirmpassword", "confirmpasswordmessage"});
        return new Object[][]{{map}};
    }

    @BeforeMethod()
    public void LaunchingBrowser() throws IOException {
        driver = launchBrowser();
    }

    @AfterMethod()
    public void Closing() {
        driver.quit();
    }


}
