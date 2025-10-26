package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditLead {

    public static void main(String[] args) throws InterruptedException {

       
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");

       
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

       
        driver.get("http://leaftaps.com/opentaps/control/main");

      
        driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

      
        driver.findElement(By.id("password")).sendKeys("crmsfa");

        
        driver.findElement(By.className("decorativeSubmit")).click();

       
        driver.findElement(By.linkText("CRM/SFA")).click();
        Thread.sleep(2000);

      
        driver.findElement(By.xpath("//a[text()='Leads']")).click();
        Thread.sleep(2000);

        
        driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
        Thread.sleep(2000);

       
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("John");

       
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(3000);

     
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
        Thread.sleep(2000);

   
        String title = driver.getTitle();
        System.out.println("Page title: " + title);

     
        driver.findElement(By.linkText("Edit")).click();
        Thread.sleep(1000);

       
        driver.findElement(By.id("updateLeadForm_companyName")).clear();
        driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("NewCompany");

        
        driver.findElement(By.name("submitButton")).click();
        Thread.sleep(2000);

       
        String updatedName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
        System.out.println("Updated company name: " + updatedName);

      
        driver.quit();
    }
}
