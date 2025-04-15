import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;
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
        // Раскомментировать строку ниже, если нужно запускать браузер в headless-режиме
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

    @Test
    public void test() {
        // Добавить Cookie#1 с параметром Otus1 и значением Value1
        driver.manage().addCookie(new Cookie("Otus1", "Value1"));

        // Добавить Cookie#3 с параметром Otus3 и значением Value3
        // (добавлять через переменную, переменная должна быть сохранена)

        Cookie cookie = new Cookie("Otus3", "Value3");
        driver.manage().addCookie(cookie);

        // Добавить Cookie#4 с параметром Otus4 и значением Value4
        driver.manage().addCookie(new Cookie("Otus4", "Value4"));

        // Вывести на экран все Cookies
        // System.out.println(driver.manage().getCookies());
        // Вывести на экран Cookie1
        System.out.println(driver.manage().getCookieNamed("Otus1"));

        // Удалить Cookie#2 по имени куки
        // driver.manage().deleteCookieNamed("Otus2");
        // System.out.println(driver.manage().getCookies());

        // Удалить Cookie#3 по переменной Cookie
        driver.manage().deleteCookie(cookie);
        System.out.println(driver.manage().getCookies());

        // Удалить все куки, убедиться что их нет
        driver.manage().deleteAllCookies();
        Assertions.assertEquals(0, driver.manage().getCookies().size());

    }
}