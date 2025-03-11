package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    static WebDriver driver;
    static Properties properties;

    public static WebDriver initialize_Driver(String browser) {
        properties = ConfigReader.getProperties();

        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();  // En güncel ChromeDriver’ı indirir
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Geçersiz tarayıcı: " + browser + ". Desteklenen tarayıcılar: Chrome, Firefox, Edge.");
        }

        // URL ve zaman aşımı sürelerini yükleme
        String url = properties.getProperty("url");
        int impWait = Integer.parseInt(properties.getProperty("implicityWait", "10")); // Default 10 sn
        int pageWait = Integer.parseInt(properties.getProperty("pageLoadTimeout", "20")); // Default 20 sn

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
