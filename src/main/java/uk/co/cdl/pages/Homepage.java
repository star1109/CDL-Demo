package uk.co.cdl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.cdl.utility.Utility;

public class Homepage extends Utility
{
  //  private static final Logger log = LogManager.getLogger(Homepage.class.getName());

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"hamburgericon\"]")
    WebElement menubar;

    @CacheLookup
    @FindBy(id = "hamburgermenu-about")
    WebElement aboutTab;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Our Mission')]")
    WebElement ourMissionTab;


    public void clickOnMenuBar()
    {
        //log.info("Clicking on Hamburger option");
        clickOnElement(menubar);
    }

    public void clickOnAboutTab()
    {
        clickOnElement(aboutTab);
    }

    public void clickOnOurMissionTab()
    {
        clickOnElement(ourMissionTab);

    }

}
