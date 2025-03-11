package stepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPageStepDefinitions {
    WebDriver driver= DriverFactory.getDriver();
    LoginPage loginPage=new LoginPage(driver);

    @Given("User at {string} Page")
    public void userAtLoginPage(String LoginTitle) {
        loginPage.verifyUserAtLoginPage();
        assertEquals(loginPage.getTitleValue(),LoginTitle);

    }

    @When("Clicks to {string} button")
    public void clicksToLoginButton(String login) {
        loginPage.clickToLogin(login);

    }

    @Then("Checks required notifications about username and pw")
    public void checksRequiredNotificationsAboutUsernameAndPw() {
        loginPage.checkRequiredNotifications();
    }




    @Then("Checks the Error Message")
    public void checksTheErrorMessage() {
        assertEquals(loginPage.getErrorMessage(),"Invalid credentials");
    }

    @When("User Writes the Username {string} and Pw {string}")
    public void userWritesTheUsernameAndPw(String username, String password) {
        loginPage.userWritesCredentials(username,password);

    }
}
