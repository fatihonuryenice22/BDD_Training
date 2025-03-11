package stepDefinitions;

import Pages.HomePage;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class HomePageStepDefinitions {
    WebDriver driver= DriverFactory.getDriver();
    HomePage homePage=new HomePage(driver);
    private static final Logger logger = LogManager.getLogger(HomePageStepDefinitions.class);
    @Then("User validates we are the the home page")
    public void userValidatesWeAreTheTheHomePage() {
        homePage.UserValidatesWeAreAtTheDashboardPage();
        logger.info("Dashboard Validated");
    }
}
