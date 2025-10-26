package assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

    public static void main(String[] args) throws InterruptedException {
        
      
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
      
        driver.get("http://leaftaps.com/opentaps/control/main");
        
      
        driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
        
        // Step 4: Enter password
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        
        // Step 5: Click Login
        driver.findElement(By.className("decorativeSubmit")).click();
        
        // Step 6: Click CRM/SFA link
        driver.findElement(By.linkText("CRM/SFA")).click();
        
        // Step 7: Click Leads link
        driver.findElement(By.linkText("Leads")).click();
        
        // Step 8: Click Find Leads
        driver.findElement(By.linkText("Find Leads")).click();
        
        // Step 9: Enter first name
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("John");
        
        // Step 10: Click Find Leads button
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        
        // Wait for results to load
        Thread.sleep(3000); // simple wait for beginners
        
        // Step 11: Click on first resulting lead
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
        
        // Step 12: Verify title of the page
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        
        // Step 13: Click Edit
        driver.findElement(By.linkText("Edit")).click();
        
        // Step 14: Change the company name
        driver.findElement(By.id("updateLeadForm_companyName")).clear();
        driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("NewCompany");
        
        // Step 15: Click Update
        driver.findElement(By.name("submitButton")).click();
        
        // Step 16: Confirm the changed name appears
        String updatedName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
        System.out.println("Updated company name: " + updatedName);
        
        // Step 17: Close the browser
        driver.quit();
    }
}
