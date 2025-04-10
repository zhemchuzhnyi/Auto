import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class OtusAutorizationTest {
    WebDriver driver;

    @BeforeClass
    public  void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public  void startDriver() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @Test
    public void fill() {
        driver.get("https://otus.home.kartushin.su/training.html");
        WebElement label = driver.findElement(By.id("textInput"));
        label.sendKeys("test");
        label.clear();
        label.sendKeys("test22");

       // driver.findElement(By.id("textInput")).sendKeys("test");
       // driver.findElement(By.id("textInput")).clear();

        driver.findElement(By.id("textInput")).sendKeys("test");
        List<WebElement> elements = driver.findElements(By.xpath("//html/body/div/div[1]/label"));
        System.out.println(elements.size() + "- количество найденных элементов");

        String text = label.getText();
        System.out.println(text + "текст в лейбле");

        String text2 = label.getAttribute("value");
        System.out.println(text2 + " Текст в лейбле новый способ");

        String x = label.getCssValue("padding");
        System.out.println(x + " размер элемента");
    }

    @Test
    public void fill2() {


    }

}
