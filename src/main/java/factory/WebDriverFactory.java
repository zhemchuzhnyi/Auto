package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;

public class WebDriverFactory {

    private  String browserName = System.getProperty("browser");

    public WebDriver getDriver() {
        switch (browserName.toLowerCase()) {
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                return new ChromeDriver();

            }
        }
        return null;
    }
}
