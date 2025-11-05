import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.*;
import java.io.File;
import org.openqa.selenium.io.FileHandler;

public class test1 {
    public static void main(String[] args) throws Exception {
        // Step 1: Launch Chrome in Guest mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        WebDriver driver = new ChromeDriver(options);

        // ✅ Set Implicit Wait (applies globally)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 2: Navigate to URL
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();

        // Optional explicit wait for specific cases
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 3: Enter username and password
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Step 4: Click on Login
        driver.findElement(By.id("login-button")).click();

        // Step 5: Capture and print first product name
        String firstProductName = driver.findElement(By.className("inventory_item_name")).getText();
        System.out.println("First Product Name: " + firstProductName);

        // Step 6: Capture and print first product price
        String firstProductPrice = driver.findElement(By.className("inventory_item_price")).getText();
        System.out.println("First Product Price: " + firstProductPrice);

        // Step 7: Add first product to cart (wait for button)
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//button[contains(translate(normalize-space(.), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'), 'ADD TO CART')])[1]")
        ));
        addToCart.click();
        Thread.sleep(2000);


        // Step 8: Click cart icon
        driver.findElement(By.className("shopping_cart_link")).click();

        // Step 9: Verify price in cart matches
        String cartPrice = driver.findElement(By.className("inventory_item_price")).getText();
        if (cartPrice.equals(firstProductPrice)) {
            System.out.println("Price verified successfully!");
        } else {
            System.out.println("Price mismatch!");
        }
        Thread.sleep(2000);

        // Step 10–12: Checkout and enter details
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        Thread.sleep(2000);


     // Step 13–14: Collect prices and find second largest
        List<WebElement> prices = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("inventory_item_price"))
        );

        List<Double> priceList = new ArrayList<>();

        for (WebElement p : prices) {
            String priceText = p.getText().replace("$", "").trim();
            if (!priceText.isEmpty()) {
                priceList.add(Double.parseDouble(priceText));
            }
        }

        // Sort in descending order
        Collections.sort(priceList, Collections.reverseOrder());

        // Check to avoid IndexOutOfBoundsException
        if (priceList.size() > 1) {
            System.out.println("Second Largest Price: $" + priceList.get(1));
        } else if (priceList.size() == 1) {
            System.out.println("Only one price found: $" + priceList.get(0));
        } else {
            System.out.println(" No prices found on the page!");
        }

        // Step 15: Click Finish
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        Thread.sleep(2000);


        // Step 16: Take Screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File("confirmation_page.png"));
        System.out.println("Screenshot saved.");

        // Step 17: Close browser
        driver.quit();
    }
}
