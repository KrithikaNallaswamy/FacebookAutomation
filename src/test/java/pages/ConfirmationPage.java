package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage extends BasePage {

    private final By headerTitleBy = By.cssSelector("h2[class='uiHeaderTitle']");


    public ConfirmationPage(WebDriver driver){
        super(driver);
    }

    public String getheaderText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerTitleBy));
        WebElement confirmationHeader = driver.findElement(headerTitleBy);
        return confirmationHeader.getText();
    }
}
