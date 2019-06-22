package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.HomePage;
import utils.RandomData;


public class SignUpTest extends BaseTest {

    @Test()
    public void successfulSignupTest(){
        final String confirmationMessage = "Enter the code from your email";

        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.fillFirstName(RandomData.generateFirstName());
        homePage.fillLastName(RandomData.generateLastName());
        homePage.fillEmail(RandomData.generateEmail());
        homePage.fillPassword(RandomData.generatePassword());

        String[] dobValues = RandomData.generateDOBvalues(1990,2000);
        homePage.selectBirthDate(dobValues[0],dobValues[1],dobValues[2]);

        homePage.selectGender("Male");
       ConfirmationPage confirmationPage= homePage.clickSignUpButton();

       Assert.assertEquals(confirmationPage.getheaderText(),confirmationMessage);

    }

    @Test
    public void failedSignupTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.fillFirstName(RandomData.generateFirstName());
        homePage.fillEmail(RandomData.generateEmail());

       homePage.clickSignUpButton();

       Assert.assertTrue(homePage.verifyLastnameFieldValidation(),"Error validation is displayed for missing lastname");

    }


}
