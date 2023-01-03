package basetest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.pages.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    static WebDriver driver;
    static Properties GlobalData;

    public static WebDriver launchBrowser() throws IOException {


        GlobalData = GetPropertiesObjects();
        String Browser = System.getProperty("Browser") != null ? System.getProperty("Browser") : GlobalData.getProperty("Browser");

        switch (Browser.trim()) {
            case "Chrome":
            case "chrome":
                ChromeOptions chromeoptions = new ChromeOptions();
                chromeoptions.setPlatformName("Windows 10");
                chromeoptions.setBrowserVersion("107");
                driver = new ChromeDriver(chromeoptions);
                break;
            case "Edge":
            case "edge":
                EdgeOptions edgeOptionsoptions = new EdgeOptions();
                edgeOptionsoptions.setPlatformName("Windows 10");
                edgeOptionsoptions.setBrowserVersion("107.0.1418.42");
                driver = new EdgeDriver(edgeOptionsoptions);
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static LandingPage LaunchApplication(WebDriver driver) {
        driver.get(GlobalData.getProperty("URL"));
        return new LandingPage(driver);
    }

    public static Properties GetPropertiesObjects() throws IOException {

        String PropertiesFilepath = "/src/test/java/properties/GLOBALDATA.properties";
        Properties prop = new Properties();
        FileInputStream globeldata = new FileInputStream(System.getProperty("user.dir") + PropertiesFilepath);
        prop.load(globeldata);
        return prop;

    }

    public static void TakeScreenShot(String path) throws IOException {
        TakesScreenshot SS = (TakesScreenshot) driver;
        File screenshotfile = SS.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotfile, new File(System.getProperty("user.dir") + "/src/test/java/reports/screenshots/" + path));
    }


}
