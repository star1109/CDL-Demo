package uk.co.cdl;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import resources.extentreport.ExtentReportManager;
import uk.co.cdl.propertyreader.PropertyReader;
import uk.co.cdl.utility.Utility;

public class Hooks extends Utility {

    private static ExtentReports extent = ExtentReportManager.getExtentReport();
    private static ExtentTest test;

    @Before
    public void setUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    @After
    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()) {
//            String screenShotPath = Utility.getScreenshot(driver, scenario.getName().replace(" ", "_"));
//            try {
//                Reporter.addScreenCaptureFromPath(screenShotPath);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        closeBrowser();
        //extent.flush();
    }
}
