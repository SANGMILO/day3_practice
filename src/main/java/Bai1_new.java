import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bai1_new {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        Thread.sleep(1000);

        WebElement frame = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"));
        frame.click();
        Thread.sleep(800);

        WebElement textbox = driver.findElement(By.xpath("(//li[@class='btn btn-light '])[1]"));
        textbox.click();
        Thread.sleep(800);

        WebElement fullname = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        fullname.sendKeys("Le Tan Sang");
        Thread.sleep(500);

        WebElement email = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        email.sendKeys("sang@gmail.com");
        Thread.sleep(800);

        WebElement current = driver.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
        current.sendKeys("Hai Duong");
        Thread.sleep(800);

        WebElement permanent = driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]"));
        permanent.sendKeys("Ha Noi");
        Thread.sleep(800);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement submit1 = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        js.executeScript("arguments[0].click();", submit1);
        Thread.sleep(800);
        js.executeScript("window.scrollBy(0,8000)");

        WebElement result = driver.findElement(By.xpath("//*[@id=\"output\"]"));
        js.executeScript("arguments[0].scrollIntoView(true)", result);
        js.executeScript("arguments[0].style.border='3px solid blue'", result);

        System.out.println(System.lineSeparator()+"Hien thi:"+result.getText());
        Thread.sleep(4000);

        driver.close();
    }
}
