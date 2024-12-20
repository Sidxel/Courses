import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocators {
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
    void openUrlTest() {
        Assertions.assertEquals("Hands-On Selenium WebDriver with Java", driver.getTitle());
    }


    @Test
    void cssSelectorsTest() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement textInputById = driver.findElement(By.cssSelector("#my-text-id"));
        textInputById.sendKeys("textInputById");
        Thread.sleep(1000);
        WebElement textInputByClass = driver.findElement(By.cssSelector(".form-control"));
        textInputByClass.sendKeys("textInputByClass");
        Thread.sleep(1000);
        WebElement textInputByName = driver.findElement(By.cssSelector("[name='my-textarea']"));
        textInputByName.sendKeys("textInputByName");
        Thread.sleep(1000);
        WebElement textDisableInputByName = driver.findElement(By.cssSelector("[name='my-disabled']"));
        textDisableInputByName.sendKeys("textDisableInputByName");
        Thread.sleep(1000);
        WebElement textReadonlyInputByName = driver.findElement(By.cssSelector("[name='my-readonly']"));
        textReadonlyInputByName.sendKeys("textReadonlyInputByName");
        Thread.sleep(1000);
        WebElement textIndexByName = driver.findElement(By.cssSelector("[name='./index.html']"));
        textIndexByName.sendKeys("textIndexByName");
        Thread.sleep(1000);
        WebElement dropdownByClass = driver.findElement(By.cssSelector(".form-select"));
        dropdownByClass.sendKeys("dropdownByClass");
        Thread.sleep(1000);
        WebElement fileByName = driver.findElement(By.cssSelector("[name='my-file']"));
        fileByName.sendKeys("fileByName");
        Thread.sleep(1000);
        WebElement check1ByTagAndId = driver.findElement(By.cssSelector("input#my-check-1"));
        check1ByTagAndId.sendKeys("check1ByTagAndId");
        Thread.sleep(1000);
        WebElement check2ByTagAndId = driver.findElement(By.cssSelector("input#my-check-2"));
        check2ByTagAndId.sendKeys("check2ByTagAndId");
        Thread.sleep(1000);
        WebElement radio1ByTagAndId = driver.findElement(By.cssSelector("input#my-radio-1"));
        radio1ByTagAndId.sendKeys("radio1ByTagAndId");
        Thread.sleep(1000);
        WebElement radio2ByTagAndId = driver.findElement(By.cssSelector("input#my-radio-2"));
        radio2ByTagAndId.sendKeys("radio2ByTagAndId");
        Thread.sleep(1000);
        WebElement formCheckLabelByNChild = driver.findElement(By.cssSelector("div.form-check label:nth-child(1)"));
        formCheckLabelByNChild.sendKeys("formCheckLabelByNChild");
        Thread.sleep(1000);
        WebElement formButtonByTagAndClass = driver.findElement(By.cssSelector("button.btn btn-outline-primary mt-3"));
        formButtonByTagAndClass.sendKeys("formButtonByTagAndClass");
        Thread.sleep(1000);
        WebElement colourByClassAndClass = driver.findElement(By.cssSelector(".form-control.form-control-color"));
        colourByClassAndClass.sendKeys("colourByClassAndClass");
        Thread.sleep(1000);
        WebElement dateFormByNChild = driver.findElement(By.cssSelector("div.nth-child(3) label:nth-child(2) input"));
        dateFormByNChild.sendKeys("dateFormByNChild");
        Thread.sleep(1000);
        WebElement formRangeByTagAndClass = driver.findElement(By.cssSelector("input.form-range"));
        formRangeByTagAndClass.sendKeys("formRangeByTagAndClass");
        Thread.sleep(1000);
    }
    @Test
    void xpathSelectorsTest() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement formControl1ByAttribute = driver.findElement(By.xpath("//*[@myprop='myvalue']"));
        formControl1ByAttribute.sendKeys("formControl1ByAttribute");
        Thread.sleep(1000);

        WebElement formControl2ByAttribute = driver.findElement(By.xpath("//*[@name='my-password']"));
        formControl2ByAttribute.sendKeys("formControl2ByAttribute");
        Thread.sleep(1000);

        WebElement formControl3ByAttribute = driver.findElement(By.xpath("//*[@name='my-textarea']"));
        formControl3ByAttribute.sendKeys("formControl3ByAttribute");
        Thread.sleep(1000);

        WebElement disabledFormByAttribute = driver.findElement(By.xpath("//*[@name='my-disabled']"));
        disabledFormByAttribute.sendKeys("disabledFormByAttribute");
        Thread.sleep(1000);

        WebElement readonlyFormByAttribute = driver.findElement(By.xpath("//*[@name='my-readonly']"));
        readonlyFormByAttribute.sendKeys("readonlyFormByAttribute");
        Thread.sleep(1000);

        WebElement indexByText = driver.findElement(By.xpath("//a[text()='Return to index']"));
        Assertions.assertEquals("Return to index", indexByText.getText());

        WebElement dropdownByAttribute = driver.findElement(By.xpath("//*[@name='my-select']"));
        dropdownByAttribute.sendKeys("dropdownByAttribute");
        Thread.sleep(1000);

        WebElement dropdown2ByAttribute = driver.findElement(By.xpath("//input[@name='my-datalist']"));
        dropdown2ByAttribute.sendKeys("dropdown2ByAttribute");
        Thread.sleep(1000);

        WebElement fileByChild = driver.findElement(By.xpath("//label/input[@name='my-file']"));
        fileByChild.sendKeys("fileByChild");
        Thread.sleep(1000);

        WebElement check1ByChild = driver.findElement(By.xpath("//label/input[@id='my-check-1']"));
        check1ByChild.click();
        Thread.sleep(1000);

        WebElement check2ByChild = driver.findElement(By.xpath("//label/input[@id='my-check-2']"));
        check2ByChild.click();
        Thread.sleep(1000);

        WebElement radio1ByChild = driver.findElement(By.xpath("//label/input[@id='my-radio-1']"));
        radio1ByChild.click();
        Thread.sleep(1000);

        WebElement radio2ByChild = driver.findElement(By.xpath("//label/input[@id='my-radio-2']"));
        radio2ByChild.click();
        Thread.sleep(1000);

        WebElement buttonByAttribute = driver.findElement(By.xpath("//input[@class='btn btn-outline-primary mt-3']"));
        buttonByAttribute.sendKeys("buttonByAttribute");
        Thread.sleep(1000);

        WebElement colourByAttribute = driver.findElement(By.xpath("//input[@class='form-control form-control-color']"));
        colourByAttribute.sendKeys("colourByAttribute");
        Thread.sleep(1000);

        WebElement dateByAttribute = driver.findElement(By.xpath("//*[@name='my-date']"));
        dateByAttribute.sendKeys("dateByAttribute");
        Thread.sleep(1000);

        WebElement rangeByAttribute = driver.findElement(By.xpath("//*[@name='my-range']"));
        rangeByAttribute.sendKeys("rangeByAttribute");
        Thread.sleep(1000);


    }
}
