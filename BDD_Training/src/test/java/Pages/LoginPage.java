package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage {
    WebDriver driver;
    util.ElementHelper elementHelper;
    WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver= driver;
        this.wait= new WebDriverWait(driver,10);
        this.elementHelper=new util.ElementHelper(driver);
    }
    By loginTitle = By.xpath("//h5[normalize-space()='Login']");
    By required=By.xpath("//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]");
    By required2=By.xpath("//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]");
    By usernameInputArea=By.xpath("//input[@placeholder='Username']");
    By passwordInputArea=By.xpath("//input[@placeholder='Password']");
    By error=By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
    public void verifyUserAtLoginPage() {
      //  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement title=driver.findElement(loginTitle);
        String titleText= title.getText();
        assertEquals(titleText,"Login");
    }
    public String getTitleValue(){
        WebElement title=driver.findElement(loginTitle);
        return title.getText();
    }

    public void clickToLogin(String login) {
        WebElement loginButton= driver.findElement(By.xpath("//button[normalize-space()='"+login+"']"));
        loginButton.click();
    }

    public void checkRequiredNotifications() {
        elementHelper.checkVisible(required);
        elementHelper.checkVisible(required2);
    }

    public void userWritesCredentials(String username, String password) {
        elementHelper.findElement(usernameInputArea).click();
        elementHelper.findElement(usernameInputArea).sendKeys(username);
        elementHelper.findElement(passwordInputArea).click();
        elementHelper.findElement(passwordInputArea).sendKeys(password);
    }
    public String getErrorMessage(){
        WebElement errormsg=driver.findElement(error);
        return errormsg.getText();
    }
}
