import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestPractice {
    // Добавляем поле для WebDriver, чтобы использовать его в тестах
    private WebDriver driver;

    @BeforeAll
    public static void webDriverInstall() {
        // Устанавливаем драйвер для Chrome
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void webDriverStart() {
        // Создаем опции для Chrome
        ChromeOptions options = new ChromeOptions();
        // Раскомментируйте строку ниже, если хотите запускать браузер в headless-режиме
        // options.addArguments("--headless");

        // Инициализируем WebDriver
        driver = new ChromeDriver(options);

        // Устанавливаем таймауты
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Выводим значения таймаутов для проверки
        System.out.println("Implicit Wait Timeout: " + driver.manage().timeouts().getImplicitWaitTimeout());
        System.out.println("Script Timeout: " + driver.manage().timeouts().getScriptTimeout());
        System.out.println("Page Load Timeout: " + driver.manage().timeouts().getPageLoadTimeout());

        // Открываем страницу
        driver.get("https://otus.home.kartushin.su/training.html");
    }

    @AfterEach
    public void webDriverStop() {
        // Проверяем, что драйвер не равен null перед закрытием
        if (driver != null) {
            driver.quit(); // Закрываем браузер и все связанные с ним процессы
        }
    }
}