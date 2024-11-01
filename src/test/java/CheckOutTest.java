import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest {

    // Create method to obtain credit card numbers depending on type
    // Create 3 positive tests with each card types
    // Create negative test case when card is empty

    public WebDriver loginToSharelane() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&last_name=" +
                "test&email=user%40pflb.ru&password1=12345678&password2=12345678");

        String email = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        return driver;
    }

    public String getCreditCardNumber(String card) {
        String cardNumber = "";
        WebDriver driver = loginToSharelane();
        driver.get("https://sharelane.com/test_portal.html");

        driver.findElement(By.xpath("/html/body/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/a")).click();

        Select objSelect = new Select(driver.findElement(By.name("type")));
        switch (card) {
            case "Visa":
                objSelect.selectByVisibleText("Visa");
                driver.findElement(By.cssSelector("input[value='Generate Credit Card']")).click();
                cardNumber = driver.findElement(By.xpath("/html/body/center/table/tbody/tr/td/center/table/tbody/tr[2]/td[2]/span/b")).getText();
                break;
            case "MasterCard":
                objSelect.selectByVisibleText("MasterCard");
                driver.findElement(By.cssSelector("input[value='Generate Credit Card']")).click();
                cardNumber = driver.findElement(By.xpath("/html/body/center/table/tbody/tr/td/center/table/tbody/tr[2]/td[2]/span/b")).getText();
                break;
            case "AmEx":
                objSelect.selectByVisibleText("AmEx");
                driver.findElement(By.cssSelector("input[value='Generate Credit Card']")).click();
                cardNumber = driver.findElement(By.xpath("/html/body/center/table/tbody/tr/td/center/table/tbody/tr[2]/td[2]/span/b")).getText();
                break;
        }
        driver.quit();
        return cardNumber;
    }

    @Test
    public void checkPositiveCheckoutWithVisa() {
        String cardType = "Visa";
        WebDriver driver = loginToSharelane();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.cssSelector("input[value='Proceed to Checkout']")).click();

        Select objSelect = new Select(driver.findElement(By.name("card_type_id")));
        objSelect.selectByVisibleText(cardType);

        driver.findElement(By.name("card_number")).sendKeys(getCreditCardNumber(cardType));

        driver.findElement(By.cssSelector("input[value='Make Payment']")).click();
        String finalMessage = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/p/font/b")).getText();
        Assert.assertEquals(finalMessage, "Thank you for your order!!!");

        driver.quit();
    }

    @Test
    public void checkPositiveCheckoutWithMasterCard() {
        String cardType = "MasterCard";
        WebDriver driver = loginToSharelane();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.cssSelector("input[value='Proceed to Checkout']")).click();

        Select objSelect = new Select(driver.findElement(By.name("card_type_id")));
        objSelect.selectByVisibleText(cardType);

        driver.findElement(By.name("card_number")).sendKeys(getCreditCardNumber(cardType));

        driver.findElement(By.cssSelector("input[value='Make Payment']")).click();
        String finalMessage = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/p/font/b")).getText();
        Assert.assertEquals(finalMessage, "Thank you for your order!!!");

        driver.quit();
    }

    @Test
    public void checkPositiveCheckoutWithAmex() {
        String cardType = "AmEx";
        WebDriver driver = loginToSharelane();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.cssSelector("input[value='Proceed to Checkout']")).click();

        Select objSelect = new Select(driver.findElement(By.name("card_type_id")));
        objSelect.selectByVisibleText(cardType);

        driver.findElement(By.name("card_number")).sendKeys(getCreditCardNumber(cardType));

        driver.findElement(By.cssSelector("input[value='Make Payment']")).click();
        String finalMessage = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/p/font/b")).getText();
        Assert.assertEquals(finalMessage, "Thank you for your order!!!");

        driver.quit();
    }

    @Test
    public void checkNegativeCheckoutEmptyCard() {
        WebDriver driver = loginToSharelane();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.cssSelector("input[value='Proceed to Checkout']")).click();

        driver.findElement(By.cssSelector("input[value='Make Payment']")).click();
        String errorMessage = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error. Invalid card number or not enough balance for purchase");

        driver.quit();
    }
}