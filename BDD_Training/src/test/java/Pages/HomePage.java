package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    util.ElementHelper elementHelper;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver= driver;
        this.wait= new WebDriverWait(driver,10);
        this.elementHelper=new util.ElementHelper(driver);
    }
    By dashboard=By.xpath("//h6[normalize-space()='Dashboard']");

    public void UserValidatesWeAreAtTheDashboardPage() {
        elementHelper.checkVisible(dashboard);
    }
}
