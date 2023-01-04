package basetest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.pages.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class BaseClass {

    static WebDriver driver;
    static Properties GlobalData;
    public static WebDriver launchBrowser() throws IOException {

       final String Chrome = "chrome";
       final String Edge = "edge";
        GlobalData = GetPropertiesObjects();
        String Browser = System.getProperty("Browser") != null ? System.getProperty("Browser") : GlobalData.getProperty("Browser");
        Browser = Browser.trim();

        DesiredCapabilities caps = new DesiredCapabilities();


       if(Browser.equalsIgnoreCase(Chrome)){
           caps.setBrowserName(Browser);
               driver = new RemoteWebDriver(new URL("http://localhost:4444"),caps);

       } else if (Browser.equalsIgnoreCase(Edge)) {
           caps.setBrowserName(Edge);
           driver = new RemoteWebDriver(new URL("http://localhost:4444"),caps);
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
