import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ShoppingCartTest {

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

    @Test
    public void checkDiscount0() {
        // Регистрация - логин - выбираем книгу и отправляем ее в корзину - заходим в корзину и проверяем скидки
        WebDriver driver = loginToSharelane();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("19");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalPrice = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "0");
        softAssert.assertEquals(discountDollar, "0.00");
        softAssert.assertEquals(totalPrice, "190.00");
        softAssert.assertAll();

        driver.quit();
    }

    @Test
    public void checkDiscount2() {
        // Регистрация - логин - выбираем книгу и отправляем ее в корзину - заходим в корзину и проверяем скидки
        WebDriver driver = loginToSharelane();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("49");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalPrice = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "2");
        softAssert.assertEquals(discountDollar, "9.8");
        softAssert.assertEquals(totalPrice, "499.80");
        softAssert.assertAll();

        driver.quit();
    }

    @Test
    public void checkDiscount3() {
        // Регистрация - логин - выбираем книгу и отправляем ее в корзину - заходим в корзину и проверяем скидки
        WebDriver driver = loginToSharelane();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("99");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalPrice = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "3");
        softAssert.assertEquals(discountDollar, "29.7");
        softAssert.assertEquals(totalPrice, "1019.70");
        softAssert.assertAll();

        driver.quit();
    }

    @Test
    public void checkDiscount4() {
        // Регистрация - логин - выбираем книгу и отправляем ее в корзину - заходим в корзину и проверяем скидки
        WebDriver driver = loginToSharelane();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("499");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalPrice = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "4");
        softAssert.assertEquals(discountDollar, "349.3");
        softAssert.assertEquals(totalPrice, "5339.30");
        softAssert.assertAll();

        driver.quit();
    }

    @Test
    public void checkDiscount5() {
        // Регистрация - логин - выбираем книгу и отправляем ее в корзину - заходим в корзину и проверяем скидки
        WebDriver driver = loginToSharelane();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("999");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalPrice = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "5");
        softAssert.assertEquals(discountDollar, "699.3");
        softAssert.assertEquals(totalPrice, "10689.30");
        softAssert.assertAll();

        driver.quit();
    }

    @Test
    public void checkDiscount6() {
        // Регистрация - логин - выбираем книгу и отправляем ее в корзину - заходим в корзину и проверяем скидки
        WebDriver driver = loginToSharelane();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("4999");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalPrice = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "6");
        softAssert.assertEquals(discountDollar, "2999.4");
        softAssert.assertEquals(totalPrice, "52989.40");
        softAssert.assertAll();

        driver.quit();
    }

    @Test
    public void checkDiscount7() {
        // Регистрация - логин - выбираем книгу и отправляем ее в корзину - заходим в корзину и проверяем скидки
        WebDriver driver = loginToSharelane();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("9999");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalPrice = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "7");
        softAssert.assertEquals(discountDollar, "6999.3");
        softAssert.assertEquals(totalPrice, "106989.30");
        softAssert.assertAll();

        driver.quit();
    }

    @Test
    public void checkDiscount8() {
        // Регистрация - логин - выбираем книгу и отправляем ее в корзину - заходим в корзину и проверяем скидки
        WebDriver driver = loginToSharelane();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("20936");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalPrice = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "8");
        softAssert.assertEquals(discountDollar, "14655.2");
        softAssert.assertEquals(totalPrice, "224015.20");
        softAssert.assertAll();

        driver.quit();
    }
}
