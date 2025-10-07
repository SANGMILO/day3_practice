import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Newuser_login {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverManager.chromedriver().setup();
        driver.get("https://demoqa.com/");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement application = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]"));
        js.executeScript("arguments[0].click();", application);
        Thread.sleep(800);

        WebElement login = driver.findElement(By.xpath("(//*[@id=\"item-0\"])[6]"));
        js.executeScript("arguments[0].click();", login);
        Thread.sleep(800);

        WebElement new_user = driver.findElement(By.xpath("//*[@id=\"newUser\"]"));
        js.executeScript("arguments[0].click();", new_user);
        Thread.sleep(800);
        js.executeScript("window.scrollTo(0,300);");


        //firstname
        WebElement firsname = driver.findElement(By.id("firstname"));
        js.executeScript("arguments[0].value='Le';", firsname);
        //js.executeScript("arguments[0].setAttribute('value','Le');", firsname);
        Thread.sleep(800);

        WebElement lastname = driver.findElement(By.id("lastname"));
        js.executeScript("arguments[0].value='Sang';", lastname);
        Thread.sleep(800);

        WebElement username = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        js.executeScript("arguments[0].value='sangle';", username);
        Thread.sleep(800);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        js.executeScript("arguments[0].value='12345';", password);
        Thread.sleep(800);

        //click captcha
        //captcha k the click tu dong duoc ma phai click thu cong bang con nguoi@@
        WebElement captcha = driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]"));
        captcha.click();
        js.executeScript("arguments[0].click();", captcha);
        Thread.sleep(800);
        js.executeScript("document.getElementById('g-recaptcha-response').innerHTML='test-value';");
        js.executeScript("document.getElementById('g-recaptcha-response').value='test-value';");
        js.executeScript("document.getElementById('recaptcha-demo-form').dispatchEvent(new Event('submit'));");


        //register
        WebElement register = driver.findElement(By.xpath("//*[@id=\"register\"]"));
        js.executeScript("arguments[0].click();", register);
        Thread.sleep(800);

    }
}
