package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends BasePage{

    private final String URL = "https://www.facebook.com/";
    private final By firstNameBy = By.name("firstname");
    private final By lastNameBy = By.name("lastname");
    private final By emailBy = By.name("reg_email__");
    private final By emailConfirmationBy = By.name("reg_email_confirmation__");
    private final By passwordBy = By.name("reg_passwd__");
    private final By dayBy = By.id("day");
    private final By monthBy = By.id("month");
    private final By yearBy = By.id("year");
    private final By signupButtonBy =By.cssSelector("button[name='websubmit']");
    private  final By loginButtonBy = By.id("loginbutton");
    private final By lastnameValdnMsgBy = By.cssSelector(".uiContextualLayer.uiContextualLayerBelowLeft");



   public HomePage(WebDriver driver){
        super(driver);
    }

    public void open() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonBy));
    }


    public void fillFirstName(String firstName) {
        driver.findElement(firstNameBy).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        driver.findElement(lastNameBy).sendKeys(lastName);
    }
    public void fillPassword(String password) {
        driver.findElement(passwordBy).sendKeys(password);
    }

    public void fillEmail(String emailID) {
        driver.findElement(emailBy).sendKeys(emailID);
        wait.until(ExpectedConditions.elementToBeClickable(emailConfirmationBy)).sendKeys(emailID);
    }


    public void selectBirthDate(String day, String monthNumber, String year){

        Select daySelect =  new Select(driver.findElement(dayBy));
        daySelect.selectByValue(day);

        Select monthSelect =  new Select(driver.findElement(monthBy));
        monthSelect.selectByValue(monthNumber);

        Select yearSelect =  new Select(driver.findElement(yearBy));
        yearSelect.selectByValue(year);
    }

    public void selectGender(String gender){
        switch (gender){
            case "Male":
                driver.findElement(By.cssSelector("input[value='1']")).click();
                break;
            case "Female":
                driver.findElement(By.cssSelector("input[value='0']")).click();
                break;
            default:
                driver.findElement(By.cssSelector("input[value='0']")).click();
                break;
        }

    }

    public ConfirmationPage clickSignUpButton(){
        driver.findElement(signupButtonBy).click();
        return new ConfirmationPage(this.driver);

    }

    public Boolean verifyLastnameFieldValidation(){
        WebElement childelement = driver.findElement(lastnameValdnMsgBy);
        WebElement parentItem = childelement.findElement(By.xpath(".."));
        String classes = parentItem.getAttribute("class");
        if (classes.contains("hidden_elem")){
            return false; }
        else return true;
    }


}
