import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewSeleniumTests {
    WebDriver driver;
    @BeforeEach
    void start() {
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/index.html");

    }

    @AfterEach
    void close() {
        driver.close();
    }

    @Test
    void openWebFormTest() {
        String xpath = "//a[@href = 'dropdown-menu.html']";
        WebElement dropDownButton = driver.findElement(By.xpath(xpath));
        dropDownButton.click();
        WebElement title = driver.findElement(By.xpath("//h1[@class = 'display-6']"));
        Assertions.assertEquals("Dropdown menu", title.getText());
    }


}
