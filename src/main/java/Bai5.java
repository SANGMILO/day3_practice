import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bai5 {
    WebDriver driver;
    By username = By.xpath("//*[@id=\"userName\"]");
    By password = By.xpath("//*[@id=\"password\"]") ;
    By login = By.xpath("//*[@id=\"login\"]");

    public Bai5(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(login).click();
    }
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

        Bai5 test = new Bai5(driver);
        test.login("sangle12345", "123");
        WebElement click_login = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        js.executeScript("arguments[0].click();", click_login);
        Thread.sleep(800);

        System.out.println(System.lineSeparator()+"Sau khi login thanh cong:" + driver.getCurrentUrl());

        driver.quit();

    }
}
