import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class MyFirstTest {
    private static WebDriver driver;
    private  final Logger logger = LogManager.getLogger(MyFirstTest.class);
    @BeforeAll
    static void beforeAll() {
        //только один раз выполнение
    }
    @BeforeEach
    void setUp() {
        System.out.println("сетап тестов");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Tag("auto")
    @DisplayName("Тест на авторизацию администратора")
    @Test
    void nameFor() {
        System.out.println("мой первый тест");
    }
    @Tag("auto2")
    @Test
    void name2() {
        System.out.println("мой первый тест2");
        driver.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.6.3");
        logger.warn("мы зашл  на мавен репозиторий");
    }
    @Tag("auto2")
    @ParameterizedTest
    @ValueSource(ints ={1,6,9})
    void name3(int arg) {
        System.out.println("мой первый тест2" +arg);
        //assertEquals(arg,9);
        boolean x=false;
        //assertEquals(arg,9);
        SoftAssertions soft = new SoftAssertions();
        assertTrue(x);
        soft.assertThat(arg);
        assertTrue(x);
    }
    @AfterEach
    void tearDown() {
        System.out.println("шаги завершения теста");
    }
    @AfterAll
    static void afterAll() {
        //один раз
    }
}