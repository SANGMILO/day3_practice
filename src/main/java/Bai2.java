import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bai2 {
        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.manage().window().maximize();
            driver.get("https://demoqa.com");
            Thread.sleep(1000);

            WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"));
            element.click();
            Thread.sleep(1000);

            //checkbox
            WebElement checkboxx = driver.findElement(By.xpath("//*[@id=\"item-1\"]"));
            checkboxx.click();
            Thread.sleep(1000);

            WebElement expand = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/div/button[1]"));
            expand.click();
            Thread.sleep(1000);

            WebElement commands = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[2]/span/label/span[1]"));
            js.executeScript("arguments[0].click();", commands);
            Thread.sleep(1000);

            WebElement resultText = driver.findElement(By.id("result"));
            System.out.println("Checkbox chọn: " + resultText.getText());

            //radio buttons
            WebElement radio = driver.findElement(By.xpath("//*[@id=\"item-2\"]"));
            radio.click();
            Thread.sleep(1000);

            WebElement yes = driver.findElement(By.xpath("//*[@id=\"yesRadio\"]"));
            js.executeScript("arguments[0].click();", yes);
            Thread.sleep(1000);

            WebElement impressive = driver.findElement(By.xpath("//*[@id=\"impressiveRadio\"]"));
            js.executeScript("arguments[0].click();", impressive);
            Thread.sleep(1000);

            WebElement radioResult = driver.findElement(By.className("text-success"));
            System.out.println("Kết quả Radio: " + radioResult.getText());


        }
}
