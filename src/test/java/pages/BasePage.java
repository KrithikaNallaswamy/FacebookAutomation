package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,20);
        }

    public String url() {
        return this.driver.getCurrentUrl();
    }

    public String title() {
        return this.driver.getTitle();
    }

}

