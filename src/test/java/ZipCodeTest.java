import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeTest {

    public WebDriver setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        return browser;
    }

    @Test
    public void testInvalidZipCode() {

        /*
        Открыть браузер
        Открыть страницу www.sharelane.com/cgi-bin/register.py
        В поле Zip Code ввести 1111
        Нажать кнопку Continue
        Проверить появление ошибки
        Закрыть браузер
        */
        WebDriver browser = setDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("1111");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        String errorMessage = browser.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();
    }

    @Test
    public void testValidZipCode() throws InterruptedException {

        /*
        Открыть браузер
        Открыть страницу www.sharelane.com/cgi-bin/register.py
        В поле Zip Code ввести 94118
        Нажать кнопку Continue
        Проверить появление формы регистрации (по кнопке Register)
        Закрыть браузер
        */
        WebDriver browser = setDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("94118");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        boolean registerButton = browser.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(registerButton, "No register button is available.");
        browser.quit();
    }

    @Test
    public void testEmptyZipCode() {

        /*
        Открыть браузер
        Открыть страницу www.sharelane.com/cgi-bin/register.py
        Нажать кнопку Continue
        Проверить появление ошибки
        Закрыть браузер
        */
        WebDriver browser = setDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        String errorMessage = browser.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();
    }

    @Test
    public void testMoreThan5DigitsZipCode() {

        /*
        Открыть браузер
        Открыть страницу www.sharelane.com/cgi-bin/register.py
        В поле Zip Code ввести 1234567890
        Нажать кнопку Continue
        Проверить появление ошибки - ТЕСТ ДОЛЖЕН ЗАВАЛИТЬСЯ
        Закрыть браузер
        */
        WebDriver browser = setDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("1234567890");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        String errorMessage = browser.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();
    }
}
