package Plans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Scenario1 {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //navigate to the site
        driver.get("https://dev.insurance.tekschool-students.com/");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/a[2]"));
        loginButton.click();
        String username = "supervisor";
        String password = "tek_supervisor";

        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        WebElement loginForm = driver.findElement(By.tagName("form"));
        loginForm.submit();


            Thread.sleep(3000);

        WebElement plansButton = driver.findElement(By.cssSelector("a[href='/csr/plans']"));
        plansButton.click();

        Thread.sleep(3000);
        WebElement table = driver.findElement(By.className("chakra-table"));

        // Get all rows in the table body
        List<WebElement> rows = table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

        // Verify the number of rows
        if (rows.size() == 4) {
            System.out.println("Expected number of rows found.");
        } else {
            System.out.println("Expected number of rows not found.");
        }
    }}


