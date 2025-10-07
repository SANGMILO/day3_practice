import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class Bai4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        Thread.sleep(800);

        WebElement alert_frame = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]"));
        js.executeScript("arguments[0].click();", alert_frame);
        Thread.sleep(800);

        WebElement multiple = driver.findElement(By.xpath("(//*[@id=\"item-0\"])[3]"));
        js.executeScript("arguments[0].click();", multiple);
        Thread.sleep(800);

        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(800);

        //luu lai Id cua tab hien tai
        String Tabmain = driver.getWindowHandle();
        //new tab
        WebElement newTab = driver.findElement(By.xpath("//*[@id=\"tabButton\"]"));
        newTab.click();
        Thread.sleep(800);

        //lay window handle cua tab moi vaf tab hien tai
        Set<String> all = driver.getWindowHandles();

        //duyet qua window
        for(String window : all){
            if(!window.equals(Tabmain)){
                driver.switchTo().window(window);
                System.out.println("Dang o tab moi!");
                WebElement heading = driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]"));
                System.out.println(System.lineSeparator()+"Text o tab moi la: "+heading.getText());
                Thread.sleep(800);
            }
        }
        driver.switchTo().window(Tabmain);
        System.out.println(System.lineSeparator()+"Dang o tab chinh!"+driver.getTitle());
        Thread.sleep(5000);
        driver.quit();
    }
}
