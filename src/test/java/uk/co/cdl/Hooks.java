package uk.co.cdl;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import uk.co.cdl.propertyreader.PropertyReader;
import uk.co.cdl.utility.Utility;

public class Hooks extends Utility {


    @Before
    public void setUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
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
    }
}
