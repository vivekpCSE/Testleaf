import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {
    public static void main(String[] args) throws InterruptedException {

       
        WebDriver driver = new ChromeDriver();

        
        driver.get("https://en-gb.facebook.com/");

        
        driver.manage().window().maximize();

        
        Thread.sleep(6000); 

        
        driver.findElement(By.partialLinkText("Create")).click();
        Thread.sleep(6000); 

        
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.findElement(By.name("lastname")).sendKeys("Doe");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("reg_email__")).sendKeys("1234567890");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("reg_passwd__")).sendKeys("Test@1234");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("birthday_day")).sendKeys("10");
        driver.findElement(By.name("birthday_month")).sendKeys("Oct");
        driver.findElement(By.name("birthday_year")).sendKeys("1990");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
        driver.findElement(By.xpath("//input[@value='1']")).click();

      
        Thread.sleep(3000);
        driver.quit();
    }
}
