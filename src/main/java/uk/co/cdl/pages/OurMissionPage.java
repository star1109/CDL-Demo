package uk.co.cdl.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import uk.co.cdl.utility.Utility;

public class OurMissionPage extends Utility {
   // private static final Logger log = LogManager.getLogger(OurMissionPage.class.getName());

    public OurMissionPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyOurMissionPage() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.cdl.co.uk/about/our_mission.html";
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
