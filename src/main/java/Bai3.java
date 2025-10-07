import io.github.bonigarcia.wdm.WdmAgent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;


public class Bai3 {
    public static void Waitloadpage(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(webDriver -> js.executeScript("return document.readyState").toString().equals("complete"));
        System.out.println("Trang da duoc load!");
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.navigate().to("https://demoqa.com/");
        Thread.sleep(1000);

        WebElement alert_frame = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]"));
        js.executeScript("arguments[0].click();", alert_frame);
        Thread.sleep(800);


        WebElement alert = driver.findElement(By.xpath("(//*[@id=\"item-1\"])[2]"));
        js.executeScript("arguments[0].click()",alert);
        Thread.sleep(800);

        WebElement clickme = driver.findElement(By.xpath("//*[@id=\"alertButton\"]"));
        js.executeScript("arguments[0].click()",clickme);
        Thread.sleep(800);

        Alert alert1 = driver.switchTo().alert();
        String read = alert1.getText();
        System.out.println(System.lineSeparator()+"Text:"+read);
        alert1.accept();

    }
}
