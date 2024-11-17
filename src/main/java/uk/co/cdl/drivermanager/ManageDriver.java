package uk.co.cdl.drivermanager;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import uk.co.cdl.propertyreader.PropertyReader;

import java.time.Duration;
import java.util.logging.Logger;

public class ManageDriver {
    private static final Logger log = (Logger) LogManager.getLogger(ManageDriver.class.getName());
    public static WebDriver driver;
    public String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    public String secondsInString = PropertyReader.getInstance().getProperty("implicitlyWait");

    public long seconds = Long.parseLong(secondsInString);

    public ManageDriver() {

        PageFactory.initElements(driver, this);


        //PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/java/resources/propertiesfile/log4j2.properties");
    }

    public void selectBrowser(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--remote-allow-origins=*");
            log.info("Launching Chrome Browser");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();

            log.info("launching firefox browser");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            log.info("launching edge browser");
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        driver.get(baseUrl);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
