package tests;

//import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.util.HashMap;
import java.util.Map;


public class BaseTest {
    private final String URL = "https://www.facebook.com/";
    public WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser, ITestContext context) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("dom.webnotifications.enabled", false);
            System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");
            //System.setProperty("webdriver.gecko.driver", "/Users/ksure/Downloads/geckodriver/geckodriver.exe");
            driver = new FirefoxDriver(options);
        }
        else if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs=new HashMap<String,Object>();
            //1-Allow, 2-Block, 0-default
            prefs.put("profile.default_content_setting_values.notifications", 1);
            options.setExperimentalOption("prefs",prefs);
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
            //System.setProperty("webdriver.chrome.driver", "/Users/ksure/Downloads/chromedriver/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver(options);
        }
        context.setAttribute("WebDriver", driver);
    }


    @AfterTest
    public void tearDown() {
       driver.quit();
    }

}
