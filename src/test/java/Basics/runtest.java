package Basics;


    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.apache.commons.lang3.Validate;
    import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
    import org.testng.annotations.AfterTest;
    import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

    //import static jdk.javadoc.internal.doclint.Env.validatePackages;

public class runtest {



        public static void main(String[] args) {

            WebDriverManager.chromedriver().setup();

            WebDriver driver = new ChromeDriver();
            // Navigate to the URL
            driver.get("https://subscribe.stctv.com/");
        

           // for SA
            WebElement saPackages = driver.findElement(By.xpath("//h3[contains(text(),'SA')]/following-sibling::table"));
            validatePackages(saPackages);


            // Find and validate the subscription packages for Kuwait
            WebElement kuwaitPackages = driver.findElement(By.xpath("//h3[contains(text(),'Kuwait')]/following-sibling::table"));
            validatePackages(kuwaitPackages);

            // Find and validate the subscription packages for Bahrain
            WebElement bahrainPackages = driver.findElement(By.xpath("//h3[contains(text(),'Bahrain')]/following-sibling::table"));
            validatePackages(bahrainPackages);

            // Close the browser
            driver.quit();
        }

    private static void validatePackages(WebElement packages) {
        // Find all the rows in the table
        java.util.List<WebElement> rows = packages.findElements(By.tagName("tr"));

        // Loop through each row and validate the type, price, and currency
        for (WebElement row : rows) {
            java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
            String type = cells.get(0).getText();
            String price = cells.get(1).getText();
            String currency = cells.get(2).getText();

            // Validate the type, price, and currency
            System.out.println("Type: " + type);
            System.out.println("Price: " + price);
            System.out.println("Currency: " + currency);
        }}}