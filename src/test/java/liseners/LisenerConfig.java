package liseners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;

import static basetest.BaseClass.GetPropertiesObjects;

public class LisenerConfig {

    public static ExtentReports ReadyReport(String reportname, String doctitle, String testername) throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/reports/index.html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName(reportname);
        extentSparkReporter.config().setDocumentTitle(doctitle);
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("TesterName", testername);
        extentReports.setSystemInfo("Browser", GetPropertiesObjects().getProperty("Browser"));
        return extentReports;

    }
}
